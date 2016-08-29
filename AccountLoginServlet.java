package servlets;

import business.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Alyssa
 */
public class AccountLoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String msg = "";
        //String URL = "/BaseFrame.jsp"; AJAX BUILD
        String URL = "/account_login.jsp";
        String sql;
        
        int primes[] = {1,2,3,4,5};
        
        int primeL = primes.length;
        
        for(int i=0; i<primes.length; i++){
            int distN = primes[i];
        }
        
        boolean isAuthen = false;
        ConnectionPool pool;
        Connection conn;
        Statement s;
        ResultSet r;
        
        Account a = new Account();
        
        String acct_name = request.getParameter("acct_name");
        String pwdAttempt = request.getParameter("password");
        String actionID_1, actionID_2, actionID_3, actionID_4;
        
        try{            
            pool = ConnectionPool.getInstance();
            conn = pool.getConnection();
            s = conn.createStatement();           
            
            sql = "SELECT * FROM account WHERE account_name = '" + acct_name + "'";
            
            r = s.executeQuery(sql);
            
            if(r.next()) {                
                a.setName(r.getString("account_name"));
                a.setPassword(r.getString("account_password"));
                a.setPwdAttempt(pwdAttempt);
                if(a.isAccountAuthen()){
                    a.setAccountID(r.getInt("account_id"));
                    a.setActiveChampID(r.getInt("account_activeChampID"));
                    msg += "Authenticated! <br>";
                    isAuthen = true;
                }else{
                    msg += "Invalid ID and/or Password. <br>";
                    request.getSession().setAttribute("acct", a);
                }
            }            
            pool.freeConnection(conn);            
        }catch(SQLException e){
            msg += "SQLError1: " + e.getMessage() + "<br>";
        }catch(Exception e){
            msg += "GeneralError1: " + e.getMessage() + "<br>";
        }
        
        if(isAuthen){
            ArrayList<Action> all_actions = new ArrayList<>();            
            try{               
                //Load Action Table
                pool = ConnectionPool.getInstance();
                conn = pool.getConnection();
                s = conn.createStatement();           

                sql = "SELECT * FROM actions";

                r = s.executeQuery(sql);

                while(r.next()) {                
                    Action act = new Action();
                    act.setActionID(r.getString("action_id"));
                    act.setActionName(r.getString("action_name"));
                    act.setAlterACC(r.getInt("action_acc"));
                    act.setAlterKNO(r.getInt("action_know"));
                    act.setAlterSKL(r.getInt("action_skill"));
                    act.setAlterSPD(r.getInt("action_spd"));
                    act.setAlterSTR(r.getInt("action_str"));
                    act.setBaseDMG(r.getInt("action_dmg"));
                    act.setBaseHEAL(r.getInt("action_heal"));
                    act.setBaseHitChance(r.getDouble("action_hitchance"));
                    all_actions.add(act);
                }
                
                request.getSession().setAttribute("allActions", all_actions);
                pool.freeConnection(conn);
                
                //If Action Table Found, Load Account Champion Table                
                if(all_actions.size() > 0){                   
                    try{
                        ArrayList<Champion> chars = new ArrayList<>();
                        pool = ConnectionPool.getInstance();
                        conn = pool.getConnection();
                        s = conn.createStatement();

                        sql = "SELECT * FROM champion WHERE account_id = '" + a.getAccountID() + "'";

                        r = s.executeQuery(sql);

                        while(r.next()) {
                            Champion c = new Champion(r.getInt("character_id"),
                                r.getInt("account_id"), r.getString("character_name"),
                                r.getInt("char_strength"), r.getInt("char_accuracy"),
                                r.getInt("char_speed"), r.getInt("char_skill"),
                                r.getInt("char_knowledge"), r.getInt("char_level"),
                                r.getLong("char_exp"), r.getLong("char_total_exp"),
                                r.getString("char_portrait"), r.getInt("beginner_wins"), 
                                r.getInt("beginner_losses"), r.getInt("apprentice_wins"),
                                r.getInt("apprentice_losses"), r.getInt("master_wins"), 
                                r.getInt("master_losses"), r.getInt("boss_wins"),
                                r.getInt("boss_losses"));

                            actionID_1 = r.getString("char_action_1");
                            actionID_2 = r.getString("char_action_2");
                            actionID_3 = r.getString("char_action_3");
                            actionID_4 = r.getString("char_action_4");
                            
                            ArrayList<Action> charActions = new ArrayList<>();
                            
                            for(Action act : all_actions){
                                if(act.getActionID().equalsIgnoreCase(actionID_1)){
                                    charActions.add(act);
                                } 
                            }
                                
                            for(Action act : all_actions){
                                if(act.getActionID().equalsIgnoreCase(actionID_2)){
                                    charActions.add(act);
                                }
                            }
                            
                            for(Action act : all_actions){
                                if(act.getActionID().equalsIgnoreCase(actionID_3)){
                                    charActions.add(act);
                                }
                            }
                            
                            for(Action act : all_actions){
                                if(act.getActionID().equalsIgnoreCase(actionID_4)){
                                    charActions.add(act);
                                }
                            }
                            
                            if(charActions.size() > 0){
                                c.setCharActions(charActions);
                                chars.add(c);
                            }else{
                                msg += "Error: Character Actions Not Loaded! <br>";
                            }
                            
                            if(c.getId() == a.getActiveChampID() && a.getActiveChampID() != 0){
                                a.setActiveChamp(c);
                            }                         
                        }
                        
                        pool.freeConnection(conn);
                        
                        if(chars.size()>0){
                            msg += chars.size() + " Characters Loaded! <br>";
                            a.setChampions(chars);
                            if(a.getActiveChampID() == 0){
                                a.setActiveChamp(a.getChampions().get(0));
                            }
                        }else{
                            msg += "No Characters Found. <br>";
                            a.setActiveChamp(new Champion());
                        }                        
                        
                        request.getSession().setAttribute("acct", a);
                    }catch(SQLException e){
                        msg += "SQLError3: " + e.getMessage() + "<br>";
                    }catch(Exception e){
                        msg += "GeneralError3: " + e.getMessage() + "<br>";
                    }
                }else{
                    msg += "Error: Can't Load Any Spells. Check Database <br>";
                }
            }catch(SQLException e){
                msg += "SQLError2: " + e.getMessage() + "<br>";
            }catch(Exception e){
                msg += "GeneralError2: " + e.getMessage() + "<br>";
            }
        }
        
        request.setAttribute("msg", msg);
        
        Cookie uid = new Cookie("acctName", acct_name);
            uid.setMaxAge(60 * 10);
            uid.setPath("/");
            response.addCookie(uid);
        
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

    private void Exception(String error_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
