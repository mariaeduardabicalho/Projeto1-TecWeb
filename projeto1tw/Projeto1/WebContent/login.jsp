<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="login.css">'
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action = "Loga" method = "POST">
<fieldset>
    <legend>Sign in</legend>

    <div>
        <label for="userName">Username:</label>
        <input type="text" id="username" name="username"
               required />
    </div>

    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"
               minlength="8" required
               placeholder="8 characters minimum" />
    </div>

    <input type="submit" value="Sign in">

</fieldset>
 </form>
</body>

</html>