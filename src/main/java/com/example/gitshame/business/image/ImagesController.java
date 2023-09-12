package com.example.gitshame.business.image;

import com.example.gitshame.domain.image.ImageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImagesController {

    @Resource
    private ImagesService imagesService;



}

