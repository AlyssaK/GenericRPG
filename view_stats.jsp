<%-- 
    Document   : view_stats
    Created on : Dec 19, 2015, 12:25:54 AM
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
        <link href="PageBuild_CSS/rpg_view.css" rel="stylesheet" type="text/css">
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
                        <h2>Greetings ${acct.name}, Here's How Your Champions Have Fared In Battle!</h2>
                    </div>
                    <div id="main_feed">
                        <a href="#bottom" name="top" class="anchor_jump"><img src="Images/sword_anchorjump2.png" width="200" height="75" /></a>
                        <p>${msg}</p>
                        <c:forEach var="c" items="${acct.champions}">                        
                            <table class="view_table">
                                <h2 class="char_header">
                                    <img src="${c.photo_loc}" width="100" height="100" />
                                    <span class="fighter_name">${c.name}</span>
                                </h2>

                                <tr class="vtbl_hdRow">
                                        <th>Computer Difficulty:</th>
                                    <th>Wins:</th>
                                    <th>Losses:</th>
                                </tr>
                                <tr class="vtbl_dataRows">
                                    <td>Beginner:</td>
                                    <td>${c.beg_wins}</td>
                                    <td>${c.beg_losses}</td>
                                </tr>
                                <tr class="vtbl_dataRows">
                                    <td>Apprentice:</td>
                                    <td>${c.app_wins}</td>
                                    <td>${c.app_losses}</td>
                                </tr>
                                <tr class="vtbl_dataRows">
                                    <td>Master:</td>
                                    <td>${c.master_wins}</td>
                                    <td>${c.master_losses}</td>
                                </tr>
                                <tr class="vtbl_dataRows">
                                    <td>Boss:</td>
                                    <td>${c.boss_wins}</td>
                                    <td>${c.boss_losses}</td>
                                </tr>           
                            </table>
                            <br><br>
                        </c:forEach>
                        <a href="#top" name="bottom" class="anchor_jump"><img src="Images/sword_anchorjump.png" width="200" height="75" /></a>
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
