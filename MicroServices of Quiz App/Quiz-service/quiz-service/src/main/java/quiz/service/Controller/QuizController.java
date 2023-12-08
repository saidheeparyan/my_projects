package quiz.service.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.service.DTO.QuizDTO;
import quiz.service.Entity.QuizQuestions;
import quiz.service.Entity.Answers;
import quiz.service.Service.QuizService;


@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<List<Integer>> create(@RequestBody QuizDTO q){

        return quizService.create(q.getCategory(),q.getQuiz_name(),q.getNoQ());
    }

    @GetMapping("/getquiz/{id}")
    public ResponseEntity<List<QuizQuestions>> getData(@PathVariable("id")long id){

        return quizService.getDataById(id);
    }

    @PostMapping("/submit")
    public ResponseEntity<String> calculate(@RequestBody List<Answers> response){

        return quizService.cal(response);

    }
}