package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDTO;

public interface ProductService {

	public ProductDTO findById(long id);

	public ProductDTO findByName(String name);

	public ProductDTO save(ProductDTO productDTO);

	public ProductDTO update(ProductDTO productDTO);

	public String deleteById(Long id);

	public List<ProductDTO> findAll();

	boolean isUserExist(Long id);

	boolean isUserExist(String name);

}
