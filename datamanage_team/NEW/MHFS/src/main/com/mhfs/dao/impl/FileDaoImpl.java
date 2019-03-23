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
			System.out.println("uName: "+file.getuName()+"file name: "+file.getName());
			preparedStatement = connection.prepareStatement(Sql.ADD_FILE);
			preparedStatement.setString(1, file.getuName());
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
	public boolean updateFileBy(File file) {
		boolean res = false;

		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Sql.UPDATE_FILE_BY_FNAME);
			preparedStatement.setString(1, file.getuName());
			preparedStatement.setString(2, file.getContent());
			preparedStatement.setInt(3, file.getPri());
			preparedStatement.setString(4, file.getName());
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
	public boolean existFile(String fname, int pri) {
		boolean res=false;
		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Sql.SEARCH_FILE_BY_NAME);
			preparedStatement.setString(1, fname);
			preparedStatement.setInt(2, pri);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
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
				File file = new File(rs.getString(1), rs.getString(2), null, 0);
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
	public String getUnameBy(String fname) {
		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		String name = null;
		try {
			preparedStatement = connection.prepareStatement(Sql.GET_UNMAE_BY_FNAME);
			preparedStatement.setString(1, fname);
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
				File file = new File(rs.getString(1), rs.getString(2), null, 0);
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
	public File getFileBy(String fname, int pri) {
		Connection connection = JdbcUtil.getConection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		File file = null;
		try {
			preparedStatement = connection.prepareStatement(Sql.SEARCH_FILE_BY_NAME);
			preparedStatement.setString(1, fname);
			preparedStatement.setInt(2, pri);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				file = new File( rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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
