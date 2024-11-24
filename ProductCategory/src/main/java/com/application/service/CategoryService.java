package com.application.service;
import org.springframework.data.domain.Page;

import com.application.dto.CategoryDTO;
import com.application.model.Category;

public interface CategoryService {
	public boolean addCategory(CategoryDTO catDTO);

	public Category getById(long cid);

	public boolean updateCategory(CategoryDTO catDTO, long cid);

	public boolean deleteCategory(long cid);

	public Page<Category> getCategory(int pageSize);

}
