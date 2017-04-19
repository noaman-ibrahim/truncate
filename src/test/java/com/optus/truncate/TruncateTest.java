package com.optus.truncate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.optus.truncate.controller.SubscriptionController;
import com.optus.truncate.util.TruncatePattern;
import com.optus.truncate.util.Truncator;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TruncateTest {

	@Autowired
	TruncatePattern truncatePattern;
	
	@Autowired
	Truncator truncator;
	
	@Autowired
	SubscriptionController controller;

	@Test
	public void testDataLargerThanMaxCharacters() {
		
		String result = controller.truncate("123456789012345678901234567890", 25);
		Assert.assertEquals("12 ... (truncated) ... 90", result);
	}
	
	@Test
	public void testDataSmallerThanMaxCharacters() {
		
		String result = controller.truncate("123456789012345678901234567890", 31);
		Assert.assertEquals("123456789012345678901234567890", result);
	}
	
	@Test
	public void testDataEqualToMaxCharacters() {
		
		String result = controller.truncate("123456789012345678901234567890", 30);
		Assert.assertEquals("123456789012345678901234567890", result);
	}
	
	@Test
	public void testOthers() {
		
		String result = controller.truncate("123456789012345678901234567890", 26);
		Assert.assertEquals("123 ... (truncated) ... 90", result);
		
		result = controller.truncate(null, 26);
		Assert.assertEquals(null, result);
		
		result = controller.truncate("1234567890", 5);
		Assert.assertEquals("1234567890", result);
		
		result = controller.truncate("", 1);
		Assert.assertEquals("", result);
		
		result = controller.truncate("12345678901234567890123", 21);
		Assert.assertEquals("12345678901234567890123", result);
		
		result = controller.truncate("12345678901234567890123", 22);
		Assert.assertEquals("12345678901234567890123", result);
		
		result = controller.truncate("12345678901234567890123", 23);
		Assert.assertEquals("12345678901234567890123", result);
		
		result = controller.truncate("123456789012345678901234", 23);
		Assert.assertEquals("1 ... (truncated) ... 4", result);
		
	}

}