package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/product/", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> listAllUsers() {
		List<ProductDTO> productDTOs = productService.findAll();
		if (productDTOs.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductDTO>>(productDTOs, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductDTO> getUser(@PathVariable("id") long id) {
		ProductDTO productDTO = productService.findById(id);
		if (productDTO == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/", method = RequestMethod.POST)
	public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {

		if (productService.isUserExist(productDTO.getName())) {
//			return new ResponseEntity(new CustomErrorType("Unable to create. A Product with name " + 
//			product.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		ProductDTO savedProduct = productService.save(productDTO);
		return new ResponseEntity<ProductDTO>(savedProduct, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ProductDTO> update(@PathVariable("id") long id, @RequestBody ProductDTO productDTO) {

		ProductDTO savedproduct = productService.update(productDTO);
		return new ResponseEntity<ProductDTO>(savedproduct, HttpStatus.OK);
	}

	// ------------------- Delete a Product-----------------------------------------

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {

//			ProductDTO productDTO = productService.findById(id);
//			if (productDTO == null) {
//				logger.error("Unable to delete. Product with id {} not found.", id);
//				return new ResponseEntity(
//						HttpStatus.NOT_FOUND);
//			}
		String message = productService.deleteById(id);
		return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
	}

}
