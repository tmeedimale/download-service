package com.assignment.file.download.service;

import org.springframework.core.io.Resource;

public interface FileDownloadService {

    Resource loadFileAsResource(String fileName);
}
