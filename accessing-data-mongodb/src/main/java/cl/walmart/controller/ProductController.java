package cl.walmart.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.walmart.model.ProductDO;
import cl.walmart.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	private static final Log log = LogFactory.getLog(ProductController.class);

	private final ProductService productsService;

	@Autowired
	public ProductController(ProductService productsService) {
		this.productsService = productsService;
	}

	@RequestMapping(method = RequestMethod.GET)
	// @ApiOperation(value = "Find all brands", notes = "Return all brands" )
	public ResponseEntity<List<ProductDO>> getAll() {
		log.info("Get allBrands");
		return ResponseEntity.ok(productsService.findAll());
	}
}
