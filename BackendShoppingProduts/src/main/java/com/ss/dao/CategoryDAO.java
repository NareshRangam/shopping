package com.ss.dao;
import java.util.*;

import com.ss.dto.Category;
public interface CategoryDAO {
	List<Category> list();
	Category get(int id);

}
