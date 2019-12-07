package com.amdocs.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.inventory.model.Product;
import com.amdocs.inventory.model.ProductCharacteristic;
import com.amdocs.inventory.repository.ProductCharacteristicsRepository;
import com.amdocs.inventory.repository.ProductRepository;

/**
 * The Class IProductService.
 */
@Service
public class IProductService implements ProductService {

	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;

	/** The product characteristics repository. */
	@Autowired
	private ProductCharacteristicsRepository productCharacteristicsRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amdocs.inventory.service.ProductService#getProduct(long)
	 */
	@Override
	public Product getProduct(long productId) {
		if (productId < 1)
			return null;
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent())
			return product.get();
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amdocs.inventory.service.ProductService#getAllProduct()
	 */
	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amdocs.inventory.service.ProductService#editProduct(com.amdocs.
	 * inventory.model.Product)
	 */
	@Override
	public Product editProduct(Product product) {
		return productRepository.save(product);
	}

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amdocs.inventory.service.ProductService#addProductCharacteristics(
	 * java.lang.Long, java.util.List)
	 */
	@Override
	public boolean addProductCharacteristics(Long productId, List<ProductCharacteristic> productCharacteristics) {
		if (getProduct(productId) == null)
			return false;
		for (ProductCharacteristic characteristic : productCharacteristics) {
			characteristic.setProductId(productId);
			productCharacteristicsRepository.save(characteristic);
		}
		return true;
	}

}
