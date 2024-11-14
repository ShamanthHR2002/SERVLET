<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>


<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">

<script>
	function validateForm() {
		let isFormValid = true;
		let name = document.getElementById("name").value;
		let email = document.getElementById("email").value;
		let phone = document.getElementById("phone").value;
		let password = document.getElementById("password").value;

		if (name.length < 3) {
			isFormValid = false;
			document.getElementById("nameError").innerText = "Name must be at least 3 characters.";
		} else {
			document.getElementById("nameError").innerText = "";
		}

		const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		if (!emailPattern.test(email)) {
			isFormValid = false;
			document.getElementById("emailError").innerText = "Enter a valid email.";
		} else {
			document.getElementById("emailError").innerText = "";
		}

		const phonePattern = /^\d{10}$/;
		if (!phonePattern.test(phone)) {
			isFormValid = false;
			document.getElementById("phoneError").innerText = "Enter a valid 10-digit phone number.";
		} else {
			document.getElementById("phoneError").innerText = "";
		}

		if (password.length < 6) {
			isFormValid = false;
			document.getElementById("passwordError").innerText = "Password must be at least 6 characters.";
		} else {
			document.getElementById("passwordError").innerText = "";
		}

		document.getElementById("registerBtn").disabled = !isFormValid;
	}

	function onInputChange() {
		validateForm();
	}
</script>
</head>
<body class="bg-light">
	<div class="container">
		<h2 class="text-center my-4">Registration Form</h2>

		<%
		String message = (String) request.getAttribute("message");
		String messageColor = (String) request.getAttribute("messageColor");
		if (message != null) {
		%>
		<p class="text-center" style="color: <%=messageColor%>;"><%=message%></p>
		<%
		}
		%>

		<form id="registrationForm" action="RegistrationServlet" method="post"
			class="p-4 bg-white rounded shadow-sm">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text" id="name"
					name="name" class="form-control" oninput="onInputChange()">
				<span id="nameError" class="text-danger"></span>
			</div>

			<div class="form-group">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" class="form-control" oninput="onInputChange()">
				<span id="emailError" class="text-danger"></span>
			</div>

			<div class="form-group">
				<label for="phone">Phone:</label> <input type="text" id="phone"
					name="phone" class="form-control" oninput="onInputChange()">
				<span id="phoneError" class="text-danger"></span>
			</div>

			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" class="form-control"
					oninput="onInputChange()"> <span id="passwordError"
					class="text-danger"></span>
			</div>

			<button type="submit" id="registerBtn"
				class="btn btn-primary btn-block" disabled>Register</button>
		</form>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
