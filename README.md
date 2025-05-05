# ECI-Bienestar Notification Service

The notification module functions as an independent component responsible for managing the delivery of messages to system users through various channels such as email, SMS, or push notifications. It is designed to be used by members of the School's academic community, allowing for an organized, accessible experience aligned with promoting university well-being.

## Authors

- Nicole Dayan Calderon Arevalo
- Alison Geraldine Valderrama Munar
- Sebastián Julián Villarraga Guerrero
- Jeimy Alejandra Yaya Martinez

## Technologies Used

- Java 17
- Spring Boot 3.x
- Maven
- JUnit 5
- JaCoCo
- SonarCloud
- Azure

## Project Structure

```
circonio-notification-service/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── notification/
│                   ├── controller/
│                   │   └── NotificationController.java
│                   │
│                   ├── service/
│                   │   └── NotificationService.java
│                   │
│                   ├── model/
│                   │   ├── Notification.java
│                   │   └── NotificationChannel.java
│                   │
│                   ├── repository/
│                   │   └── NotificationRepository.java
│                   │
│                   └── NotificationApplication.java
│
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── notification/
│                   └── (tests aquí)
│
├── pom.xml
└── README.md
```

## Diagramas
- **Diagramas de datos**: 
![image](https://github.com/user-attachments/assets/2d41a27d-1f53-43b7-bae3-7b69ab1e8b3f)


- **Diagramas de clases**: 
![image](https://github.com/user-attachments/assets/66bbf3e0-ac92-43cf-b08a-2e36a3244297)


- **Diagramas de componentes**:
![image](https://github.com/user-attachments/assets/ccde988d-a799-428b-b4be-66a90457fed5)



  
