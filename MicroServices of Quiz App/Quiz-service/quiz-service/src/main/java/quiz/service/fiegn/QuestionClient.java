package quiz.service.fiegn;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import quiz.service.Entity.QuizQuestions;
import quiz.service.Entity.Answers;

@Component
@FeignClient("QUESTION-SERVICE")
public interface QuestionClient {
    
    @GetMapping("/question/generatequiz")
    public ResponseEntity<List<Integer>> 
    generateQuiz(@RequestParam String category,@RequestParam Integer noQ);

    @PostMapping("/question/getquestions")
    public ResponseEntity<List<QuizQuestions>> getQuestions(@RequestBody List<Integer> qIds);

    @PostMapping("/question/calculate")
    public ResponseEntity<String> calculate(@RequestBody List<Answers> responses);
}