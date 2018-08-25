<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS Spacelab theme-->
    <link rel="stylesheet" href="/library-clients/boostrap/css/bootstrap.css">
    <!-- <link rel="stylesheet" type="text/css" href="/library-clients/include/css/library-clients.css"> -->

    <title>Recherche de livres - Bibliothèque Bradbury</title>
</head>

<body>
<div class="container">
    <header class="pb-2 mt-4 mb-2 border-bottom">
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3">Bibliothèque Bradbury</h1>
            </div>
        </div>
    </header>

    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
        <ul class="navbar-nav">
            <li class="nav-item">
                <s:a class="nav-link active" action="search_books">Recherche</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link" action="myBorrows">Mes emprunts</s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top: 30px">
    <div class="card mb-4">
        <div class="card-header text-white bg-primary"><h4 class="text-center">Recherche de livres</h4></div>
        <div class="card-body">

            <form method="post" action="search_books">
                <div class="form-row justify-content-around">
                    <div class="form-group mr-sm-2">
                        <label for="authorLastName" class="mr-sm-2">Nom de l'auteur : </label>
                        <input type="text" class="form-control mb-2 mr-sm-2" id="authorLastName" name="authorLastName">
                    </div>
                    <div class="form-group mr-sm-2">
                        <label for="title" class="mr-sm-2">Titre du livre : </label>
                        <input type="text" class="form-control mb-2 mr-sm-2" id="title" name="title">
                    </div>
                </div>
                <div class="form-row justify-content-around">
                    <div class="form-group mr-sm-2">
                        <label for="genreName" class="mr-sm-2">Genre : </label>
                        <input type="text" class="form-control mb-2 mr-sm-2" id="genreName" name="genreName">
                    </div>
                    <div class="form-group mr-sm-2">
                        <label for="publisherName" class="mr-sm-2">Nom de l'éditeur : </label>
                        <input type="text" class="form-control mb-2 mr-sm-2" id="publisherName" name="publisherName">
                    </div>
                    <div class="form-group mr-sm-2">
                        <label for="ean13" class="mr-sm-2">EAN13 : </label>
                        <input type="text" class="form-control mb-2 mr-sm-2" id="ean13" name="ean13">
                    </div>
                </div>
                <div class="form-row justify-content-around">
                    <div class="form-check mb-4 mr-sm-2">
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input" value="true" id="bookAvailable"
                                   name="bookAvailable">Livre(s) disponible(s)
                        </label>
                    </div>
                </div>
                <div class="form-row text-center">
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary">Rechercher</button>
                    </div>
                </div>
            </form>

        </div>
    </div>

    <div class="card mb-4">
        <div class="card-header text-white bg-secondary"><h4 class="text-center">Liste des livres recherchés</h4></div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Auteur(s)</th>
                        <th>Genre</th>
                        <th>Editeur</th>
                        <th>Résumé</th>
                    </tr>
                    </thead>

                    <s:iterator value="booksList" var="books">
                        <tr>
                            <td>
                                <s:property value="title"/><br>
                                publié le : <s:property value="publishingDate"/>
                            </td>
                            <td>
                                <ul>
                                    <s:iterator value="authors">
                                        <li><s:property value="lastName"/>, <s:property value="firstName"/></li>
                                    </s:iterator>
                                </ul>
                            </td>
                            <td><s:property value="genreName"/></td>
                            <td><s:property value="publisherName"/></td>
                            <td><s:property value="resume"/></td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
    </div>

</div>

<%@include file="/include/jsp/footer.jsp" %>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>
</body>

</html>
