package org.udea.proint1.ms.producto_backend.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.udea.proint1.ms.producto_backend.dto.Product;
import org.udea.proint1.ms.producto_backend.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ProductRestController {
	
	private final static Logger logger = LoggerFactory.getLogger(ProductRestController.class);
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/find")
	@ResponseBody
	public Product getProduct( String code) {
		logger.info("Ingresó al metodo find con code " + code);
		Product product = new Product();
		product = productDAO.findByCode(code);
		return product;
	
	}
	
	@RequestMapping (method = RequestMethod.POST, value ="/save")
	@ResponseBody
	public String setProduct( @RequestBody Product product) {
		productDAO.save(product);
		logger.info("Producto guardado");
		return "Done!";
	
	}
}
