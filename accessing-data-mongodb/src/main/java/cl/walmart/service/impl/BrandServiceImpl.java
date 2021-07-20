package cl.walmart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.walmart.repository.ProductRepository;
import cl.walmart.service.BrandService;

@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {

    private ProductRepository productRepository;

    @Autowired
    public BrandServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

	@Override
	public List<String> findAll() {
		Optional<List<String>> product = productRepository.findAllBrands();
        return product.get(); 
	}


}
