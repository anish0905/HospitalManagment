<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="component/allcss.jsp"%>
</head>
<body>
<%@include file="component/navBar.jsp" %>
	<h1>Sign up</h1>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">

				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text center">Signup
						<p />

						<form action="user_register" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> 
								<input type="text" name='name1'
									class="form-control" required  >
							</div>

							<div class="mb-3">
								<label class="form-label">Email address</label> 
								<input required
									name='email' type="email" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name='password' type="password" class="form-control">
							</div>
							<button type="submit" class="btn bg-success text-white col-md-12">Register</button>

						</form>
					</div>
				</div>


			</div>


		</div>


	</div>

	<%@ include file ="component/footer.jsp" %>

</body>
</html>