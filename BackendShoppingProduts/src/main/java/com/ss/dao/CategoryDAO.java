package com.ss.dao;
import java.util.*;

import com.ss.dto.Category;
public interface CategoryDAO {
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	

}
