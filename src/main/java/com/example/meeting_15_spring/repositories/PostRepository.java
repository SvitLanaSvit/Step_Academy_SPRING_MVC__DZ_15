package com.example.meeting_15_spring.repositories;

import com.example.meeting_15_spring.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
