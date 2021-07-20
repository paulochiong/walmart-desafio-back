package cl.walmart.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import cl.walmart.model.DiscountDO;
import cl.walmart.model.ProductDO;
import cl.walmart.repository.impl.DiscountRepositoryImpl;
import cl.walmart.repository.impl.ProductRepositoryImpl;

public class NotEmptyRepositoryTest {
	
	MongoOperations mongoOperationsMock = Mockito.mock(MongoOperations.class);
	
	@Autowired
	DiscountRepository discountRepository = new DiscountRepositoryImpl(mongoOperationsMock);
	@Autowired
	ProductRepository productRepository = new ProductRepositoryImpl(mongoOperationsMock);
	
	@BeforeEach
	void setUp() {
		List<DiscountDO> discountMock = new ArrayList<DiscountDO>();
		DiscountDO discount = new DiscountDO();
		discount.setBrand("Marca1");
		discount.setDiscount(500);
		discount.setThreshold(5000);
		discountMock.add(discount);
		List<ProductDO> productMock = new ArrayList<ProductDO>();
		ProductDO product = new ProductDO();
		product.setId(1);
		product.setBrand("Marca1");
		product.setDescription("TestUnit");
		product.setImage("TestUnit.img");
		product.setPrice(600);
		product.setDiscount(new DiscountDO());
		productMock.add(product);
		List<String> brandMock = new ArrayList<String>();
		brandMock.add("Marca1");
		Mockito.when(mongoOperationsMock.find(new Query(), DiscountDO.class)).thenReturn(discountMock);
		Mockito.when(mongoOperationsMock.find(new Query(), ProductDO.class)).thenReturn(productMock);
		Mockito.when(mongoOperationsMock.findDistinct("brand", ProductDO.class, String.class)).thenReturn(brandMock);
	}
	
	@DisplayName("Should send array of discounts")
	@Test
	void discountShouldSendEmptyWhenNoData() {
		Optional<List<DiscountDO>> response = discountRepository.findAll();
		System.out.println("Object returned size:" + response.get().size());
		Assertions.assertEquals(false, response.get().isEmpty());
	}
	
	@DisplayName("Should send array of products")
	@Test
	void productShouldSendEmptyWhenNoData() {
		Optional<List<ProductDO>> response = productRepository.findAll();
		System.out.println("Object returned:" + response.get().size());
		Assertions.assertEquals(false, response.get().isEmpty());
	}
	
	@DisplayName("Should send array of brands")
	@Test
	void brandsShouldSendEmptyWhenNoData() {
		Optional<List<String>> response = productRepository.findAllBrands();
		System.out.println("Object returned:" + response.get().size());
		Assertions.assertEquals(false, response.get().isEmpty());
	}
}
