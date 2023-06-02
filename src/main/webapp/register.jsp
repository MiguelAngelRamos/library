<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"  rel="stylesheet">
	
	<title>Login</title>
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center">Registre una Cuenta</h1>
	
   	<!-- Codigo del Formulario Login -->
		 <div class="row mt-5">
		    <div class="col-4 offset-4">
		    
		      <form id="form-register">
		        <div class="mb-3">
		          <label for="user" class="form-label">Usuario</label>
		          <input
		            type="text"
		            class="form-control"
		            id="user"
		        		name="usuario"
		        		required
		          />
		        </div>
		
		        <div class="mb-3">
		          <label for="password" class="form-label">Ingrese su contraseña</label>
		          <input
		            type="password"
		            class="form-control"
		            id="password"
		            name="password"
		            required
		          />
		    
		        </div>
		        
		        <div class="d-grid gap-2">
		          <button type="submit" class="btn btn-secondary">Registrarse</button>
		        </div>
		        
		      </form>
		
		    </div>
		  </div>
		<!-- Fin Codigo del Formulario Login -->
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/app.js"></script>
</body>
</html>