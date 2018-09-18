<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="login.css">'
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action = "Loga" method = "GET">
<fieldset>
    <legend>Sign in</legend>

    <div>
        <label for="userName">Username:</label>
        <input type="text" id="username" name="username"
               required />
    </div>

    <div>
        <label for="password">Password:</label>
        <input type="password"  id="username" name="password"
                required
               placeholder="8 characters minimum" />
    </div>

    <input type="submit" value="Sign in">

</fieldset>
 </form>
</body>

</html>