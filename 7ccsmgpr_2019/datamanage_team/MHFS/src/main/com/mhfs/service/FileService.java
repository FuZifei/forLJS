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

	public boolean deleteFile(String fId, String uName) {
		String username = fileDao.getUnameBy(fId);
		if (username.equals(uName)) {
			return fileDao.deleteFile(fId);
		}
		return false;
	}

	public boolean updateFile(File file) {
		return fileDao.updateFileBy(file);
	}

	public List<File> searchBy(String name) {
		
		return fileDao.priSearch(name);
	}

	public File download(String fid) {
		return fileDao.getFileBy(fid);
	}

}
