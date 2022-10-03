package com.example.ciclo3.Reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ciclo3.Reto3.model.Score;
import com.example.ciclo3.Reto3.repository.RepositoryScore;

@Service
public class ServiceScore {
    
    @Autowired
    private RepositoryScore repositoryScore;


    public List<Score> getAll() {
        return repositoryScore.getAll();
    }

    public Optional<Score> getScore(int id) {
        return repositoryScore.getScore(id);
    }

    public Score save( Score score) {
        if (score.getIdScore() == null) {
            return repositoryScore.save(score);
        } else {
            Optional<Score> score1 = repositoryScore.getScore(score.getIdScore());
            if (score1.isEmpty()) {
                return repositoryScore.save(score);
            } else {
                return score;
            }
        }
    }
}
