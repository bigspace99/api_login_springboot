# api_login_springboot

Simple API Rest in JAVA Springboot. Spring boot and H2 are configured in docker so just use docker-compose up --build to start the project.

Use Postman to test it :

http://localhost:8080/auth/register for register http://localhost:8080/auth/login for login

user,password,role(USER or ADMIN) as JSON.

It's an API Rest so there is only a simple front end but you can try it in http://localhost:8080/auth/home if you don't use postman.
