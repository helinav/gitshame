package com.example.gitshame.business.image;

import com.example.gitshame.business.image.dto.AvatarRequest;
import com.example.gitshame.domain.image.Image;
import com.example.gitshame.domain.image.ImageMapper;
import com.example.gitshame.domain.image.ImageService;
import com.example.gitshame.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ImagesService {
    @Resource
    private ImageService imageService;
    @Resource
    private ImageMapper imageMapper;


    public void createAndSaveAvatar(AvatarRequest request) {
        Image image = createAvatar(request);
        imageService.saveAvatar(image);

    }

    private Image createAvatar(AvatarRequest request) {
        Image image = imageMapper.toAvatar(request);
        String requestImageData = Arrays.toString(request.getData());
        Image imageFromData = ImageConverter.imageDataToImage(requestImageData);
        image.setData(imageFromData.getData());
        return image;
    }
}

