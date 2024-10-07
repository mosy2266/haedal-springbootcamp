package com.haedal.spring.bootcamp.repository;

import com.haedal.spring.bootcamp.domain.Post;
import com.haedal.spring.bootcamp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Long countByUser(User user);
    List<Post> findByUser(User user);
}
