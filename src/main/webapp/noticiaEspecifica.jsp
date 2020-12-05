<%-- 
    Document   : noticiaEspecifica
    Created on : Nov 12, 2020, 8:13:56 PM
    Author     : CARLOS
--%>
<%@page import="com.pw.dbconnection.models.User"%>
<%@page import="com.pw.dbconnection.models.Comentario"%>
<%@page import="java.util.List"%>
<%@page import="com.pw.dbconnection.models.Noticias"%>
<%@page import="com.pw.dbconnection.models.Media"%>
<%@page import="com.pw.dbconnection.models.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Noticias NoticiaSola = (Noticias) request.getAttribute("Noticion");
     List<Comentario> commentaries = (List<Comentario>) request.getAttribute("Commentaries");
    Category laCate=NoticiaSola.getCategory();
    List<Media> hola = NoticiaSola.getMedia();
    Media Video = null;
  
    for(Media LaMedia : hola){
        if(LaMedia.isTipo() == false){
            Video = LaMedia;
        }
    }
    if(Video == null){
        Video = new Media();
        Video.setUrl("");
    }
    /*Aqui debe ir la de comentarios*/
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CineTicias [Noticia]</title>
    <link rel="icon" href="assets/Recursos/Logo.jpg">
    <link rel="stylesheet" href="assets/css/noticiaEspecifica.css">
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
          var varVideo = "<%= Video.getUrl()%>";

          if(varVideo === "")
          {
            document.getElementById("Videito").style.display = "none"; 
          } 
          if(varId !== null)
          {
            $("#EstaONo").remove();
            $("#imagenUser").src= varFoto;
            document.getElementById("NombreUser").innerHTML = varUser;
            document.getElementById("Tunombre").style.display = "none";
            document.getElementById("comenid").innerHTML = varId;
            
          }else{
               $("#imagenUser").remove();
               $("#NombreUser").remove();
               $("#LogOFF").remove();
               document.getElementById("comenid").innerHTML = "";
               document.getElementById("Tunombre").style.display = "block";
               document.getElementById("botonfav").style.display = "none";
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
        <a class="navbar-brand" href="index.jsp">
            <img src="assets/Recursos/Logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
            CineTicias
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
       
        <div class="collapse navbar-collapse" id="navbarSupportedContent" >
          <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link" href="indexController">Home</a>
              </li>
              <li class="nav-item">
                 <a class="nav-link" href="NoticiasPaginaController" Method"GET">Noticia</a>
              </li>
              <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Usuario
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a id="perfi" class="dropdown-item active" href="PerfilController?id=<%=session.getAttribute("id")%>">Perfil <span class="sr-only">(current)</span></a>
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
    <div class="container">
        <h1 style="text-align: center;"><%=NoticiaSola.getTitle()%></h1>
        <hr class="my-4">
        <div>
            <h4><%=laCate.getName()%></h4>
            <p><%=NoticiaSola.getDescription()%></p>
            <form  action="FavoritoController?idNoti=<%=NoticiaSola.getId()%>" method="POST">
                <button id="botonfav" class=" btn btn-outline-success" type="submit" onclick="comprueba()" >Agrega Favorito</button>
            </form>
        </div>    
        <hr class="my-4">
        <!-- Video de la noticia-->
        <div id="Videito" class="embed-responsive embed-responsive-16by9">
            <iframe class="embed-responsive-item" src="<%=Video.getUrl()%>" allowfullscreen></iframe>
        </div>
            <div class="row row-cols-1 row-cols-md-3">
                <%
                   for (Media LaMedia2 : hola) 
                    {
                        if(LaMedia2.isTipo() == true)
                        {
                       
                %>                   
                <div class="card col-12 col-sm-6 col-md-4" style="width: 18rem;">
                  <img id="chikito" class="card-img-top" src="<%= LaMedia2.getUrl() %>" alt="Card image cap">
                </div> 
                <%
                        }
                    }
                %>                  
            </div>
        <br>
        <!--Noticia en si-->
        <section>   
            <p><%=NoticiaSola.getContenido()%></p>
        </section>
        <br>
        <div class="col-12 commentaries p-3">
            <h2>Comentarios</h2>
            <form method="POST" action="ComentariosController" >
                <div class="form-group">
                    <label for="commentary">Contenido</label>
                    <textarea class="form-control" name="idusuario" id="comenid" style="display: none"></textarea>
                    <input type="text" class="form-control" name="commenName" id="Tunombre" placeholder="Nombre (si no coloca nada sera Anonimo)">
                    <textarea class="form-control" name="commentary" id="commentary"></textarea>
                    <input type="hidden" name="idNews" value="<%= NoticiaSola.getId()%>">
                </div> 
                <div class="form-group">
                    <input type="submit" class="btn btn-success" value="Comentar" >
                </div>
            </form>
            <%
                for (Comentario commentary : commentaries) {
                String usuario = commentary.getUser().getFoto();
                if(null == usuario){
                    usuario = "http://cdn.onlinewebfonts.com/svg/img_506739.png";
                }
                List<Comentario> hola2 = commentary.getAnswers();
            %>
            <div class="media" style="padding-bottom: 15px">
                <img src="<%= usuario %>" class="mr-3" alt="...">
                <div class="media-body">
                    <h5 class="mt-0"><%= commentary.getUser().getUsername()%></h5>
                    <%= commentary.getContent()%>
                </div>
                <a style="display: none"class="btn btn-danger my-auto" href="DeleteCommentaryController?id=<%= commentary.getId()%>&idNews=<%= NoticiaSola.getId()%>">Eliminar</a>
            </div>
                <%
                    for (Comentario respuestitas : hola2) {
                    String usuario2 = commentary.getUser().getFoto();
                    if(null == usuario2){
                        usuario2 = "http://cdn.onlinewebfonts.com/svg/img_506739.png";
                    }
                %>
                    <div class="media" style="padding-left: 20px; padding-bottom: 15px;">
                        <img src="<%= usuario2 %>" class="mr-3" alt="...">
                        <div class="media-body">
                            <h5 class="mt-0"><%= respuestitas.getUser().getUsername()%></h5>
                            <%= respuestitas.getContent()%>
                        </div>
                        <a style="display: none"class="btn btn-danger my-auto" href="DeleteCommentaryController?id=<%= respuestitas.getId()%>&idNews=<%= NoticiaSola.getId()%>">Eliminar</a>
                    </div>
                <%             
                    }
                %>
                <form method="GET" action="ComentariosController" >
                    <div style="padding-left: 20px" class="form-group">
                        <textarea class="form-control" name="idusuario" id="comenid" style="display: none"></textarea>
                        <textarea class="form-control" name="idparent" id="comenparent" style="display: none"><%= commentary.getId()%></textarea>
                        <input type="text" class="form-control" name="commenName" id="Tunombre" placeholder="Nombre (si no coloca nada sera Anonimo)">
                        <textarea class="form-control" name="commentary" id="commentary"></textarea>
                        <input type="hidden" name="idNews" value="<%= NoticiaSola.getId()%>">
                    </div> 
                    <div style="padding-left: 20px" class="form-group">
                        <input type="submit" class="btn btn-success" value="Responder" >
                    </div>
                </form>
            <%
                }
            %>
        </div>
    </div>   
        <section id="footer" style="margin-top: 20px">
	<div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">         
	    	<p><u><a href="#">CineTicias</a></u> is a Registered MSP/ISO of Elavon, Inc. Georgia [a wholly owned subsidiary of U.S. Bancorp, Minneapolis, MN]</p>
	    	<p class="h6">&copy All right Reversed.<a class="text-green ml-2" href="#" target="_blank">Sunlimetech</a></p>
        </div>
    </section>

</body>

</html>