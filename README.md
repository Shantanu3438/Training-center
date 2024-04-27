# Training Center Management Application

This is a Spring Boot application for managing training centers. It has APIs for creating and retrieving training centers.

## Dependencies

The application has the following dependencies:

- Spring Boot Web Starter
- Spring Boot Data JPA
- Spring Boot Validation
- PostgreSQL Driver

## Database Configuration

The application uses PostgreSQL as the primary database. The configuration of the the PostgreSQL connection is in the `application.properties` file:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
## API Endpoints

The application provides the following API endpoints:

### Training Center

#### Get All Training Centers
- **Endpoint**: `GET /training-centers`
- **Description**: Retrieve a list of all training centers.
- **Response**: An array of training center objects.
 - **Status Code**: 200 OK

#### Create a New Training Center
- **Endpoint**: `POST /training-centers`
- **Description**: Create a new training center.
- **Request Body**:
```json
{
    "centerName" : "Bangalore",
    "centerCode" : "BA45ARDWEDNC",
    "address" : {
        "streetName" : "Anandnagar",
        "city" : "Bangalore",
        "state" : "Karnataka",
        "pincode" : "560064"
    },
    "studentCapacity" : "100",
    "cources" : ["Java", "Python", "C++"],
    "contactEmail" : "xyz@gmail.com",
    "contactPhone" : "8875243213"
}
```
#### Get Training Centers by Name
- **Endpoint**: `GET /get-center-name?centerName=<centerName>`
- **Description**: Retrieve training centers by center name.
- **Request Parameters**:
 - `centerName`: The name of the training center.
- **Response**: A list of training center objects matching the provided name.
 - **Status Code**: 200 OK
   
#### Get Training Centers by Code
- **Endpoint**: `GET /get-center-code?centerCode=<centerCode>`
- **Description**: Retrieve training centers by center code.
- **Path Parameters**:
 - `centerCode`: The code of the training center.
- **Response**: A list of training center objects matching the provided code.
 - **Status Code**: 200 OK
