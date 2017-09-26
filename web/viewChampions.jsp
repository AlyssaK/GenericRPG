<%-- 
    Document   : view_character
    Created on : Dec 19, 2015, 12:25:43 AM
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
            <c:if test="${account.accountAuthen}">
                <p>Welcome, ${account.name}!</p>
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
                    <h2>Greetings ${account.name}, These Are Your Champions' Attributes!</h2>
                </div>

                <div id="main_feed">                       
                    <div class="news_update" id="messageBlock">
                        <h2>Error Messages</h2>
                        <p>${msg}</p>
                    </div>                       
                    <a href="createChampion.jsp"><button name="newChar" id="newChar" class="form_button">New Champion!</button></a>                        
                    <s:iterator value="#session['account'].champions">
                        <table class="view_table">
                            <h2 class="char_header">
                                <a name="<s:property value="name" />">
                                    <img src="<s:property value="portrait" />" width="100" height="100" />
                                    <span class="fighter_name"><s:property value="name" /></span>
                                </a>
                            </h2>
                            <input type="hidden" name="champID" id="champID" value="<s:property value="id" />">                            
                            <tr class="vtbl_dataRows">
                                <td>Level:</td>
                                <td><s:property value="levelz" /></td>                                  
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Experience:</td>
                                <td><s:property value="exp" /></td>
                                <td>Experience Needed For Next:</td>
                                <td><s:property value="expAtNext" /></td>
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Total Experience:</td>
                                <td><s:property value="totalExp" /></td>
                                <td>Total Experience For Next:</td>
                                <td><s:property value="totalExpAtNext" /></td>
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Health:</td>
                                <td><s:property value="healthPoints" /></td>

                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Strength:</td>
                                <td><s:property value="strength" /></td> 
                                <td>Move 1:</td>
                                <td><s:property value="move1.name" /></td>
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Accuracy:</td>
                                <td><s:property value="accuracy" /></td>
                                <td>Move 2:</td>
                                <td><s:property value="move2.name" /></td>
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Speed:</td>
                                <td><s:property value="speed" /></td>
                                <td>Move 3:</td>
                                <td><s:property value="move3.name" /></td>
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Skill:</td>
                                <td><s:property value="skill" /></td>
                                <td>Move 4:</td>
                                <td><s:property value="move4.name" /></td>
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Knowledge:</td>
                                <td><s:property value="knowledge" /></td>                                    
                            </tr>
                        </table><br>                                        
                        <table class="view_table">                                    
                            <tr class="vtbl_hdRow">
                                <th>Computer Difficulty:</th>
                                <th>Wins:</th>
                                <th>Losses:</th>
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Beginner:</td>
                                <td><s:property value="beg_wins" /></td>
                                <td><s:property value="beg_losses" /></td>
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Apprentice:</td>
                                <td><s:property value="app_wins" /></td>
                                <td><s:property value="app_losses" /></td>
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Master:</td>
                                <td><s:property value="master_wins" /></td>
                                <td><s:property value="master_losses" /></td>
                            </tr>
                            <tr class="vtbl_dataRows">
                                <td>Boss:</td>
                                <td><s:property value="boss_wins" /></td>
                                <td><s:property value="boss_losses" /></td>
                            </tr>                            
                        </table>
                        <br><br>
                    </s:iterator>
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
