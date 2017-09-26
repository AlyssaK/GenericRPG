<%-- 
    Document   : create_character
    Created on : Dec 19, 2015, 12:25:35 AM
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
        <link href="style/rpg_create.css" rel="stylesheet" type="text/css">
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
                    <h2>Greetings ${acct.name},<br>Systems are Prepared for Production of a New Fighter.</h2>
                </div>
                <div id="main_feed">
                    <div class="news_update" id="messageBlock">
                        <h2>Error Messages</h2>
                        <p>${msg}</p>
                    </div>
                    <s:form action="ChampionCreate" method="post" >
                        <h3>You have 25 points to distribute amongst the 5 attributes.</h3>
                        <s:textfield label="Character Name" name="name" id="name" required="true" />
                        <s:textfield label="Strength" name="strength" id="strength" required="true" />
                        <s:textfield label="Accuracy" name="accuracy" id="accuracy" required="true" />
                        <s:textfield label="Speed" name="speed" id="speed" required="true" />
                        <s:textfield label="Skill" name="skill" id="skill" required="true" />
                        <s:textfield label="Knowledge" name="knowledge" id="knowledge" required="true" />                                           
                        <div id="portrait_select">                            
                            <label class="selectIcon">
                                <input type="radio" name="portrait" id="portrait" value="images/icons/americanguy.jpg" checked>
                                <img src="images/icons/americanguy.jpg" width="100" height="100" />                                
                            </label>
                            <label class="selectIcon">
                                <input type="radio" name="portrait" id="portrait" value="images/icons/discodude.jpg">
                                <img src="images/icons/discodude.jpg" width="100" height="100" />                                
                            </label>
                            <label class="selectIcon">
                                <input type="radio" name="portrait" id="portrait" value="images/icons/inconspicuousflower.jpg">
                                <img src="images/icons/inconspicuousflower.jpg" width="100" height="100" />                                
                            </label>
                            <label class="selectIcon">
                                <input type="radio" name="portrait" id="portrait" value="images/icons/scarydragon.jpg">
                                <img src="images/icons/scarydragon.jpg" width="100" height="100" />                                
                            </label>
                            <label class="selectIcon">
                                <input type="radio" name="portrait" id="portrait" value="images/icons/sillysnail.jpg">
                                <img src="images/icons/sillysnail.jpg" width="100" height="100" />                                
                            </label>
                            <label class="selectIcon">
                                <input type="radio" name="portrait" id="portrait" value="images/icons/spookywitch.jpg">
                                <img src="images/icons/spookywitch.jpg" width="100" height="100" />                                
                            </label>
                            <label class="selectIcon">
                                <input type="radio" name="portrait" id="portrait" value="images/icons/stupidhorse.jpg">
                                <img src="images/icons/stupidhorse.jpg" width="100" height="100" />                                
                            </label>
                            <label class="selectIcon">
                                <input type="radio" name="portrait" id="portrait" value="images/icons/trickycat.jpg">
                                <img src="images/icons/trickycat.jpg" width="100" height="100" />                                
                            </label>
                        </div>                        
                        <s:submit name="createChar" id="createChar" class="form_button" value="Create!" />
                    </s:form>               
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
