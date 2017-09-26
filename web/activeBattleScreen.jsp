<%-- 
    Document   : battle_screen
    Created on : Dec 19, 2015, 12:25:17 AM
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
    <link href="style/rpg_battle.css" rel="stylesheet" type="text/css">
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
    <style>
        #compHPBar {
            width: (${battle.compHP}/${battle.computer.healthPoints})%;           
        }
        #plyrHPBar {
            width: (${battle.playerHP}/${battle.computer.healthPoints})%;
        }            
    </style>
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
                
        <!-- TITLE DIV BOX !-->
            <div id="title">
                <h2>${acct.name} has sent ${battle.player.name} to fight ${battle.computer.name}!</h2>
            </div>
        <!-- END TITLE DIV BOX !-->    
        
        <!-- MAIN FEED DIV BOX !-->
            <div id="main_feed">
                
            <!-- OPPONENT VIEW DIV BOX !-->
                <div id="opp_view">
                    <table class="battle_table">
                        <h2 id="opp_header">
                        <span class="figthter_name">${battle.computer.name}</span>
                        <img src="${battle.computer.portrait}" width="100" height="100" />                    
                        </h2>
                        <tr class="tbl_healthrow">
                            <td>Health: ${compPercentHP}</td>
                            <td class="hp_wrapper">
                                <div id="compHPBar">${battle.compHP} / ${battle.computer.healthPoints}</div>
                            </td>
                        </tr>
                    </table>           
                </div>          
            <!-- END OPPONENT VIEW DIV BOX !-->
            
            <!-- USER VIEW DIV BOX !-->
                <div id="user_view">
                     <table class="battle_table">
                        <h2 id="user_header">
                        <img src="${battle.player.portrait}" width="100" height="100"/>
                        <span class="figthter_name">${battle.player.name}</span>
                        </h2>
                        <tr class="tbl_healthrow">
                            <td>Health: ${plyrPercentHP}</td>
                            <td class="hp_wrapper">
                                <div id="plyrHPBar"> ${battle.playerHP} / ${battle.player.healthPoints}</div>
                            </td>                
                        </tr>
                    </table>
                    <s:form action="TurnBattle" method="post">         
                         <div id="buttonWrap">
                             <input type="submit" name="action1"
                                    id="action1" class="battle_button" 
                                    value="${battle.moves[0].name}" >
                             <input type="submit" name="action2" 
                                    id="action2" class="battle_button" 
                                    value="${battle.moves[1].name}">
                             <input type="submit" name="action3" 
                                    id="action3" class="battle_button" 
                                    value="${battle.moves[2].name}" >
                             <input type="submit" name="action4" 
                                    id="action4" class="battle_button" 
                                    value="${battle.moves[3].name}" >
                         </div>                        
                    </s:form>
                </div>
                <!-- END USER VIEW DIV BOX !-->               
                <br><br>
                
                <!-- BATTLE TEXT DIV BOX !-->
                <div id="battle_text">
                    <p>${msg}</p>
                <div>
                <!-- END BATTLE TEXT DIV BOX !-->
            
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
<!-- FOOTER DIV BOX !-->
</body>
</html>
