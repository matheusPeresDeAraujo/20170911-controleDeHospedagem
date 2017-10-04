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
                                <h3 class="panel-title">Apagar Cliente</h3>
                            </div>
                            <div class="panel-body">
                                <form accept-charset="UTF-8" role="form" action="FrontController?action=ApagarCliente" method="post">
                                    <fieldset>
                                        <div class="form-group">
                                            <th><span>Codigo </span></th>
                                            <input name="textCodigo" type="text" value="${cliente.codigo}" hidden/>
                                            <input class="form-control" placeholder="Numero" name="textCodigo" type="text" value="${cliente.codigo}" readonly="readonly"/>
                                        </div>
                                        <div class="form-group">
                                            <th><span>Nome </span></th>
                                            <input name="textNome" type="text" value="${cliente.nome}" hidden/>
                                            <input class="form-control" placeholder="Nome" name="textNome" type="text" value="${cliente.nome}" readonly="readonly"/>
                                        </div>
                                        <div class="form-group">
                                            <th><span>Idade </span></th>
                                            <input name="textIdade" type="text" value="${cliente.idade}" hidden/>
                                            <input class="form-control" placeholder="Idade" name="textIdade" type="text" value="${cliente.idade}" readonly="readonly"/>
                                        </div>
                                        <div class="form-group">
                                            <th><span>Identificacao </span></th>
                                            <input name="textIdentificacao" type="text" value="${cliente.identificacao}" hidden/>
                                            <input class="form-control" placeholder="Identificacao" name="textIdenificacao" type="text" value="${cliente.identificacao}" readonly="readonly"/>
                                        </div>
                                        <div class="form-group">
                                            <th><span>Telefone </span></th>
                                            <input name="textTelefone" type="text" value="${cliente.telefone}" hidden/>
                                            <input class="form-control" placeholder="Telefone" name="textTelefone" type="text" value="${cliente.telefone}" readonly="readonly"/>
                                        </div>
                                        <div class="form-group">
                                            <th><span>Celular </span></th>
                                            <input name="textCelular" type="text" value="${cliente.celular}" hidden/>
                                            <input class="form-control" placeholder="Celular" name="textCelular" type="text" value="${cliente.celular}" readonly="readonly"/>
                                        </div>
                                        <div class="form-group">
                                            <th><span>Email </span></th>
                                            <input name="textEmail" type="text" value="${cliente.email}" hidden/>
                                            <input class="form-control" placeholder="Email" name="textEmail" type="text" value="${cliente.email}" readonly="readonly"/>
                                        </div>
                                        <input class="btn btn-lg btn-danger btn-block" type="submit" value="Apagar">
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
