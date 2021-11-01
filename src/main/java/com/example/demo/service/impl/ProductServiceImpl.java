package com.example.demo.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;

import java.sql.Timestamp;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.utilities.ConverterUtilities;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ConverterUtilities converterUtilities;

	@Override
	public ProductDTO findById(long id) {
		Product product = productRepository.findById(id).get();
		return converterUtilities.toProductDTO(product);
	}

	@Override
	public ProductDTO findByName(String name) {
		Product product = productRepository.findByName(name).get();
		return converterUtilities.toProductDTO(product);
	}

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		Product savedProduct = productRepository.save(converterUtilities.toProductEntity(productDTO));
		return converterUtilities.toProductDTO(savedProduct);
	}

	@Override
	public ProductDTO update(ProductDTO productDTO) {
		Product savedProduct = productRepository.save(converterUtilities.toProductEntity(productDTO));
		return converterUtilities.toProductDTO(savedProduct);
	}

	@Override
	public String deleteById(Long id) {
		productRepository.deleteById(id);
		return "Product succesfully deleted";
	}

	@Override
	public List<ProductDTO> findAll() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDTos = products.stream().map(e -> converterUtilities.toProductDTO(e))
				.collect(Collectors.toList());
		Collections.sort(productDTos, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		return productDTos;
	}

	@Override
	public boolean isUserExist(String name) {
		return productRepository.findByName(name).isPresent();
	}

	@Override
	public boolean isUserExist(Long id) {
		return productRepository.findById(id).isPresent();
	}

}
