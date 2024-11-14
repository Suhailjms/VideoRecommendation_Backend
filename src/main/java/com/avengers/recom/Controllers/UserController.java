package com.avengers.recom.Controllers;

import com.avengers.recom.Model.User;
import com.avengers.recom.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/userscores")
public class UserController {

    @Autowired
    private UserService service;

    // Get all user scores
    @GetMapping
    public List<User> getAllScores() {
        return service.getAllScores();
    }

    // Get a single user score by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getScoreById(@PathVariable Long id) {
        return service.getScoreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new user score
    @PostMapping
    public ResponseEntity<User> createScore(@RequestBody User userScore) {
        User savedScore = service.saveScore(userScore);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedScore);
    }

    // Update an existing user score
    @PutMapping("/{id}")
    public ResponseEntity<User> updateScore(@PathVariable Long id, @RequestBody User userScore) {
        try {
            User updatedScore = service.updateScore(id, userScore);
            return ResponseEntity.ok(updatedScore);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a user score by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        service.deleteScore(id);
        return ResponseEntity.noContent().build();
    }
}
