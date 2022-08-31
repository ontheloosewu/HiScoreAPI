package dev.wu.controllers;

import dev.wu.entities.Score;
import dev.wu.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @GetMapping("/scores")
    @ResponseBody
    public List<Score> sortedScores(@RequestParam(required = false) String orderInitialsBy){
        if(orderInitialsBy == null){
            return scoreService.sortScoresDesc();
        } else {
            return scoreService.sortScoresByInitials(orderInitialsBy);
        }
    }

    @GetMapping("/scores/{id}")
    @ResponseBody
    public Score getScoreById(@PathVariable String id){
        int scoreId = Integer.parseInt(id);
        return scoreService.getScoreById(scoreId);
    }

    @PostMapping("/scores")
    @ResponseBody
    public ResponseEntity<Score> createScore(@RequestBody Score score){
        Score savedScore = scoreService.createScore(score);
        return new ResponseEntity<>(savedScore, HttpStatus.CREATED);
    }

    @PutMapping("/scores")
    @ResponseBody
    public ResponseEntity<Score> updateScore(@RequestBody Score score){
        Score updatedScore = scoreService.updateScore(score);
        return new ResponseEntity<>(updatedScore, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/scores/{id}")
    @ResponseBody
    public ResponseEntity<Score> deleteScoreById(@PathVariable String id){
        int scoreId = Integer.parseInt(id);
        scoreService.deleteScoreById(scoreId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
