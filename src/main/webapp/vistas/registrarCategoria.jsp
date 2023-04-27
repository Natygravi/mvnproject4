<%-- 
    Document   : registrarCategoria
    Created on : 26 abr. 2023, 10:43:48
    Author     : saudd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>Registrar Categorías</title>
    </head>
    <body>
        <h1>Registrar Categorías</h1>
        <form action="RegistrarCategoriaServlet" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" id="nombre"><br><br>
            <label for="descripcion">Descripción:</label>
            <textarea name="descripcion" id="descripcion"></textarea><br><br>
            <label for="listaDesplegable">Cursos Disponibles:</label>
            <select class="form-select" name="curso" id="curso">
                        <option selected disabled>Seleccione un curso</option>
                        <c:forEach items="${opcionesListaCursos}" var="curso">
                          <option value="${curso.valor}">${curso.valor} ${curso.texto}</option>
                        </c:forEach>
                      </select><br><br>
          <br><br>
            <input type="submit" value="Registrar">
        </form>
        <br>
        <button onclick="agregarListaDesplegable()">Agregar lista desplegable</button>
        <br>
        <div id="contenedor-listas-desplegables"></div>

    </body>
</html>
