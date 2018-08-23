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

    <title>Erreur - Bibliothèque Bradbury</title>
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
                <s:a class="nav-link" action="myBorrows">Mes emprunts</s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top:30px">
    <div class="alert alert-danger">
        <h4>Malgré tous nos efforts, une erreur est survenue !</h4>
        <p><s:actionerror/></p>
        <p>Veuillez réessayer ou si nécessaire contacter l'administrateur du site.</p>
    </div>
</div>

</body>
</html>
