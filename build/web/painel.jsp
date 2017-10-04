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
                    <div class="col-md-8 col-md-offset-2">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="col-md-6">
                                    <h3 class="panel-title">Painel</h3>
                                </div>
                                <div class="btn-group">
                                    <a href="FrontController?action=Painel" class="btn btn-info" role="button">Painel</a>
                                </div>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Cliente
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="FrontController?action=BuscarCliente" class="" role="button">Painel</a></li>
                                        <li><a href="FrontController?action=PrepararInserirCliente" class="" role="button">Cadastro</a></li>
                                    </ul>
                                </div>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Salas
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="FrontController?action=BuscarSala" class="" role="button">Painel</a></li>
                                        <li><a href="FrontController?action=PrepararInserirSala" class="" role="button">Cadastro</a></li>
                                    </ul>
                                </div>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Quartos
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="FrontController?action=BuscarQuarto" class="" role="button">Painel</a></li>
                                        <li><a href="FrontController?action=PrepararInserirQuarto" class="" role="button">Cadastro</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <c:if test="${resposta == 'Alteração recusada'}">
                                            <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                <span class="sr-only">Erro:</span>
                                                ${resposta}
                                            </div>
                                        </c:if>
                                        <tr>
                                            <th>Numero</th>
                                            <th>Tipo</th>
                                            <th>Status</th>
                                            <th colspan=3>Ação</th>
                                        </tr>
                                        <c:forEach items="${quartos}" var="quarto">
                                            <tr>
                                                <td><c:out value="${quarto.numero}" /></td>
                                                <td><c:out value="${quarto.tipo}" /></td>
                                                <td><c:out value="${quarto.estado}" /></td>
                                                <!--
                                                <td><a class="btn btn-success btn-xs <c:if test="${quarto.estado.equals('ocupado') || quarto.estado.equals('manutencao')}"> disabled</c:if>" role="button" href="FrontController?action=PrepararCheckInQuarto&codigo=<c:out value="${quarto.codigo}"/>">Check-in</a></td>
                                                <td><a class="btn btn-danger btn-xs <c:if test="${!quarto.estado.equals('ocupado')}"> disabled</c:if>" role="button" href="FrontController?action=PrepararCheckOutQuarto&codigo=<c:out value="${quarto.codigo}"/>">Check-out</a></td>
                                                <td><a class="btn btn-primary btn-xs <c:if test="${!quarto.estado.equals('reservado') && !quarto.estado.equals('disponivel')}"> disabled</c:if>" role="button" href="FrontController?action=PrepararReservarQuarto&codigo=<c:out value="${quarto.codigo}"/>">Reservar</a></td>
                                                    -->
                                                <td><a class="btn btn-success btn-xs " role="button" href="FrontController?action=PrepararCheckInQuarto&codigo=<c:out value="${quarto.codigo}"/>">Check-in</a></td>
                                                <td><a class="btn btn-danger btn-xs " role="button" href="FrontController?action=PrepararCheckOutQuarto&codigo=<c:out value="${quarto.codigo}"/>">Check-out</a></td>
                                                <!--<td><a class="btn btn-primary btn-xs " role="button" href="FrontController?action=PrepararReservarQuarto&codigo=<c:out value="${quarto.codigo}"/>">Reservar</a></td>-->
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <footer class="footer">
                <p>&copy; 2017 Padrões de Projetos - GRANBERY JF.</p>
            </footer>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

