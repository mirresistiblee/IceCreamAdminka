package com.example.icecreamadmin.services.modul;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileService {

    public static File convertMultipartFileToFile(MultipartFile multipartFile) {
        try {
            // Create a temporary file
            File file = new File("uploads/" + multipartFile.getOriginalFilename());

            // Ensure the directory exists
            File directory = new File("uploads");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            try (InputStream inputStream = multipartFile.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(file)) {

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }

            return file;
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while uploading file", e);
        }
    }
}