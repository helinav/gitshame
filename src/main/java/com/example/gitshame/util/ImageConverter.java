package com.example.gitshame.util;

import com.example.gitshame.domain.image.Image;

import java.nio.charset.StandardCharsets;

public class ImageConverter {

    public static Image imageDataToImage(String imageData) {
        byte[] bytes = getBytesArrayFromImageData(imageData);
        Image image = new Image();
        image.setData(bytes);
        return image;
    }

    public static byte[] getBytesArrayFromImageData(String imageData) {
        return imageData.getBytes(StandardCharsets.UTF_8);
    }

    public static String imageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        return new String(image.getData(), StandardCharsets.UTF_8);
    }
}
