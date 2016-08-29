<%-- 
    Document   : index
    Created on : Dec 19, 2015, 12:22:52 AM
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
    <link rel="image_src" href="Images/genericRPG_Logo.png">
    <link href="PageBuild_CSS/rpg.css" rel="stylesheet" type="text/css">
    <link href="PageBuild_CSS/rpg_news.css" rel="stylesheet" type="text/css">
    <script src="Javascript/RetractLoginTab.js" ></script>
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
            <main id="main_page">
                <div id="title" class="expandable">
                    <h2>Welcome to Generic Role-Playing Game!</h2>
                </div>

                <div id="main_feed" class="expandable">
                    <a href="#bottom" name="top" class="anchor_jump"><img src="Images/sword_anchorjump2.png" width="200" height="75" /></a>
                    <div class="news_update">
                        <h2>Update as of 12/26-27/2015 (10:17 PM)</h2>
                        <p>I've finished the better part of Servlet and Class structure
                            for this website. The databases are created, and the user can
                            login by querying the database for a account name and password.
                            They can view all of their characters and statistics.
                            Create New Characters.
                            A New Account can be created and added to the database.
                            And the servlet to load the battle into the Battle class object is built, not tested yet.
                            Not yet tested for bad data entry, but safeguards have been built.
                            Adjustments were made to the html (now jsp) pages to display data
                            from the request objects sent by the servlets, and css was edited
                            for minor differences in tags.
                            My new computer has a larger monitor, so I adjusted some of the css
                            and built a new display shell for the page design at 1990 resolution.
                        </p>
                        <br><br>
                    </div>
                    <div class="news_update">
                        <h2>Update as of 12/26-27/2015 (10:17 PM)</h2>
                        <p>
                            I've finished the better part of Servlet and Class structure
                            for this website. The databases are created, and the user can
                            login by querying the database for a account name and password.
                            They can view all of their characters and statistics.
                            Create New Characters.
                            A New Account can be created and added to the database.
                            And the servlet to load the battle into the Battle class object is built, not tested yet.
                            Not yet tested for bad data entry, but safeguards have been built.
                            Adjustments were made to the html (now jsp) pages to display data
                            from the request objects sent by the servlets, and css was edited
                            for minor differences in tags.
                            My new computer has a larger monitor, so I adjusted some of the css
                            and built a new display shell for the page design at 1990 resolution.
                        </p>
                        <br><br>
                    </div>
                    <div class="news_update">
                        <h2>Update as of 5/15/2015 (4:45PM)</h2>
                        <p>The Battle Screen is Finished! (At least as far as the first design iteration,
                            given background coding in the future, won't make me have to rethink the display.)
                            I added a @media only screen attribute to help with layout distortion for screens
                            less then 1440 pixel width. (That's what mine is.) 
                            So it should handle 1280 pixel width adequately. 
                            As suggested by my mother, I redid the anchor jump sword,
                            so hopefully it looks less like a syringe now. 
                            It has also been added to the view character/stats pages
                            given live a player account could have well over the 4
                            sample characters I put in.
                        </p>
                        <br><br>
                    </div>
                    <div class="news_update">
                    <h2>Update as of 5/10/2015 (3:22 AM)</h2>
                                <p>I've finished building most the design aspects, except for the battle screen. I'm not quite sure what else to create external links to so I'll use this update as a shout-out to a few of the sites that I go to a lot for help with debugging & coding.</p>
                        <ol>
                            <li><a href="http://www.w3schools.com/" target="_blank">W3 Schools</a>
                                &nbsp;-&nbsp;Go to reference for tag and attribute names.</li>
                            <li><a href="http://stackoverflow.com/" target="_blank">Stack Overflow</a>
                                &nbsp;-&nbsp;Good community of programmers with tons of threads on bugs and errors others have encountered and how they were solved.</li>
                            <li><a href="http://www.ffiles.com/" target="_blank">FFiles</a>
                                &nbsp;-&nbsp;Collection of mostly free flash files uploaded by members.</li>
                            <li><a href="https://www.youtube.com/" target="_blank">YouTube</a>
                                &nbsp;-&nbsp;Other then the silly cat video I added. There are some good tutorials I've used on there before to do certain code.</li>
                        </ol>
                        <br><br>
                    </div>
                    <div class="news_update">
                        <h2>Update as of 5/6/2015 (5:47 AM)</h2>
                        <p><span class="update_highlight">I got the first 6 char_icons finished!</span></p>
                        <ul id="image_list">
                            <li>American Guy:<br>
                                <img width="100px" height="100px" src="Images/CharacterIcons/americanguy.jpg" /></li>
                            <li>Disco Dude:<br>
                                <img width="100px" height="100px" src="Images/CharacterIcons/discodude.jpg" /></li>
                            <li>Inconspicuous Flower:<br>
                                <img width="100px" height="100px" src="Images/CharacterIcons/inconspicuousflower.jpg" /></li>
                            <li>Scary Dragon:<br>
                                <img width="100px" height="100px" src="Images/CharacterIcons/scarydragon.jpg" /></li>
                            <li>Silly Snail:<br>
                                <img width="100px" height="100px" src="Images/CharacterIcons/sillysnail.jpg" /></li>
                            <li>Tricky Cat:<br>
                                <img width="100px" height="100px" src="Images/CharacterIcons/trickycat.jpg" /></li>
                        </ul>
                        <br><br>
                    </div>
                    <div class="news_update">
                        <h2>Update as of 5/6/2015 (4:54 AM)</h2>
                        <p>Successfully did the things I said I finished in yesterday's (8 hours ago) update.
                        <br><span class="update_highlight">Here's a cat video<br>There will be no Cat Boss... ; )</span></p>
                        <iframe width="350" height="209" src="https://www.youtube.com/embed/_ifYax8Smoc" frameborder="0" allowfullscreen></iframe>
                        <br><br>
                    </div>
                    <div class="news_update">
                        <h2>Update as of 5/5/2015</h2>
                        <p>Talked with Professor Kahan today, and decided to not include the back-end
                        code with this project. This will focus on aesthetic aspects of the site. So..
                        <br><span class="update_highlight">Here's what I accomplished today:</span></p>
                        <ul>
                            <li><span style="top:-5px; position:relative;">Built Table Design for View Stats & View Characters</span></li>
                            <li><span style="top:-5px; position:relative;">Restructured ScrollView & Title Area of General Frame</span></li>
                            <li><span style="top:-5px; position:relative;">Built Battle Menu & Battle Screen Layout</span></li>
                            <li><span style="top:-5px; position:relative;">Moved to Eclipse...useless for the time being though...</span></li>
                        </ul>
                        <br><br>
                    </div>
                    <div class="news_update">
                        <h2>Update as of 5/4/2015</h2>
                        <p>Got a good general layout for the main page, and it should be
                                easy to transfer it to the support pages. I have the general layout
                                in mind, and the structure building in NetBeans. Tomorrow, I'm
                                planning more work in the morning, then run it past Prof. Kahan.</p>
                        <br><br>
                    </div>
                    <a href="#top" name="bottom" class="anchor_jump"><img src="Images/sword_anchorjump.png" width="200" height="75" /></a>
                </div>
                <div id="login" class="showable">
                    <form action="AccountLogin" method="post">
                        <h3>Login to Begin!</h3>
                        <span class="login_lbl">&nbsp; Account:</span>
                        <input type="text" name="acct_name" id="acct_name" required 
                               value="${empty acct.name ? cookie.acctName.value : acct.name }">
                        <br><br>
                        <span class="login_lbl">Password:</span>
                        <input type="password" name="password" id="password" required>
                        <br><br>
                        <input type="submit" id="login_button" value="Log In!">                     
                     </form>
                    <br>
                    <p>${msg}</p>
                    <c:if test="${acct.accountAuthen}">
                        <p>Welcome, ${acct.name}!</p>
                    </c:if>
                    <a href="create_account.jsp">Not a Member?<br>Click Here to Sign Up!</a>
                </div>          
            <a href="#" id="close">Close Login Tab</a>     
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
