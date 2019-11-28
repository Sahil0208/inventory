package com.amdocs.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.inventory.model.Product;
import com.amdocs.inventory.service.ProductService;
import com.amdocs.inventory.utils.InventoryConstants;
import com.amdocs.inventory.utils.ResponseHandler;

@RestController
@RequestMapping("/inventory")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public Product getProduct(@RequestParam long productId) {
		if (productId < 1)
			return null;
		return productService.getProduct(productId);
	}

	@GetMapping("/products")
	public ResponseEntity<Object> getAllProduct() {
		return ResponseHandler.doSuccessResponse(productService.getAllProduct(), HttpStatus.OK);
	}

	@PostMapping("/product")
	public ResponseEntity<Object> editProduct(@Valid @RequestBody Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<String> errors = ResponseHandler.errorFields(bindingResult.getFieldErrors());
			return ResponseHandler.doErrorResponse(errors, HttpStatus.OK);
		}
		Product newProduct = productService.editProduct(product);
		if (newProduct != null)
			return ResponseHandler.doSuccessResponse(InventoryConstants.PRODUCT_IS_SUCCESSFULLY_CREATED, HttpStatus.OK);
		return ResponseHandler.doErrorResponse(InventoryConstants.FAILED_TO_CREATE_PRODUCT, HttpStatus.OK);
	}

	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Object> deleteProduct(@PathVariable long productId) {
		if (productId < 1) {
			return ResponseHandler.doErrorResponse(InventoryConstants.INVALID_PRODUCT_ID, HttpStatus.OK);
		}
		boolean isProductDeleted = productService.deleteProduct(productId);
		if (isProductDeleted) {
			return ResponseHandler.doSuccessResponse(InventoryConstants.PRODUCT_IS_SUCCESSFULLY_CREATED, HttpStatus.OK);
		}
		return ResponseHandler.doErrorResponse(InventoryConstants.FAILED_TO_DELETE_PRODUCT, HttpStatus.OK);
	}
}
