
# Health App Project with JavaFX

## Overview

This project is a desktop application built with JavaFX, designed to provide secure access to a health page for users and an admin dashboard with advanced features. The application supports two-factor authentication (2FA), CAPTCHA codes, secure login, role-based access for users and admins, and additional features like a session manager, PC notifications, integrated ChatGPT bot, PDF reading bot, and more.

## Features

1. **User Login System with 2FA**: Users can securely log in with two-factor authentication to access their personalized health page.
2. **Admin Dashboard**: Admins can log in to access a dashboard that provides an overview of key statistics, accessible only to users with the Admin role.
3. **Role-Based Security**: Separate roles for regular users and admins, with distinct permissions.
4. **Data Encryption**: User data is securely encrypted to enhance data privacy.
5. **CAPTCHA Verification**: CAPTCHA codes are used for enhanced security, helping to prevent bot logins.
6. **Session Manager**: Tracks logged-in users, maintaining session information for authorized actions.
7. **PC Notifications**: The application sends notifications directly to the user’s computer for important updates.
8. **ChatGPT Integration**: Users can interact with an integrated ChatGPT bot for various tasks and assistance.
9. **PDF Reading Bot**: A bot that reads and extracts information from PDFs, aiding users with document handling.
10. **Password Reset Functionality**: Users can reset their password through an automated, secure process.

## Getting Started

### Prerequisites

- JDK >= 11
- JavaFX SDK
- MySQL or PostgreSQL (for backend database storage)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/haider0708/USER-DESKTOP-JAVAFX.git
   ```

2. Configure your database connection in the application's configuration file (e.g., `application.properties` or `config.xml`):
   ```plaintext
   db.url=jdbc:mysql://localhost:3306/health_app
   db.username=your-db-username
   db.password=your-db-password
   ```

3. Build the application using Maven or Gradle:
   ```bash
   mvn clean install
   ```

4. Launch the application:
   ```bash
   java -jar target/health-app-javafx.jar
   ```

### Usage

1. Launch the application and register as a user or log in with admin credentials to access the dashboard.

2. Upon logging in, complete the 2FA verification to securely access the application.

3. Access various functionalities such as PDF reading, notifications, ChatGPT interaction, and personalized health details.

### Security & Additional Features

- **Two-Factor Authentication (2FA)**: An additional layer of security requiring a verification code.
- **CAPTCHA Verification**: Enhances security, preventing automated logins.
- **Session Management**: A session manager to keep track of logged-in users, allowing authorized access to restricted areas.
- **PC Notifications**: Notifications are sent directly to the user’s computer.
- **ChatGPT Integration**: ChatGPT bot available for interactive assistance.
- **PDF Reading Bot**: The bot can read and extract key information from PDF files.
- **Password Reset**: Users can request a secure link to reset their password.

## Built With

- JavaFX - For UI development
- JDK 11 - Java Development Kit
- SQL Database (MySQL or PostgreSQL) - For data persistence
- OpenAI API (ChatGPT) - For interactive chatbot functionality
- PDFBox or similar library - For PDF reading functionality

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
