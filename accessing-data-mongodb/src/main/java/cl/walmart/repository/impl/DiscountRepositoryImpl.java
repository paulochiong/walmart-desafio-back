package cl.walmart.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import cl.walmart.model.DiscountDO;
import cl.walmart.repository.DiscountRepository;

@Repository
public class DiscountRepositoryImpl implements DiscountRepository {
	private final MongoOperations mongoOperations;

	@Autowired
	public DiscountRepositoryImpl(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public Optional<List<DiscountDO>> findAll() {
		List<DiscountDO> descuentos = this.mongoOperations.find(new Query(), DiscountDO.class);
		Optional<List<DiscountDO>> optionalDescuentos = Optional.ofNullable(descuentos);
		return optionalDescuentos;
	}

}
