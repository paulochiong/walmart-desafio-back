package cl.walmart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import cl.walmart.model.DiscountDO;
import cl.walmart.model.ProductDO;
import cl.walmart.repository.DiscountRepository;
import cl.walmart.repository.ProductRepository;
import cl.walmart.service.impl.BrandServiceImpl;
import cl.walmart.service.impl.DiscountServiceImpl;
import cl.walmart.service.impl.ProductServiceImpl;

public class EmptiesServiceTest {

	ProductRepository productRepositoryMock = Mockito.mock(ProductRepository.class);
	DiscountRepository discountRepositoryMock = Mockito.mock(DiscountRepository.class);
	
	@Autowired
	BrandService brandService = new BrandServiceImpl(productRepositoryMock);
	@Autowired
	DiscountService discountService = new DiscountServiceImpl(discountRepositoryMock);
	@Autowired
	ProductService productService = new ProductServiceImpl(productRepositoryMock);
	
	@BeforeEach
	void setUp() {
		Optional<List<ProductDO>> opProd = Optional.ofNullable(new ArrayList<ProductDO>());
		Optional<List<DiscountDO>> opDisc = Optional.ofNullable(new ArrayList<DiscountDO>());
		Optional<List<String>> opStr = Optional.ofNullable(new ArrayList<String>());
		Mockito.when(productRepositoryMock.findAll()).thenReturn(opProd);
		Mockito.when(discountRepositoryMock.findAll()).thenReturn(opDisc);
		Mockito.when(productRepositoryMock.findAllBrands()).thenReturn(opStr);
	}
	
	@DisplayName("Should send empty array of brands")
	@Test
	void brandShouldSendEmptyWhenNoData() {
		List<String> response = brandService.findAll();
		System.out.println("Object returned size:" + response.size());
		Assertions.assertEquals(true, response.isEmpty());
	}
	
	@DisplayName("Should send empty array of discounts")
	@Test
	void discountShouldSendEmptyWhenNoData() {
		List<DiscountDO> response = discountService.findAll();
		System.out.println("Object returned size:" + response.size());
		Assertions.assertEquals(true, response.isEmpty());
	}
	
	@DisplayName("Should send empty array of products")
	@Test
	void productShouldSendEmptyWhenNoData() {
		List<ProductDO> response = productService.findAll();
		System.out.println("Object returned:" + response.size());
		Assertions.assertEquals(true, response.isEmpty());
	}
}
