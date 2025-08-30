✍️ JournalApplication

A Spring Boot backend application to write, save, and manage your daily journal entries 📝.
Built with Java + Spring Boot, it provides clean REST APIs for CRUD operations.

🚀 Overview

JournalApplication helps you maintain a digital diary through backend APIs.
You can create, read, update, and delete journal entries — like your personal notebook, but powered by Spring Boot!

✨ Features

➕ Create daily journal entries

📜 View all saved entries

🔍 Fetch a journal entry by ID

✏️ Update existing entries

❌ Delete entries

🌐 RESTful API design (ready for frontend/mobile integration)



🛠 Tech Stack

☕ Java 8+

🌱 Spring Boot

🗄️ MongoDB

📦 Maven

📂 Project Structure
JournalApplication/
├── src/
│   ├── main/java/com/example/journal
│   │   ├── controller/       # REST Controllers
│   │   ├── model/            # Entity (JournalEntry)
│   │   ├── repository/       # JPA Repository
│   │   └── service/          # Business logic
│   └── main/resources/
│       ├── application.properties
├── pom.xml

⚡ Getting Started
Prerequisites

Java 8+

Maven

Run Locally
# Clone repo
- git clone https://github.com/Adarsh8434/JournalApplication.git
- cd JournalApplication

# Build
mvn clean install

# Run
mvn spring-boot:run


👉 App runs at: http://localhost:8080

📖 API Endpoints
Method	Endpoint	Description
POST	/api/journals	➕ Create a new journal
GET	/api/journals	📜 Get all journals
GET	/api/journals/{id}	🔍 Get journal by ID
PUT	/api/journals/{id}	✏️ Update journal entry
DELETE	/api/journals/{id}	❌ Delete journal entry
📝 Example Request

POST /api/journals

{
  "title": "Day 1 - Spring Boot Journey",
  "content": "Started building my Journal App today!",
  "date": "2025-08-30"
}


Response

{
  "id": 1,
  "title": "Day 1 - Spring Boot Journey",
  "content": "Started building my Journal App today!",
  "date": "2025-08-30"
}


🤝 Contributing

- Fork the repo

- Create a branch (feature-name)

- Commit your changes

- Open a Pull Request
  
🧑‍💻 Author

- Adarsh Kumar Choubey
- 🔗[ LinkedIn](https://www.linkedin.com/in/adarshku/)
- 📧 rohitadarsh02@gmail.com
