package com.nestor.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nestor.model.Order;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid @ModelAttribute(name="order") Order order, Errors errors) {
		
		if(errors.hasErrors()) {
			log.info("Orden recibida inválida: " + order);
		}
		log.info("Orden recibida: " + order);
		return "redirect:/";
	}
}
