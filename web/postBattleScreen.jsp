<%-- 
    Document   : after_battle
    Created on : Dec 27, 2015, 10:02:44 PM
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
        <link rel="image_src" href="images/genericRPG_Logo.png">
        <link href="style/rpg.css" rel="stylesheet" type="text/css">
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
                    <h2>${acct.name}, ${win_msg}!</h2>
                </div>
                <div id="main_feed">
                    <p>${exp_msg}</p>                 
                    <p>${win_msg}</p>
                    <p>${err_msg}</p>
                    <form action="UpdateChampion" method="post">                        
                        <c:if test="${clvl}">
                            <h2>You have leveled!!!</h2>
                            <h3>You have 25 points to distribute amongst the 5 attributes.</h3>
                            <table>
                                <tr>
                                    <td>Character Name: ${acct.activeChamp.name}</td>                               
                                </tr>
                                <tr>
                                    <td>Strength:</td>
                                    <td><input type="number" name="strength" 
                                               id="strength" min="0" max="25" 
                                               required></td>
                                    <td>This determines how damaging your attacks will be to enemy.</td>
                                </tr>
                                <tr>
                                    <td>Accuracy:</td>
                                    <td><input type="number" name="accuracy" 
                                               id="accuracy" min="0" max="25"
                                               required></td>
                                    <td>This determines how often you will land a hit against the enemy.</td>
                                </tr>
                                <tr>
                                    <td>Speed:</td>
                                    <td><input type="number" name="speed" id="speed"
                                               min="0" max="25" required></td>
                                    <td>This determines who goes first, as well as how likely you are to dodge an enemy attack.</td>
                                </tr>
                                <tr>
                                    <td>Skill:</td>
                                    <td><input type="number" name="skill" id="skill"
                                               min="0" max="25" required></td>
                                    <td>This determines how often you can land and avoid skill strikes.</td>
                                </tr>
                                <tr>
                                    <td>Knowledge:</td>
                                    <td><input type="number" name="knowledge" 
                                               id="knowledge" min="0" max="25" 
                                               required></td>
                                    <td>This determines how well you're able to block enemy attacks reducing their base damage.</td>
                                </tr>
                            </table>
                        </c:if>
                        <input type="submit" name="updateChamp" id="updateChamp" class="form_button" value="Conclude Battle">
                    </form>
                </div>
            </main>
        </div>
        <footer>
            <p>This website, as it relates to a website design course, is for
                    educational purposes only. It is published for a limited time for
                    grading purposes. It will be removed at the end of the course. Any
                    views and/or content are the sole responsibility of the student
                    website designer.</p>
            <p>Website modified and maintained by Alyssa Kimmich, 10/18/2016.</p>
        </footer>
    </body>
</html>
