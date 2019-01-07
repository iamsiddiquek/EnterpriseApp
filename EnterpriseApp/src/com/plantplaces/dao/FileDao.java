package com.plantplaces.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.plantplaces.service.IFileDao;

@Component
public class FileDao implements IFileDao {

	@Override
	public void savePhoto(InputStream inputStream, File file) throws IOException {
		OutputStream outputStream = new FileOutputStream(file);
		IOUtils.copy(inputStream, outputStream);
		
	}

	
	
	
	
}
