<%-- 
    Document   : battle_menu
    Created on : Dec 19, 2015, 12:24:01 AM
    Author     : Alyssa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script language="javascript" type="text/javascript">
        function pageAction(action)
        {
            document.battle.actiontype.value=action;
            document.battle.submit();
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
        <c:if test="${!acct.accountAuthen}">
            <script type="text/javascript">
                window.location = "/GenericRPG/NotAuthenticatedReturnToMainServlet";
            </script>
        </c:if>
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
                    <h2>Greetings ${acct.name}, Select a Manufacturing Standard for Queue:</h2>
            </div>
            <p>${msg}</p>
            <div id="main_feed">	
                <form action="LoadBattle" name="battle" id="battle" method="post">
                    <div id="portrait_select">
                        <c:forEach var="c" items="${acct.champions}">
                            <img src="${c.photo_loc}" 
                                 width="100" height="100" />
                            <a href="view_character.jsp#${c.name}">
                                ${c.name}</a>
                            <input type="radio" name="active" id="active" 
                                   value="${c.id}" 
                                   ${c.id == acct.activeChamp.id ? ' checked ' : ' '}>
                        </c:forEach>
                    </div>

                    <input type="button" name="beginner" id="beginner" 
                           class="fight_button" value="Beginner!" 
                           onclick="pageAction('beginner')">
                    <input type="button" name="apprentice" id="apprentice" 
                           class="fight_button" value="Apprentice!" 
                           onclick="pageAction('apprentice')">
                    <input type="button" name="master" id="master" 
                           class="fight_button" value="Master!" 
                           onclick="pageAction('master')">
                    <input type="button" name="boss" id="boss" 
                           class="fight_button" value="Boss!" 
                           onclick="pageAction('boss')"> 

                    <input type="hidden" name="actiontype" id="actiontype" value="">
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
