<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
index jsp
<a href="/logout">登出</a>
<a href="/product">产品</a>
<security:authorize access="hasAnyRole('ROLE_USER')">
    WAHAHA
</security:authorize>
<security:authorize access="hasAnyRole('ROLE_PRODUCT')">
    LLLLLL
</security:authorize>
</body>
</html>
