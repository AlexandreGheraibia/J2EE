<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<form  method="post" action="accueil">
			<label for="slogin" class="col-sm-2 well well-sm">prénom :</label>
			<input id="slogin" type="text"  class="col-sm-2 well well-sm"  name="prenom"/>
			<label for="spwd" class="col-sm-3 well well-sm">Métier :</label>
			<input id="spwd" class="col-sm-2 well well-sm" type="text"  name="metier"/>
			<input type="submit" class="col-sm-3 well well-sm" value="envoyer"/>
		</form>
	</div>
</div>


</body>
</html>