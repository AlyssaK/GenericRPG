package servlets;

import business.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alyssa
 */
public class UpdateChampionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        final int points_per_level = 25;
        
        //Get Session Objects - Account & CurrBattle
        Battle currBattle = (Battle) request.getSession().getAttribute("currBattle");        
        Account currAccount = (Account) request.getSession().getAttribute("acct");
        
        String msg = "";
        //String URL = "/ViewCharacters.jsp"; AJAX BUILD
        String URL = "/view_character.jsp";
        int str=0, acc=0, spd=0, skl=0, kno=0;
        boolean leveled = (boolean) request.getSession().getAttribute("leveled");
        String sql;
        
        ConnectionPool pool;
        Connection conn;
        Statement s;
        ResultSet r;        
        
        if(leveled){
            try{
                str = Integer.parseInt(request.getParameter("strength"));
                if(str > 25 || str < 0){
                    msg += "FormatError: Attribute Cannot be Greater Than 25 or Less Than 0.<br>";
                }            
            }catch(Exception e){
                msg += "Error: " +  e.getMessage() + "<br>";                    
            }

            try{
                acc = Integer.parseInt(request.getParameter("accuracy"));
                if(acc > 25 || acc < 0){
                    msg += "FormatError: Attribute Cannot be Greater Than 25 or Less Than 0.<br>";
                }            
            }catch(Exception e){
                msg += "Error: " +  e.getMessage() + "<br>";                    
            }

            try{
                spd = Integer.parseInt(request.getParameter("speed"));
                if(spd > 25 || spd < 0){
                    msg += "Format Error: Attribute Cannot be Greater Than 25 or Less Than 0.<br>";
                }            
            }catch(Exception e){
                msg += "Error: " +  e.getMessage() + "<br>";                    
            }

            try{
                skl = Integer.parseInt(request.getParameter("skill"));
                if(skl > 25 || skl < 0){
                    msg += "Format Error: Attribute Cannot be Greater Than 25 or Less Than 0.<br>";
                }            
            }catch(Exception e){
                msg += " General Error: " +  e.getMessage() + "<br>";                    
            }

            try{
                kno = Integer.parseInt(request.getParameter("knowledge"));
                if(kno > 25 || kno < 0){
                    msg += "Format Error: Number Cannot be Greater Than 25 or Less Than 0.<br>";
                }            
            }catch(Exception e){
                msg += "General Error: " +  e.getMessage() + "<br>";                    
            }
        }
                
        int temp_total;
        if(leveled){
            temp_total = str + acc + spd + skl + kno;
        }else{
            temp_total = 25;                
        }
            
        switch(currBattle.getDifficulty_level()){
            case "beginner":
                if(currBattle.getWinner() == 1){
                    int tempWins = currAccount.getActiveChamp().getBeg_wins();
                    tempWins++;
                    currAccount.getActiveChamp().setBeg_wins(tempWins);
                }else if(currBattle.getWinner() == -1){
                    int tempLosses = currAccount.getActiveChamp().getBeg_losses();
                    tempLosses++;
                    currAccount.getActiveChamp().setBeg_wins(tempLosses);
                }else{
                    msg+= "Unknown Error: Battle Has No Winner.";
                }
                break;
            case "apprentice":
                if(currBattle.getWinner() == 1){
                    int tempWins = currAccount.getActiveChamp().getApp_wins();
                    tempWins++;
                    currAccount.getActiveChamp().setApp_wins(tempWins);
                }else if(currBattle.getWinner() == -1){
                    int tempLosses = currAccount.getActiveChamp().getApp_losses();
                    tempLosses++;
                    currAccount.getActiveChamp().setApp_wins(tempLosses);
                }else{
                    msg+= "Unknown Error: Battle Has No Winner.";
                }
                break;
            case "master":
                if(currBattle.getWinner() == 1){
                    int tempWins = currAccount.getActiveChamp().getMaster_wins();
                    tempWins++;
                    currAccount.getActiveChamp().setMaster_wins(tempWins);
                }else if(currBattle.getWinner() == -1){
                    int tempLosses = currAccount.getActiveChamp().getMaster_losses();
                    tempLosses++;
                    currAccount.getActiveChamp().setMaster_wins(tempLosses);
                }else{
                    msg+= "Unknown Error: Battle Has No Winner.";
                }
                break;
            case "boss":
                if(currBattle.getWinner() == 1){
                    int tempWins = currAccount.getActiveChamp().getBoss_wins();
                    tempWins++;
                    currAccount.getActiveChamp().setBoss_wins(tempWins);
                }else if(currBattle.getWinner() == -1){
                    int tempLosses = currAccount.getActiveChamp().getBoss_losses();
                    tempLosses++;
                    currAccount.getActiveChamp().setBoss_wins(tempLosses);
                }else{
                    msg+= "Unknown Error: Battle Has No Winner.";
                }
                break;
            default:
                msg+= "Unknown Error: Battle Has No Difficuly.";
                break;
        }        
        
        if(msg.isEmpty()){    
            if(temp_total != points_per_level){                
                msg += "Error: Check Your Math! Your Attributes Do Not Add Up To 25.<br>";                
            }else{
                
                Champion c = currAccount.getActiveChamp();
                
                try{
                    pool = ConnectionPool.getInstance();
                    conn = pool.getConnection();

                    sql = "REPLACE champion (character_id, account_id, character_name, "
                            + " char_strength, char_accuracy, char_speed, char_skill, "
                            + " char_knowledge, char_level, char_exp, char_total_exp, "
                            + " char_action_1, char_action_2, char_action_3, char_action_4, "
                            + " char_portrait, beginner_wins, beginner_losses, apprentice_wins, "
                            + " apprentice_losses, master_wins, master_losses, boss_wins, boss_losses )" 
                            + ""
                            + "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , " 
                            + " ? , ? , ? , ? , ? , ? , ? , ? ) ";
                    

                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, c.getId());
                    ps.setInt(2, c.getAccountID());
                    ps.setString(3, c.getName());
                    ps.setInt(4, c.getStr());
                    ps.setInt(5, c.getAcc());
                    ps.setInt(6, c.getSpeed());
                    ps.setInt(7, c.getSkill());
                    ps.setInt(8, c.getKnow());
                    ps.setInt(9, c.getLevel());
                    ps.setDouble(10, c.getExp());
                    ps.setDouble(11, c.getTotalExp());
                    ps.setString(12, c.getCharActions().get(0).getActionID());
                    ps.setString(13, c.getCharActions().get(1).getActionID());
                    ps.setString(14, c.getCharActions().get(2).getActionID());
                    ps.setString(15, c.getCharActions().get(3).getActionID());
                    ps.setString(16, c.getPhoto_loc());
                    ps.setInt(17, c.getBeg_wins());
                    ps.setInt(18, c.getBeg_losses());
                    ps.setInt(19, c.getApp_wins());
                    ps.setInt(20, c.getApp_losses());
                    ps.setInt(21, c.getMaster_wins());
                    ps.setInt(22, c.getMaster_losses());
                    ps.setInt(23, c.getBoss_wins());
                    ps.setInt(24, c.getBoss_losses());

                    int rc = ps.executeUpdate();
                    
                    if(rc == 0 || rc == 1){
                        msg += "Character Update Failed! <br>";
                        URL = "/after_battle.jsp";
                        //URL = "/AfterBattle.jsp"; AJAX BUILD
                    }else if(rc == 2){
                        msg += "Character Successfully Updated! <br>";                        
                    }else{
                        msg += "Warning: " + rc + " records changed. Check Database. <br>";                        
                    }
                    
                    pool.freeConnection(conn);
                }catch(SQLException e){
                    msg += "SQL Error: " + e.getMessage();
                }
            }
        }
        
        request.getSession().setAttribute("acct", currAccount);
        request.getSession().setAttribute("currBattle", currBattle);        
        
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
