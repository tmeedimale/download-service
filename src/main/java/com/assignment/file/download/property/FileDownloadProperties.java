package com.assignment.file.download.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix= "file")
public class FileDownloadProperties {

    private String uploadDir;
}
