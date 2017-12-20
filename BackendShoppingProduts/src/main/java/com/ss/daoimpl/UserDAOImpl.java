package com.ss.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ss.dao.UserDAO;
import com.ss.dto.Address;
import com.ss.dto.Cart;
import com.ss.dto.User;
@Repository("userDao")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addAddress(Address address) {
		try{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery="from User where email=:email";
		try{
			return sessionFactory.getCurrentSession()
						.createQuery(selectQuery,User.class)
						.setParameter("email", email)
						.getSingleResult();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery="from Address where user=:user and billing=:billing";
		try{
			return sessionFactory.getCurrentSession().createQuery(selectQuery,Address.class)
							.setParameter("user", user)
							.setParameter("billing", true).getSingleResult();
			 
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Address> listShippingAddress(User user) {
		
		String selectQuery="from Address where user=:user and shipping=:shipping";
		try{
			return sessionFactory.getCurrentSession().createQuery(selectQuery,Address.class)
							.setParameter("user", user)
							.setParameter("shipping", true).getResultList();
			 
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
