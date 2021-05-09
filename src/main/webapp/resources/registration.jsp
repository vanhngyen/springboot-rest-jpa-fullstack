<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title> Login with your account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<body>
<div class="container">
    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading"> Create your account</h2>
        <sping:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}" >
                <form:input type="text" path="username" class="form-control" placeholder="Username" autofocus ="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </sping:bind>
        <sping:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}" >
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </sping:bind>
        <sping:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}" >
                <form:input type="password" path="passwordConfirm" class="form-control" placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </sping:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit"> Submit</button>
    </form:form>
</div>
<script src="https://ajax.googleapis.com/ajax/lib/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</head>

</html>
