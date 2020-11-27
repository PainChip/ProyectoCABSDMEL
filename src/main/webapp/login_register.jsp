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
            <div class="button-box">
                <div id="btn"></div>
                <button type="button" class="toggle-btn" onclick="login()">Log In</button>
                <button type="button" class="toggle-btn" onclick="register()">Registro</button>
            </div>
            <form action="LogInController" class="input-group" id="login" method="POST">
                <input name="username" type="text" class="input-field" placeholder="Correo" required>
                <input name="password" type="text" class="input-field" placeholder="Contraseña" required>
                <input type="checkbox" class="check-box"><span>Recordar Contraseña</span>
                <button type="submit" class="submit-btn">Ingresar</button> 
                <button action="LogInControllerAnonimo" class="submit-btn" style="margin-top: 50px">Anonimo</button> 
            </form>
            <form action="SignInController" class="input-group" id="register" method="POST">
                <input name="username" type="text" class="input-field" placeholder="Nombre de Usuario" required>
                <input name="correo" type="email" class="input-field" placeholder="Correo Electronico" required>
                <input id="contra1" name="password" type="text" class="input-field" placeholder="Contraseña" required>
                <input id="contra2" name="confirmp" type="text" class="input-field" placeholder="Confirma Contraseña" required>
                <input id="cajita" name="TyC" type="checkbox" class="check-box"><span>Acepto Terminos y Condiciones</span>
                <button id="botoncitoRegistra" type="submit" class="submit-btn" >Registrar</button>
            </form>

        </div>
    </div>
    <script>
        var x = document.getElementById("login");
        var y = document.getElementById("register");
        var z = document.getElementById("btn");
        function register(){
            x.style.left= "-400px";
            y.style.left= "50px";
            z.style.left= "110px";
        }
        function login(){
            x.style.left= "50px";
            y.style.left= "450px";
            z.style.left= "0";
        }
        document.getElementById("botoncitoRegistra").addEventListener("click", function(event){
                   
            let valor1 = document.getElementById("contra1").value;
            let valor2 = document.getElementById("contra2").value;
            let checado = document.getElementById("cajita").checked;
            let bandera1 = true;
            let bandera2 = true;

            if(valor1 !== valor2)
            {   
                alert("Tienes la contraseña diferente");
                bandera1 = false;
            }
            if(checado === false)
            {
                alert("Acepta los Terminos y Condiciones");
                bandera2 = false;
            }
            if(bandera1 === false || bandera2 === false)
            {
                event.preventDefault();
                alert("Revisa que todo haya sido ingresado correctamente");
            }
        
         });
        
    </script>
</body>
</html>