package com.application.model;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cid;
	private String cname;
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	private Set<Product> product;
	public Category(String name) {
		cname= name;
	}
	@Override
	public String toString() {
		return "Category [Category Id=" + cid + ", Category Name=" + cname + "]";
	}
}
