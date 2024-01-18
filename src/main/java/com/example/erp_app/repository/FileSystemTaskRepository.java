package com.example.erp_app.repository;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Repository
public class FileSystemTaskRepository {

    // todo DO POPRAWY !!!!!!!!!!!!!!!!!!!!! (getPath() zwraca ścieżke ze znakiem ":")
    // Zakomentowana linia kodu powinna działać poprawnie na systemie linux,
    // gdzie domyślnie ma byc uruchomiona aplikacja
    String RESOURCES_PATH = FileSystemTaskRepository.class.getResource("/").getPath().replaceAll("/C:","");
//    String RESOURCES_PATH = FileSystemTaskRepository.class.getResource("/").getPath();

    public String save(byte[] fileContent, String fileName) throws Exception{
        Path newFile = Paths.get(RESOURCES_PATH + new Date().getTime() + "-" + fileName);

        Files.createDirectories(newFile.getParent());

        Files.write(newFile,fileContent);
        return newFile.toAbsolutePath().toString();
    }

    public FileSystemResource findInFileSystem(String location) {
        try {
            return new FileSystemResource(Paths.get(location));
        } catch (Exception e) {
            // Handle access or file not found problems.
            throw new RuntimeException();
        }
    }
}
