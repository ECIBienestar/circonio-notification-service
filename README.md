# ECI-Bienestar Notification Service

Notification microservice for the ECI-Bienestar platform. Handles real-time push notifications using WebSockets, providing instant updates to users across different modules of the wellness system at Escuela Colombiana de Ingeniería Julio Garavito.

## Authors

- Sebastián Julián Villarraga Guerrero

## Project Overview

This microservice is part of the ECI-Bienestar integrated platform designed for the Escuela Colombiana de Ingeniería Julio Garavito.
The Notification Service is built using Spring Boot and WebSockets, enabling real-time communication with clients subscribed to specific notification channels.

## Technologies Used

- Java 17
- Spring Boot 3.x (Spring WebSocket, Spring Web)
- Redis (for message brokering)
- Maven
- Lombok
- JUnit 5 & Mockito (for testing)
- JaCoCo (for code coverage)
- SonarCloud (for code quality)
- STOMP protocol (for WebSocket messaging)
- Azure

## Project Structure
 ```
CIRCONIO-NOTIFICATION-SERVICE/
├── .github/
├── .mvn/
├── .vscode/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── eci/
│   │   │           └── notification/
│   │   │               ├── controller/
│   │   │               │   └── MessageController.java
│   │   │               ├── model/
│   │   │               │   └── NotificationMessage.java
│   │   │               ├── websocket/
│   │   │               │   └── WebSocketConfig.java
│   │   │               └── NotificationApplication.java
│   │   └── resources/
│   │       └── static/
│   │           └── websocket-client.html
│   └── test/
│       └── java/
│           └── com/
│               └── eci/
│                   └── notification/
│                       └── messaging/
│                           └── service/
├── target/
├── .gitattributes
├── .gitignore
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
 ```

## Microservices diagram

![image](https://github.com/user-attachments/assets/20426a33-e1a2-49ab-b551-c0cf22a519e4)

## Architectural Style

Microservices architecture with decoupled communication using WebSockets and optional Redis pub/sub backend for scalability.

## Internal Functioning

The Notification Service enables other modules to send push notifications by:

1. Receiving events via internal REST API or message queues (future).

2. Broadcasting the notification to subscribed WebSocket clients.

3. Supporting topics or user-specific destinations.

## How to Run the Project

### Prerequisites

- Install Java 17
- Install Maven
- Install Redis for production-scale message handling

### Steps to Run

```
git clone https://github.com/ECIBienestar/bismuto-notification-service.git
cd bismuto-notification-service
```
### Build and run:

```
mvn clean install
mvn spring-boot:run
```
## Diagrams

### Data
Represents the notification payload and its structure, including userId, content, timestamp, and topic.

### Components
Shows how Notification Controller interacts with WebSocket clients and receives events from other services.

### Sequence
Illustrates the process from receiving an event to pushing it to the client via WebSocket.

## WebSocket Endpoints

| Method    | Endpoint               | Description                          |
|-----------|------------------------|--------------------------------------|
| SUBSCRIBE | /topic/notifications   | Subscribe to general notifications   |
| SEND      | /app/notify            | Send a new notification (internal)   |


## Running Tests

```
mvn test
mvn test jacoco:report
```
## Contributing

We welcome contributions! To contribute:
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/my-feature`).
3. Commit your changes (`git commit -m "Add my feature"`).
4. Push to the branch (`git push origin feature/my-feature`).
5. Open a pull request.

## Testing and Code Quality

- **Unit Tests**: Written with JUnit 5, covering entities, services, and controllers.
- **Code Coverage**: Measured with JaCoCo, targeting >80% coverage.
- **Static Analysis**: Integrated with SonarCloud for code quality and security checks.
- Run tests locally:
  ```bash
  mvn test
  ```
- View coverage report: `target/site/jacoco/index.html`.

## CI/CD and Deployment

The project uses GitHub Actions to automate the build, test, and deployment process:

- Build: Compiles and packages the application.
- Test: Runs unit and integration tests with coverage.
- Deploy: Deploys the application to Azure App Services.
- 
Workflows are defined in .github/workflows/.

### Deployment Details
- Hosted on Azure App Service.

![image](https://github.com/user-attachments/assets/3cce130f-e90d-4043-be87-90446e994626)

![image](https://github.com/user-attachments/assets/73072162-93ba-4ab8-9950-b3215d477b73)

## Integration with Other Modules

This service integrates with:

- User Management: To deliver user-specific notifications.
- Statistics Service: To log delivery or view metrics.
- All Other Services: Can emit events (e.g., new activities, results, alerts).

## Error Handling

The module returns structured error responses via REST, and also manages WebSocket error messages.

| Status Code | Error Message             | Cause                          | Recommendation               |
|-------------|---------------------------|--------------------------------|------------------------------|
| 400         | "Invalid payload"         | Missing fields in notification | Ensure payload is complete   |
| 401         | "Unauthorized access"     | Unauthenticated WebSocket user | Authenticate via JWT         |
| 500         | "Internal server error"   | Unexpected failure             | Report and check server logs |

## Future Improvements

- Persistent notification storage
- User preferences for subscription filters
- Mobile push notification gateway integration
- Admin panel for message broadcasting



## Diagrams
- **Class Driagram**:

  ![image](https://github.com/user-attachments/assets/9805ba85-1a90-4743-a6db-4fbe9fb70f7c)

- **Component Diagram**:
  
    ![image](https://github.com/user-attachments/assets/778256c3-ad8c-4734-a3e5-e1918834c8e4)




For questions, contact us via [GitHub Issues](https://github.com/ECIBienestar/circonio-booking-loans-services/issues).
  
