# Music Catalog API

## Project Overview
The **Music Catalog API** is a RESTful service designed to manage a music catalog with albums, songs, and users. Built using Spring Boot, it ensures secure, stateless authentication and adheres to modern DevOps practices. The API supports user roles (USER and ADMIN) for controlled access to its features, including album and song management, and user authentication.

## Features
### Album Management
- **List Albums**: Paginated listing of all albums.
- **Search Albums**: Search by title, artist, or filter by release year with pagination and sorting.
- **Add/Edit/Delete Albums**: Admin-only operations for creating, updating, and removing albums.

### Song Management
- **List Songs**: Paginated listing of all songs.
- **Search Songs**: Search by title or view songs within a specific album.
- **Add/Edit/Delete Songs**: Admin-only operations for managing songs.

### User Management
- **Authentication**: Stateless JWT-based login and secure token generation.
- **User Registration**: Allow users to create accounts.
- **Role Management**: Admins can assign roles to users.
- **List Users**: Admin-only access to list all users.

### Security
- **Role-Based Access**: Restrict access to endpoints based on roles (USER or ADMIN).
- **Password Encryption**: Secure password storage using `BCryptPasswordEncoder`.
- **JWT Authentication**: Tokens include issuer, subject, roles, and expiration.

### DevOps Integration
- **CI/CD Pipelines**: Automated testing and deployment.
- **Containerization**: Dockerized deployment for consistency.
- **Monitoring**: Ensure API performance and uptime.

## API Endpoints
### Public Endpoints
- `POST /api/auth/login`: Authenticate a user and generate a JWT.
- `POST /api/auth/register`: Register a new user.

### User Endpoints
- `GET /api/user/albums`: List albums.
- `GET /api/user/songs`: List songs.
- `GET /api/user/songs/album/{albumId}`: List songs in a specific album.

### Admin Endpoints
- `POST /api/admin/albums`: Add a new album.
- `PUT /api/admin/albums/{id}`: Update album details.
- `DELETE /api/admin/albums/{id}`: Delete an album.
- `POST /api/admin/songs`: Add a new song.
- `PUT /api/admin/songs/{id}`: Update song details.
- `DELETE /api/admin/songs/{id}`: Delete a song.
- `GET /api/admin/users`: List all users.
- `PUT /api/admin/users/{id}/roles`: Manage user roles.

## Technologies Used
- **Spring Boot**: Backend framework.
- **Spring Security**: Role-based access control and JWT authentication.
- **MongoDb Database**: For development and production data storage.
- **Docker**: Containerization for deployment.
- **JUnit**: Testing framework.

## Getting Started
### Prerequisites
- Java 8 or higher
- Maven
- Docker (optional, for containerized deployment)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Benfill/ISDb.git
   cd ISDb
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Running in Docker
1. Build the Docker image:
   ```bash
   docker build -t ISDb .
   ```
2. Run the container:
   ```bash
   docker run -p 8080:8080 ISDb
   ```

### Testing
Run the test suite with:
```bash
mvn test
```

## Security Best Practices
- Use HTTPS in production environments.
- Rotate JWT signing keys regularly.
- Store database credentials securely (e.g., environment variables).

## Future Enhancements
- Add support for album and song ratings.
- Implement advanced search features (e.g., by genre or duration).
- Enable third-party integrations for music recommendations.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For questions or contributions, please reach out to:
- **Name**: Anass Benfillous
- **Email**: benfianass@gmail.com

