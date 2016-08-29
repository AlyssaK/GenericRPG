package servlets;

import business.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class ProcessTurnServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String err_msg = "";
        String plyr_move_stats = "";
        String comp_move_stats = "";
        String win_msg = "";
        String exp_msg = "";
        boolean leveled = false;
        boolean didCrit = false;
        
        //String URL = "/AfterBattle.jsp"; AJAX BUILD
        String URL = "/battle_screen.jsp";
        String sql;
        
        ConnectionPool pool;
        Connection conn;
        Statement s;
        ResultSet r;
        
        Battle currBattle = (Battle) request.getSession().getAttribute("currBattle");
        Account a = (Account) request.getSession().getAttribute("acct");
        
        Random rand = new Random();
        Action currPlayerAction = currBattle.getPlayer().getCharActions().get(Integer.parseInt(request.getParameter("actiontype")));
        Action currCompAction = currBattle.getComputer().getCharActions().get(rand.nextInt(4));
        
        //Load Current Move Choice into Battle Class
        currBattle.setPlayer_curr_move(currPlayerAction);
        currBattle.setComp_curr_move(currCompAction);
        
        //Check for Action Alters and Apply Them
        currBattle.isAlterApplyAlter();
        
        //Check if Applied Alters change FirstStrike
        currBattle.firstStrike();
        
        //Process First Side of Battle
        int currCompHP = currBattle.getComp_curr_hp();
        int currPlyrHP = currBattle.getPlayer_curr_hp();        

        if(currBattle.isTurn()){
            if(currBattle.doesHit()){
                int plyrDMG;
                if(currBattle.doesCrit()){
                    plyrDMG = currBattle.DamageDone() + currBattle.getPlayer().getBaseCritDmgBonus();
                    didCrit = true;
                }else{
                    plyrDMG= currBattle.DamageDone();
                }
                int plyrHEALZ = currBattle.HealsDone();                
                currBattle.setComp_curr_hp(currCompHP - plyrDMG);
                currBattle.setPlayer_curr_hp(currPlyrHP + plyrHEALZ);
                if(plyrDMG>0){
                    plyr_move_stats = "The Attack Landed! You did " + plyrDMG + " DMG! " +"<br>";
                    if(didCrit){ plyr_move_stats += "Critical Strike!"; didCrit=false; }
                    plyr_move_stats +="Hit Ratio : " + currBattle.getPlayer().getBaseHitPercent() + "% <br>"
                                    + "Crit Ratio: " + currBattle.getPlayer().getBaseCritPercent() + "% <br>"
                                    + "Crit DMG: " + currBattle.getPlayer().getBaseCritDmgBonus() + "DMG <br>"
                                    + "Dodge Ratio: " + currBattle.getPlayer().getBaseDodgePercent() + "% <br><br>"
                                    + "Strength: " + currBattle.getPlayer().getStr() 
                                    + "Accuracy: " + currBattle.getPlayer().getAcc() + "<br>"
                                    + "Speed: " + currBattle.getPlayer().getSpeed()
                                    + "Skill: " + currBattle.getPlayer().getSkill() + "<br>"
                                    + "Knowledge: " + currBattle.getPlayer().getKnow() + "<br>";
                }
                if(plyrHEALZ>0){
                    plyr_move_stats += "You healed for " + plyrHEALZ + " Health Points!<br>"
                                    + "Hit Ratio : " + currBattle.getPlayer().getBaseHitPercent() + "% <br>"
                                    + "Crit Ratio: " + currBattle.getPlayer().getBaseCritPercent() + "% <br>"
                                    + "Crit DMG: " + currBattle.getPlayer().getBaseCritDmgBonus() + "DMG <br>"
                                    + "Dodge Ratio: " + currBattle.getPlayer().getBaseDodgePercent() + "% <br><br>"
                                    + "Strength: " + currBattle.getPlayer().getStr() 
                                    + "Accuracy: " + currBattle.getPlayer().getAcc() + "<br>"
                                    + "Speed: " + currBattle.getPlayer().getSpeed()
                                    + "Skill: " + currBattle.getPlayer().getSkill() + "<br>"
                                    + "Knowledge: " + currBattle.getPlayer().getKnow() + "<br>";
                }
            }else{
                plyr_move_stats += "You missed.<br>"
                                + "Hit Ratio : " + currBattle.getPlayer().getBaseHitPercent() + "% <br>"
                                + "Crit Ratio: " + currBattle.getPlayer().getBaseCritPercent() + "% <br>"
                                + "Crit DMG: " + currBattle.getPlayer().getBaseCritDmgBonus() + "DMG <br>"
                                + "Dodge Ratio: " + currBattle.getPlayer().getBaseDodgePercent() + "% <br><br>"
                                + "Strength: " + currBattle.getPlayer().getStr() 
                                + "Accuracy: " + currBattle.getPlayer().getAcc() + "<br>"
                                + "Speed: " + currBattle.getPlayer().getSpeed()
                                + "Skill: " + currBattle.getPlayer().getSkill() + "<br>"
                                + "Knowledge: " + currBattle.getPlayer().getKnow() + "<br>";
            }
            currBattle.setTurn(false);
        }else{
            if(currBattle.doesHit()){
                int CompDMG;
                if(currBattle.doesCrit()){
                    CompDMG = currBattle.DamageDone() + currBattle.getComputer().getBaseCritDmgBonus();                    
                }else{
                    CompDMG= currBattle.DamageDone();
                }
                int CompHEALZ = currBattle.HealsDone();
                currBattle.setPlayer_curr_hp(currPlyrHP - CompDMG);
                currBattle.setComp_curr_hp(currCompHP + CompHEALZ);
                if(CompDMG>0){
                    comp_move_stats += "The Attack Landed! Your opponent did " + CompDMG + " DMG!<br>";
                    if(didCrit){ comp_move_stats += "Critical Strike!"; didCrit=false; }
                    comp_move_stats += "Hit Ratio : " + currBattle.getComputer().getBaseHitPercent() + "% <br>"
                                    + "Crit Ratio: " + currBattle.getComputer().getBaseCritPercent() + "% <br>"
                                    + "Crit DMG: " + currBattle.getComputer().getBaseCritDmgBonus() + "DMG <br>"
                                    + "Dodge Ratio: " + currBattle.getComputer().getBaseDodgePercent() + "% <br><br>"
                                    + "Strength: " + currBattle.getComputer().getStr() 
                                    + "Accuracy: " + currBattle.getComputer().getAcc() + "<br>"
                                    + "Speed: " + currBattle.getComputer().getSpeed()
                                    + "Skill: " + currBattle.getComputer().getSkill() + "<br>"
                                    + "Knowledge: " + currBattle.getComputer().getKnow() + "<br>";
                }
                if(CompHEALZ>0){
                    comp_move_stats += "Your opponent healed for " + CompHEALZ + " Health Points!<br>"
                                    + "Hit Ratio : " + currBattle.getComputer().getBaseHitPercent() + "% <br>"
                                    + "Crit Ratio: " + currBattle.getComputer().getBaseCritPercent() + "% <br>"
                                    + "Crit DMG: " + currBattle.getComputer().getBaseCritDmgBonus() + "DMG <br>"
                                    + "Dodge Ratio: " + currBattle.getComputer().getBaseDodgePercent() + "% <br><br>"
                                    + "Strength: " + currBattle.getComputer().getStr() 
                                    + "Accuracy: " + currBattle.getComputer().getAcc() + "<br>"
                                    + "Speed: " + currBattle.getComputer().getSpeed()
                                    + "Skill: " + currBattle.getComputer().getSkill() + "<br>"
                                    + "Knowledge: " + currBattle.getComputer().getKnow() + "<br>";
                }
            }else{
                comp_move_stats += "Your opponent missed.<br>"
                                + "Hit Ratio : " + currBattle.getComputer().getBaseHitPercent() + "% <br>"
                                + "Crit Ratio: " + currBattle.getComputer().getBaseCritPercent() + "% <br>"
                                + "Crit DMG: " + currBattle.getComputer().getBaseCritDmgBonus() + "DMG <br>"
                                + "Dodge Ratio: " + currBattle.getComputer().getBaseDodgePercent() + "% <br><br>"
                                + "Strength: " + currBattle.getComputer().getStr() 
                                + "Accuracy: " + currBattle.getComputer().getAcc() + "<br>"
                                + "Speed: " + currBattle.getComputer().getSpeed()
                                + "Skill: " + currBattle.getComputer().getSkill() + "<br>"
                                + "Knowledge: " + currBattle.getComputer().getKnow() + "<br>";
            }
            currBattle.setTurn(true);
        }        
        
        //Check if Over :: Else Process Second Side of Battle
        if(currBattle.getPlayer_curr_hp()<=0 || currBattle.getComp_curr_hp()<=0){
            if(currBattle.getPlayer_curr_hp()<=0){
                win_msg += "You've been vanquished!";
                currBattle.setPlayer_curr_hp(0);
                currBattle.setWinner(-1);
            }else{
                win_msg += "You have vanquished the enemy!";
                currBattle.setComp_curr_hp(0);
                currBattle.setWinner(1);
            }            
        }else{
            currCompHP = currBattle.getComp_curr_hp();
            currPlyrHP = currBattle.getPlayer_curr_hp();        
           
            if(currBattle.isTurn()){
                if(currBattle.doesHit()){
                    int plyrDMG;
                    if(currBattle.doesCrit()){
                        plyrDMG = currBattle.DamageDone() + currBattle.getPlayer().getBaseCritDmgBonus();                    
                    }else{
                        plyrDMG= currBattle.DamageDone();
                    }
                    int plyrHEALZ = currBattle.HealsDone();                
                    currBattle.setComp_curr_hp(currCompHP - plyrDMG);
                    currBattle.setPlayer_curr_hp(currPlyrHP + plyrHEALZ);
                    if(plyrDMG>0){
                        plyr_move_stats = "The Attack Landed! You did " + plyrDMG + " DMG! " +"<br>";
                        if(didCrit){ plyr_move_stats += "Critical Strike!"; didCrit=false; }
                        plyr_move_stats +="Hit Ratio : " + currBattle.getPlayer().getBaseHitPercent() + "% <br>"
                                        + "Crit Ratio: " + currBattle.getPlayer().getBaseCritPercent() + "% <br>"
                                        + "Crit DMG: " + currBattle.getPlayer().getBaseCritDmgBonus() + "DMG <br>"
                                        + "Dodge Ratio: " + currBattle.getPlayer().getBaseDodgePercent() + "% <br><br>"
                                        + "Strength: " + currBattle.getPlayer().getStr() 
                                        + "Accuracy: " + currBattle.getPlayer().getAcc() + "<br>"
                                        + "Speed: " + currBattle.getPlayer().getSpeed()
                                        + "Skill: " + currBattle.getPlayer().getSkill() + "<br>"
                                        + "Knowledge: " + currBattle.getPlayer().getKnow() + "<br>";
                    }
                    if(plyrHEALZ>0){
                        plyr_move_stats += "You healed for " + plyrHEALZ + " Health Points!<br>"
                                        + "Hit Ratio : " + currBattle.getPlayer().getBaseHitPercent() + "% <br>"
                                        + "Crit Ratio: " + currBattle.getPlayer().getBaseCritPercent() + "% <br>"
                                        + "Crit DMG: " + currBattle.getPlayer().getBaseCritDmgBonus() + "DMG <br>"
                                        + "Dodge Ratio: " + currBattle.getPlayer().getBaseDodgePercent() + "% <br><br>"
                                        + "Strength: " + currBattle.getPlayer().getStr() 
                                        + "Accuracy: " + currBattle.getPlayer().getAcc() + "<br>"
                                        + "Speed: " + currBattle.getPlayer().getSpeed()
                                        + "Skill: " + currBattle.getPlayer().getSkill() + "<br>"
                                        + "Knowledge: " + currBattle.getPlayer().getKnow() + "<br>";
                    }                        
                }else{
                    plyr_move_stats += "You missed.<br>"
                                    + "Hit Ratio : " + currBattle.getPlayer().getBaseHitPercent() + "% <br>"
                                    + "Crit Ratio: " + currBattle.getPlayer().getBaseCritPercent() + "% <br>"
                                    + "Crit DMG: " + currBattle.getPlayer().getBaseCritDmgBonus() + "DMG <br>"
                                    + "Dodge Ratio: " + currBattle.getPlayer().getBaseDodgePercent() + "% <br><br>"
                                    + "Strength: " + currBattle.getPlayer().getStr() 
                                    + "Accuracy: " + currBattle.getPlayer().getAcc() + "<br>"
                                    + "Speed: " + currBattle.getPlayer().getSpeed()
                                    + "Skill: " + currBattle.getPlayer().getSkill() + "<br>"
                                    + "Knowledge: " + currBattle.getPlayer().getKnow() + "<br>";
                }
                currBattle.setTurn(false);
            }else{
                if(currBattle.doesHit()){
                    int CompDMG;
                    if(currBattle.doesCrit()){
                        CompDMG = currBattle.DamageDone() + currBattle.getComputer().getBaseCritDmgBonus();                    
                    }else{
                        CompDMG= currBattle.DamageDone();
                    }   
                    int CompHEALZ = currBattle.HealsDone();
                    currBattle.setPlayer_curr_hp(currPlyrHP - CompDMG);
                    currBattle.setComp_curr_hp(currCompHP + CompHEALZ);
                    if(CompDMG>0){
                        comp_move_stats += "The Attack Landed! Your opponent did " + CompDMG + " DMG!<br>";
                        if(didCrit){ comp_move_stats += "Critical Strike!"; didCrit=false; }
                        comp_move_stats += "Hit Ratio : " + currBattle.getComputer().getBaseHitPercent() + "% <br>"
                                        + "Crit Ratio: " + currBattle.getComputer().getBaseCritPercent() + "% <br>"
                                        + "Crit DMG: " + currBattle.getComputer().getBaseCritDmgBonus() + "DMG <br>"
                                        + "Dodge Ratio: " + currBattle.getComputer().getBaseDodgePercent() + "% <br><br>"
                                        + "Strength: " + currBattle.getComputer().getStr() 
                                        + "Accuracy: " + currBattle.getComputer().getAcc() + "<br>"
                                        + "Speed: " + currBattle.getComputer().getSpeed()
                                        + "Skill: " + currBattle.getComputer().getSkill() + "<br>"
                                        + "Knowledge: " + currBattle.getComputer().getKnow() + "<br>";
                    }
                    if(CompHEALZ>0){
                        comp_move_stats += "Your opponent healed for " + CompHEALZ + " Health Points!<br>"
                                        + "Hit Ratio : " + currBattle.getComputer().getBaseHitPercent() + "% <br>"
                                        + "Crit Ratio: " + currBattle.getComputer().getBaseCritPercent() + "% <br>"
                                        + "Crit DMG: " + currBattle.getComputer().getBaseCritDmgBonus() + "DMG <br>"
                                        + "Dodge Ration: " + currBattle.getComputer().getBaseDodgePercent() + "% <br><br>"
                                        + "Strength: " + currBattle.getComputer().getStr() 
                                        + "Accuracy: " + currBattle.getComputer().getAcc() + "<br>"
                                        + "Speed: " + currBattle.getComputer().getSpeed()
                                        + "Skill: " + currBattle.getComputer().getSkill() + "<br>"
                                        + "Knowledge: " + currBattle.getComputer().getKnow() + "<br>";
                    }
                }else{
                    comp_move_stats += "Your opponent missed.<br>"
                                    + "Hit Ratio : " + currBattle.getComputer().getBaseHitPercent() + "% <br>"
                                    + "Crit Ratio: " + currBattle.getComputer().getBaseCritPercent() + "% <br>"
                                    + "Crit DMG: " + currBattle.getComputer().getBaseCritDmgBonus() + "DMG <br>"
                                    + "Dodge Ratio: " + currBattle.getComputer().getBaseDodgePercent() + "% <br><br>"
                                    + "Strength: " + currBattle.getComputer().getStr() 
                                    + "Accuracy: " + currBattle.getComputer().getAcc() + "<br>"
                                    + "Speed: " + currBattle.getComputer().getSpeed()
                                    + "Skill: " + currBattle.getComputer().getSkill() + "<br>"
                                    + "Knowledge: " + currBattle.getComputer().getKnow() + "<br>";
                }
                currBattle.setTurn(true);
            }
            
            //Check Again for Battle Completion
            if(currBattle.getPlayer_curr_hp()<=0 || currBattle.getComp_curr_hp()<=0){
                if(currBattle.getPlayer_curr_hp()<=0){
                    win_msg += "You've been vanquished!";
                    currBattle.setPlayer_curr_hp(0);
                    currBattle.setWinner(-1);
                }else{
                    win_msg += "You have vanquished the enemy!";
                    currBattle.setComp_curr_hp(0);
                    currBattle.setWinner(1);
                }                
            }
        }
        
        if(currBattle.getWinner() != 0){
            //URL = "/AfterBattle.jsp"; AJAX BUILD
            URL = "/after_battle.jsp";
            
            try{
                pool = ConnectionPool.getInstance();
                conn = pool.getConnection();
                s = conn.createStatement();

                sql = "SELECT xp." + currBattle.getDifficulty_level() 
                        + ", xp.char_xp2next, xp.char_total_xp, xp.acc_xp2next, "
                        + " xp.acc_total_xp "
                        + " FROM xp_level_chart xp "
                        + " WHERE xp.level = '" + currBattle.getPlayer().getLevel() + "' "
                        + " ORDER BY xp.level";

                r = s.executeQuery(sql);
                
                if(r.next()){
                    double char_earned_xp;
                    double acc_earned_xp;
                    if(currBattle.getWinner() != 1){
                        char_earned_xp = 1.5 * (r.getDouble(currBattle.getDifficulty_level()) * currBattle.getComputer().getLevel());
                        acc_earned_xp = 3.3 * (r.getDouble(currBattle.getDifficulty_level()) * currBattle.getComputer().getLevel());
                    }else{
                        char_earned_xp = 0.5 * (r.getDouble(currBattle.getDifficulty_level()) * currBattle.getComputer().getLevel());
                        acc_earned_xp = 3.3 * (r.getDouble(currBattle.getDifficulty_level()) * currBattle.getComputer().getLevel());
                    }
                    int charforNext = r.getInt("char_xp2next");
                    int chartotalAtNext = r.getInt("char_total_xp");
                    int accforNext = r.getInt("acc_xp2next");
                    int acctotalAtNext = r.getInt("acc_total_xp");
                    double char_current_XP = a.getActiveChamp().getExp();
                    double char_current_totalXP = a.getActiveChamp().getTotalExp();
                    double acc_current_XP = a.getAccount_exp();
                    double acc_current_totalXP = a.getAccount_total_exp();
                    exp_msg += a.getActiveChamp().getName() + " gained " + char_earned_xp + " xp!";
                    
                    char_current_XP += char_earned_xp;
                    char_current_totalXP += char_earned_xp;
                    acc_current_XP += acc_earned_xp;
                    acc_current_totalXP += acc_earned_xp;
                    a.getActiveChamp().setExp(char_current_XP);
                    a.getActiveChamp().setTotalExp(char_current_totalXP);
                    a.setAccount_exp(acc_earned_xp);
                    a.setAccount_total_exp(acc_current_totalXP);
                    
                    if(char_current_XP >= charforNext && char_current_totalXP >= chartotalAtNext){
                        int charcurrLevel = a.getActiveChamp().getLevel();
                        charcurrLevel++;
                        a.getActiveChamp().setLevel(charcurrLevel);
                        exp_msg += a.getActiveChamp().getName() + " leveled up!";
                        leveled = true;
                    }
                    
                    if(char_current_XP >= charforNext && char_current_totalXP >= chartotalAtNext){
                        int acccurrLevel = a.getAccount_level();
                        acccurrLevel++;
                        a.getActiveChamp().setLevel(acccurrLevel);
                        exp_msg += "You leveled up!";
                        
                    }
                }else{
                    err_msg = "No xp_table_data found.";
                }
                
                pool.freeConnection(conn);                
            }catch(SQLException e){
               err_msg += "SQL Error: " + e.getMessage(); 
            }catch(Exception e){
                err_msg += "General Error: " + e.getMessage();
            }
        }        
        
        request.getSession().setAttribute("currBattle", currBattle);
        request.getSession().setAttribute("acct", a);
        
        request.getSession().setAttribute("leveled", leveled);
        request.setAttribute("err_msg", err_msg);
        request.setAttribute("plyr_move_stats", plyr_move_stats);
        request.setAttribute("comp_move_stats", comp_move_stats);
        request.setAttribute("win_msg", win_msg);
        request.setAttribute("exp_msg", exp_msg);
        
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
