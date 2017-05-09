package com.newer.service;

import java.util.List;

import com.newer.dao.StusDao;
import com.newer.pojo.Student1;

public class SearchService {
	private StusDao  sd = new StusDao();
	public List<Student1> getStusBytag(int id, String name, String cla,int page) {		
		return sd.getStus(id,name,cla,page);
	}
	public List<Student1> getAll() {
		
		return sd.getAll();
	}
	public boolean removeStu(int num) {
		
		return sd.removeStu(num);
	}
	public List<Student1> getKeystu(int key) {
		return sd.getKeystu(key);
	}
	public Long getCount() {
		return sd.getCount();
	}
	public List<Student1> getStus(int cp) {
		return sd.getPageStus(cp);
	}
	public Long getById(int cid) {	
		return sd.getById(cid);
	}
	

}
