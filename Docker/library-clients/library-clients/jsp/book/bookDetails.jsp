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

    <title>Détails du livre - Bibliothèque Bradbury</title>
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
                <s:a class="nav-link" action="search_books">Recherche</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link" action="myBorrows">Mes emprunts en cours</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link" action="myReservations">Mes réservations en cours</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link" action="history">Historique</s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top: 30px">
    <div class="card mb-4">
        <div class="card-header text-white bg-secondary"><h4 class="text-center">Détails du livre</h4></div>
        <div class="card-body">
            <h5 class="card-text text-center"><s:property value="bookDetailsDto.title"/></h5>
            <div class="card-text">Auteurs :
                <ul>
                    <s:iterator value="bookDetailsDto.authors">
                        <li><s:property value="lastName"/>, <s:property value="firstName"/></li>
                    </s:iterator>
                </ul>
            </div>
            <p>Editeur : <s:property value="bookDetailsDto.publisherName"/><br/>
                Date de publication : <s:property value="bookDetailsDto.publishingDate"/></p>
            <p>Genre : <s:property value="bookDetailsDto.genreName"/></p>
            <p>EAN13 : <s:property value="bookDetailsDto.ean13"/></p>
            <p>Résumé : <br/><br/>
                <s:property value="bookDetailsDto.resume"/>
            </p>
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