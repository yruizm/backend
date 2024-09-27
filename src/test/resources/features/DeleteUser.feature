# language: es

@Regresion
Característica: eliminar un usuario
  Deseo eliminar un usuario

  @Eliminar
  Escenario:  eliminar un usuario
    Dado que consumo el api operacion eliminar
    Cuando valido el codigo de respuesta "204"

