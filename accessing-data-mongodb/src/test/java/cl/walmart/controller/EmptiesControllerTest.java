package cl.walmart.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import cl.walmart.model.DiscountDO;
import cl.walmart.model.ProductDO;
import cl.walmart.service.BrandService;
import cl.walmart.service.DiscountService;
import cl.walmart.service.ProductService;

public class EmptiesControllerTest {

	BrandService brandServiceMock = Mockito.mock(BrandService.class);
	DiscountService discountServiceMock = Mockito.mock(DiscountService.class);
	ProductService productServiceMock = Mockito.mock(ProductService.class);
	
	@Autowired
	BrandController brandController = new BrandController(brandServiceMock);
	@Autowired
	DiscountController discountController = new DiscountController(discountServiceMock);
	@Autowired
	ProductController productController = new ProductController(productServiceMock);
	
	@BeforeEach
	void setUp() {
		Mockito.when(brandServiceMock.findAll()).thenReturn(new ArrayList<String>());
		Mockito.when(discountServiceMock.findAll()).thenReturn(new ArrayList<DiscountDO>());
		Mockito.when(productServiceMock.findAll()).thenReturn(new ArrayList<ProductDO>());
	}
	
	@DisplayName("Should send empty array of brands")
	@Test
	void brandShouldSendEmptyWhenNoData() {
		ResponseEntity<List<String>> response = brandController.getAll();
		System.out.println("Object returned:" + response.getBody());
		Assertions.assertEquals(true, response.getBody().isEmpty());
	}
	
	@DisplayName("Should send empty array of discounts")
	@Test
	void discountShouldSendEmptyWhenNoData() {
		ResponseEntity<List<DiscountDO>> response = discountController.getAll();
		System.out.println("Object returned:" + response.getBody());
		Assertions.assertEquals(true, response.getBody().isEmpty());
	}
	
	@DisplayName("Should send empty array of products")
	@Test
	void productShouldSendEmptyWhenNoData() {
		ResponseEntity<List<ProductDO>> response = productController.getAll();
		System.out.println("Object returned:" + response.getBody());
		Assertions.assertEquals(true, response.getBody().isEmpty());
	}
}
