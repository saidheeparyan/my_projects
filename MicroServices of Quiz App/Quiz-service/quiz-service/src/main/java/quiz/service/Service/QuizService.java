package quiz.service.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import quiz.service.Entity.Quiz;
import quiz.service.Entity.QuizQuestions;
import quiz.service.Entity.Answers;
import quiz.service.Repository.QuizRepository;
import quiz.service.fiegn.QuestionClient;



@Service
public class QuizService {


    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    public ResponseEntity<List<Integer>> create(String category,String Qtitle,Integer noQ) {

        List<Integer> in=questionClient.generateQuiz(category,noQ).getBody();

        Quiz q=new Quiz();
        q.setQuestionIds(in);
        q.setQuiz_name(Qtitle);
        quizRepository.save(q);
       
        return new ResponseEntity<>(in,HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuizQuestions>> getDataById(long id) {

            Quiz quiz = quizRepository.findById(id).get();

            List<QuizQuestions> qs = new ArrayList<>();

            qs.addAll(questionClient.getQuestions(quiz.getQuestionIds()).getBody());

        return new ResponseEntity<>(qs,HttpStatus.OK);
    }

    public ResponseEntity<String> cal(List<Answers> response) {

        return questionClient.calculate(response);
    }

}