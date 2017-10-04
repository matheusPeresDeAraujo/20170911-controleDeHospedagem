<%-- 
    Document   : login
    Created on : 21/09/2017, 21:44:59
    Author     : matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Criar favicon.ico -->
        <!--<link rel="icon" href="img/favicon.ico">-->

        <title> Controle de Hospedagem </title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/jumbotron-narrow.css" rel="stylesheet">

    </head>

    <body>
        <div class="container">
            <div class="header clearfix">
                <h1 class="text-muted"><img src="img/predio.png" width="48" alt="..." /> Controle de Hospedagem</h1>
            </div>
            <div class="container">
                <br />
                <div class="row vertical-offset-100">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Alterar Sala</h3>
                            </div>
                            <div class="panel-body">
                                <form accept-charset="UTF-8" role="form" action="FrontController?action=AlterarSala" method="post">
                                    <fieldset>
                                        <div class="form-group">
                                            <th><span>Codigo </span></th>
                                            <input name="textCodigo" type="text" value="${sala.codigo}" hidden/>
                                            <input class="form-control" placeholder="Numero" name="textCodigo" type="text" value="${sala.codigo}" readonly="readonly"/>
                                        </div>
                                        <div class="form-group">
                                            <th><span>Numero </span></th>
                                            <input class="form-control" placeholder="Numero" name="textNumero" type="text" value="${sala.numero}" />
                                        </div>
                                        <div class="form-group">
                                            <th><span>Nome </span></th>
                                            <select name="textNome" class="form-control">
                                                <option name="textNome" value="auditorio" <c:if test="${sala.nome.equals('auditorio')}"> selected</c:if>>Sala Auditorio</option>
                                                <option name="textNome" value="banquete">Sala Banquete</option>
                                                <option name="textNome" value="escolar">Sala Escolar</option>
                                                <option name="textNome" value="espinhadepeixe">Sala Espinha de Peixe</option>
                                                <option name="textNome" value="formatoU">Sala Formato U</option>
                                                <option name="textNome" value="reuniao">Sala Reuniao</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <th><span>Preco Cadastro</span></th>
                                            <input class="form-control" placeholder="Preco" name="textPreco" type="text" value="<fmt:formatNumber type="number" maxFractionDigits = "2" value="${sala.preco}" />" />
                                        </div>
                                        <div class="form-group">
                                            <th><span>Preco Apresentado</span></th>
                                            <input class="form-control" placeholder="Preco" name="textPrecoApresentacao" type="text" value="<fmt:formatNumber type="number" maxFractionDigits = "2" value="${sala.precoA}" />" readonly="readonly"/>
                                        </div>
                                        <input class="btn btn-lg btn-warning btn-block" type="submit" value="Alterar">
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="footer">
                <p>&copy; 2017 Padrões de Projetos - GRANBERY JF.</p>
            </footer>
        </div>
        <script src="https://use.fontawesome.com/45e03a14ce.js"></script>
        <script src="js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
