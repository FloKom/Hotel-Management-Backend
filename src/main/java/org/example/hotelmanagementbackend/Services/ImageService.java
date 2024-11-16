package org.example.hotelmanagementbackend.Services;

import org.example.hotelmanagementbackend.Entities.Bedroom;
import org.example.hotelmanagementbackend.Entities.Image;
import org.example.hotelmanagementbackend.Exceptions.ApiRequestException;
import org.example.hotelmanagementbackend.Repositories.BedroomRepository;
import org.example.hotelmanagementbackend.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ImageService {

    @Autowired
    private BedroomRepository bedroomRepository;
    @Autowired
    private ImageRepository imageRepository;
    private String directory = "src/main/resources/static/images/ads";
    // Save image in a local directory
    public Image saveImageToStorage(MultipartFile imageFile, int bedroomId){
        String uniqueFileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

        Path uploadPath = Path.of(directory);
        Path filePath = uploadPath.resolve(uniqueFileName);
        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new ApiRequestException("Cannot create directory for image" + bedroomId);
        }
        Bedroom bedroom = bedroomRepository.findById(bedroomId)
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + bedroomId));
        Image image = new Image();
        image.setImageId(uniqueFileName);
        image.setBedroom(bedroom);
        return imageRepository.save(image);
    }

    // To view an image
    public byte[] getImage(String imageName) throws IOException {
        Path imagePath = Path.of(directory, imageName);

        if (Files.exists(imagePath)) {
            return Files.readAllBytes(imagePath);
        } else {
            return null; // Handle missing images
        }
    }

    // Delete an image
    public String deleteImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            Files.delete(imagePath);
            return "Success";
        } else {
            return "Failed"; // Handle missing images
        }
    }
}
