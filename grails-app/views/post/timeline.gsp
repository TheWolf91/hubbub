<html>
<head>
    <title>
        Timeline for ${ user.profile ? user.profile.fullName :
                user.loginId }
    </title>
    <meta name="layout" content="main"/>
    <g:if test="${user.profile?.skin}">
        <g:external dir="css" file="${user.profile.skin}.css"/>
    </g:if>
</head>
<body>
<h1>Timeline for ${ user.profile ? user.profile.fullName :
        user.loginId }</h1>
<g:if test="${flash.message}">
    <div class="flash">
        ${flash.message}
    </div>
</g:if>
<div id="newPost">
    <g:form>
        <g:textArea id="postContent" name="content" rows="3" cols="50"/><br/>
        <g:submitToRemote value="Post"
                          url="[controller: 'post', action: 'addPostAjax', id: user.loginId]"
                          update="allPosts"
                          onSuccess="clearPost(data)"
                          onLoading="showSpinner(true)"
                          onComplete="showSpinner(false)"
        />
        <g:img id="spinner" style="display: none" dir="images" file="spinner.gif" alt="Loading..."/>
    </g:form>
</div>
<div id="allPosts">
    <g:render template="postEntry" collection="${user.posts}" var="post"/>
</div>
<g:javascript>
    function clearPost(e) {
        $('#postContent').val('');
    }
    function showSpinner(visible) {
        if (visible) $('#spinner').show();
        else $('#spinner').hide();
    }
</g:javascript>
</body>
</html>