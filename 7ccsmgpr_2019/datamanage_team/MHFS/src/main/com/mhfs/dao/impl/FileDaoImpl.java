package com.mhfs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mhfs.dao.FileDao;
import com.mhfs.dao.Sql;
import com.mhfs.javabean.File;
import com.mhfs.util.JdbcUtil;

public class FileDaoImpl implements FileDao {
	@Override
	public boolean addFile(File file) {
		boolean res = false;

		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Sql.ADD_FILE);
			preparedStatement.setString(1, file.getUName());
			preparedStatement.setString(2, file.getName());
			preparedStatement.setString(3, file.getContent());
			preparedStatement.setInt(4, file.getPri());
			if (preparedStatement.executeUpdate() != 0) {
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
			}
		}
		return res;
	}

	@Override
	public boolean deleteFile(String fid) {
		boolean res = false;

		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Sql.DELETE_FILE);
			preparedStatement.setInt(1, Integer.parseInt(fid));
			if (preparedStatement.executeUpdate() != 0) {
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
			}
		}
		return res;
	}

	@Override
	public boolean updateFileBy(File file) {
		boolean res = false;

		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Sql.UPDATE_FILE_BY_ID);
			preparedStatement.setString(1, file.getName());
			preparedStatement.setString(2, file.getContent());
			preparedStatement.setInt(3, file.getId());
			if (preparedStatement.executeUpdate() != 0) {
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
			}
		}
		return res;
	}

	@Override
	public List<File> getFileListBy(String uName, String keyWord) {
		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		List<File> files = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(Sql.SEARCH_FILE);
			preparedStatement.setString(1, "%" + uName + "%");
			preparedStatement.setString(2, "%" + keyWord + "%");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				File file = new File(rs.getInt(1), rs.getString(2), rs.getString(3), null, 0);
				files.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
			}
		}
		return files;
	}

	@Override
	public String getUnameBy(String fId) {
		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		String name = null;
		try {
			preparedStatement = connection.prepareStatement(Sql.GET_UNMAE_BY_FID);
			preparedStatement.setInt(1, Integer.parseInt(fId));
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				name = rs.getString("u_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
			}
		}
		return name;
	}

	@Override
	public List<File> priSearch(String name) {
		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		List<File> files = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(Sql.SEARCH_PRI_FILE);
			preparedStatement.setString(1, name);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				File file = new File(rs.getInt(1), rs.getString(2), rs.getString(3), null, 0);
				files.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
			}
		}
		return files;
	}

	@Override
	public File getFileBy(String fid) {
		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		File file = null;
		try {
			preparedStatement = connection.prepareStatement(Sql.SEARCH_FILE_BY_ID);
			preparedStatement.setInt(1, Integer.parseInt(fid));
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				file = new File(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
			}
		}
		return file;
	}

}
