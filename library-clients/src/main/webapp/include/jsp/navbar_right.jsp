<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:if test="#session.userLog">
    <ul class="navbar-nav ml-auto">
        <li><s:a class="nav-link" action="logout">Se déconnecter</s:a></li>
    </ul>
</s:if>
<s:else>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item"><s:a class="nav-link" action="register">S'inscrire</s:a></li>
        <li class="nav-item"><s:a class="nav-link" action="login">Se connecter</s:a></li>
    </ul>
</s:else>