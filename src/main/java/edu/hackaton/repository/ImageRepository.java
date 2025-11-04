package edu.hackaton.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.hackaton.model.entity.Image;

public interface ImageRepository extends MongoRepository<Image, String> {
    
    List<Image> findByUserId(String userId);

}
