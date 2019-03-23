package com.mhfs.dao;

import java.util.List;

import com.mhfs.javabean.File;

public interface FileDao {
	boolean addFile(File file);

	boolean deleteFile(String fname, int pri);

	boolean updateFileBy(File file);

	boolean existFile(String fname, int pri);

	List<File> getFileListBy(String uName, String keyWord);

	String getUnameBy(String fname);

	List<File> priSearch(String name);

	File getFileBy(String fname, int pri);
}
