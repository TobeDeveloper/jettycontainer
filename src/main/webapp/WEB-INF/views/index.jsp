<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap.min.css" />
    <script src="/static/js/jquery-2.1.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<body>
    <h2><spring:message code="hello"/></h2>
    <p>some content.</p>
</body>
</html>