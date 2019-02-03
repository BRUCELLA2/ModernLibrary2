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

    <title>Emprunts terminés - Bibliothèque Bradbury</title>
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
                <s:a class="nav-link active" action="history">Historique</s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top: 30px">
    <div class="card mb-4">
        <div class="card-header text-white bg-secondary"><h4 class="text-center">Emprunts terminés</h4></div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Début de l'emprunt</th>
                        <th>Fin de l'emprunt</th>
                        <th></th>
                    </tr>
                    </thead>

                    <s:iterator value="borrowsList" var="books">
                        <tr>
                            <td>
                                <s:property value="title"/><br>
                            </td>
                            <td>
                                <s:property value="borrowDate"/>
                            </td>
                            <td>
                                <s:property value="endDate"/>
                            </td>
                            <td class="text-center">
                                <s:a class="btn btn-primary text-center" action="book_details">
                                    <s:param name="bookId" value="bookId"/>
                                    Détails</s:a></td>
                            </td>
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