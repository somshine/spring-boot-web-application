package com.somshine.webApp.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.Option;
import com.somshine.webApp.WebAppApplication;
import com.somshine.webApp.model.Product;
import com.somshine.webApp.repository.ProductRepository;

@RestController
@RequestMapping(value = "/products/v1")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class ProductController {
	private static final Logger LOG = Logger.getLogger(WebAppApplication.class.getName());
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Product getProductData(@PathVariable Long id) {
		LOG.log(Level.INFO, "product/get/" + id + " is calling");
		return productRepository.findById(id).orElse(null);
	}
	
	@RequestMapping(value = "/stockoverview/{type}", method = RequestMethod.GET)
	public List<Product> getProductStockInformation(@PathVariable String type) {
		LOG.log(Level.INFO, "product/stockoverview/" + type + " is calling");
		if (type.toLowerCase().equals("low")) {
			return productRepository.findProductByStockAscSorting();
		} else {
			return productRepository.findProductByStockDescSorting();
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Product> getProductList() {
		LOG.log(Level.INFO, "product/list is calling");
		try {
//			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productRepository.findAll();
	}
	
	@RequestMapping(value = "getByName/{name}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("name") String name) {
		LOG.log(Level.INFO, "getByName/ " + name + " is calling");
		return productRepository.findByName(name);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Product update(@RequestBody Product product) {
		LOG.log(Level.INFO, "update/ is calling");
		Product updateProduct = productRepository.findById(product.getId()).orElse(null);
		if (updateProduct != null) {
			updateProduct.setName(product.getName());
			updateProduct.setDescription(product.getDescription());
			updateProduct.setCompany(product.getCompany());
			productRepository.save(updateProduct);
		}
		return updateProduct;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable Long id) {
		LOG.log(Level.INFO, "delete/" + id + " is calling");
		Product product = productRepository.findById(id).orElse(null);
		if (product != null) {
			try {
				productRepository.deleteById(id);
			} catch (Exception e) {
				return null;
			}
		}
		return product;
	}
	
}
