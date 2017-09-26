<%-- 
    Document   : create_account
    Created on : Dec 19, 2015, 12:25:25 AM
    Author     : Alyssa
--%>

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
    <link rel="image_src" href="images/genericRPG_Logo.png" / >
    <link href="style/rpg.css" rel="stylesheet" type="text/css">
    <link href="style/rpg_create.css" rel="stylesheet" type="text/css">v
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
        <!-- TITLE DIV BOX !-->
            <div id="title">
                <h2>Greetings New Master,<br>Ready to Start Your Button Clicking Adventure?</h2>
            </div>
        <!-- END TITLE DIV BOX !-->
        
        <!-- MAIN FEED DIV BOX !-->
            <div id="main_feed">
                <div class="news_update" id="messageBlock">
                    <h2>Error Messages</h2>
                    <p>${msg}</p>
                </div>
                <s:form action="AccountCreate" method="post">
                    <h3>Enter the Information Below to Register for an Account!</h3>
                    <p>* Only required if an email newsletter is desired.</p>
                    <table>
                        <tr>                            
                            <td><s:textfield name="acct_name" id="acct_name" label="Desired Account Name: " required="true" /></td>
                        </tr>
                        <tr>
                            <td><s:password  name="password1" id="password1" label="Password:" required="true" /></td>
                        </tr>
                        <tr>
                            <td><s:password  name="password2" id="password2" label="Password:" required="true" /></td>
                        </tr>
                        <tr>
                            <td><s:textfield name="email" id="email" label="Email Address" /></td>                            
                        </tr>
                    </table>
                    <s:submit name="createAccount" id="createAccount" class="form_button" value="Create!" />                     
                </s:form>
            </div>
        <!-- END MAIN FEED DIV BOX !-->
        </main>
    <!-- END MAIN DIV BOX !-->
    </div>
<!-- END WRAPPER DIV BOX !-->

<!-- FOOTER DIV BOX !-->
        <footer>
            <p>This website, as it relates to a website design course, is for
                    educational purposes only. It is published for a limited time for
                    grading purposes. It will be removed at the end of the course. Any
                    views and/or content are the sole responsibility of the student
                    website designer.</p>
            <p>Website modified and maintained by Alyssa Kimmich, 10/18/2016.</p>
        </footer>
<!-- END FOOTER DIV BOX !-->
</body>
</html>
