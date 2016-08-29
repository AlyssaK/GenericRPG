<%-- 
    Document   : create_character
    Created on : Dec 19, 2015, 12:25:35 AM
    Author     : Alyssa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Generic Role-Playing Game</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="The only place where you can embody yourself in a crudely drawn representation of some creature and fight other crudely drawn creatures in mostly text based turn-based combat." />
        <link rel="image_src" href="Images/genericRPG_Logo.png" / >
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
                    <h2>Greetings ${acct.name},<br>Systems are Prepared for Production of a New Fighter.</h2>
                </div>
                <div id="main_feed">
                    <p>${msg}</p>                        
                    <form action="CharacterCreate" method="post">
                        <h3>You have 25 points to distribute amongst the 5 attributes.</h3>
                        <table>
                            <tr>
                                <td>Character Name:</td>
                                <td><input type="text" name="char_name" id="char_name" required></td>
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
                        <div id="portrait_select">
                            <img src="Images/CharacterIcons/americanguy.jpg" width="100" height="100" />
                            <input type="radio" name="photo" id="photo" value="amguy" checked>                        
                            <img src="Images/CharacterIcons/discodude.jpg" width="100" height="100" />
                            <input type="radio" name="photo" id="photo" value="disco">
                            <img src="Images/CharacterIcons/inconspicuousflower.jpg" width="100" height="100" />
                            <input type="radio" name="photo" id="photo" value="flower">
                            <img src="Images/CharacterIcons/scarydragon.jpg" width="100" height="100" />
                            <input type="radio" name="photo" id="photo" value="dragon">
                            <img src="Images/CharacterIcons/sillysnail.jpg" width="100" height="100" />
                            <input type="radio" name="photo" id="photo" value="snail">
                            <img src="Images/CharacterIcons/spookywitch.jpg" width="100" height="100" />
                            <input type="radio" name="photo" id="photo" value="witch">
                            <img src="Images/CharacterIcons/stupidhorse.jpg" width="100" height="100" />
                            <input type="radio" name="photo" id="photo" value="horse">
                            <img src="Images/CharacterIcons/trickycat.jpg" width="100" height="100" />
                            <input type="radio" name="photo" id="photo" value="cat">
                        </div>
                        <input type="submit" name="submit_button" id="submit_button" value="Submit!">
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
