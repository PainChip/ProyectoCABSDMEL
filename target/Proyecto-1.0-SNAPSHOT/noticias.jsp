<%-- 
    Document   : noticias
    Created on : Nov 12, 2020, 8:14:15 PM
    Author     : CARLOS
--%>
<%@page import="java.util.List"%>
<%@page import="com.pw.dbconnection.models.Category"%>
<%@page import="com.pw.dbconnection.models.Noticias"%>
<%@page import="com.pw.dbconnection.models.Media"%>
<%
    List<Category> categories = (List<Category>) request.getAttribute("Categories");
    List<Noticias> Noticias3 = (List<Noticias>) request.getAttribute("News3");
    List<Noticias> NoticiasAbajo = (List<Noticias>) request.getAttribute("NewsDebajo");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CineTicias [Noticias]</title>
    <link rel="icon" href="assets/Recursos/Logo.jpg">
    <link rel="stylesheet" href="assets/css/noticias.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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
                 <a class="nav-link" href="indexController">Home </a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="NoticiasPaginaController" Method"GET">Noticia <span class="sr-only">(current)</span></a>
              </li>

              <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Usuario
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a id="perfi" class="dropdown-item active" href="PerfilController?id=<%=session.getAttribute("id")%>">Perfil</a>
                    <div class="dropdown-divider"></div>
                        <a id="cn"class="dropdown-item" href="AddNewsController" Method="GET" >Crear noticia</a>    
                        <a id="edi" class="dropdown-item" href="RevisaNewsController"  Method="GET">Edicion</a>
                    <div class="dropdown-divider"></div>
                    <a id="confi" class="dropdown-item" href="ConfiguracionController" Method="GET">Configuracion</a>
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
    <nav class="navbar navbar-light bg-light">
        <div class="container text-left">
          <%
              for (Category category : categories) {
          %>
          <form href="NoticiasPaginaController" Method="POST">
              <input type="text" style="display: none"name="CateID" value="<%= category.getId()%>"> 
              <button class="btn btn-outline-success" type="submit"><%= category.getName()%></button>
          </form>
          <%
              }
          %>
        </div>  
    </nav>
    <div class="container">
      <!--Cards-->
      <h3>Recientes</h1>
      <hr class="my-4">
      <div class="Destacados container-fluid">
            <div class="row row-cols-1 row-cols-md-3">
                <%
                    for (Noticias Noticias : NoticiasAbajo) { 
                        List<Media> hola = Noticias.getMedia();
                        Media primero = hola.get(0);            
                %>
                <div class="card col-12 col-sm-6 col-md-4" style="width: 18rem;">
                    <img id="chikito" class="card-img-top" src="<%= primero.getUrl() %>" alt="Card image cap">
                    <div class="card-body">
                      <h5 class="card-title"><%= Noticias.getTitle()%></h5>
                      <p class="card-text"><%= Noticias.getDescription()%></p>
                      <a href="NoticiaEspecificaController?id=<%=Noticias.getId()%>" class="btn btn-primary">Detalles</a>
                    </div>
                  </div>   
                <%
                    }
                %>
            </div>
      </div>
      <br>
      <h3>Todas</h1>
      <hr class="my-4">
      <div class="Destacados container-fluid">
            <div class="row row-cols-1 row-cols-md-3">
                                
                <%
                    for (Noticias Noticias : Noticias3) { 
                        List<Media> hola = Noticias.getMedia();
                        Media primero = hola.get(0);            
                %>
                <div class="card col-12 col-sm-6 col-md-4" style="width: 18rem;">
                    <img id="chikito" class="card-img-top" src="<%= primero.getUrl() %>" alt="Card image cap">
                    <div class="card-body">
                      <h5 class="card-title"><%= Noticias.getTitle()%></h5>
                      <p class="card-text"><%= Noticias.getDescription()%></p>
                      <a href="NoticiaEspecificaController?id=<%=Noticias.getId()%>" class="btn btn-primary">Detalles</a>
                    </div>
                  </div>   
                <%
                    }
                %>
            </div>
      </div>
      <br>

    </div>  
    

</body>
    <section id="footer">
	    <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">         
	    	<p><u><a href="#">CineTicias</a></u> is a Registered MSP/ISO of Elavon, Inc. Georgia [a wholly owned subsidiary of U.S. Bancorp, Minneapolis, MN]</p>
	    	<p class="h6">&copy All right Reversed.<a class="text-green ml-2" href="#" target="_blank">Sunlimetech</a></p>
	    </div>
    </section>
    <script>
        
        var valor2 = <%= NoticiasAbajo.size()%>;
        var valor = <%= Noticias3.size()%>;
        
        if(valor2 >= 4 || (valor >= 1 && valor2 >= 1)){
            document.getElementById("footer").style.position = "relative";
        }
    </script>
</html>