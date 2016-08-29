<%-- 
    Document   : after_battle
    Created on : Dec 27, 2015, 10:02:44 PM
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
        <link href="PageBuild_CSS/rpg_create.css" rel="stylesheet" type="text/css">
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
                    <h2>${acct.name}, ${win_msg}!</h2>
                </div>
                <div id="main_feed">
                    <p>${exp_msg}</p>                 
                    <p>${win_msg}</p>
                    <p>${err_msg}</p>
                    <p>${act_msg}</p>
                    <form action="UpdateChampion" method="post">                        
                        <c:if test="${leveled}">
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
                        <input type="submit" name="submit_button" id="submit_button" value="Conclude Battle">
                    </form>
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
