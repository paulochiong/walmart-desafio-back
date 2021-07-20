package cl.walmart.repository;

import java.util.List;
import java.util.Optional;

import cl.walmart.model.DiscountDO;

public interface DiscountRepository {
	
	public Optional<List<DiscountDO>> findAll();

}
