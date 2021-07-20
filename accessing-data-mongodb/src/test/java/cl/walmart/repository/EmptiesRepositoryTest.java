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

public class EmptiesRepositoryTest {
	
	MongoOperations mongoOperationsMock = Mockito.mock(MongoOperations.class);
	
	@Autowired
	DiscountRepository discountRepository = new DiscountRepositoryImpl(mongoOperationsMock);
	@Autowired
	ProductRepository productRepository = new ProductRepositoryImpl(mongoOperationsMock);
	
	@BeforeEach
	void setUp() {
		Mockito.when(mongoOperationsMock.find(new Query(), DiscountDO.class)).thenReturn(new ArrayList<DiscountDO>());
		Mockito.when(mongoOperationsMock.find(new Query(), ProductDO.class)).thenReturn(new ArrayList<ProductDO>());
		Mockito.when(mongoOperationsMock.findDistinct("brand", ProductDO.class, String.class)).thenReturn(new ArrayList<String>());
	}
	
	@DisplayName("Should send empty array of discounts")
	@Test
	void discountShouldSendEmptyWhenNoData() {
		Optional<List<DiscountDO>> response = discountRepository.findAll();
		System.out.println("Object returned size:" + response.get().size());
		Assertions.assertEquals(true, response.get().isEmpty());
	}
	
	@DisplayName("Should send empty array of products")
	@Test
	void productShouldSendEmptyWhenNoData() {
		Optional<List<ProductDO>> response = productRepository.findAll();
		System.out.println("Object returned:" + response.get().size());
		Assertions.assertEquals(true, response.get().isEmpty());
	}
	
	@DisplayName("Should send empty array of brands")
	@Test
	void brandsShouldSendEmptyWhenNoData() {
		Optional<List<String>> response = productRepository.findAllBrands();
		System.out.println("Object returned:" + response.get().size());
		Assertions.assertEquals(true, response.get().isEmpty());
	}
}
