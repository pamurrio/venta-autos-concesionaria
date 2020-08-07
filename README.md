# venta-autos-concesionaria

venta-autos-concesionaria es un sistema simple para generar pedidos de auto y poder seleccionar optionalmente otras variantes.

## Installation

maven package
maven clean install

## RUN
java -jar target/venta-autos-concesionaria-0.0.1-SNAPSHOT


## Contributing

GET - http://localhost:1197/list/cars
Lista los autos disponibles

GET - http://localhost:1197/detail/car/{id}
Detalla el auto seleccionado

GET - http://localhost:1197/list/invoices
Detalle las reservas hechas con auto y accesorios si tiene

GET - http://localhost:1197/stats
Estadisticas de autos y accesorios guardados

POST - http://localhost:1197/calculateBudget
Calcula el presupuesto del auto y accesorios seleccionados

POST - http://localhost:1197/reserveVehicle
Reserva el presupuesto del auto y accesorios seleccionados

Postman la carpeta postman con su variable de entorno.




## License
[MIT](https://choosealicense.com/licenses/mit/)