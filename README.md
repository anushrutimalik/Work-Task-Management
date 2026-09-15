# 🚀 Work & Task Management System (Backend)

A robust and scalable backend system built with **Spring Boot** and **PostgreSQL** to manage employees, roles, and work/task assignments efficiently. This project serves as the core backend service designed for high-performance enterprise task tracking.

---

## 🛠️ Tech Stack

* **Language & Framework:** Java, Spring Boot
* **Data Access:** Spring Data JPA, Hibernate
* **Database:** PostgreSQL
* **Build Tool:** Maven
* **Version Control:** Git & GitHub

---

## 📂 Project Architecture

The project follows a standard layered architecture:
* **Controllers (`com.example.demo.controllers`):** Manages incoming HTTP requests and exposes RESTful APIs.
* **Services (`com.example.demo.services`):** Contains the core business logic.
* **Repositories (`com.example.demo.repositories`):** Interfaces for database interactions using Spring Data JPA.
* **Models/Entities (`com.example.demo.models`):** Database entity definitions (`Employee`, `Work`, `Role`, etc.).
* **DTOs & Exceptions:** Handles data transfer objects and custom error management.

---

## ⚙️ Getting Started & Installation

Follow these steps to run the project locally on your machine:

### 1. Clone the Repository
```bash
git clone [https://github.com/anushrutimalik/Work-Task-Management.git](https://github.com/anushrutimalik/Work-Task-Management.git)
cd Work-Task-Management
