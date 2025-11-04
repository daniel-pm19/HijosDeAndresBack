package edu.hackaton.model.dto.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequestDTO {
    
    private String id;

    private String userId;

    private String imageUrl;

    private String description;

    private LocalDateTime createdAt;

}
