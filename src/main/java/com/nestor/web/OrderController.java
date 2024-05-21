package com.nestor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SimpleSessionStatus;

import com.nestor.data.OrderRepository;
import com.nestor.model.Order;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

	@Autowired
	OrderRepository orderRepo;
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid @ModelAttribute(name="order") Order order, Errors errors, SessionStatus sessionStatus) {
		
		if(errors.hasErrors()) {
			log.info("Orden recibida inválida: " + order);
		}
		
		orderRepo.save(order);
		
		log.info("Orden recibida: " + order);
		return "redirect:/";
	}
}
