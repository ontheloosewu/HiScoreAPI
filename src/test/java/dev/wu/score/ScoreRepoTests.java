package dev.wu.score;

import dev.wu.entities.Score;
import dev.wu.repos.ScoreRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional // any CRUD operations will not persist outside, all statements are rolled back
public class ScoreRepoTests {

    @Autowired
    ScoreRepo scoreRepo;

    @Test
    public void create_score(){
        Score score = new Score(0, "FUN", 2000);
        Score addedScore = this.scoreRepo.save(score);
        Assertions.assertNotEquals(0, addedScore.getId());
        System.out.println(addedScore);
    }

    @Test
    public void get_score_by_id(){
        Optional<Score> score = this.scoreRepo.findById(1);
        if(score.isPresent()){
            Score scoreExists = score.get();
        } else {
            System.out.println("Score doesn't exist");
        }
    }

    @Test
    public void get_all_scores(){
        Score score1 = new Score(0, "FUN", 2000);
        Score addedScore1 = this.scoreRepo.save(score1);
        Score score2 = new Score(0, "FUN", 2000);
        Score addedScore2 = this.scoreRepo.save(score2);
        Score score3 = new Score(0, "FUN", 2000);
        Score addedScore3 = this.scoreRepo.save(score3);
        List<Score> scores = this.scoreRepo.findAll();
        System.out.println(scores);
        Assertions.assertEquals(3, scores.size());
    }

//    @Test
//    public void get_scores_by_initial(){
//        List<Score> specificInitials = this.scoreRepo.fina
//    }

    @Test
    public void update_score(){
        Score newScore = new Score(1, "UUU", 3000);
        this.scoreRepo.save(newScore);
    }
}
