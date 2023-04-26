package com.example.springedu.domain;

import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;
@Getter
@AllArgsConstructor
public class FileVO2 {
	private MultipartFile[] uploadFiles;
}
