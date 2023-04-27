<%-- 
    Document   :  nabvar
    Created on : 7 abr. 2023, 21:25:12
    Author     : sauddiel
--%>

<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="messages_${sessionScope.language}" var="msg" />


<!DOCTYPE html>
<html lang="${sessionScope.language}">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PROMPS</title>
        <!-- Agregar los enlaces a los archivos CSS de Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid"> 
                <a class="navbar-brand" href="#"><fmt:message key="navbar.categories" bundle="${msg}"/></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#"><fmt:message key="navbar.home" bundle="${msg}"/></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ItemServlet"><fmt:message key="navbar.categories" bundle="${msg}"/></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ItemServlet"><fmt:message key="navbar.items" bundle= "${msg}" /></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="RegistrarItemServlet">Registrar Item</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="consultarTopServlet">Consultar Top</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Contenido principal -->
        <div class="container my-5">
            <h1 class="text-center"><fmt:message key="pageTitle" bundle="${msg}"/></h1>
            <p class="lead text-center"><fmt:message key="pageSubtitle" bundle="${msg}"/></p>
        </div>
        

        <!-- Agregar los enlaces a los archivos JS de Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>

