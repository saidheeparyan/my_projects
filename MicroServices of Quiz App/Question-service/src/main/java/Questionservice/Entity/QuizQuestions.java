package Questionservice.Entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizQuestions {

    private long question_No;
    private String que_name;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    
}