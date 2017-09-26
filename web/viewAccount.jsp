
<%-- 
    Document   : view_account.jsp
    Created on : Aug 30, 2016, 11:46:11 PM
    Author     : Alyssa
--%>

<%@page import="business.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Generic Role-Playing Game</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="The only place where you can embody yourself in a crudely drawn representation of some creature and fight other crudely drawn creatures in mostly text based turn-based combat." />
        <link rel="image_src" href="images/genericRPG_Logo.png">
        <link href="style/rpg.css" rel="stylesheet" type="text/css">
        <link href="style/rpg_view.css" rel="stylesheet" type="text/css">
        <link href="style/rpg_news.css" rel="stylesheet" type="text/css">
        <link rel="icon" type="image/ico" href="images/rpglogo.ico">
        <link type="text/css" href="style/jquery.jscrollpane.css" rel="stylesheet" media="all" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="script/jquery.mousewheel.js"></script>
        <script type="text/javascript" src="script/jquery.jscrollpane.min.js"></script>
        <script language="javascript" type="text/javascript">
            $(function()
                    {
                    $('#main_feed').jScrollPane();
                });
        </script>
    </head>
    <body>
        <c:if test="${!account.accountAuthen}">
            <script type="text/javascript">
                window.location = "/GenericRPG-Struts2/";
            </script>
        </c:if>
        <!-- LOGIN DIV BOX !-->
	<div id="login">                
                <s:form action="AccountLogin" method="post">         
                    <h3>Login to Begin!</h3>
                    <span class="login_lbl">
                        <s:textfield name="acct_name" label="User ID:" required="true" />
                    </span>
                    <br><br>
                    <span class="login_lbl">
                        <s:password name="pattempt" id="password" label="Password:" required="true" />
                    </span>
                    <br><br>
                    <s:submit id="login_button" value="Log In!" />                
                </s:form>                
            <br>                        
            <c:if test="${acct.accountAuthen}">
                <p>Welcome, ${acct.name}!</p>
            </c:if>
            <a href="createAccount.jsp">Not a Member?<br>Click Here to Sign Up!</a>
        </div>
<!-- END LOGIN DIV BOX !-->

<!-- WRAPPER DIV BOX !-->
        <div id="wrapper">
            
    <!-- HEADER BOX !-->
            <a href="homeAccount.jsp"><header></header></a>
    <!-- END HEADER BOX !-->
            
    <!-- NAV DIV BOX !-->
            <nav>
                <a href="homeAccount.jsp">Home</a>
                <a href="viewChampions.jsp">View Champions</a>
                <a href="viewAccount.jsp">View Account</a>
                <a href="selectBattleScreen.jsp">Battle Menu</a>
                <a href="createAction.jsp">Create Action</a>                               
            </nav>
    <!-- END NAV DIV BOX !-->
            
    <!-- MAIN DIV BOX !-->
            <main>
                <div id="title">
                    <h2>Greetings ${acct.name}, View & Update Your Account Info!</h2>
                </div>
                <div id="main_feed">
                    <s:form action="AccountUpdate" method="post">    
                        <input type="hidden" name="account.accountID" value="<s:property value="#session['account'].accountID" />" >
                        <input type="hidden" name="account.accountActiveChampID" value="<s:property value="#session['account'].accountActiveChampID" />" >
                        <input type="hidden" name="account.accountPrivileges" value="<s:property value="#session['account'].accountPrivileges" />" >
                        <input type="hidden" name="account.accountOnline" value="<s:property value="#session['account'].accountOnline" />" >
                        <div class="news_update" id="messageBlock">
                            <h2>Error Messages</h2>
                            <p>${msg}</p>
                        </div>
                        <table class="view_table">
                        <tr class="vtbl_dataRows">
                            <td>Account Name:</td>
                            <td><input type="text" name="account.name" 
                                    value="<s:property value="#session['account'].name" />"
                                    readonly="true"</td>
                            <td>Account Level:</td>
                            <td><s:property value="#session['account'].level" /></td>
                        </tr>
                        <tr class="vtbl_dataRows">
                            <td>Change Password:</td>
                            <td><input type="password" name="account.password"
                                       value="<s:property value="#session['account'].password" />"></td>
                            <td>Confirm Password:</td>
                            <td><input type="password" name="account.pwdAttempt"
                                       value="<s:property value="#session['account'].pwdAttempt" />"></td>
                        </tr>
                        <tr class="vtbl_dataRows">                 
                            <td>Experience:</td>
                            <td><input type="text" name="account.exp"
                                       value="<s:property value="#session['account'].exp" />" readonly="true"></td>
                            <td>Experience Needed For Next:</td>
                            <td><input type="text" name="account.expAtNext"
                                       value="<s:property value="#session['account'].expAtNext" />"></td>
                        </tr>
                        <tr class="vtbl_dataRows">
                            <td>Total Experience:</td>
                            <td><input type="text" name="account.totalExp"
                                       value="<s:property value="#session['account'].totalExp" />"></td>
                            <td>Total Experience For Next:</td>
                            <td><input type="text" name="account.totalExpAtNext"
                                       value="<s:property value="#session['account'].totalExpAtNext" />"></td>
                        </tr>
                        <tr class="vtbl_dataRows">
                            <td>*Email Address:</td>
                            <td><input type="text" name="account.email"
                                       value="<s:property value="#session['account'].email" />"></td>                            
                        </tr>
                        </table>
                        <s:submit name="updateAccount" id="updateAccount" class="form_button" value="Update!" />                     
                    </s:form>
                    <br><br>
                    <s:form action="PostCreate" method="post">
                        <div id="postBox">
                            <h3>Post to News Feed</h3>
                            <s:textarea id="text" name="text" label="Write Your Text Here"/>
                            <s:submit  id="postTo" class="form_button" value="Post!" />
                        </div>
                    </s:form>
                </div>
            </main>
        </div>
        <footer>
            <p>This website, as it relates to a website design course, is for
                    educational purposes only. It is published for a limited time for
                    grading purposes. It will be removed at the end of the course. Any
                    views and/or content are the sole responsibility of the student
                    website designer.
            </p>
            <p>Website modified and maintained by Alyssa Kimmich, 10/18/2016.</p>
        </footer>
    </body>
</html>
