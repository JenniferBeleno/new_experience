Feature: Iniciar Sesion
Yo como usuario de new experience
Necesito iniciar sesion en new experience
Para acceder a todas las funciones de la pagina

	Scenario:
	Given Ingreso a la pagina new experience
	When Ingreso a Sign In
	And Digito Email address "jenniferbeleno11@gmail.com"
	And Digito Password "PRUEBA123"
	Then accedo a la pagina new experience con el cliente "Jennifer Paola Beleño Sanchez"