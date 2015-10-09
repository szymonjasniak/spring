<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>   
</head>
<body>
<c:forTokens items="employeeList" delims="," var="item">
   <c:out value="${name}"/><p>
</c:forTokens>
</body>
</html>