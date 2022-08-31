package dev.wu.services;

import dev.wu.entities.Score;
import dev.wu.exceptions.EmptyInitialsException;
import dev.wu.exceptions.InvalidParamException;
import dev.wu.exceptions.InvalidScoreException;
import dev.wu.exceptions.ScoreNotFoundException;
import dev.wu.repos.ScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    ScoreRepo scoreRepo;

    @Override
    public Score createScore(Score score) {
        if(score.getPoints() < 0){
            throw new InvalidScoreException();
        }
        if(score.getInitials().length() == 0){
            throw new EmptyInitialsException();
        }
        if(score.getInitials().length() > 3){
            score.setInitials(score.getInitials().substring(0,3));
        }
        return this.scoreRepo.save(score);
    }

    @Override
    public Score getScoreById(int id) {
        Optional<Score> optionalScore = this.scoreRepo.findById(id);
        if(optionalScore.isPresent()){
            return optionalScore.get();
        } else {
            throw new ScoreNotFoundException();
        }
    }

    @Override
    public Score updateScore(Score score) {
        if(score.getPoints() < 0){
            throw new InvalidScoreException();
        }
        if(score.getInitials().length() == 0){
            throw new EmptyInitialsException();
        }
        if(score.getInitials().length() > 3){
            score.setInitials(score.getInitials().substring(0,3));
        }
        return this.scoreRepo.save(score);
    }

    @Override
    public void deleteScoreById(int id) {
        Optional<Score> optionalScore = this.scoreRepo.findById(id);
        if(optionalScore.isPresent()){
            this.scoreRepo.delete(optionalScore.get());
        } else {
            throw new ScoreNotFoundException();
        }
    }

    @Override
    public List<Score> sortScoresDesc() {
        return this.scoreRepo.findAllByOrderByPointsDesc();
    }

    @Override
    public List<Score> sortScoresByInitials(String orderBy) {
        if(orderBy.equalsIgnoreCase("DESC")){
            return this.scoreRepo.findAllByOrderByInitialsDesc();
        } else if (orderBy.equalsIgnoreCase("ASC")){
            return this.scoreRepo.findAllByOrderByInitialsAsc();
        } else {
            throw new InvalidParamException();
        }
    }


}
