package edu.hackaton.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.hackaton.model.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    
    Optional<User> findByEmail(String id);

}
