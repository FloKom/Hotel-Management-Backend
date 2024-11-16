package org.example.hotelmanagementbackend.Controllers;

import org.example.hotelmanagementbackend.Entities.Image;
import org.example.hotelmanagementbackend.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/{bedroomId}")
    public List<Image> addImage(@RequestParam("images")  MultipartFile[] adsImages, @PathVariable int bedroomId) {
        List<Image> images = new ArrayList<>();
        for (MultipartFile imageFile : adsImages) {
            images.add(imageService.saveImageToStorage(imageFile, bedroomId));
        }
        return images;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) throws Exception{
        String uploadDirectory = "src/main/resources/static/images/ads";
        Path filePath = Path.of(uploadDirectory, id);
        String contentType = Files.probeContentType(filePath);
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(imageService.getImage(id));
    }
}
