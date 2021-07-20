package cl.walmart.repository;

import java.util.List;
import java.util.Optional;

import cl.walmart.model.ProductDO;

public interface ProductRepository {

	public Optional<List<String>> findAllBrands();
	public Optional<List<ProductDO>> findAll();

}
