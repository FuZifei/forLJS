package com.mhfs.dao;

import java.util.List;

import com.mhfs.javabean.File;

public interface FileDao {
	boolean addFile(File file);

	boolean deleteFile(String fId);

	boolean updateFileBy(File file);

	List<File> getFileListBy(String uName, String keyWord);

	String getUnameBy(String fId);

	List<File> priSearch(String name);

	File getFileBy(String fid);
}
