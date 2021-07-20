package cl.walmart.service;

import java.util.List;

import cl.walmart.model.DiscountDO;

public interface DiscountService {

	List<DiscountDO> findAll();
}
