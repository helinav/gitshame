package com.example.gitshame.domain.image;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Resource
    private ImageRepository imageRepository;

    public Image getImageBy(Integer imageId) {
        return imageRepository.getReferenceById(imageId);
    }

    public void saveAvatar(Image avatar) {
        imageRepository.save(avatar);
    }

    public List<Image> getAvatars() {
        List<Image> images = imageRepository.getAvatarsBy("A");
        return images;
    }
    public void saveImage(Image image) {
        imageRepository.save(image);
    }
}
