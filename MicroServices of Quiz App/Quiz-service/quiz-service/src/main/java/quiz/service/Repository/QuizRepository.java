package quiz.service.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import quiz.service.Entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
}