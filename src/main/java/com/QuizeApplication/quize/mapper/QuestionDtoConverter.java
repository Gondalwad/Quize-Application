package com.QuizeApplication.quize.mapper;

import com.QuizeApplication.quize.dto.AddQuestionsDTO;
import com.QuizeApplication.quize.dto.QuizQuestionResponse;
import com.QuizeApplication.quize.exception.InvalidQuestionException;
import com.QuizeApplication.quize.model.QuizQuestions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Component
public class QuestionDtoConverter {
    
    public List<QuizQuestions> maptoQuizQuestionsList(String id, List<AddQuestionsDTO> dto){

        List<QuizQuestions> questions = new ArrayList<>();

        /// iterates to dto and add them to List of question defined above
        for(AddQuestionsDTO question : dto){
            QuizQuestions questionToAdd = new QuizQuestions();// new question to prepare

            String questionType = question.getQuestionType(); // gets type for easier access

            questionToAdd.setQuestionNo(question.getQuestionNo());
            questionToAdd.setQuestionText(question.getQuestionText());
            questionToAdd.setQuizId(UUID.fromString(id));// sets quiz id

            /// checks if question has MCQ type
            if(questionType.equalsIgnoreCase("MCQ") && question.getMcqOptions()!=null && question.getCorrectOption()!=null){

                /// sets options string by getting values from hashmap and stores them by separating with %%%
                String options = String.join(" %%% ", question.getMcqOptions().values());

                questionToAdd.setMcqOptions(options); // sets MCQ options
                questionToAdd.setCorrectOption(question.getCorrectOption()); // sets correct option
                questionToAdd.setQuestionType("MCQ");

            }else if(questionType.equalsIgnoreCase("Descriptive")){
                questionToAdd.setQuestionType("DESCRIPTIVE");
            }else{
                throw new InvalidQuestionException("Question Type should be either MCQ or Descriptive");
            }

            /// adds question to list
            questions.add(questionToAdd);
        }

        return questions;
    }

    /// method to convert quizQuestion to QuizQuestionResponse
    public List<QuizQuestionResponse> maptoQuizeQuestinResponseDTOList(List<QuizQuestions> questions){
        List<QuizQuestionResponse> dto = new ArrayList<>();

        for(QuizQuestions q : questions){
            QuizQuestionResponse current = new QuizQuestionResponse();

            if(q.getQuestionType().equalsIgnoreCase("mcq")){
                HashMap<String,String> options = new HashMap<>();

                /// below is loop which makes the string options to hashMap
                int i = 0; /// jsut to act as counter
                for(String s : q.getMcqOptions().split("%%%")){
                    i++;
                    options.put("Option"+i, s);
                }
                current.setMcqOptions(options);
            }

            current.setQuestionNo(q.getQuestionNo());
            current.setQuestionId(q.getId().toString());
            current.setQuestionType(q.getQuestionType());
            current.setQuizId(q.getQuizId().toString());
            current.setQuestion(q.getQuestionText());

            dto.add(current);
        }

        return dto;
    }
}
