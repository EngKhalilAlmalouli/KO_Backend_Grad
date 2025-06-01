package com.example.ko_app.ImagesFile;

import com.example.ko_app.Configruration.RequestNotValidException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageFileService {

    private final ImageFileRepository imageFileRepository;

    private final String uploadDir = "uploads/";


    public ImageFileService(ImageFileRepository imageFileRepository) {
        this.imageFileRepository = imageFileRepository;
    }

    public void init() {
        try {
            Files.createDirectories(Paths.get(uploadDir));
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory!");
        }
    }

    public ImageFile saveFile(MultipartFile file) {
        try {
            Path path = Paths.get(uploadDir + file.getOriginalFilename());
            Files.write(path, file.getBytes());

            String fileName = file.getOriginalFilename();

            ImageFile imageFile = new ImageFile();
            imageFile.setFileName(fileName);
            imageFile.setFilePath(path.toString());
            imageFile.setFileType(file.getContentType());
            imageFile.setFileSize((int) file.getSize());

            return imageFileRepository.save(imageFile);
        } catch (IOException e) {
            throw new RuntimeException("Could not save file. Error: " + e.getMessage());
        }
    }

    public ImageFile getFile(Integer id) {
        return imageFileRepository.findById(id)
                .orElseThrow(() -> new RequestNotValidException("File not found"));
    }

    public ImageFile update(ImageFile imageFile, ResourceType resourceType, Integer relationId) {
        ImageFile file = imageFileRepository.findById(imageFile.getId())
                .orElseThrow(() -> new RequestNotValidException("File not found"));

        file.setRelationType(resourceType);
        file.setRelationId(relationId);

        return imageFileRepository.save(file);
    }
}