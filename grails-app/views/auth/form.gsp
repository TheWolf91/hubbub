<html>
<head>
    <title>Sign into Hubbub</title>
    <meta name="layout" content="main">
</head>
<body>
<h1>Sign in</h1>
<g:form uri="/login/authenticate" method="POST">
    <fieldset class="form">
        <div class="fieldcontain required">
            <label for="username">Login ID</label>
            <g:textField name="username" value="${loginId}"/>
        </div>
        <div class="fieldcontain required">
            <label for="password">Password</label>
            <g:passwordField name="password"/>
        </div>
        <div class="fieldcontain required">
            <label for="_spring_security_remember_me">Remember me</label>
            <g:checkBox name="_spring_security_remember_me"/>
        </div>
    </fieldset>
    <fieldset class="buttons">
        <g:submitButton name="signIn" value="Sign in"/>
    </fieldset>
</g:form>

</body>
</html>