<%-- 
    Document   : noticiaEspecifica
    Created on : Nov 12, 2020, 8:13:56 PM
    Author     : CARLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CineTicias [Articulo]</title>
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
    <div id="fb-root"></div>
    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v8.0&appId=3496486320412131&autoLogAppEvents=1" nonce="WNPCBicN"></script>
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
                <a class="nav-link" href="index.jsp">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="noticias.jsp">Noticia</a>
              </li>

      
              <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Usuario
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item active" href="perfil.jsp">Perfil <span class="sr-only">(current)</span></a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="AddNewsController" Method="GET" >Crear noticia</a>    
                    <a class="dropdown-item" href="edicion.jsp">Edicion</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Configuracion.jsp">Configuracion</a>
                  </div>
              </li>  
              <li class="nav-item">
                  <a class="nav-link" href="login_register.jsp">Login/Registrar</a>
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
        <h1 style="text-align: center;">Nombre de la noticia</h1>
        <hr class="my-4">
            <h4>Categoria</h4>
            <p>Descripcion corta</p>
        <hr class="my-4">
        <!-- Video de la noticia-->
        <div class="embed-responsive embed-responsive-16by9">
            <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/zpOULjyy-n8?rel=0" allowfullscreen></iframe>
        </div>
        <br>
        <!--Noticia en si-->
        <section>
            <h2>WWF's Symbol</h2>
            <p>The Panda has become the symbol of WWF. The well-known panda logo of WWF originated from a panda named Chi Chi that was transferred from the Beijing Zoo to the London Zoo in the same year of the establishment of WWF.</p>
            <p>The Panda has become the symbol of WWF. The well-known panda logo of WWF originated from a panda named Chi Chi that was transferred from the Beijing Zoo to the London Zoo in the same year of the establishment of WWF.</p>
            <p>The Panda has become the symbol of WWF. The well-known panda logo of WWF originated from a panda named Chi Chi that was transferred from the Beijing Zoo to the London Zoo in the same year of the establishment of WWF.</p>
            <p>The Panda has become the symbol of WWF. The well-known panda logo of WWF originated from a panda named Chi Chi that was transferred from the Beijing Zoo to the London Zoo in the same year of the establishment of WWF.</p>
        </section>
        <br>
        <div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/comments#configurator" data-numposts="5" data-width="100%"></div>
    </div>  
    <section id="footer">
	    <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">         
	    	<p><u><a href="#">CineTicias</a></u> is a Registered MSP/ISO of Elavon, Inc. Georgia [a wholly owned subsidiary of U.S. Bancorp, Minneapolis, MN]</p>
	    	<p class="h6">&copy All right Reversed.<a class="text-green ml-2" href="#" target="_blank">Sunlimetech</a></p>
        </div>
    </section>

</body>

</html>