package Questionservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Questionservice.Entity.Question;
import Questionservice.Entity.QuizQuestions;
import Questionservice.Entity.Answers;
import Questionservice.Service.QuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/save")
    public ResponseEntity<Question> save(@RequestBody Question q){
         return questionService.save(q);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Question> getById(@PathVariable int id){

        return questionService.getById(id);
    }
    
    @GetMapping("/getall")
    public ResponseEntity<List<Question>> getAll(){
        return questionService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return questionService.delete(id);

    }

    @GetMapping("/generatequiz")  //returns random question ids
    public ResponseEntity<List<Integer>> 
    generateQuiz(@RequestParam String category,@RequestParam Integer noQ){
        return questionService.generateQuiz(category,noQ);
    }

    @PostMapping("/getquestions") //gives questions back to quiz microservice based on the list of qids given by quiz-service
    public ResponseEntity<List<QuizQuestions>> getQuestions(@RequestBody List<Integer> qIds){
         return questionService.getQuestions(qIds);
    }

    @PostMapping("/calculate") //gives score by analysing responses given from quiz-service
    public ResponseEntity<String> calculate(@RequestBody List<Answers> responses){

        return questionService.calculate(responses);

    }
}