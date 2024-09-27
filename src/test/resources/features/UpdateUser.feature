# language: es

@Regresion
Característica: Actulizar informacion de un usuario usuario
  Actulizar informacion de un usuario usuario

  @Actulizar
  Esquema del escenario: Actulizar informacion de un usuario usuario
    Dado que ingreso la data para la actualizacion de un ususario
      | <name> | <job> |
    Cuando valido el codigo de respuesta "200"
    Entonces verifico la respuestas con los datos creados
      | <name> | <job> |
    Ejemplos: Actulizar informacion de un usuario usuario
      | name      | job         |
      | Tadeo Elias Ruiz | Ingeniero         |
