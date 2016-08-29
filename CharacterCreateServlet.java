package servlets;

import business.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Alyssa
 */
public class CharacterCreateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        final int starting_points = 25;

        //String URL = "/CreateCharacter.jsp"; AJAX BUILD
        String URL = "/create_character.jsp";
        String msg = "";
        String sql;
        
        ConnectionPool pool;
        Connection conn;
        Statement s;
        ResultSet r;        
        
        int str=0, acc=0, spd=0, skl=0, kno=0;
        String photo_choice = request.getParameter("photo");
        String photo_loc = "";
        String charName= "";
        Account a = (Account) request.getSession().getAttribute("acct");
        
        try{                
            charName = request.getParameter("char_name");
            pool = ConnectionPool.getInstance();
            conn = pool.getConnection();            
            s = conn.createStatement();           

            sql = "SELECT * FROM champion WHERE character_name = '" + charName + "' "
                    + " AND account_id = '" + a.getAccountID() + "' ";

            r = s.executeQuery(sql);
            
            if(r.next()) {                
                msg += "Error1: You Already Have a Character with that Name! <br>";
            }
            pool.freeConnection(conn);            
        }catch(SQLException e){
            msg += "SQLError1: " + e.getMessage() + "<br>";
        }catch(Exception e){
            msg += "GeneralError1: " + e.getMessage() + "<br>";
        }        
        
        try{
            str = Integer.parseInt(request.getParameter("strength"));
            if(str > 25 || str < 0){
                msg += "FormatError2: Attribute Cannot be Greater Than 25 or Less Than 0.<br>";
            }            
        }catch(Exception e){
            msg += "Error2: " +  e.getMessage() + "<br>";                    
        }
        
        try{
            acc = Integer.parseInt(request.getParameter("accuracy"));
            if(acc > 25 || acc < 0){
                msg += "FormatError3: Attribute Cannot be Greater Than 25 or Less Than 0.<br>";
            }            
        }catch(Exception e){
            msg += "Error3: " +  e.getMessage() + "<br>";                    
        }
        
        try{
            spd = Integer.parseInt(request.getParameter("speed"));
            if(spd > 25 || spd < 0){
                msg += "FormatError4: Attribute Cannot be Greater Than 25 or Less Than 0.<br>";
            }            
        }catch(Exception e){
            msg += "Error4: " +  e.getMessage() + "<br>";                    
        }
        
        try{
            skl = Integer.parseInt(request.getParameter("skill"));
            if(skl > 25 || skl < 0){
                msg += "FormatError5: Attribute Cannot be Greater Than 25 or Less Than 0.<br>";
            }            
        }catch(Exception e){
            msg += "Error5: " +  e.getMessage() + "<br>";                    
        }
        
        try{
            kno = Integer.parseInt(request.getParameter("knowledge"));
            if(kno > 25 || kno < 0){
                msg += "FormatError6: Number Cannot be Greater Than 25 or Less Than 0.<br>";
            }            
        }catch(Exception e){
            msg += "Error6: " +  e.getMessage() + "<br>";                    
        }      
        
        switch(photo_choice){
            case "amguy":
                photo_loc = "Images/CharacterIcons/americanguy.jpg";
                break;
            case "disco":
                photo_loc = "Images/CharacterIcons/discodude.jpg";
                break;
            case "flower":
                photo_loc = "Images/CharacterIcons/inconspicuousflower.jpg";
                break;
            case "dragon":
                photo_loc = "Images/CharacterIcons/scarydragon.jpg";
                break;
            case "snail":
                photo_loc = "Images/CharacterIcons/sillysnail.jpg";
                break;
            case "witch":
                photo_loc = "Images/CharacterIcons/spookywitch.jpg";
                break;
            case "horse":
                photo_loc = "Images/CharacterIcons/stupidhorse.jpg";
                break;
            case "cat":
                photo_loc = "Images/CharacterIcons/trickycat.jpg";
                break;
            default:
                msg += "Error: Unknown Champion Portrait Selected.<br>";
        }
        
        if(msg.isEmpty()){
            int temp_total = str + acc + spd + skl + kno;
            if(temp_total!=starting_points){
                msg += "Error7: Check Your Math! Your Attributes Do Not Add Up To 25.<br>";
            }else{
                Champion c = new Champion(a.getAccountID(), charName, str, acc, spd, skl, kno, photo_loc);
                c.setExp(0);
                c.setTotalExp(0);
                c.setBeg_wins(0);
                c.setBeg_losses(0);
                c.setApp_wins(0);
                c.setApp_losses(0);
                c.setMaster_wins(0);
                c.setMaster_losses(0);
                c.setBoss_wins(0);
                c.setBoss_losses(0);
                
                try{
                    pool = ConnectionPool.getInstance();
                    conn = pool.getConnection();

                    sql = "INSERT INTO champion (account_id, character_name, "
                            + " char_strength, char_accuracy, char_speed, char_skill, "
                            + " char_knowledge, char_level, char_exp, char_total_exp, "
                            + " char_action_1, char_action_2, char_action_3, char_action_4, "
                            + " char_portrait, beginner_wins, beginner_losses, apprentice_wins, "
                            + " apprentice_losses, master_wins, master_losses, boss_wins, boss_losses )" 
                            + "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , " 
                            + " ? , ? , ? , ? , ? , ? , ? ) ";

                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, c.getAccountID());
                    ps.setString(2, c.getName());
                    ps.setInt(3, c.getStr());
                    ps.setInt(4, c.getAcc());
                    ps.setInt(5, c.getSpeed());
                    ps.setInt(6, c.getSkill());
                    ps.setInt(7, c.getKnow());
                    ps.setInt(8, c.getLevel());
                    ps.setDouble(9, c.getExp());
                    ps.setDouble(10, c.getTotalExp());
                    ps.setString(11, "A001");
                    ps.setString(12, "B001");
                    ps.setString(13, "C001");
                    ps.setString(14, "D001");
                    ps.setString(15, c.getPhoto_loc());
                    ps.setInt(16, c.getBeg_wins());
                    ps.setInt(17, c.getBeg_losses());
                    ps.setInt(18, c.getApp_wins());
                    ps.setInt(19, c.getApp_losses());
                    ps.setInt(20, c.getMaster_wins());
                    ps.setInt(21, c.getMaster_losses());
                    ps.setInt(22, c.getBoss_wins());
                    ps.setInt(23, c.getBoss_losses());         

                    int rc = ps.executeUpdate();
                    pool.freeConnection(conn);

                    if(rc == 0){
                        msg += "Character Creation Failed! <br>";
                    }else {                       
                        try{
                            ArrayList<Action> allActions = (ArrayList<Action>) request.getSession().getAttribute("allActions");
                            pool = ConnectionPool.getInstance();
                            conn = pool.getConnection();

                            s = conn.createStatement();           

                            sql = "SELECT * FROM champion WHERE character_name = '" + c.getName() + "'";

                            r = s.executeQuery(sql);

                            if(r.next()){
                                c.setId(r.getInt("character_id"));
                                
                                ArrayList<Action> charActions = new ArrayList<>(Collections.nCopies(4, new Action()));
                            
                                allActions.stream().forEach((act) -> {
                                    if(act.getActionID().equalsIgnoreCase("A001")){
                                        charActions.add(0, act);
                                    }else if(act.getActionID().equalsIgnoreCase("B001")){
                                        charActions.add(1, act);
                                    }else if(act.getActionID().equalsIgnoreCase("C001")){
                                        charActions.add(2, act);
                                    }else if(act.getActionID().equalsIgnoreCase("D001")){
                                        charActions.add(3, act);
                                    }
                                });
                                
                                c.setCharActions(charActions);
                                
                                ArrayList<Champion> temp_array = a.getChampions();
                                temp_array.add(c);                                
                                a.setChampions(temp_array);
                                
                                request.getSession().setAttribute("acct", a);
                                
                                msg += "Character Successfully Created! <br>";
                                URL = "/view_character.jsp";
                            }                   

                            pool.freeConnection(conn);            
                        }catch(SQLException e){
                            msg += "SQLError7: " + e.getMessage() + "<br>";
                        }catch(Exception e){
                            msg += "GeneralError7: " + e.getMessage() + "<br>";
                        }
                    }
                }catch(SQLException e){
                    msg += "SQLError9: " + e.getMessage() + "<br>";
                }catch(Exception e){
                    msg += "GeneralError8: " + e.getMessage() + "<br>";
                }
            }
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
