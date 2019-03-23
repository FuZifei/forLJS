package com.mhfs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mhfs.javabean.File;
import com.mhfs.service.FileService;

@WebServlet("/system/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FileService fileService = new FileService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		JSONArray ret = new JSONArray();
		if (action.equals("search")) {
			String username = req.getParameter("username");
			String keyword = req.getParameter("keyword");
			handleSearch(ret, username, keyword);
		} else if (action.equals("priSearch")) {
			String name = (String) req.getSession().getAttribute("name");
			handlePriSearch(ret, name);
		}else if (action.equals("trashSearch")) {
			String username = req.getParameter("username");
			String keyword = req.getParameter("keyword");
			ret=handleTrashSearch( username,  keyword);
		
		} 
		else if (action.equals("download")) {
			String fname = req.getParameter("fname");
			String pri = req.getParameter("pri");
			JSONObject jo = new JSONObject();
			System.out.println("pri is: "+pri);
			
												
				File file = fileService.download(fname, Integer.parseInt(pri));
				jo.put("fName", file.getName());
				jo.put("fContent", file.getContent());
				jo.put("ret", "0");
				jo.put("msg", "download success");
			
			resp.getWriter().write(jo.toString());
			return;
		} else if (action.equals("upload")) {
			String fName = req.getParameter("fname");
			String fContent = req.getParameter("fcontent");
			String pri = req.getParameter("pri");
			JSONObject jsonObject = new JSONObject();
			//search for existance ??
			//if exist already, whether lock is available?
			if(fileService.existFile(fName,Integer.parseInt(pri))) {
																		
																				
					File file = new File((String) req.getSession().getAttribute("name"), fName, fContent,
						Integer.parseInt(pri));
					boolean flag = fileService.movetoTrash(fName, Integer.parseInt(pri));
					if (flag) {
						flag = fileService.updateFile(file);
						if(flag) {
							jsonObject.put("ret", "2");
							jsonObject.put("msg", "Update success! The previous version is in bin");
						}
						else {
							jsonObject.put("ret", "1");
							jsonObject.put("msg", "Update failed but move to trash");
						}
					
					}
					else {
						jsonObject.put("ret", "1");
						jsonObject.put("msg", "update failed but success move to trash");
					}
			
				
			}
								//if not exist yet,upload new file directly
			else {
				File file = new File((String) req.getSession().getAttribute("name"), fName, fContent,
					Integer.parseInt(pri));
			boolean flag = fileService.addFile(file);
			
			if (flag) {
				jsonObject.put("ret", "0");
				jsonObject.put("msg", "");
			} else {
				jsonObject.put("ret", "1");
				jsonObject.put("msg", "Upload Failed");
			}
			 
			}
			resp.getWriter().write(jsonObject.toString());
			return;
		} else if (action.equals("delete")) {
			String fname = req.getParameter("fname");
			String pri = req.getParameter("pri");
			String uName = (String) req.getSession().getAttribute("name");
			JSONObject jsonObject = new JSONObject();
															

				boolean flag = fileService.movetoTrash(fname, Integer.parseInt(pri));
				if(flag) {
					flag = fileService.deleteFile(fname, Integer.parseInt(pri));
					if(flag) {
						jsonObject.put("ret", "0");
						jsonObject.put("msg", "move to trash");
					}
					else {
						jsonObject.put("ret", "1");
						jsonObject.put("msg", "delete failed");
					}
				}
				else {
					jsonObject.put("ret", "1");
					jsonObject.put("msg", "move to trash failed");
				}
			
			
			resp.getWriter().write(jsonObject.toString());
			return;
		}else if (action.equals("totallyDel")) {
			String fID = req.getParameter("id");
			boolean flag = fileService.totallyDel(fID);
			JSONObject jsonObject = new JSONObject();
			if(flag) {
				jsonObject.put("ret", "0");
				jsonObject.put("msg","Totally Delete!");
			}
			else {
				jsonObject.put("ret", "1");
				jsonObject.put("msg","Totally Delete failed!");
			}
			resp.getWriter().write(jsonObject.toString());
			return;
		}

		resp.getWriter().write(ret.toString());
	}

	private void handlePriSearch(JSONArray ret, String name) {
		List<File> files = fileService.searchBy(name);
		for (File file : files) {
			JSONObject jo = new JSONObject();
			//jo.put("id", file.getId());
			jo.put("uName", file.getuName());
			jo.put("fName", file.getName());
			jo.put("fContent", file.getContent());
			ret.put(jo);
		}
	}

	private void handleSearch(JSONArray ret, String username, String keyword) {
		List<File> files = fileService.searchBy(username, keyword);
		for (File file : files) {
			JSONObject jo = new JSONObject();

			jo.put("uName", file.getuName());
			jo.put("fName", file.getName());
			jo.put("fContent", file.getContent());
			ret.put(jo);
		}
	}
	
	public JSONArray	 handleTrashSearch( String username, String keyword) {
		 return fileService.searchTrash(username, keyword);
	
	}
}
