package com.amdocs.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.inventory.model.Product;
import com.amdocs.inventory.repository.ProductRepository;

@Service
public class IProductService implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProduct(long productId) {
		if (productId < 1)
			return null;
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent())
			return product.get();
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product editProduct(Product product) {
		return productRepository.save(product);
	}

	/* (non-Javadoc)
	 * @see com.amdocs.inventory.service.ProductService#deleteProduct(long)
	 */
	@Override
	public boolean deleteProduct(long productId) {
		boolean isDeleted = false;
		try {
			productRepository.deleteById(productId);
			isDeleted = true;
		} catch (Exception exception) {
			exception.printStackTrace();
			isDeleted = false;
		}
		return isDeleted;
	}

}
