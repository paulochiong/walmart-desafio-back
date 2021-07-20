package cl.walmart.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.walmart.model.DiscountDO;
import cl.walmart.service.DiscountService;

@RestController
@RequestMapping("discounts")
public class DiscountController {
	private static final Log log = LogFactory.getLog(ProductController.class);

	private final DiscountService discountService;

	@Autowired
	public DiscountController(DiscountService discountService) {
		this.discountService = discountService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DiscountDO>> getAll() {
		log.info("Get allBrands");
		return ResponseEntity.ok(discountService.findAll());
	}
}
