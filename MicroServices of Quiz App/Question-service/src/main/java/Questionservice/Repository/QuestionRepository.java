package Questionservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Questionservice.Entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

    @Query(value = "SELECT que_id from question where category=:c ORDER BY RAND() LIMIT :n",nativeQuery = true)
    public List<Integer> getQuestionId(@Param("c") String category,@Param("n") Integer noQ);
    
}