# ms-test-usuario
Spring Boot con H2

##Como Usar el Microservcio
(Utilizar collecttion de postman "Test-usuario.postman_collection")
- Primero Creo un usuario en la Base de datos H2 , con el POST /Insertar Usuario, (La password y el correo deben cumplir con el formato.)
- Luego genero un token con la clave y el Email insertado en el POST anterior , utilizado el POST token
- Finalmente ingreso el token (Bearer ...) del header de la respuesta anterior, lo coloco en la cabezera del GET /obtener Usuario
con el correo anteriormente ingresado para obtener el detalle del dato del Usuario

NOTA : se deja diagrama de la solucion en el Repositorio con el nombre "Diagrama_Test_Usuario.pdf"