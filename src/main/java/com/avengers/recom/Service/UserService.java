package com.avengers.recom.Service;

import com.avengers.recom.Model.User;
import com.avengers.recom.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repository;

    public List<User> getAllScores() {
        return repository.findAll();
    }

    public Optional<User> getScoreById(Long id) {
        return repository.findById(id);
    }

    public User saveScore(User userScore) {
        userScore.setGenre(determineGenre(userScore.getScore()));
        return repository.save(userScore);
    }

    public User updateScore(Long id, User updatedScore) {
        if (repository.existsById(id)) {
            updatedScore.setId(id);
            updatedScore.setGenre(determineGenre(updatedScore.getScore()));
            return repository.save(updatedScore);
        } else {
            throw new RuntimeException("UserScore not found.");
        }
    }

    public void deleteScore(Long id) {
        repository.deleteById(id);
    }

    private String determineGenre(int score) {
        if (score >= 80) {
            return "Excellent";
        } else if (score >= 50) {
            return "Good";
        } else if (score >= 30) {
            return "Average";
        } else {
            return "Needs Improvement";
        }
    }
}
