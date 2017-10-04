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
                                <h3 class="panel-title">Gravar Quarto</h3>
                            </div>
                            <div class="panel-body">
                                <form accept-charset="UTF-8" role="form" action="FrontController?action=GravarQuarto" method="post">
                                    <fieldset>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Numero" name="textNumero" type="text">
                                        </div>
                                        <div class="form-group">
                                            <select name="textTipo" class="form-control">
                                                <option name="textTipo" value="single room">Single Room</option>
                                                <option name="textTipo" value="twin room">Twin Room</option>
                                                <option name="textTipo" value="double room">Double Room</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Vista" name="textVista" type="text">
                                        </div>
                                        <div class="form-group">
                                            <select name="textEstado" class="form-control">
                                                <option name="textEstado" value="disponivel">Disponivel</option>
                                                <option name="textEstado" value="ocupado">Ocupado</option>
                                                <!--<option name="textEstado" value="reservado">Reservado</option>-->
                                                <option name="textEstado" value="manutencao">Manutencao</option>
                                            </select>
                                        </div>
                                        <input class="btn btn-lg btn-success btn-block" type="submit" value="Gravar">
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

