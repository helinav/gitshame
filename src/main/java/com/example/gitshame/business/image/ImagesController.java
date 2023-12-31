package com.example.gitshame.business.image;

import com.example.gitshame.business.image.dto.AvatarResponse;
import com.example.gitshame.business.image.dto.AvatarRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImagesController {

    @Resource
    private ImagesService imagesService;

    @PostMapping("/avatar")
    @Operation(summary = "Võimaldab andmebaasi pilti lisada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")})
    public void createAndSaveAvatar(@RequestBody AvatarRequest request) {
        imagesService.createAndSaveAvatar(request);
    }

    @GetMapping("/account")
    @Operation(summary = "Toob imageId ja imageData abil süsteemist avataride pildid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")})
    public List<AvatarResponse> getAvatars() {
        return imagesService.getAvatars();
    }
}


