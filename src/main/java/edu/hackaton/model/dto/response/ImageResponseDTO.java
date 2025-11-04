package edu.hackaton.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponseDTO {
    
    private String id;

    private String userId;

    private String imageUrl;

    private String description;

    private LocalDateTime createdAt;

}
