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

## Diagramas
- **Diagramas de datos**:
  
    ![image](https://github.com/user-attachments/assets/2d41a27d-1f53-43b7-bae3-7b69ab1e8b3f)


- **Diagramas de clases**:

    ![image](https://github.com/user-attachments/assets/70bd59a4-491d-49c5-bce3-c827b2e7b81b)



- **Diagramas de componentes**:
  
    ![image](https://github.com/user-attachments/assets/778256c3-ad8c-4734-a3e5-e1918834c8e4)


##  How to Run the Project

### Prerequisites
- Install **Java 17**
- Install **Maven**

### Steps to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/ECIBienestar/circonio-booking-loans-services.git
   ```

2. Configure database connection in `application.properties`:
   ```properties
   spring.application.name=EciBienestar
   spring.datasource.username=postgres
   spring.datasource.url=jdbc:postgresql://db.tbdioafooovaedfssykt.supabase.co:5432/postgres?
   ```

3. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```



  
