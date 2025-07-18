package com.jaladhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaladhi.model.Swapping;
import com.jaladhi.service.SwappingServices;

@Controller
public class SwappingController {

	@Autowired
	SwappingServices service;
	
	@RequestMapping(value = "/swapping", method = RequestMethod.GET)
	public String showSwappingPage(ModelMap model) {
		return "swapping";
	}
	
	@RequestMapping(value = "/swapping", method = RequestMethod.POST)
	public String showSuccessPage(ModelMap model, @ModelAttribute Swapping swapping) {
		
		if(swapping.getFirstValue() > 0 ) {
			model.put("errorMessage", "First Value Should not be Null Value");
			return "swapping";
		} else if(swapping.getSecondValue() > 0) {
			model.put("errorMessage", "Second Value Should not be Null Value");
			return "swapping";
		}
		
		Swapping swap = null;
		
		if(swapping.getOperation().equals(SwappingServices.SINGLE_LINE)) {
			swap = service.singleLine(swapping.getFirstValue(), swapping.getSecondValue());
		} else if(swapping.getOperation().equals(SwappingServices.BIT_WISE_XOR)) {
			swap = service.bitWiseXor(swapping.getFirstValue(), swapping.getSecondValue());
		} else if(swapping.getOperation().equals(SwappingServices.MULTIPLE_DIVISION)) {
			swap = service.bitWiseXor(swapping.getFirstValue(), swapping.getSecondValue());
		} else if(swapping.getOperation().equals(SwappingServices.ADDITION_SUBTRACTION)) {
			swap = service.bitWiseXor(swapping.getFirstValue(), swapping.getSecondValue());
		} else if(swapping.getOperation().equals(SwappingServices.THIRD_VARIABLE)) {
			swap = service.bitWiseXor(swapping.getFirstValue(), swapping.getSecondValue());
		} else {
			model.put("errorMessage", "Operation Should not be Null Value");
			return "swapping";
		}
		
		model.put("firstValue", swap.getFirstValue());
		model.put("secondValue", swap.getSecondValue());
		model.put("operation", swap.getOperation());
		
		return "success";
	}
}
