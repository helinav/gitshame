package com.example.gitshame.domain.image;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Resource
    private ImageRepository imageRepository;

    public Image getImageBy(Integer imageId) {
        return imageRepository.getReferenceById(imageId);
    }
}
