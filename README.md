# Quiz Application 📚

Hello! 👋  
This is my Quiz App I build using Spring Boot with H2 database. This app is created as part of challange organized by Verto Pune.

This application is currently enough to conduct online quizzes but it is not secure currently.

I have followed good package structure to build this apis. 
Maintinating separation of concern and implemented `Single Responsibility Principle`

---

## 📁 Project Structure

I try to separate logics in packages. Below is the packages and what they do:

- `controller` – This has all rest api endpoints. Like `/createQuiz`, `/addQuestions`, etc.
- `dto` – These are data transfer objects. I use them in request and response to send limited and clean data.
- `exception` – For handling error cases like quiz not found, bad request, etc.
- `mapper` – I made simple mappers to convert model to DTO and back.
- `model` – It has my entity classes which save data in database.
- `repo` – It has interfaces that connect with database using Spring Data JPA.
- `service` – Here I write main business logics like save quiz, validate answers, etc.

---

## 🧠 What This App Do?

This is backend of quiz system. It can do things like:

- Create new quiz (with title) <img width="1350" height="458" alt="image" src="https://github.com/user-attachments/assets/c8b103e3-be77-464b-8f2b-de374ed48c52" />

- Add questions in quiz (MCQ or Descriptive type) currently responding with input itself but can be changed<img width="1344" height="618" alt="image" src="https://github.com/user-attachments/assets/2199347e-348a-435f-93bd-83ffe27f6285" />
- Save options and correct answer for MCQ 
- Store user's answer if needed (for future) currently just passing the username from front end but we can imporve it.
- Fetch quiz and questions by quiz ID 
- Validate if answers are correct and returs response as <img width="1350" height="816" alt="image" src="https://github.com/user-attachments/assets/9a3816ec-7214-4030-83d6-63818a8eb321" />

- Count total number of questions in quiz by getting quizId.

---

## 🗄️ Database

I use H2 in-memory database for now. This is good for testing and no setup needed.  
But if you want to open the H2 database console, you can use:

