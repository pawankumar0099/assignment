package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.UserAuthentication;

@Transactional
@Repository
@Component
public class UserAuthenticationDaoImpl implements UserAuthenticationDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean ValidateUser(String username, String password) {

		UserAuthentication user = hibernateTemplate.get(UserAuthentication.class, username);

		if (user == null)
			return false;
		return compare(user.getPassword(), password);

//		return false;

	}

	@Override
	public void updatePassword(String username, String password) {

		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery("update UserAuthentication set password=:pwd where username=:uname")
				.setParameter("pwd", password).setParameter("uname", username);
		q.executeUpdate();
		transaction.commit();
	}

	@Override
	public boolean isUserExist(String username) {
		if (hibernateTemplate.get(UserAuthentication.class, username) != null)
			return true;
		return false;
	}

	public boolean compare(String dbPassword, String password) {
		if (dbPassword.equals(password))
			return true;
		return false;
	}
}
