package com.application.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.application.dto.ProductDTO;
import com.application.model.Product;

public interface ProductService {
	public boolean addProduct(ProductDTO proDTO);

	public Product getById(long pid);

	public boolean updateProduct(ProductDTO proDTO, long pid);

	public boolean deleteProduct(long pid);

	public Page<Product> getProduct(int pageSize);

	public List<Product> viewProduct();

}
