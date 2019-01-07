package com.plantplaces.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface IFileDao {

	public void savePhoto(InputStream inputStream, File file) throws IOException;

	
}
