package com.newer.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.newer.pojo.Student1;
import com.newer.service.SearchService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchService ss = new SearchService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int id;
		try{id = Integer.parseInt(request.getParameter("id"));}
		catch(NumberFormatException e){
			id = 0;
		}
		String name = request.getParameter("classname");
		String cla = request.getParameter("class");
		String type = request.getParameter("type");		
		if("find".equals(type)){
			int page = Integer.parseInt(request.getParameter("mm"));
			List<Student1> stus = ss.getStusBytag(id,name,cla,page);
			if(stus.size()==0){
				out.print("无结果");
			}else{
				Gson gson = new Gson();
				String str = gson.toJson(stus);
				out.print(str);
				System.out.println(str);
			}			
		}else if("delete".equals(type)){
			int num =Integer.parseInt(request.getParameter("id")) ;
			boolean res = ss.removeStu(num);
			if(res){
				out.print("删除成功");
			}else{
				out.print("删除失败");
			}
		}
		else if("all".equals(type)){
			List<Student1> stus = ss.getAll();
			Gson gson = new Gson();
			String str = gson.toJson(stus);
			out.print(str);			
		}
		else if("search".equals(type)){
			int key = Integer.parseInt(request.getParameter("key"));
			List<Student1> stus = ss.getKeystu(key);
			if(stus.size()==0){
				out.print("无结果");
			}else{
				Gson gson = new Gson();
				String str = gson.toJson(stus);
				out.print(str);
			}			
			
		}
		else if("count".equals(type)){
		Long count = ss.getCount();
			out.print(count);			
	}
	else if("currentPage".equals(type)){
			int cp = Integer.parseInt(request.getParameter("cp"));
			List<Student1> stus = ss.getStus(cp);
			Gson gson = new Gson();
			String str = gson.toJson(stus);
			out.print(str);
		}  
	else if("countById".equals(type)){
		int cid = Integer.parseInt(request.getParameter("cid"));
		long count = ss.getById(cid);
		out.print(count);
	}
	}
	
}
