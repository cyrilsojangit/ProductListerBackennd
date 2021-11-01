package com.example.demo.utilities;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductCategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;

@Component
public class ConverterUtilities {

	public Product toProductEntity(ProductDTO productDTO) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Product product = modelMapper.map(productDTO, Product.class);
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(productDTO.getCategory().getId());
		productCategory.setName(productDTO.getCategory().getName());
		return product;

	}

	public ProductDTO toProductDTO(Product product) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
		productCategoryDTO.setId(product.getCategory().getId());
		productCategoryDTO.setName(product.getCategory().getName());
		productDTO.setCategory(productCategoryDTO);
		return productDTO;
	}

	public ProductCategory toProductCategoryEntity(ProductCategoryDTO productCategoryDTO) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductCategory productCategory = modelMapper.map(productCategoryDTO, ProductCategory.class);
//		Optional<ProductCategoryCategory> productCategoryCategory = productCategoryRepository.findById(productCategoryDTO.getId());
//		productCategory.setCategory(productCategoryCategory.get());
		return productCategory;

	}

	public ProductCategoryDTO toProductCategoryDTO(ProductCategory productCategory) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductCategoryDTO productCategoryDTO = modelMapper.map(productCategory, ProductCategoryDTO.class);
		return productCategoryDTO;
	}

}
