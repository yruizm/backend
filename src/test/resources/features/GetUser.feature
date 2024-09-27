# language: es

@Regresion
Característica: Consulta unico usuario
  Deseo Consultar un unico usuario

  @Consultar
  Escenario:  Consulta unico usuario
    Dado que consumo el api operacion get
    Cuando valido el codigo de respuesta "200"
    Entonces verifico el id en la respuesta

