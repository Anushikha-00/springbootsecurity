# springbootLoginSecurity


This project is a backend implementation of a login and signup REST API with security features and JSON Web Tokens (JWT) for authentication.
It is built using the Spring Boot framework and utilizes the H2 database for storing user account information.

Installation
Clone the repository:
  git clone https://github.com/Anushikha-00/springbootsecurity.git
Navigate to the project directory:
  cd project-name
Build the project using Maven:
  mvn clean install
Run the project:
  mvn spring-boot:run
The application will be accessible at http://localhost:8080.


Dependencies
The project has the following dependencies:

Spring Boot Starter Web: For building RESTful APIs.
Spring Boot Starter Data JPA: For interacting with the H2 database.
Spring Boot Starter Security: For implementing security measures.
H2 Database: In-memory database for storing user account information.
Springfox Swagger: For generating API documentation.


Functionality
UserController
This class handles the user signup and login functionality.

signup(): POST request to /api/signup. Allows users to create a new account by providing their username, password, and email. The user's password is encrypted and saved securely in the database.
login(): POST request to /api/login. Authenticates users by checking their username and password. Upon successful authentication, a JWT token is generated and returned in the response.

User
This entity class represents the user account details.

id: Unique identifier for the user.
username: User's username.
password: Encrypted password for user authentication.
email: User's email address.

UserRepository
This interface extends the JpaRepository and provides methods for interacting with the user data in the database.

findByUsername(String username): Retrieves a user by their username.
existsByUsername(String username): Checks if a user with the given username exists in the database.


UserDetailsServiceImpl
This class implements the UserDetailsService interface provided by Spring Security.

loadUserByUsername(String username): Loads user details from the UserRepository based on the given username. Used for user authentication during the login process.


WebSecurityConfig
This class extends the WebSecurityConfigurerAdapter provided by Spring Security.

configure(HttpSecurity http): Configures security measures for the application. Allows access to the /api/signup endpoint without authentication, while requiring authentication for other endpoints.


JwtTokenUtil
This class provides utility methods for JWT token generation and validation.

generateToken(UserDetails userDetails): Generates a JWT token based on the provided user details.
extractUsername(String token): Extracts the username from a JWT token.
validateToken(String token, UserDetails userDetails): Validates the provided JWT token.

API Documentation
The API documentation is generated using Postman It provides detailed information about each API endpoint, including the request and response structures, as well as the authentication requirements.






