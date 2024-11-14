package com.avengers.recom.Model;


import jakarta.persistence.*;

import javax.naming.Name;

@Entity
@Table(name="videoreco")
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private Long userId;
     private int score;
     private String genre;  // This will be set based on the score
     private String videoName;
     private String videoUrl;

     // Getters and setters

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public Long getUserId() {
          return userId;
     }

     public void setUserId(Long userId) {
          this.userId = userId;
     }

     public int getScore() {
          return score;
     }

     public void setScore(int score) {
          this.score = score;
          this.genre = determineGenre(score);  // Set genre based on score
     }

     public String getGenre() {
          return genre;
     }

     // Add a setter for genre if you need to set it manually
     public void setGenre(String genre) {
          this.genre = genre;
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

     public String getVideoName() {
          return videoName;
     }

     public void setVideoName(String videoName) {
          this.videoName = videoName;
     }

     public String getVideoUrl() {
          return videoUrl;
     }

     public void setVideoUrl(String videoUrl) {
          this.videoUrl = videoUrl;
     }
}
