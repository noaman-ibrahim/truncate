package com.optus.truncate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.optus.truncate.util.TruncatePattern;
import com.optus.truncate.util.Truncator;

/**
 * Demo controller.
 */
@RestController
public class SubscriptionController {
	
	@Autowired
	TruncatePattern truncatePattern;
	
	@Autowired
	Truncator truncator;
	
	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public String subscribe(HttpServletRequest request) {
	
//		String orderDetails = getOrderDetails(request);
	
		// truncate method should be called by the controller end point as follows.
//		String truncatedOrderDetails = truncate(orderDetails, 250);
		
//		log(truncatedOrderDetails);	

		return "";
	}
	
	// Declaring this method as public to unit test it without the controller endPoint.
	public String truncate(String data, int maxCharacters){
		
		return truncator.truncate(data, maxCharacters, truncatePattern);		
	}

}
