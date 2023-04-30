<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>solo servira para redirigirme a una pagina donde se veran todos los casos</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
    <body>
    <h1>
        el login deberia se esto para que me mande a la pagina que me toca xd
    </h1>
    <br/>

    <div class="container">
        <div class="row">
            <h2>Casos por aprobar o rechazar.</h2>
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
                            <div class="huge"></div>
                            <div><h4>Casos</h4></div>
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
    </div>
</body>
</html>