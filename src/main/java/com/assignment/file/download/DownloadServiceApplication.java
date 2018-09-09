package com.assignment.file.download;

import com.assignment.file.download.property.FileDownloadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileDownloadProperties.class})
public class DownloadServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DownloadServiceApplication.class, args);
    }
}
