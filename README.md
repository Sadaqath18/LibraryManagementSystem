#  📚 Library Management System (Java OOP)

## Overview
A simple Java-based Library Management System demonstrating **Object-Oriented Programming (OOP)** concepts.  
Users can register, issue books, return books, and view available books.

---
## 🛠 Tools Used

- Java (JDK 21 recommended)  
- Eclipse IDE / VS Code  
- Terminal / Git for version control

---

## ⚙️ Features
- Add books to the library
- Register users
- Show all registered users
- Issue books to users
- Return books from users
- Simple console-based interface

---

## Classes
- **Book.java** – Defines Book attributes and issue/return methods  
- **User.java** – Defines User attributes  
- **Library.java** – Handles library operations: add, issue, return, show books  
- **Main.java** – Interactive console interface

---

## 💻 How to Run

<details>
<summary>Click to expand instructions</summary>

1. Clone the repository:

```bash
git clone https://github.com/<your-username>/<your-repo-name>.git
cd LibrarySystem
```

2. Compile the Java files:
```bash
javac src/com/sadaqath/library/*.java
```

3. Run the program:
```bash
java -cp src com.sadaqath.library.Main
```

4. Follow the interactive menu:

=== Library Management System ===

1. Show Books
2. Register User
3. Show Users
4. Issue Book
5. Return Book
6. Exit
Choose option:

</details>

---

## 📖 Example Usage
<details> <summary>Click to view example</summary>

- Choose option: 1
- Library Books:
- Java Basics by James
- Data Structures by Cormen
- OOP Concepts by Grady Booch

- Choose option: 2
- Enter Name: Sadaqath
- Enter User ID: 101
- User registered.

- Choose option: 4
- Enter User ID: 101
- Enter Book Title: Java Basics
- Book issued to user 101

- Choose option: 5
- Enter User ID: 101
- Enter Book Title: Java Basics
- Book returned
</details>

---
### 👤 Author: S Sadaqath Ulla Qureshi

### 🔗 Github: Sadaqath18
