package mypkg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mypkg.entity.Product;
import mypkg.repository.ProductRepository;

@Service
@Profile(value={"abc","testabc","aaa"})
public class ProductService {

	@Autowired
	private ProductRepository repository;
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return repository.save(product);
	}
	public List<Product> saveProducts(List<Product> products) {
		// TODO Auto-generated method stub
		return repository.saveAll(products);
	}
	public Product getProductByID(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	public String deleteProduct(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return "ID of the product removed is : - "+id;
	}
	public Product updateProduct(Product p) {
		// TODO Auto-generated method stub
		Product prodInDB=repository.findById(p.getId()).orElse(null);
		prodInDB.setQuantity(12);
		prodInDB.setPrice(1778.0);
		return repository.save(prodInDB);
	}
	
	
}
