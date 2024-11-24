package com.application.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pid;
	private String pname;
	@ManyToOne()
	@JoinColumn(name="cid", nullable= false)
	private Category category;
	public Product(String pname, Category category) {
		this.pname = pname;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [Product Id=" + pid + ", Product Name=" + pname + "]";
	}
}
