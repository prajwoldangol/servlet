<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;300;500;600;700;900&display=swap"
	rel="stylesheet">
	<link href="style.css" rel="stylesheet" >
	<script type="text/javascript">
	window.onload = function() {
		var select = document.getElementById("state");
		var defaultVal = document.getElementById("defaultstate").value;
		console.log(select);
		console.log(defaultVal);
		for( var s = 0; s< select.length; s++){
			var option = select.options[s];
			if( option.value == defaultVal ){
				option.setAttribute("selected",true) ;
				
			}
		}
	}
	</script>

</head>
<body>
	<!-- <form name="loginForm" method="post" action="loginServlet">
  Number1: <input type="number" name="num1"/> <br/>
  Number2: <input type="number" name="num2"/> <br/>
  <input type="submit" value="Login" />


</form> -->

	<form name="details" method="post" action="edit">
		<header>
		<a href="ViewRecord"> View Student List &rarr;</a>
			<h1>New Student Registration</h1>
			
		</header>
		<div class="wrap">
			<div class="fwrapper">
				
				<div class="field">
					<label for="fname">First Name</label> <input type="text"
						name="fname" placeholder="First Name" value = "<c:out value="${student.fname}"/>" required >
				</div>
				<div class="field">
					<label for="mname">Middle </label> <input type="text" name="mname" value = "<c:out value="${student.mname}"/>"
						placeholder="Middle Name">
				</div>
				<div class="field">
					<label for="lname">Lastname</label> <input type="text" name="lname" value = "<c:out value="${student.lname}"/>"
						placeholder="Last Name" required>
				</div>
				<div class="field radios">
					<label for="gender" class="gender">Gender</label> <label for="male">Male</label>
					<c:if test ="${student.gender == 'male'}">
						<c:set var = "malecheck" value="checked=\"checked\"" />
					</c:if>
					<c:if test ="${student.gender == 'female'}">
						<c:set var = "femalecheck" value="checked=\"checked\"" />
					</c:if>
					<input type="radio" name="gender" id="male" value="male" <c:out value="${malecheck}"/>  > <label
						for="female">Female</label> <input type="radio" name="gender"
						id="female" value="female" <c:out value="${femalecheck}"/> >
				</div>
				<div class="field date">
					<label for="age">Date Of Birth</label> <input type="date" value = "<c:out value="${student.dob}"/>"
						name="age" required>
				</div>
				<!-- </div> -->
				<!-- <div class="fwrapper address"> -->

				<!-- </div>
      <div class="fwrapper"> -->
				<div class="field">
					<label for="email">Email</label> <input type="email" name="email" value = "<c:out value="${student.email}"/>"
						placeholder="Email@email.com" required>
				</div>
				<div class="field">
					<label for="tel">Telephone</label> <input type="tel" name="tel" value = "<c:out value="${student.phone}"/>"
						placeholder="000-000-0000" required>
				</div>

			</div>
			<h2>Address Informations</h2>
			<div class="fwrapper fwrapper-row">
				<div class="field address">
					<label for="address">Mailing Address</label> <input type="text" value = "<c:out value="${student.adddress1}"/>"
						name="address" class="mainaddress"
						placeholder="Main Street Address">
				</div>
				<div class="field address">
					<label for="addressline">Address Line 2</label> <input type="text" value = "<c:out value="${student.address2}"/>"
						name="addressline" class="mainaddress" placeholder="Apt/Suite">
				</div>
			</div>
			<input type="hidden" name="uid" value="<c:out value="${student.id}"/>">
			<div class="fwrapper">

				<div class="field">
				<input type="hidden" id="defaultstate" value="<c:out value="${student.state}"/>">
					<label for="state">State</label>
				
					<!-- <input type="text" name="state" > -->
					<select name="state" id="state" required>
						<option value="" selected disabled>Select Your State</option>
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">Dist of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA">Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
					</select>
				</div>
				<div class="field">
					<label for="city">City</label> <input type="text" name="city" value = "<c:out value="${student.city}"/>"
						placeholder="City">
				</div>
				<div class="field">
					<label for="zip">Zip Code</label> <input type="number" name="zip" value = "<c:out value="${student.zip}"/>"
						placeholder="Zip/Postal">
				</div>
			</div>

			<div class="submitbtn">
				<input type="submit" name="submit" value="Enter">
			</div>
		</div>

	</form>

</body>
</html>
