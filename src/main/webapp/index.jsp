<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/org/cometd.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.cometd.js"></script>
    <script type="text/javascript" src="application.js"></script>
    <script type="text/javascript">
        var config = {
            contextPath: '${pageContext.request.contextPath}'
        };
    </script>

</head>
<body>
<h2>RESTful WebService + Websocket</h2>
<p><a href="rest/user/someuser">RESTful WebService</a>

<div id="body"></div>

</body>
</html>
