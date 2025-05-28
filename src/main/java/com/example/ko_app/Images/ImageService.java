package com.example.ko_app.Images;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.File.FileData;
import com.example.ko_app.File.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH = "C:\\Users\\UsEr\\IdeaProjects\\grad-pro\\ko_app\\ko_app\\src\\main\\resources\\products_Image\\";

    public String uploadImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setImageData(ImageUtils.compressImage(file.getBytes()));

        Image savedImage = imageRepository.save(image);

        if (savedImage != null) {
            return "Image uploaded successfully: " + file.getOriginalFilename();
        }
        return "Image upload failed";
    }

    public byte[] downloadImage(String fileName) throws NotFoundInDatabaseException {
        Optional<Image> dbImage = imageRepository.findByName(fileName);

        if (dbImage.isPresent()) {
            return ImageUtils.compressImage(dbImage.get().getImageData());
        } else {
            throw new NotFoundInDatabaseException("Image not found in database with name: " + fileName);
        }
    }

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        FileData fileData = new FileData();
        fileData.setName(file.getOriginalFilename());
        fileData.setType(file.getContentType());
        fileData.setFilePath(filePath);

        FileData savedFile = fileDataRepository.save(fileData);

        file.transferTo(new File(filePath));

        if (savedFile != null) {
            return "Image uploaded successfully: " + filePath;
        }
        return "Image upload to file system failed";
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException, NotFoundInDatabaseException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);

        if (fileData.isPresent()) {
            String filePath = fileData.get().getFilePath();
            return Files.readAllBytes(new File(filePath).toPath());
        } else {
            throw new NotFoundInDatabaseException("Image not found in file system with name: " + fileName);
        }
    }
}
