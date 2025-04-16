# 🚇 Metro Ticketing System

A simple yet functional full-stack metro ticket booking application that allows users to check fares, generate tickets, and manage station entries/exits — all backed by a clean API and database design.

## 🔧 Tech Stack

- **Backend:** Java Spring Boot  
- **Frontend:** Angular 
- **Database:** MySQL  
- **Other:** QR Code Generator, RESTful APIs

## 🎯 Features

- 🔍 **Fare Lookup:** Users can select source and destination stations to view ticket fare.
- 🎫 **Ticket Generation:** Tickets include a unique Ticket ID, QR code, and are stored in MySQL.
- ⏱️ **Ticket Validity:** Tickets are valid for 18 hours from the time of purchase.
- 🚪 **Entry/Exit System:**
  - Each ticket can be used **twice** — once for entry, once for exit.
  - Exit is only allowed if entry is recorded.
- 🔄 **Backend Integration:** All user actions (booking, entry, exit) communicate via backend APIs with the database.

## 🧪 Sample Flow

1. User selects "From" and "To" stations.
2. System calculates fare and generates a ticket.
3. Ticket ID and QR are shown on screen.
4. User uses the Ticket ID (or scans QR) to **Enter** and **Exit** stations.
5. Backend enforces rules and updates ticket status.

## 📸 Screenshots

### Ticket Booking View with Fare Display & Buy Button
![image](https://github.com/user-attachments/assets/4e8974a1-efab-4bca-99b0-f3b52dde6484)

### Ticket Details View
![image](https://github.com/user-attachments/assets/974b6748-9665-4393-bdc5-787aa25626d4)

### Enter/Exit Station
<img width="970" alt="image" src="https://github.com/user-attachments/assets/b151fb7a-d57a-4a5a-b451-8d9ae0bfdada" />


###For dublicate entry
<img width="1017" alt="Screenshot 2025-04-16 at 10 45 18 AM" src="https://github.com/user-attachments/assets/545ea2ee-43f6-4388-b1d4-f3d798315ce9" />
<img width="445" alt="Screenshot 2025-04-16 at 10 39 16 AM" src="https://github.com/user-attachments/assets/fc71ed7b-8a48-488a-b658-4fc20abf6d34" />

### Backend SS
<img width="1294" alt="image" src="https://github.com/user-attachments/assets/00c71476-1ab3-493d-af72-16d4474209b9" />


## 🚀 Getting Started

### Backend (Spring Boot)
```bash
cd backend/
./mvnw spring-boot:run
```
### Frontend (Angular)
```bash
cd frontend/
npm install
npm start
```
### Database Setup
```bash
Import the provided SQL file into your MySQL instance.
Update DB credentials in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/metro_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

