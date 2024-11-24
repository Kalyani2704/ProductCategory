package com.application.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.application.dto.CategoryDTO;
import com.application.model.Category;
import com.application.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository repo;

	@Override
	public boolean addCategory(CategoryDTO catDTO) {
		Category c= new Category(catDTO.getCname());
		try {
			repo.save(c);
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public Category getById(long cid) {
		return repo.findById(cid).get();
	}

	@Override
	public boolean updateCategory(CategoryDTO catDTO, long cid) {
		try {
			Category c= repo.findById(cid).get();
			c.setCname(catDTO.getCname());
			repo.save(c);
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public boolean deleteCategory(long cid) {
		try {
			repo.deleteById(cid);
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public Page<Category> getCategory(int pageSize) {
		return repo.findAll(PageRequest.ofSize(pageSize));
	}

}
