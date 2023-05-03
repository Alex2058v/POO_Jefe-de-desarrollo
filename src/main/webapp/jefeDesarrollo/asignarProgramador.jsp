<%--
    Created by IntelliJ IDEA.
    User: AYALA
    Date: 1/5/2023
    Time: 17:11
    To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Asignar programador</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
    <jsp:include page="menuJefeDesarollo.jsp"/>
    <div class="container">
        <div class="row">
            <h3>Asignar un caso a un programador.</h3>
        </div>

        <form role="form" action="${contextPath}/CasosController.do" method="POST">
            <input type="hidden"  name="op" value="asignarCaso">

            <div class="form-group">
                <label for="idCaso">Código del caso:</label>
                <div class="input-group">
                    <input readonly type="text" class="form-control" name="idCaso"  id="idCaso" value="${casoObtener.id_caso}" placeholder="Código del caso." >
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                </div>
            </div>

            <div class="form-group">
                <label for="idTitulo">Titulo del caso:</label>
                <div class="input-group">
                    <input disabled type="text" class="form-control" name="idTitulo"  id="idTitulo" value="${casoObtener.titulo_caso}" placeholder="Titulo del caso." >
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                </div>
            </div>

            <div class="form-group">
                <label for="programador">Programador:</label>
                <div class="input-group">
                    <select name="programador" id="programador" class="form-control">
                        <c:forEach items="${requestScope.listaProgramadores}" var="progra">
                            <option value="${progra.id_usuario}">${progra.nombres}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="fechaSolicitud">Fecha de solicitud:</label>
                <div class="input-group">
                    <input readonly type="date" class="form-control" name="fechaSolicitud" id="fechaSolicitud" value="${casoObtener.fecha_solicitud}" >
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                </div>
            </div>

            <div class="form-group">
                <label for="fechaLimite">Fecha limite:</label>
                <div class="input-group">
                    <input type="date" class="form-control" name="fechaLimite"  id="fechaLimite" value="${casoObtener.fecha_limite}" >
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                </div>
            </div>

            <input type="submit" class="btn btn-info" value="Guardar" name="Guardar">
            <a class="btn btn-danger" href="${contextPath}/CasosController.do?op=gestionProgramadores">Cancelar</a>
        </form>
    </div>

    <script>
        // Obtener la fecha actual en formato ISO
        var fechaActual = new Date().toISOString().slice(0, 10);

        // Establecer el valor del input con la fecha actual
        document.getElementById("fechaSolicitud").value = fechaActual;
    </script>
</body>
</html>
