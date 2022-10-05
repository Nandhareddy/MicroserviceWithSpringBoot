package com.digitalbook.author.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbook.author.models.Author;

@Repository
public interface UserRepository extends JpaRepository<Author, Long> {
  Optional<Author> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
