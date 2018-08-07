package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext()	;
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO= (CategoryDAO)context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		category = new Category();
//		category.setName("Televisor");
//		category.setDescription("Artefacto con pantalla");
//		category.setImageURL("CAT_1.png");
//
//		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
//		
//		category = new Category();
//		category.setName("Computadora");
//		category.setDescription("Artefacto para jugar");
//		category.setImageURL("CAT_2.png");
//
//		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
//		
//		category = new Category();
//		category.setName("Radio");
//		category.setDescription("Artefacto para tonear");
//		category.setImageURL("CAT_3.png");
//
//		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
//	}
	
//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.get(1);
//		
//		assertEquals("Successfully fectched  a  sibgle category from  the table!","Televisor",category.getName());
//		
//		
//	}
	
//	@Test
//	public void testUdateCategory() {
//		category = categoryDAO.get(1);
//		category.setName("TV");
//		assertEquals("Successfully update  a  single category from  the table!",true,categoryDAO.update(category));
//		
//		
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.get(3);
//		assertEquals("Successfully delete  a  single category from  the table!",true,categoryDAO.delete(category));
//		
//		
//	}
//	
//	@Test
//	public void testListCategory() {
//		assertEquals("Successfully listing active categories from  the table!",2,categoryDAO.list().size());
//		
//		
//	}
	
	
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));

		
		// fetching and updating the category
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());		
				
		
	}
	
}
