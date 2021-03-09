<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Employee Success</title>
        <link href="..\css\bootstrap.min.css" rel="stylesheet">
<title>Employee List</title>
</head>
<body>
	<div class="container">
        <h2>Employee Added with name ${emp.name}</h2>

        <form action="list" >//method="GET">
            <button type="submit" class="btn btn-primary">List all employees</button>
        </form>
    </div>
</body>
</html>