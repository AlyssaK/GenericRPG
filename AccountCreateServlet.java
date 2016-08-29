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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Alyssa
 */
public class AccountCreateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //String URL = "/BaseFrame.jsp"; AJAX BUILD
        String URL = "/account_login.jsp";
        String msg = "";
        String sql;
        
        ConnectionPool pool;
        Connection conn;
        Statement s;
        ResultSet r;
        
        Account a = new Account();        
        
        String name_attempt = request.getParameter("acct_name");
        String password = request.getParameter("password");
        String check_password = request.getParameter("passwordc");
        String email;
        
        if(!request.getParameter("email").isEmpty()){
            email = request.getParameter("email");
        }else{
            email = "null";
        }
        
        if(password.equalsIgnoreCase(check_password)){       
            try{            
                pool = ConnectionPool.getInstance();
                conn = pool.getConnection();
                s = conn.createStatement();           

                sql = "SELECT * FROM account WHERE account_name = '" + name_attempt + "' ";

                r = s.executeQuery(sql);

                if(r.next()) {                
                    msg += "Error: Account Name Has Already Been Chosen! <br>";
                    URL = "/create_account.jsp";
                }else{
                    pool.freeConnection(conn);
                    
                    pool = ConnectionPool.getInstance();
                    conn = pool.getConnection();
                    
                    sql = "INSERT INTO account (account_name, account_password, account_email) " +
                                "VALUES ( ? , ? , ? ) ";
                    
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, name_attempt);
                    ps.setString(2, password);
                    ps.setString(3, email);
                    
                    int rc = ps.executeUpdate();
                    pool.freeConnection(conn);

                    if(rc == 0){
                        msg += "Account Creation Failed! <br>";
                        URL = "/create_account.jsp";
                    }else if(rc == 1){
                        msg += "Account Successfully Created! <br>";                        
                    }else{
                        msg += "Warning: " + rc + " records changed. Check Database. <br>";                        
                    }                  
                }
                
                pool.freeConnection(conn);            
            }catch(SQLException e){
                msg += "SQLError: " + e.getMessage() + "<br>";
                URL = "/create_account.jsp";
            }catch(Exception e){
                msg += "GeneralError: " + e.getMessage() + "<br>";
                URL = "/create_account.jsp";
            }
        }else{
            msg += "Error: Passwords Do Not Match";
            //URL = "/CreateAccount.jsp"; AJAX BUILD
            URL = "/create_account.jsp";
        }       
        
        request.setAttribute("msg", msg);
        
        Cookie uid = new Cookie("acctName", name_attempt);
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

}
