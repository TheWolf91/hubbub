<!doctype html>
<html ${pageProperty(name: 'page.htmlAttrs')}>
<head>
    <title>Hubbub &raquo; <g:layoutTitle default="Welcome" /></title>
    <asset:stylesheet src="application.css"/>
    <g:external dir="css" file="bootstrap.min.css"/>
    <g:external dir="css" file="main.css"/>
    <asset:javascript src="application"/>
</head>
<body>
<div>
    <div id="hd">
        <g:link uri="/">
            <g:img id="logo" dir="images" file="headerlogo.png" alt="hubbub logo"/>
        </g:link>
    </div>
    <nav class="nav navbar">
        <ul>
            <li><g:link controller="post" action="personal">My Timeline</g:link></li>
            <li><g:link controller="post" action="global">Global Timeline</g:link></li>
            <li><g:link controller="user" action="search">Search</g:link></li>
            <li><g:link controller="user" action="advSearch">Advanced Search</g:link></li>
            <li><g:link controller="user" action="register">Register</g:link></li>

        </ul>
        <sec:ifLoggedIn>
            <g:form name="logoutForm" controller="logout" action="index">
                <g:submitButton name="signOut" value="sign out"/>
            </g:form>
        </sec:ifLoggedIn>
    </nav>
    <div id="bd"><!-- start body -->
    <g:layoutBody/>
    </div> <!-- end body -->
    <div id="ft">
        <div id="footerText">Hubbub - Social Networking on Grails</div>
    </div>
</div>
</body>
</html>
