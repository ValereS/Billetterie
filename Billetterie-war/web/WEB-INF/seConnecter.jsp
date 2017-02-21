<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="FrontController" method="POST">
    <label>Email:</label><input type="text" name="email" value="" /><br/>
    <label>Mot de Passe:</label><input type="password" name="mdp" value="" /><br/>
    <input type="hidden" name="section" value="seConnecter">
    <input type="submit" value="Se connecter" />
</form>
