# practica-queues

1. Abrir una terminal y crear el directorio practicas-entregables
2. Ingresar al directorio creado en el paso anterior
3. Clonar el repositorio https://github.com/edreycruz/practica-queues.git
4. Abrir Eclipse o STS
5. Importar el proyecto Accounts como Proyecto Existente Maven
6. Importar el proyecto Log como Proyecto Existente Maven
7. Importar el proyecto Users como Proyecto Existente Maven
8. Abrir el archivo microservice-accounts/src/main/resources/application.properties y cambiar los valores spring.rabbitmq.host y spring.rabbit.port por los valores de la instancia RabbitMQ que esté en ejecución
9. Abrir el archivo microservice-log/src/main/resources/application.properties y cambiar los valores spring.rabbitmq.host y spring.rabbit.port por los valores de la instancia RabbitMQ que esté en ejecución
10. Abrir el archivo microservice-users/src/main/resources/application.properties y cambiar los valores spring.rabbitmq.host y spring.rabbit.port por los valores de la instancia RabbitMQ que esté en ejecución
11. Abrir la clase AccountMicroserviceApplication y Ejecutar como Aplicación Spring Boot
12. Abrir la clase LogMicroserviceApplication y Ejecutar como Aplicación Spring Boot
13. Abrir la clase UserMicroserviceApplication y Ejecutar como Aplicación Spring Boot
14. Abrir un Cliente SOAP/REST (ej. Boomerang)
15. Introducir el nombre del proyecto (ej. Microservicios) y seleccionar Create a service
16. Seleccionar la opción REST e introducir un nombre para el servicio (ej. Queues) y seleccionar Add
17. En la pestaña Request1 cambiar el método GET por POST e introducir la URL http://localhost:8083/users-microservice/users
18. En el cuerpo de la petición introducir {"name":"eucc","email":"eucc@mail.com"} y verificar que el formato de la petición sea JSON
19. Seleccionar Send
20. El servicio devolverá el texto user created.
