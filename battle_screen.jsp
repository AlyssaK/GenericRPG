<%-- 
    Document   : battle_screen
    Created on : Dec 19, 2015, 12:25:17 AM
    Author     : Alyssa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script language="javascript" type="text/javascript">
        function pageAction(action)
        {
            document.playerAction.actiontype.value=action;
            document.playerAction.submit();
        }
</script>
<html>
    <head>
        <title>Generic Role-Playing Game</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="The only place where you can embody yourself in a crudely drawn representation of some creature and fight other crudely drawn creatures in mostly text based turn-based combat." />
        <link rel="image_src" href="Images/genericRPG_Logo.png">
        <link href="PageBuild_CSS/rpg.css" rel="stylesheet" type="text/css">
        <link href="PageBuild_CSS/rpg_battle.css" rel="stylesheet" type="text/css">
        <link rel="icon" type="image/ico" href="Images/rpglogo.ico">
    </head>
    <body>
        <div id="wrapper">
            <a href="account_login.jsp"><header></header></a>
            <nav>
            <form name="ReturnHome" id="ReturnHome" action="account_login.jsp" method="get">
                <input type="submit" name="btnRetHome" id="btnRetHome" value="Home">
            </form>      
            <form name="ViewCharacters" id="ViewCharacters" action="view_character.jsp" method="get">
                <input type="submit" name="btnViewChars" id="btnViewChars" value="View Champions">
            </form>
            <form name="ViewStats" id="ViewStats" action="view_stats.jsp" method="get">
                <input type="submit" name="btnViewStats" id="btnViewStats" value="View Statistics">
            </form>      
            <form name="BattleMenu" id="BattleMenu" action="battle_menu.jsp" method="get">
                <input type="submit" name="btnBattleMenu" id="btnBattleMenu" value="Battle Menu">
            </form>
            </nav>
            <main>
            <div id="title">
                    <h2>${acct.name} has sent ${currBattle.player.name} to fight ${currBattle.computer.name}!</h2>
            </div>
            <div id="main_feed">
                <div id="opp_view">
                    <table class="battle_table">
                        <h2 id="opp_header">
                        <span class="figthter_name">${currBattle.computer.name}</span>
                        <img src="${currBattle.computer.photo_loc}" width="50" height="50" />                    
                        </h2>
                        <tr class="tbl_healthrow">
                            <td>Health:</td><td>${currBattle.comp_curr_hp} / ${currBattle.computer.healthPoints}</td>                
                        </tr>
                    </table>           
                </div>
                <div id="battle_graphic">
                    <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="250" height="175" id="menu" align="middle">
                        <param name="allowScriptAccess" value="sameDomain" />
                        <param name="movie" value="Stick_Fight.swf" />
                        <param name="quality" value="high" />
                        <param name="allowFullScreen" value="true" />
                        <embed src="Images/Stick_Fight.swf" quality="high" width="250" height="175" name="menu" align="middle" allowScriptAccess="sameDomain" allowFullScreen="true" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />
                    </object>
                </div>
                <div id="user_view">
                     <table class="battle_table">
                        <h2 id="user_header">
                        <img src="${currBattle.player.photo_loc}" width="50" height="50"/>
                        <span class="figthter_name">${currBattle.player.name}</span>
                        </h2>
                        <tr class="tbl_healthrow">
                            <td>Health:</td>
                            <td>${currBattle.player_curr_hp} / ${currBattle.player.healthPoints}</td>                
                        </tr>
                    </table>
                    <form action="ProcessTurn" name="playerAction" id="playerAction" method="post">
                         <ul>
                            <li><input type="button" name="action1"
                                    id="action1" class="battle_button" 
                                    value="${currBattle.player.charActions[0].actionName}" 
                                    onclick="pageAction('0')"></li>
                            <li><input type="button" name="action2" 
                                    id="action2" class="battle_button" 
                                    value="${currBattle.player.charActions[1].actionName}" 
                                    onclick="pageAction('1')"></li>                       
                        </ul>
                        <ul>
                            <li><input type="button" name="action3" 
                                    id="action3" class="battle_button" 
                                    value="${currBattle.player.charActions[2].actionName}" 
                                    onclick="pageAction('2')"></li>
                            <li><input type="button" name="action4" 
                                    id="action4" class="battle_button" 
                                    value="${currBattle.player.charActions[3].actionName}" 
                                    onclick="pageAction('3')"></li>
                        </ul>                            
                        <input type="hidden" name="actiontype" id="actiontype" value="">
                    </form>
                </div>
                <p>${err_msg}</p>
                <p>${plyr_move_stats}</p>
                <p>${comp_move_stats}</p>
            </div>
            </main>
        </div>
        <footer>
            <a href="site-map.html">Site-Map</a>
            <p>This website, as it relates to a website design course, is for
                    educational purposes only. It is published for a limited time for
                    grading purposes. It will be removed at the end of the course. Any
                    views and/or content are the sole responsibility of the student
                    website designer.</p>
            <p>Website modified and maintained by Alyssa Kimmich, 05/04/2015.</p>
        </footer>
    </body>
</html>
