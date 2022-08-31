package dev.wu.services;

import dev.wu.entities.Score;

import java.util.List;

public interface ScoreService {

    Score createScore(Score score);

    Score getScoreById(int id);

    Score updateScore(Score score);

    void deleteScoreById(int id);

    List<Score> sortScoresDesc();

    List<Score> sortScoresByInitials(String orderBy);
}
