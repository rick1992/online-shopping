package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional

public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> list() {

		String selectActiveCategory = "FROM Product WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);

		return query.getResultList();
	}

	@Override
	public boolean add(Product product) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().save(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {

		product.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	Obteniendo a un solo producto por id 
	@Override
	public Product get(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM  Product where active = :active";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProducts = "FROM  Product where active = :active and categoryId = :categoryId";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> listLatestActiveProducts(int count) {
		String selectActiveProducts = "FROM  Product where active = :active order by id";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
