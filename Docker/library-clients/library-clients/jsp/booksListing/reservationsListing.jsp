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

    <title>Mes réservations en cours - Bibliothèque Bradbury</title>
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
                <s:a class="nav-link active" action="myBorrows">Mes emprunts en cours</s:a>
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
        <div class="card-header text-white bg-secondary"><h4 class="text-center"></h4></div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Titre</th>
                        <th class="text-center">Prochain retour</th>
                        <th class="text-center">Position réservation</th>
                        <th></th>
                    </tr>
                    </thead>

                    <s:iterator value="reservationList" var="reservation">
                        <tr>
                            <td>
                                <s:property value="title"/>
                            </td>
                            <td class="text-center">
                                <s:property value="firstEndBorrowDate"/>
                            </td>
                            <td class="text-center">
                                <s:set var="position" value="%{position(#reservation)}"/>
                                <s:set var="nbReservations" value="%{nbReservations(#reservation)}"/>
                                <s:property value="#position"/>/<s:property value="#nbReservations"/>
                            </td>
                            <td class="text-center">
                                <s:a class="btn btn-primary text-center" action="cancelReservation">
                                    <s:param name="bookReservationId" value="bookReservationId"/>
                                    Annuler
                                </s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
