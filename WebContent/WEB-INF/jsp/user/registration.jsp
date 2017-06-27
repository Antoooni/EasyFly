<%@include file="/WEB-INF/include/root.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang=${language}>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Registration</title>
	
	<link rel="stylesheet" type="text/css" href="css/registration.css" />
	<style>
	@import url(css/registration_files/formoid1/formoid-solid-red.css);
	</style>
	<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>-->
</head>
<body class="blurBg-false" style="background-color: #EBEBEB">


	<div class="container_flights_list">
		<header>
			<%@include file="/WEB-INF/include/header.jspf"%>
		</header>

		<div class="main-and-sidebar-wrapper">

			<!-- Start Formoid form-->
			<!--<link rel="stylesheet" href="formoid_files/formoid1/formoid-solid-red.css" type="text/css" />-->
			<script type="text/javascript"
				src="registration_files/formoid1/jquery.min.js"></script>
			<form class="formoid-solid-red"
				style="background-color: #FFFFFF; font-size: 15px; font-family: 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
				method="GET" action="Main" id="create_user">
				<input type="hidden" name="action" value="create_user">
				<div class="title">
					<h2>Registration</h2>
				</div>
				<div class="element-input">
					<label class="title"> <span class="required">*</span>
					</label>
					<div class="item-cont">
						<input class="large" type="text" name="create_login"
							required="required" placeholder="Login" />
						<!--<span class="icon-place"></span>-->
					</div>
				</div>
				<div class="element-password">
					<label class="title"> <span class="required">*</span>
					</label>
					<div class="item-cont">
						<input class="large" type="password" name="create_password"
							value="" required="required" placeholder="Password" />
						<!--<span class="icon-place"></span>-->
					</div>
				</div>
				<div class="element-password">
					<label class="title"></label>
					<div class="item-cont">
						<input class="large" type="password" name="create_password1"
							value="" placeholder="Password confirm" />
						<!-- <span class="icon-place"></span>-->
					</div>
				</div>
				<div class="element-name">
					<!--<label class="title"></label>-->
					<span class="nameFirst"> <input placeholder="Name First"
						type="text" size="8" name="name[first]" /> <span
						class="icon-place"></span>
					</span> <span class="nameLast"> <input placeholder="Name Last"
						type="text" size="14" name="name[last]" /> <span
						class="icon-place"></span>
					</span>
				</div>
				<div class="element-email">
					<label class="title"> <span class="required">*</span>
					</label>
					<div class="item-cont">
						<input class="large" type="email" name="create_email" value=""
							required="required" placeholder="Email" />
						<!--<span class="icon-place"></span>-->
					</div>
				</div>
				<div class="submit">
					<input type="submit" value="Register" />
				</div>
			</form>
		</div>
		<div>
			<!-- FOOTER -->
			<%@include file="/WEB-INF/include/footer.jspf"%>
	</div>
	<c:if test="${user_exist == true}">
		<div class="message_registartion">
			<c:out value="This user is already exists!" />
		</div>
	</c:if>
	<c:if test="${email_exist == true}">
		<div class="message_registartion">
			<c:out value="This email is already busy!!!" />
		</div>
	</c:if>
	<c:if test="${success != null}">
		<div class="message_registartion_success">
			<c:out value="User created successfully" />
		</div>
	</c:if>
	<p class="frmd">
		<a href="http://formoid.com/v29.php">html form</a> Formoid.com 2.9
	</p>
	<script type="text/javascript"
		src="registration_files/formoid1/formoid-solid-red.js"></script>
	<!-- Stop Formoid form-->

	
</body>
</html>