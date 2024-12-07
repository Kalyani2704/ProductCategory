package com.application.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.dto.ProductDTO;
import com.application.model.Product;
import com.application.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService serv;
	
	@GetMapping("/view")
	public List<Product> viewProduct() {
		return serv.viewProduct();
	}
	
	@GetMapping("")
	public Page<Product> getProduct(@RequestParam(name="page", required=true) Integer pageSize){
		return serv.getProduct(pageSize);
	}
	
	@PostMapping("")
	public String addProduct(@RequestBody ProductDTO proDTO) {
		System.out.println(proDTO.toString());
		if(serv.addProduct(proDTO))
			return "new product added";
		else
			return "unable to add data";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getById(@PathVariable("id") long pid){
		Product p= serv.getById(pid);
		return new ResponseEntity<String>(p.toString(), HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@PathVariable("id") long pid, @RequestBody ProductDTO proDTO) {
		System.out.println(proDTO.toString());
		if(serv.updateProduct(proDTO, pid))
			return "product updated";
		else
			return "unable to update data";
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable("id") long pid) {
		if(serv.deleteProduct(pid))
			return "product deleted";
		else
			return "unable to dlete product";
	}
}
