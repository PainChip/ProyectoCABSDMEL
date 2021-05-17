<%-- 
    Document   : Configuracion
    Created on : Nov 23, 2020, 1:49:53 AM
    Author     : CARLOS
--%>
<%@page import="com.pw.dbconnection.models.User"%>
<%
    User usuario = (User) request.getAttribute("Usuinfo");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CineTicias [Configuracion]</title>
        <link rel="icon" href="assets/Recursos/Logo.jpg">
        <link rel="stylesheet" href="assets/css/edicion.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script>
      $(document).ready(function() 
      {
         
          var varId = <%= session.getAttribute("id")%>;
          var varUser = "<%= session.getAttribute("username")%>";
          var varFoto = "<%= session.getAttribute("foto")%>";
          var varRol = "<%= session.getAttribute("rol")%>";   
          var varRolID = "<%= session.getAttribute("rolId")%>";

          if(varId !== null)
          {
            $("#EstaONo").remove();
            document.getElementById("imagenUser").src = varFoto;
            document.getElementById("NombreUser").innerHTML = varUser;
            
          }else{
               $("#imagenUser").remove();
               $("#NombreUser").remove();
               $("#LogOFF").remove();
          }
          if(varRol === "Usuario" || varRol === "null" )
          {
            document.getElementById("cn").addEventListener("click", function(event)
            {                   
               event.preventDefault();
            });
            document.getElementById("edi").addEventListener("click", function(event)
            {                   
               event.preventDefault();
            });  
          }
          if(varRol === "null"){
            document.getElementById("perfi").addEventListener("click", function(event)
            {                   
               event.preventDefault();
            }); 
            document.getElementById("confi").addEventListener("click", function(event)
            {                   
               event.preventDefault();
            });   
          }
          if(varRol === "CC")
          {
            document.getElementById("edi").addEventListener("click", function(event)
            {                   
               event.preventDefault();
            });              
          }            
   
      });
    </script>
    </head>
    <body>
        <!--NavBar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">
                <img src="assets/Recursos/Logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
                CineTicias
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent" >
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                     <a class="nav-link" href="indexController">Home </a>
                </li>
                <li class="nav-item">
                     <a class="nav-link" href="NoticiasPaginaController" Method"GET">Noticia</a>
                </li>
                <li class="nav-item dropdown active">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Usuario
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a id="perfi" class="dropdown-item active" href="PerfilController?id=<%=session.getAttribute("id")%>">Perfil</a>
                        <div class="dropdown-divider"></div>
                            <a id="cn"class="dropdown-item" href="AddNewsController" Method="GET" >Crear noticia</a>                   
                            <a id="edi" class="dropdown-item" href="RevisaNewsController"  Method="GET">Edicion</a>
                        <div class="dropdown-divider"></div>
                        <a id="confi" class="dropdown-item" href="ConfiguracionController" Method="GET">Configuracion <span class="sr-only">(current)</span></a>
                    </div>
                </li>  
              </ul>
              <form action="BuscadorController" method="GET" class="form-inline my-2 my-lg-0">
                <input name="Botonbusca" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
              <form id="EstaONo" action="login_register.jsp" class="form-inline my-2 my-lg-0" style="padding-left: 50px; padding-right: 10px;">
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login/Registrar</button>
              </form>
              <img id="imagenUser" src="http://cdn.onlinewebfonts.com/svg/img_506739.png" alt="ImagenPerfil" width="50" height="30" style="padding-left: 10px; padding-right: 10px;">
              <a id="NombreUser" style="color: #ecfdf9">Username</a>
              <form id="LogOFF" action="LogOffController" method="POST" class="form-inline my-2 my-lg-0" style="padding-left: 20px; padding-right: 10px;">
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log Out</button>
              </form>
            </div>
        </nav>
        <br>
        <div class="container">
            <div class="row">
                <form class="col-12" action="ConfiguracionController" method="POST" enctype="multipart/form-data" >
                    <h3>Redes Sociales</h3>
                    <div class="form-group">
                        <label for="title">Facebook</label>
                        <input type="text" class="form-control" name="feis" id="title" placeholder="<%= usuario.getFace()%>">
                    </div>
                    <div class="form-group">
                        <label for="title">Instagram</label>
                        <input type="text" class="form-control" name="insta" id="Instagram" placeholder="<%= usuario.getInsta()%>">
                    </div>
                    <div class="form-group">
                        <label for="title">Twitter</label>
                        <input type="text" class="form-control" name="tuit" id="Twitter" placeholder="<%= usuario.getTwitter()%>">
                    </div>     
                     <hr class="my-4">
                      <h3>Foto Perfil</h3>
                    <div class="form-group">
                        <label for="image">Imagen</label>
                        <input type="file" class="form-control" name="image" id="image">
                        <small id="emailHelp" class="form-text text-muted">Tamaño maximo de archivo 5 Mb.</small>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" onclick="revisa()" value="Enviar">
                    </div>
                </form>
            </div>
        </div>
        <section id="footer">
	    <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">         
	    	<p><u><a href="#">CineTicias</a></u> is a Registered MSP/ISO of Elavon, Inc. Georgia [a wholly owned subsidiary of U.S. Bancorp, Minneapolis, MN]</p>
	    	<p class="h6">&copy All right Reversed.<a class="text-green ml-2" href="#" target="_blank">Sunlimetech</a></p>
	    </div>
	</section>                        
    </body>
    <script>
        
        function revisa(){
        var x = document.getElementById("Facebook").value;
        var y = document.getElementById("Instagram").value;
        var z = document.getElementById("Twitter").value;
        alert(x);
        alert(y);
        alert(z);
            
        }
    </script>
</html>
