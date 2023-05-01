<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Jefe de desarrollo</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<jsp:include page="menuJefeDesarollo.jsp"/>
    <div class="container">
        <div class="row">
            <h2>Jefe de desarrollo.</h2>
        </div>

        <!-- Aqui los botones a utilizar -->
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="glyphicon glyphicon-folder-open huge"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">${requestScope.totalCasos}</div>
                            <div><h4>Gestión de casos</h4></div>
                        </div>
                    </div>
                </div>
                <a href="${pageContext.request.contextPath}/#">
                    <div class="panel-footer">
                        <span class="pull-left">Ver Casos</span>
                        <span class="pull-right"><i class="glyphicon glyphicon-arrow-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>

        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="glyphicon glyphicon-user huge"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">${requestScope.totalProgra}</div>
                            <div><h4>Casos por asignar.</h4></div>
                        </div>
                    </div>
                </div>
                <a href="${pageContext.request.contextPath}/#">
                    <div class="panel-footer">
                        <span class="pull-left">Ver casos asignados</span>
                        <span class="pull-right"><i class="glyphicon glyphicon-arrow-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>

        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="glyphicon glyphicon glyphicon-education huge"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">${requestScope.totalAvance}</div>
                            <div><h4>Avances de los programadores</h4></div>
                        </div>
                    </div>
                </div>
                <a href="${pageContext.request.contextPath}/#">
                    <div class="panel-footer">
                        <span class="pull-left">Ver avances</span>
                        <span class="pull-right"><i class="glyphicon glyphicon-arrow-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</body>
</html>