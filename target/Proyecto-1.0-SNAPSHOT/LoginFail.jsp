<%-- 
    Document   : login_register
    Created on : Nov 12, 2020, 8:15:14 PM
    Author     : CARLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login/Registro</title>
    <link rel="icon" href="assets/Recursos/Logo.jpg">
    <link rel="stylesheet" href="assets/css/Login_register.css">

</head>
<body>
    <div class="hero">
        <div class="form-box">

            <form action="login_register.jsp" class="input-group" id="login" >
                <span style="font-size: 2.5em;color: #323232" >Este usuario no se encuentra registrado, intente de nuevo</span>


                <button type="submit" class="submit-btn" style="margin-top: 20px">Intentar de nuevo</button> 
            </form>
               
        </div>
    </div>

</body>
</html>