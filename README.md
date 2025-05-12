# ECI-Bienestar Notification Service

The notification module functions as an independent component responsible for managing the delivery of messages to system users through various channels such as email. It is designed to be used by members of the School's academic community, allowing for an organized, accessible experience aligned with promoting university well-being.

## Authors

- Nicole Dayan Calderon Arevalo
- Alison Geraldine Valderrama Munar
- Sebastián Julián Villarraga Guerrero
- Jeimy Alejandra Yaya Martinez

## Technologies Used

- Java 17
- Spring Boot 3.x
- RabbitMQ
- Maven
- JUnit 5
- JaCoCo
- Azure

## Project Structure
 ```
circonio-notification-service/
│
├── src/
│   └── main/
|       └── java/  
│           └── com/
│               └── eci/
│                   └── notification/
│                       ├── config/
│                       │   └── MailConfig.java
│                       │
│                       ├── messaging/
│                       │   ├── dto/
│                       │   │    └── CreatedReserveEvent.java
│                       │   │
│                       │   └── listener/
│                       │        └── NotificationListener.java
│                       │
│                       └── service/
│                           └── NotificationService.java
│                       
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── eci/
│                   └── notification
│                       └── messaging/
│                       │   └── listener/
│                       │        └── NotificationListenerTest.java
│                       │
│                       └── service/
│                           └── NotificationServiceTest.java
│
├── pom.xml
└── README.md
 ```

## Diagrams
- **Class Driagram**:

  ![image](https://github.com/user-attachments/assets/9805ba85-1a90-4743-a6db-4fbe9fb70f7c)

- **Component Diagram**:
  
    ![image](https://github.com/user-attachments/assets/778256c3-ad8c-4734-a3e5-e1918834c8e4)


##  How to Run the Project

### Prerequisites
- Install **Java 17**
- Install **Maven**
- Git: For cloning the repository.

### Steps to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/ECIBienestar/circonio-booking-loans-services.git
   ```

2. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   
## CI/CD and Deployment

The project uses **Azure Pipelines** and **GitHub Actions** for continuous integration and deployment:
- **GitHub Actions**: Runs tests and code quality checks on pull requests (`pipeline-develop.yml`).
- **Azure Pipelines**: Deploys the application to Azure App Service (`main_ecibienestar-booking.yml`).

### Deployment Details
- Hosted on Azure App Service.

![image](https://github.com/user-attachments/assets/3cce130f-e90d-4043-be87-90446e994626)

![image](https://github.com/user-attachments/assets/73072162-93ba-4ab8-9950-b3215d477b73)

## Testing and Code Quality

- **Unit Tests**: Written with JUnit 5, covering entities, services, and controllers.
- **Code Coverage**: Measured with JaCoCo, targeting >80% coverage.
- **Static Analysis**: Integrated with SonarCloud for code quality and security checks.
- Run tests locally:
  ```bash
  mvn test
  ```
- View coverage report: `target/site/jacoco/index.html`.

## Contributing

We welcome contributions! To contribute:
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/my-feature`).
3. Commit your changes (`git commit -m "Add my feature"`).
4. Push to the branch (`git push origin feature/my-feature`).
5. Open a pull request.

Please follow our [Code of Conduct](CODE_OF_CONDUCT.md) and use the [issue templates](.github/ISSUE_TEMPLATE).

For questions, contact us via [GitHub Issues](https://github.com/ECIBienestar/circonio-booking-loans-services/issues).
  
