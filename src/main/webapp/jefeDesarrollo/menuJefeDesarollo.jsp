<%--
    Created by IntelliJ IDEA.
    User: AYALA
    Date: 30/4/2023
    Time: 19:22
    To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Desplegar navegación</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Jefe de desarrollo</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/jefeDesarrollo.do">Inicio</a></li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                        role="button" aria-haspopup="true"
                        aria-expanded="false">Jefe de desarrollo.<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/CasosController.do?op=mostarCasos">Gestión de casos</a></li>
                        <li><a href="${pageContext.request.contextPath}/#">Gestión de programadores</a></li>
                        <li><a href="${pageContext.request.contextPath}/#">Ver avances de programadores</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
