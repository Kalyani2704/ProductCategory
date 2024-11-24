package com.application.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.application.dto.ProductDTO;
import com.application.model.Category;
import com.application.model.Product;
import com.application.repository.CategoryRepository;
import com.application.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository proRepo;
	
	@Autowired
	private CategoryRepository catRepo;

	@Override
	public boolean addProduct(ProductDTO proDTO) {
		try {
			Category c= catRepo.findById(proDTO.getCid()).get();
			Product p= new Product(proDTO.getPname(), c);
			proRepo.save(p);
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public Product getById(long pid) {
		return proRepo.findById(pid).get();
	}

	@Override
	public boolean updateProduct(ProductDTO proDTO, long pid) {
		try {
			Product p= proRepo.findById(pid).get();
			p.setPname(proDTO.getPname());
			proRepo.save(p);
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public boolean deleteProduct(long pid) {
		try {
			proRepo.deleteById(pid);
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public Page<Product> getProduct(int pageSize) {
		return proRepo.findAll(PageRequest.ofSize(pageSize));
	}

	@Override
	public List<Product> viewProduct() {
		return proRepo.findAll();
	}
}
