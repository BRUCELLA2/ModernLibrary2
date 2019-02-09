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

    <title>Enregistrement - Bibliothèque Bradbury</title>
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
    <div class="card mb-4 w-75 mx-auto">
        <div class="card-header text-white bg-secondary"><h4 class="text-center">Enregistrement</h4></div>
        <div class="card-body">

            <form method="post" action="register">

                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="userLogin" class="mr-sm-2">Identifiant : </label>
                        <input type="text" class="form-control is-invalid mb-2 mr-sm-2" id="userLogin" name="userLogin"
                               value='<s:property value="userLogin"/>' maxlength="30">
                        <div class="invalid-feedback"><s:fielderror fieldName="userLogin"/></div>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="userLine1" class="mr-sm-2">Adresse ligne 1 : </label>
                        <input type="text" class="form-control is-invalid mb-2 mr-sm-2" id="userLine1" name="userLine1"
                               value='<s:property value="userLine1"/>' maxlength="200">
                        <div class="invalid-feedback"><s:fielderror fieldName="userLine1"/></div>
                    </div>

                    <div class="col-sm-6">
                        <label for="userLine2" class="mr-sm-2">Adresse ligne 2 : </label>
                        <input type="text" class="form-control mb-2 mr-sm-2" id="userLine2" name="userLine2"
                               value='<s:property value="userLine2"/>' maxlength="200">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="userLine3" class="mr-sm-2">Adresse ligne 3 : </label>
                        <input type="text" class="form-control mb-2 mr-sm-2" id="userLine3" name="userLine3"
                               value='<s:property value="userLine3"/>' maxlength="200">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="userZipCode" class="mr-sm-2">Code postal : </label>
                        <input type="text" class="form-control is-invalid mb-2 mr-sm-2" id="userZipCode"
                               name="userZipCode"
                               value='<s:property value="userZipCode"/>' maxlength="5" minlength="5">
                        <div class="invalid-feedback"><s:fielderror fieldName="userZipCode"/></div>
                    </div>

                    <div class="col-sm-6">
                        <label for="userCity" class="mr-sm-2">Ville : </label>
                        <input type="text" class="form-control is-invalid mb-2 mr-sm-2" id="userCity" name="userCity"
                               value='<s:property value="userCity"/>' maxlength="100">
                        <div class="invalid-feedback"><s:fielderror fieldName="userCity"/></div>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="userEmail" class="mr-sm-2">Email : </label>
                        <input type="email" class="form-control is-invalid mb-2 mr-sm-2" id="userEmail" name="userEmail"
                               value='<s:property value="userEmail"/>' maxlength="100">
                        <div class="invalid-feedback"><s:fielderror fieldName="userEmail"/></div>
                    </div>

                    <div class="col-sm-6">
                        <label for="userPhone" class="mr-sm-2">Téléphone : </label>
                        <input type="text" class="form-control is-invalid mb-2 mr-sm-2" id="userPhone" name="userPhone"
                               value='<s:property value="userPhone"/>' maxlength="10" minlength="10">
                        <div class="invalid-feedback"><s:fielderror fieldName="userPhone"/></div>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="userPass" class="mr-sm-2">Mot de passe : </label>
                        <input type="password" class="form-control is-invalid mb-2 mr-sm-2" id="userPass"
                               name="userPass"
                               maxlength="100">
                        <div class="invalid-feedback"><s:fielderror fieldName="userPass"/></div>
                    </div>

                    <div class="col-sm-6">
                        <label for="userPassConf" class="mr-sm-2">Confirmation du mot de passe : </label>
                        <input type="password" class="form-control is-invalid mb-2 mr-sm-2" id="userPassConf"
                               name="userPassConf"
                               maxlength="100">
                        <div class="invalid-feedback"><s:fielderror fieldName="userPassConf"/></div>
                    </div>
                </div>
                <!--
                                <div class="form-group row">
                                    <div class="col-sm-6">
                                        <label class="form-check-label" for="beforeReminder">Activer l'option de rappel avant expiration des emprunts :
                                        <input type="checkbox" class="form-check-input" id="beforeReminder" value="false" name="beforeReminder">
                                        </label>
                                    </div>
                                </div>
                -->
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="beforeReminder" value="true"
                           name="beforeReminder">
                    <label class="form-check-label" for="beforeReminder">Rappel avant expiration des emprunts.</label>
                </div>

        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary">S'enregistrer</button>
        </div>

        </form>

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