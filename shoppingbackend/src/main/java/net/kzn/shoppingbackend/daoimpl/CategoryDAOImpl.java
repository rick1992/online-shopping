package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);

		return query.getResultList();
	}

	@Override
	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().save(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	Obteniendo a una sola categoria por id 
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

//	private static List<Category> categories = new ArrayList<>();
//
//	static {
//		Category category = new Category();
//		category.setId(1);
//		category.setName("Televisor");
//		category.setDescription("Artefacto con pantalla");
//		category.setImageURL("CAT_1.png");
//
//		categories.add(category);
//
//		category = new Category();
//		category.setId(2);
//		category.setName("Radio");
//		category.setDescription("Artefacto con escuchar música");
//		category.setImageURL("CAT_2.png");
//
//		categories.add(category);
//
//		category = new Category();
//		category.setId(3);
//		category.setName("Computadora");
//		category.setDescription("Artefacto para ver porno");
//		category.setImageURL("CAT_3.png");
//
//		categories.add(category);
//	}

//	@Override
//	public Category get(int id) {
//		// enchanced for loop
//
//		for (Category category : categories) {
//			if (category.getId() == id)
//				return category;
//		}
//
//		return null;
//
//	}
}
