# City Library Management System

A Spring Boot application for managing a city library system, including books, authors, and publishers.

## Overview

City Library Management System is a robust Java-based application built with Spring Boot that helps manage library resources efficiently. The system handles books, authors, and publishers with their respective relationships and addresses. It provides a complete solution for libraries to digitize their inventory and management processes.

## Technologies Used

- Java 23
- Spring Boot 3.3.5
- Spring Data JPA
- MySQL Database
- Lombok
- Maven
- JUnit (for testing)
- Git (version control)
- GitHub Actions (CI/CD)

## Features

### Core Functionality
- Book management with ISBN tracking and metadata
- Author profile management with complete biographical information
- Publisher management with address information and contact details
- Advanced search and filtering capabilities
- Inventory tracking and management

### Data Relationships
- Many-to-Many relationship between Books and Authors
- One-to-Many relationship between Publishers and Books
- One-to-One relationship between Publishers and Addresses

### Technical Features
- RESTful API endpoints for all operations
- Data validation and error handling
- Secure database operations
- Optimized database queries
- Comprehensive logging system

## Prerequisites

### Required Software
- JDK 23
- MySQL Server 8.0 or higher
- Maven 3.8+
- Git

### Development Environment
- Any Java IDE (IntelliJ IDEA recommended)
- MySQL Workbench (optional)
- Postman or similar API testing tool

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/mucahitkayadan/CityLibrary.git
   ```

2. Navigate to project directory:
   ```bash
   cd CityLibrary
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Database Configuration

The application uses MySQL as its database. Configure your database connection in `src/main/resources/application.properties`:
