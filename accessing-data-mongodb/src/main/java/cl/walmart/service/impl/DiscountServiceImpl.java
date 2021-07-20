package cl.walmart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.walmart.model.DiscountDO;
import cl.walmart.repository.DiscountRepository;
import cl.walmart.service.DiscountService;

@Service("discountService")
@Transactional
public class DiscountServiceImpl implements DiscountService{
	private DiscountRepository discountRepository;

    @Autowired
    public DiscountServiceImpl(DiscountRepository discountRepository){
        this.discountRepository = discountRepository;
    }

	@Override
	public List<DiscountDO> findAll() {
		Optional<List<DiscountDO>> discount = discountRepository.findAll();
        return discount.get(); 
	}

}
