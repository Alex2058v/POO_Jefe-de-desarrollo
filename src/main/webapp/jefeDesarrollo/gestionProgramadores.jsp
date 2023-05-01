<%--
    Created by IntelliJ IDEA.
    User: AYALA
    Date: 1/5/2023
    Time: 15:17
    To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Gestión de casos a programadores</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<jsp:include page="menuJefeDesarollo.jsp"/>
<div class="container">
    <div class="row">
        <h3>GESTIÓN DE CASOS POR APROBAR.</h3>
    </div>

    <table class="table table-striped table-bordered table-hover" id="tabla" style="margin-top: 3rem">
        <thead>
        <tr>
            <th>ID del caso</th>
            <th>Titulo del caso</th>
            <th>Descripción</th>
            <th>Archivo pdf</th>
            <th>Departamento</th>
            <th>Operaciones</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.casosProgramadores}" var="casos">
                <tr>
                    <td>${casos.id_caso}</td>
                    <td>${casos.titulo_caso}</td>
                    <td>${casos.descripcion_caso}</td>
                    <td>${casos.archivo_pdf}</td>
                    <td>${casos.id_departamento}</td>

                    <td>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
