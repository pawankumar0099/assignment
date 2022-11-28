package com.nagarro.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.model.TShirt;

@Component
public class ProductSearchDaoImpl implements ProductSearchDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<TShirt> search(String color, String size, String gender, String outputPreference) {

		String query = "from TShirt where color=:clr and size=:sz and gender=:gen order by " + outputPreference
				+ " desc";
		List<TShirt> result = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		System.out.println(outputPreference);
		result = session.createQuery(query).setParameter("clr", color).setParameter("sz", size)
				.setParameter("gen", gender).getResultList();

		return result;
	}

}
