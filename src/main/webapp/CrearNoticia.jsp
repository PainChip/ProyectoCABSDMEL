<%-- 
    Document   : CrearNoticia
    Created on : Nov 22, 2020, 4:56:18 PM
    Author     : CARLOS
--%>
<%@page import="java.util.List"%>
<%@page import="com.pw.dbconnection.models.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Category> categories = (List<Category>) request.getAttribute("Categories");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CineTicias [CrearNoticia]</title>
        <link rel="icon" href="assets/Recursos/Logo.jpg">
        <link rel="stylesheet" href="assets/css/CrearNoticia.css">
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
          document.getElementById("iteraciones").value = 0;
          


          
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
                    <a class="nav-link" href="noticias.jsp">Noticia</a>
                  </li>


                  <li class="nav-item dropdown active">
                      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Usuario
                      </a>
                      <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item active" href="perfil.jsp">Perfil </a>
                        <div class="dropdown-divider"></div>
                        <a id="cn" class="dropdown-item" href="AddNewsController" Method="GET" >Crear noticia</a>    
                        <a id="edi" class="dropdown-item" href="edicion.jsp">Edicion</a>
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
            <div class="row">
                <form class="col-12" method="POST" enctype="multipart/form-data" action="AddNewsController">
                    <h1>Nueva Noticia</h1>
                    <div class="form-group">
                        <label for="title" >Titulo</label>
                        <input type="text" class="form-control" name="title" id="title">
                    </div>
                    <div class="form-group">
                        <label for="description">Descripcion</label>
                        <textarea class="form-control" name="description" id="description" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="contenido">Contenido</label>
                        <textarea class="form-control" name="contenido" id="contenido" rows="3"></textarea>
                    </div>                    
                    <div class="form-group">
                        <label for="category">Categorias</label>
                        <select class="form-control" name="category" id="category">
                            <option value="-1">Seleccione una Categoria</option>
                            <%
                                for (Category category : categories) {
                            %>
                            <option value="<%= category.getId()%>"><%= category.getName()%></option>
                            <%
                                }
                            %>
                        </select>
                        <input type="button" class="btn btn-primary" style="margin-top: 20px" value="Siguiente" onclick="Parte2()">
                    </div>
                    <hr class="my-4">    
                    <div id="Parte2" class="form-group container-fluid"  style="display: none">
                        <div>
                            <label for="image">Imagen</label>
                            <input type="file" class="form-control" name="image" id="image">
                            <small id="emailHelp" class="form-text text-muted">Tamaño maximo de archivo 5 Mb.</small> 
                            <input type="button" chetado ="1" class="btn btn-primary" style="margin-top: 10px; margin-bottom: 10px" value="Siguiente" onclick="Insertando()">
                        </div>
                        </div>
                        <div class="form-group" style="display: none" id="ocultos">
                            <input type="text" class="form-control"  name="iteraciones" id="iteraciones">                      
                        </div>                        
                        <hr class="my-4"> 
                        <input type="submit" class="btn btn-primary"  value="Enviar">
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
          function Parte2(){
              document.getElementById("Parte2").style.display = "inline-block";
              document.getElementById("footer").style.position = "relative";
          }
          function Insertando(){
               let url;
              url = document.getElementById("image").value;
             if(url !== ""){
             
              let contenlo = document.getElementById("iteraciones").value;
              let numero = parseInt(contenlo)+1;
              document.getElementById("iteraciones").value= numero;
             
                 let preparando = '<input type="text" class="form-control" value="'+url+'" id="elemento'+numero+'" name="elemento'+numero+'">';
                 let Nelemento = 'elemento'+numero;
                 $("#ocultos").append(preparando);               
                
             }
                 
                 
          }
          function ComprobarTodo(){
              let valor2 = document.getElementById("iteraciones").value;
              if(valor2 < 3)
              {
                event.preventDefault();
                alert("Debe haber minimo 3 imagenes");
              }

          }

                   
    </script>
</html>