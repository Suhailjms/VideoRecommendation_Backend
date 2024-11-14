package com.avengers.recom.Repo;

import com.avengers.recom.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    // Find all scores for a specific user
    List<User> findByUserId(Long userId);

    // Find all records with a specific genre
    List<User> findByGenre(String genre);

    // Find all records for a user with a specific genre
    List<User> findByUserIdAndGenre(Long userId, String genre);
}
