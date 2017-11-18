<html>
<head>
    <title>Global Timeline</title>
    <meta name="layout" content="main"/>
</head>
<body>
<h1>Global Timeline</h1>

<g:if test="${flash.message}">
    <div class="flash">
        ${flash.message}
    </div>
</g:if>
<div id="allPosts">
    <g:render template="postEntry" collection="${posts}" var="post"/>
</div>
<g:paginate action="global" total="${postCount}" max="3"/>
</body>
</html>