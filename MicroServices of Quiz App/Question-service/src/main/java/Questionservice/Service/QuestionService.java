package Questionservice.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import Questionservice.Entity.Question;
import Questionservice.Entity.QuizQuestions;
import Questionservice.Entity.Answers;
import Questionservice.Repository.QuestionRepository;


@Service
public class QuestionService {

    @Autowired
    private  QuestionRepository questionRepository;

    public  ResponseEntity<Question> save(Question q) {
        return new ResponseEntity<>(questionRepository.save(q),HttpStatus.CREATED);
    }

    public ResponseEntity<Question> getById(long id) {
        return new ResponseEntity<>(questionRepository.findById(id).get(),HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getAll() {
        return new ResponseEntity<>(questionRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String> delete(long id) {
        
        questionRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.GONE);
    }

    public ResponseEntity<List<Integer>> generateQuiz(String category, Integer noQ) {

        return new ResponseEntity<List<Integer>>(questionRepository.getQuestionId(category,noQ),HttpStatus.OK);
    }

    public ResponseEntity<List<QuizQuestions>> getQuestions(List<Integer> qIds) {

        List<QuizQuestions> quizQuestions = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for(Integer i: qIds){
            
            questions.add(questionRepository.findById((long)i).get());
        }

        for(Question q: questions){
            quizQuestions.add(new QuizQuestions(q.getQue_id(), q.getQue_name(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4()));
        }
        return new ResponseEntity<>(quizQuestions,HttpStatus.OK);
    }

    public ResponseEntity<String> calculate(List<Answers> responses) {

        int score=0;

        for(Answers r: responses){

            long p=r.getR_Id();
            
             Optional<Question> byId = questionRepository.findById(p);
            if(byId.isPresent()){
             Question question = byId.get();

            if((r.getResponse()).equals(question.getRight_answer())){
                score++;
            }
        }
        else
        System.out.println("not found");
        }
        return new ResponseEntity<>("Your score is :"+score,HttpStatus.OK) ;
    }

}
