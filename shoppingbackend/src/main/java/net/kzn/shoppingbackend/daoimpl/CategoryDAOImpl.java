package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")

public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Televisor");
		category.setDescription("Artefacto con pantalla");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		category = new Category();
		category.setId(1);
		category.setName("Radio");
		category.setDescription("Artefacto con escuchar musica");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		category = new Category();
		category.setId(1);
		category.setName("Computadora");
		category.setDescription("Artefacto para ver porno");
		category.setImageURL("CAT_3.png");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
