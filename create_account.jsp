<%-- 
    Document   : create_account
    Created on : Dec 19, 2015, 12:25:25 AM
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
                    <h2>Greetings New Master,<br>Ready to Start Your Button Clicking Adventure?</h2>
                </div>
                <div id="main_feed">
                    <form action="AccountCreate" method="post">
                        <h3>Enter the Information Below to Register for an Account!</h3>
                        <p>* Only required if an email newsletter is desired.</p>
                        <table>
                        <tr>
                            <td>Desired Account Name:</td>
                            <td><input type="text" name="acct_name" id="acct_name" required></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" id="password" required></td>
                        </tr>
                        <tr>
                            <td>Confirm Password:</td>
                            <td><input type="password" name="passwordc" id="passwordc" required></td>
                        </tr>
                        <tr>
                            <td>*Email Address:</td>
                            <td><input type="email" name="email" id="email"></td>                            
                        </tr>
                        </table>
                        <input type="submit" id="submit_button" value="Submit!">                     
                    </form>
                    <p>${msg}</p>
                </div>
                    </main>
            </div>
            <footer>
            <a href="site-map">Site-Map</a>
                    <p>This website, as it relates to a website design course, is for
                            educational purposes only. It is published for a limited time for
                            grading purposes. It will be removed at the end of the course. Any
                            views and/or content are the sole responsibility of the student
                            website designer.</p>
                    <p>Website modified and maintained by Alyssa Kimmich, 05/04/2015.</p>
            </footer>
    </body>
</html>
