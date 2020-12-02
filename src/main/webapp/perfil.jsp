<%-- 
    Document   : perfil
    Created on : Nov 12, 2020, 8:14:39 PM
    Author     : CARLOS
--%>

<%@page import="com.pw.dbconnection.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User usuario = (User) request.getAttribute("resultadito");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CineTicias [Perfil]</title>
    <link rel="icon" href="assets/Recursos/Logo.jpg">
    <link rel="stylesheet" href="assets/css/perfil.css">
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
            $("#imagenUser").src= varFoto;
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
                <a class="nav-link" href="index.jsp">Home </a>
              </li>
              <li class="nav-item">
                 <a class="nav-link" href="NoticiasPaginaController" Method"GET">Noticia</a>
              </li>

              <li class="nav-item dropdown active">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Usuario
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item active" href="perfil.jsp">Perfil <span class="sr-only">(current)</span></a>
                    <div class="dropdown-divider"></div>
                        <a id="cn"class="dropdown-item" href="AddNewsController" Method="GET" >Crear noticia</a> 
                        <a id="edi" class="dropdown-item" href="RevisaNewsController"  Method="GET">Edicion</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Configuracion.jsp">Configuracion</a>
                  </div>
              </li>  
          </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
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
        <div class="jumbotron">
            <h1 class="display-5">Mi Perfil</h1>
            <div class="container d-flex align-items-center">
                <div class="image-cropper">
                    <img src="<%= usuario.getFoto()%>" alt="avatar" class="profile-pic">
                </div>
                <section id="nombre">
                    <p class="lead"><%= usuario.getUsername()%></p>
                    <p class="lead">Estado que se mostrara cuando el lo configure (Proximamente)</p>
                </section>
                
            </div> 
            <a href="<%= usuario.getFace()%>" class="fa fa-facebook"></a>
            <a href="<%= usuario.getTwitter()%>" class="fa fa-twitter"></a>
            <a href="<%= usuario.getInsta()%>" class="fa fa-instagram"></a>
        </div>
        <div class="jumbotron">
            <h4>Favoritos</h4>

            <hr class="my-4">
            <div class="d-flex align-items-center">
                <img id="imagenoticia" class="card-img-top" src="https://vignette.wikia.nocookie.net/disney/images/4/4b/Mulan_2020_theatrical_poster.jpeg/revision/latest?cb=20191204223834" alt="Card image cap">
                <section style="padding-left: 1%;">
                    <h6>Titulo Noticia</h6>
                    <hr class="my-4">
                    <p>Descripcion de noticia</p>
                    <a href="noticiaEspecifica.jsp">Clic para ver</a>               
                </section>
            </div>
            <br>
            <div class="d-flex align-items-center">
                <img id="imagenoticia" class="card-img-top" src="https://vignette.wikia.nocookie.net/disney/images/4/4b/Mulan_2020_theatrical_poster.jpeg/revision/latest?cb=20191204223834" alt="Card image cap">
                <section style="padding-left: 1%;">
                    <h6>Titulo Noticia</h6>
                    <hr class="my-4">
                    <p>Descripcion de noticia</p>
                    <a href="noticiaEspecifica.jsp">Clic para ver</a>               
                </section>
            </div> 

        </div>


    </div>  
  
    <section id="footer">
	    <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">         
	    	<p><u><a href="#">CineTicias</a></u> is a Registered MSP/ISO of Elavon, Inc. Georgia [a wholly owned subsidiary of U.S. Bancorp, Minneapolis, MN]</p>
	    	<p class="h6">&copy All right Reversed.<a class="text-green ml-2" href="#" target="_blank">Sunlimetech</a></p>
	    </div>
	</section>

</body>

</html>