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
		} else if (action.equals("download")) {
			String fid = req.getParameter("fid");
			File file = fileService.download(fid);
			JSONObject jo = new JSONObject();
			jo.put("fName", file.getName());
			jo.put("fContent", file.getContent());
			ret.put(jo);
			resp.getWriter().write(jo.toString());
			return;
		} else if (action.equals("upload")) {
			String fName = req.getParameter("fname");
			String fContent = req.getParameter("fcontent");
			String pri = req.getParameter("pri");
			File file = new File(-1, (String) req.getSession().getAttribute("name"), fName, fContent,
					Integer.parseInt(pri));
			boolean flag = fileService.addFile(file);
			JSONObject jsonObject = new JSONObject();
			if (flag) {
				jsonObject.put("ret", "0");
				jsonObject.put("msg", "");
			} else {
				jsonObject.put("ret", "1");
				jsonObject.put("msg", "error");
			}
			resp.getWriter().write(jsonObject.toString());
			return;
		} else if (action.equals("delete")) {
			String fId = req.getParameter("fId");
			String uName = (String) req.getSession().getAttribute("name");
			boolean flag = fileService.deleteFile(fId, uName);
			JSONObject jsonObject = new JSONObject();
			if (flag) {
				jsonObject.put("ret", "0");
				jsonObject.put("msg", "");
			} else {
				jsonObject.put("ret", "1");
				jsonObject.put("msg", "Without permission");
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
			jo.put("id", file.getId());
			jo.put("uName", file.getUName());
			jo.put("fName", file.getName());
			jo.put("fContent", file.getContent());
			ret.put(jo);
		}
	}

	private void handleSearch(JSONArray ret, String username, String keyword) {
		List<File> files = fileService.searchBy(username, keyword);
		for (File file : files) {
			JSONObject jo = new JSONObject();
			jo.put("id", file.getId());
			jo.put("uName", file.getUName());
			jo.put("fName", file.getName());
			jo.put("fContent", file.getContent());
			ret.put(jo);
		}
	}
}
