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

## ⚙️ Installation Steps 
Using H2 inmemory database, I made it very easy for 
Installation.

- Download the repository as zip or pull into local into your device.
- Open the project in intelliJ Idea ( easy to run )
- Load maven dependacies
- Run the project. 
- Need to use external API platforms such as Postman or Insomnia to fetch APIs
- Create the quiz First.
  use endpoint given below to create Quiz
  <pre><code> http://localhost:5000/create </code></pre>
  using POST method use request body like given below
  <pre><code>{
  	"quizTitle":"First Quiz",
  	"creator":"Sudarshan"
  }</code></pre>
- Add Question to quiz ( change quizeId with actual created generated )
  <pre><code> http://localhost:5000/addQuestions/{quizId}</code></pre>
  use POST rquest and request body structure like given below to add questions
  <pre><code>[
    {
      "questionNo": 1,
      "questionType": "mcq",
      "questionText": "What is the capital of India?",
      "mcqOptions": {
        "option1": "Mumbai",
        "option2": "Delhi",
        "option3": "Kolkata",
        "option4": "Chennai"
      },
      "correctOption": "Delhi"
    },
    {
      "questionNo": 2,
      "questionType": "descriptive",
      "questionText": "Explain what is JVM.",
      "mcqOptions": null,
      "correctOption": null
    },]</code></pre>
- To get all available quizzes ( use GET request )
  <pre><code> http://localhost:5000/getAll </code></pre>
- To get quiz questions of particular Quiz use endpoint given below
  <pre><code> http://localhost:5000/getOne/{quizId} </code></pre>
- To fetch submit quize and get Result use Post Method
  endpoint to fetch
  <pre><code> http://localhost:5000/submitQuiz/{quizId} </code></pre>
  use POST method and request body structure like below.( but need to change question ids )
  <pre><code>[
  {
    "questionId": "d4a3c42e-481c-45be-aee2-9e27c7706c35",
    "selected": "Delhi"
  },
  {
    "questionId": "3ae96771-b96f-47c1-b8b3-1adc5ac9068b",
    "text": "JVM stands for Java Virtual Machine, it runs bytecode on host machine..."
  },]</code></pre>

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

