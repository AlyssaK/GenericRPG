package servlets;

import business.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Alyssa
 */
public class LoadBattleServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String msg = "";
        //String URL = "/BattleMenu.jsp"; AJAX BUILD
        String URL = "/battle_menu.jsp";
        
        ConnectionPool pool;
        Connection conn;
        Statement s;
        ResultSet r;
        
        String sql;
        
        Random rand = new Random();
        ArrayList<Action> allActions = (ArrayList<Action>) request.getSession(). getAttribute("allActions");
        Account a = (Account) request.getSession().getAttribute("acct");
        Champion activeChamp = a.getActiveChamp();
        Opponent activeOpp = null;
        Battle currBattle;
        
        int activeChampID = Integer.parseInt(request.getParameter("active"));
        String actiontype = request.getParameter("actiontype");
        
        int opp_level = 0;
        int opp_id = rand.nextInt(41) + 1;
        String aid1, aid2, aid3, aid4;
        
        //Check For Change in Player's Active Champ
        if(activeChamp.getId() != (activeChampID)){
            for(Champion c : a.getChampions()){
                if(c.getId() == activeChampID){
                    activeChamp = c;
                }
            }
        }
        
        
        
        //Load Opponent into activeOpp object
        try{            
            pool = ConnectionPool.getInstance();
            conn = pool.getConnection();
            s = conn.createStatement();           
            
            sql = "SELECT * FROM opponent WHERE opponent_id = " + opp_id + " ";
            
            r = s.executeQuery(sql);
            
            if(r.next()) {
                activeOpp = new Opponent(
                    r.getInt("opponent_id"), r.getString("opponent_name"),
                    (opp_level * r.getInt("opp_strength")), 
                    (opp_level * r.getInt("opp_accuracy")),
                    (opp_level * r.getInt("opp_speed")), 
                    (opp_level * r.getInt("opp_skill")), 
                    (opp_level * r.getInt("opp_knowledge")), 
                     opp_level, actiontype, r.getString("opp_portrait")                       
                );

                aid1 = r.getString("opp_action_1");
                aid2 = r.getString("opp_action_2");
                aid3 = r.getString("opp_action_3");
                aid4 = r.getString("opp_action_4");

                ArrayList<Action> oppActions = new ArrayList<>();

                allActions.stream().filter((act) -> (act.getActionID().equalsIgnoreCase(aid1))).forEach((act) -> {
                    oppActions.add(act);
                });

                allActions.stream().filter((act) -> (act.getActionID().equalsIgnoreCase(aid2))).forEach((act) -> {
                    oppActions.add(act);
                });

                allActions.stream().filter((act) -> (act.getActionID().equalsIgnoreCase(aid3))).forEach((act) -> {
                    oppActions.add(act);
                });

                allActions.stream().filter((act) -> (act.getActionID().equalsIgnoreCase(aid4))).forEach((act) -> {
                    oppActions.add(act);
                });
                
                activeOpp.setCharActions(oppActions);            
            }else{
                msg += "Error: No Opponent Found. Battle Aborted.<br>";
            } 
            pool.freeConnection(conn);            
        }catch(SQLException e){
            msg += "SQLError: " + e.getMessage() + "<br>";
        }catch(Exception e){
            msg += "GeneralError: " + e.getMessage() + "<br>";
        }
        
        //Load Battle into Object and Set to Session
        if(msg.isEmpty()){
                currBattle = new Battle(activeChamp, activeOpp);
                currBattle.setDifficulty_level(actiontype);
                request.getSession().setAttribute("currBattle", currBattle);
                msg+="Battle Successfully Loaded!<br>";
                //URL = "/BattleScreen.jsp";
                URL = "/battle_screen.jsp";
        } 
        
        request.setAttribute("msg", msg);
        
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
