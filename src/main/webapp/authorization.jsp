<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>
    <title>Authorization</title>
</head>

<body class="auth_body" style="background: olive">
<header class="auth_header" style="height: 45%; display:  flex; justify-content: center">
    <img src="img/authLogo.png" alt="logo">
</header>

<main class="auth_main" style="height: 25%; display: flex; justify-content: center; align-items:center; flex-direction: column">
    <form action="" method="POST" style="width: 20%; display: flex; flex-direction: column">
        <h4 style="border-radius:10px; border: 12px solid #008B8B; margin: 3px">Login: <input type="text" name="login" /> <br>${loginErr}</h4>
        <h4 style="border-radius:10px; border: 12px solid #008B8B; margin: 3px">Password: <input type="password" name="pass" /> <br>${passErr}</h4>

        <div class="buttons" style="display: flex; flex-direction:row; width: 100%; justify-content: center">
            <div class="button">
                <input type="submit" value="Sign in" style="cursor: pointer; font-size:17px; text-decoration: none; padding:10px 20px; color:#ffffff; background-color:#000000; border-radius:10px; border: 12px solid #32c75e;"></div>

        </div>
    </form>
</main>

<footer class="auth_footer" style="display: flex; align-items:flex-end ; flex-direction: column; margin: 20px 0px;">
    <div class="button">
        <p class="buttond"><a href="http://localhost:8080/ServletWithJSP_war" target="_self" style="cursor: pointer; font-size:17px; text-decoration: none; padding:10px 20px; color:#ffffff; background-color:#000000; border-radius:10px; border: 12px solid #c79832;">Cancel</a></p>
    </div>
</footer>
</body></html>