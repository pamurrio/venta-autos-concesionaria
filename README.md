# venta-autos-concesionaria

venta-autos-concesionaria es un sistema simple para generar pedidos de auto y poder seleccionar optionalmente otras variantes.

## Installation

maven package
maven clean install

## RUN
java -jar target/venta-autos-concesionaria-0.0.1-SNAPSHOT


## Contributing

GET - http://localhost:1197/list/cars
host: https://venta-autos-concesionaria.herokuapp.com/list/cars
Lista los autos disponibles

GET - http://localhost:1197/detail/car/{id}
host: https://venta-autos-concesionaria.herokuapp.com/detail/car/{id}
Detalla el auto seleccionado

GET - http://localhost:1197/list/invoices
host: https://venta-autos-concesionaria.herokuapp.com/list/invoices
Detalle las reservas hechas con auto y accesorios si tiene

GET - http://localhost:1197/stats
host: https://venta-autos-concesionaria.herokuapp.com/stats
Estadisticas de autos y accesorios guardados

POST - http://localhost:1197/calculateBudget
host: https://venta-autos-concesionaria.herokuapp.com/calculateBudget
Calcula el presupuesto del auto y accesorios seleccionados
body: {
    "idCar": 3, // indica el id del auto
    "optionals": [ 1,2] // indica el listado de ids de los opcionales a completar
}

POST - http://localhost:1197/reserveVehicle
host: https://venta-autos-concesionaria.herokuapp.com/reserveVehicle
Reserva el presupuesto del auto y accesorios seleccionados
body: {
    "idCar": 3, // indica el id del auto
    "optionals": [ 1,2] // indica el listado de ids de los opcionales a completar
}


Postman la carpeta postman con su variable de entorno.

REPO:
https://github.com/pamurrio/venta-autos-concesionaria


## License
[MIT](https://choosealicense.com/licenses/mit/)