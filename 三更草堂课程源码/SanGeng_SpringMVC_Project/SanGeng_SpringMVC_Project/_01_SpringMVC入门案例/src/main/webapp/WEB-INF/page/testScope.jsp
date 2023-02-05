<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2021/5/16
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${requestScope.get("name")}
    ${requestScope.get("title")}
    ${requestScope.get("org.springframework.web.servlet.HandlerMapping.bestMatchingPattern")}
    <hr>
    ${sessionScope.get("name")}
    ${sessionScope.get("title")}
</body>
</html>
