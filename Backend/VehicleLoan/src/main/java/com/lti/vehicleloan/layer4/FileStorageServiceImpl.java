package com.lti.vehicleloan.layer4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	private final Path root = Paths.get("uploads");
	
	@Override
	public void init() {
		try {
			Files.createDirectory(root);
		}
		catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}

	}

	@Override
	public void save(MultipartFile file) {
		try {
//			String path = userId.toString()+ "_" + file.getOriginalFilename();
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		} 
		catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());

	}

	@Override
	public Stream<Path> loadBasedOnUserId(String userId) {
		try {
			return Files.walk(this.root, 1).filter(path -> path.getFileName().toString().substring(0, 4).equalsIgnoreCase(userId)).map(this.root::relativize);
	    }
		catch (IOException e) {
			throw new RuntimeException("Could not load the files!");
	    }
	}

}
