<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Page</title>
</head>
<body>
<h1>List Items:</h1>
<ul>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>

    <%-- Retrieve the list from the request --%>
    <% List<String> myList = (List<String>) request.getAttribute("myList"); %>

    <%-- Loop through the list and display the items --%>
    <% for (String item : myList) { %>
    <li><%= item %></li>
    <% } %>
</ul>
</body>
</html>
