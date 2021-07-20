package cl.walmart.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.walmart.service.BrandService;

@RestController
@RequestMapping("brands")
public class BrandController {
	private static final Log log = LogFactory.getLog(ProductController.class);

	private final BrandService brandService;

	@Autowired
	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}

	@RequestMapping(method = RequestMethod.GET)
	// @ApiOperation(value = "Find all brands", notes = "Return all brands" )
	public ResponseEntity<List<String>> getAll() {
		log.info("Get allBrands");
		return ResponseEntity.ok(brandService.findAll());
	}
}
