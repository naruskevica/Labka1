<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/process" method="post">
    <label for="key">Key:</label>
    <input type="text" name="key" id="key" required><br>
    <label for="value">Value:</label>
    <input type="number" name="value" id="value" required><br>
    <label for="test">Test:</label>
    <input type="checkbox" name="test" id="test"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
