package com.assignment.file.download.service.impl;

import com.assignment.file.download.exception.FileDownloadException;
import com.assignment.file.download.property.FileDownloadProperties;
import com.assignment.file.download.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {

    private final Path fileStorageLocation;

    @Autowired
    public FileDownloadServiceImpl(FileDownloadProperties fileDownloadProperties) {
        this.fileStorageLocation = Paths.get(fileDownloadProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileDownloadException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
                Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
                Resource resource = new UrlResource(filePath.toUri());
                if(resource.exists()) {
                    return resource;
                } else {
                    throw new FileDownloadException("File not found " + fileName);
                }
            } catch (MalformedURLException ex) {
                throw new FileDownloadException("File not found " + fileName, ex);
            }
        }
}
