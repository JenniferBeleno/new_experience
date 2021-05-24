Feature: Busqueda General de productos
Yo como usuario de new experience
Necesito buscar en new experience un producto
Para validar el motor de busqueda

Scenario: BusquedaGeneralProducto
Given Ingreso a la pagina
When Busco el producto "Dresses"
Then Los resultados para "\"DRESSES\"" se muestran