package com.waracle.cake.controller;

import com.waracle.cake.domain.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.waracle.cake.repository.CakeRepository;

@Controller
public class CakeController {

	@Autowired
	private CakeRepository repository;

	@GetMapping(path = "/")
	public String getAllCakes() {
		return "index";
	}

	@ModelAttribute(name = "cakes")
	private Iterable<Cake> getCakes() {
		return repository.findAll();
	}
}
