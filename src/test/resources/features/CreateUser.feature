# language: es

@Regresion
Característica: Crear un usuario usuario
  Crear un usuario usuario

  @Crear
  Esquema del escenario: Crear un usuario usuario
    Dado que ingreso la data para el almacenamiento un ususario nuevo
    Cuando valido el codigo de respuesta "201"
    Entonces verifico la respuestas con los datos creados
      | <name> | <job> |
    Ejemplos: Crear un usuario usuario
      | name      | job         |
      |Yefri|Qa Automatión|
