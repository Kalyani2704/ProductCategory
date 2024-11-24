package com.application.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.dto.CategoryDTO;
import com.application.model.Category;
import com.application.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService serv;
	
	@GetMapping("/page={pageSize}")
	public Page<Category> getCategory(@PathVariable int pageSize){
		return serv.getCategory(pageSize);
	}
	
	@PostMapping("")
	public String addCategory(@RequestBody CategoryDTO catDTO) {
		if(serv.addCategory(catDTO))
			return "new category added......";
		else
			return "unable to add data";	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getById(@PathVariable("id") long cid){
		Category c= serv.getById(cid);
		return new ResponseEntity<String>(c.toString(), HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public String updateCategory(@PathVariable("id") long cid, @RequestBody CategoryDTO catDTO) {
		System.out.println(catDTO.toString());
		if(serv.updateCategory(catDTO, cid))
			return "category updated";
		else
			return "unable to update data";
	}
	
	@DeleteMapping("/{id}")
 	public String deleteCategory(@PathVariable("id") long cid, @RequestBody CategoryDTO catDTO) {
		if(serv.deleteCategory(cid))
			return "category deleted";
		else
			return "unable to delete data";
	}
}
