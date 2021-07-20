package cl.walmart.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import cl.walmart.model.DiscountDO;
import cl.walmart.model.ProductDO;
import cl.walmart.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private final MongoOperations mongoOperations;

	@Autowired
	public ProductRepositoryImpl(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public Optional<List<ProductDO>> findAll() {
		List<ProductDO> productos = this.mongoOperations.find(new Query(), ProductDO.class);
		List<DiscountDO> descuentos = this.mongoOperations.find(new Query(), DiscountDO.class);
		Map<String,DiscountDO> descuentosMap = descuentos.stream()
			      .collect(Collectors.toMap(DiscountDO::getBrand, Function.identity()));
		for (ProductDO producto : productos) {
			producto.setDiscount(descuentosMap.get(producto.getBrand()));
		}
		Optional<List<ProductDO>> optionalProductos = Optional.ofNullable(productos);
		return optionalProductos;
	}

	@Override
	public Optional<List<String>> findAllBrands() {
		List<String> marcas = this.mongoOperations.findDistinct("brand", ProductDO.class, String.class);
		Optional<List<String>> optionalMarcas = Optional.ofNullable(marcas);
		return optionalMarcas;
	}

}
