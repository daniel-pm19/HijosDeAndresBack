package edu.hackaton.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hackaton.service.ImageService;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController{

    private final ImageService imageService;
    

}