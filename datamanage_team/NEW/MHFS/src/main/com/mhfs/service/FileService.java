package com.mhfs.service;

import java.util.List;

import com.mhfs.dao.FileDao;
import com.mhfs.dao.impl.FileDaoImpl;
import com.mhfs.javabean.File;

public class FileService {
	private FileDao fileDao = new FileDaoImpl();

	public List<File> searchBy(String username, String keyword) {
		return fileDao.getFileListBy(username, keyword);
	}

	public boolean addFile(File file) {
		return fileDao.addFile(file);
	}
	
	public boolean updateFile(File file) {
		return fileDao.updateFileBy(file);
	}
	public boolean existFile(String fname, int pri) {
		return fileDao.existFile(fname, pri);
	}

	public List<File> searchBy(String name) {
		
		return fileDao.priSearch(name);
	}

	public File download(String fname, int pri) {
		return fileDao.getFileBy(fname, pri);
	}

}
