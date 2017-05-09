package com.newer.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.newer.pojo.Student1;
import com.newer.util.HibernateSessionFactory;

public class StusDao {
	private Session s = null;
	private Transaction tr = null;

	public List<Student1> getStus(int id, String name, String cla,int page) {
		List<Student1> stus = new ArrayList<Student1>();
		s = HibernateSessionFactory.getSession();
		tr = s.beginTransaction();
		String hql = "from Student1 where 1=1";
		if (0 != id) {
			hql = hql + " and studentNo " + "like '%" + id + "%'";
		}
		if (!"".equals(name)) {
			hql = hql + " and studentName " + "like '%" + name + "%'";
		}
		if (!"".equals(cla)) {
			hql = hql + "and studentClass " + "like '%" + cla + "%'";
		}
		Query query = s.createQuery(hql);
		query.setFirstResult((page-1)*2);
		query.setMaxResults(2);
		stus = query.list();
		s.close();
		return stus;
	}

	/**
	 * 查询所有集合的方法
	 * 
	 * @return
	 */
	public List<Student1> getAll() {
		List<Student1> stus = new ArrayList<Student1>();
		s = HibernateSessionFactory.getSession();
		tr = s.beginTransaction();
		String hql = "from Student1";
		Query query = s.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(2);
		stus = query.list();
		tr.commit();
		s.close();
		return stus;

	}

	public boolean removeStu(int num) {
		boolean res = true;
		s = HibernateSessionFactory.getSession();
		tr = s.beginTransaction();
		try {
			String hql = "from Student1 where id = " + num;
			Query query = s.createQuery(hql);
			Student1 stu = (Student1) query.uniqueResult();
			s.delete(stu);
			tr.commit();
		} catch (Exception e) {
			res = false;
			tr.rollback();
		} finally {
			s.close();
		}
		return res;
	}

	public List<Student1> getKeystu(int key) {
		s = HibernateSessionFactory.getSession();
		tr = s.beginTransaction();
		List<Student1> stus = new ArrayList<Student1>();
		try {
			String hql = "from Student1 where id " + "like'%" + key + "%'";
			Query query = s.createQuery(hql);
			stus = query.list();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		} finally {
			s.close();
		}
		return stus;
	}

	public Long getCount() {
		s = HibernateSessionFactory.getSession();
		tr = s.beginTransaction();
		String hql = "select count(id) from Student1";
		Query query = s.createQuery(hql);
		Long count = (Long) query.uniqueResult();
		s.close();
		return count;
	}

	public List<Student1> getPageStus(int cp) {
		List<Student1> stus = new ArrayList<Student1>();
		s = HibernateSessionFactory.getSession();
		tr = s.beginTransaction();
		String hql = "from Student1";
		Query query = s.createQuery(hql);
		query.setFirstResult((cp-1)*2);
		query.setMaxResults(2);
		stus = query.list();
		s.close();
		return stus;
		
	}

	public Long getById(int cid) {
		long count = 0;
		s = HibernateSessionFactory.getSession();
		tr = s.beginTransaction();
		//String hql = "select count(s.id) from (select id from Student1 where id like '%"+cid+"%') s";
		String hql = "select count(id) from Student1 where id like :id";
		Query query = s.createQuery(hql);
		query.setString("id", "%"+cid+"%");
		count = (Long) query.uniqueResult();
		s.close();
		return count;
	}

	

	
}
