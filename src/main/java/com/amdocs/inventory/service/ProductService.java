package com.amdocs.inventory.service;

import java.util.List;

import com.amdocs.inventory.model.Product;

/**
 * The Interface ProductService.
 */
public interface ProductService {
	
	/**
	 * Gets the product.
	 *
	 * @param productId the product id
	 * @return the product
	 */
	public Product getProduct(long productId);
	
	/**
	 * Gets the all product.
	 *
	 * @return the all product
	 */
	public List<Product> getAllProduct();
	
	/**
	 * Edits the product.
	 *
	 * @param product the product
	 * @return the product
	 */
	public Product editProduct(Product product);
	
	/**
	 * Delete product.
	 *
	 * @param productId the product id
	 * @return true, if successful
	 */
	public boolean deleteProduct( long productId);
	
}
