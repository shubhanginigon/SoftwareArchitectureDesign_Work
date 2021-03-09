<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<br>
  <div class="container">
    <div class="row">
      <div class="col-lg-4"></div>
      <div class="col-lg-4">
        <h2>Add New User/Employee</h2>
        <form action="employee" method="POST">
          <div class=" form-group">
            <label for="name">Name</label>
            <input type="text" name="name" id="name" class="form-control" placeholder="Enter name">
          </div>
          <div class="form-group">
            <label for="level">Level</label>
            <select class="form-control" name="level" id="level">
              <c:forEach items="${levels}" var="level">
                <option value="${level}">${level}</option>
              </c:forEach>
            </select>
          </div> 
          
          <div class=" form-group">
            <label for="birthDay">Birthday</label>
            <input type="date" name="birthDay" id="birthDay" class="form-control" placeholder="">
          </div>
          
          <div class=" form-group">
            <label for="houseNo">HouseNo.</label>
            <input type="text" name="city" id="city" class="form-control" placeholder="">
          </div>
          
          <div class=" form-group">
            <label for="streetAddress">Street</label>
            <input type="text" name="streetAddress" id="streetAddress" class="form-control" placeholder="">
          </div>
          
          <div class=" form-group">
            <label for="city">City</label>
            <input type="text" name="city" id="city" class="form-control" placeholder="">
          </div>
          
          <div class=" form-group">
            <label for="zipcode">Zipcode:</label>
            <input type="text" name="zipcode" id="zipcode" class="form-control" placeholder="">
          </div>
          
          <br>
          <button type="submit" class="btn btn-success btn-block">Add</button>
        </form>
      </div>
      <div class="col-lg-4"></div>
    </div>
  </div>

</body>
</html>