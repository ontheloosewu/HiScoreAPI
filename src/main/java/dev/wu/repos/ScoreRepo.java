package dev.wu.repos;

import dev.wu.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepo extends JpaRepository<Score, Integer> {

    List<Score> findAllByOrderByPointsDesc();

    List<Score> findAllByOrderByInitialsDesc();

    List<Score> findAllByOrderByInitialsAsc();
}
