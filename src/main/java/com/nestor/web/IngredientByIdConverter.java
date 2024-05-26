package com.nestor.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.nestor.data.IngredientRepository;
import com.nestor.model.Ingredient;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

	@Autowired
	IngredientRepository ingredientRepo;
	
	@Override
	public Ingredient convert(String source) {
		Optional<Ingredient> optIngredient = ingredientRepo.findById(source);
		
		if(optIngredient.isPresent()) {
			return optIngredient.get();
		}
		return null;
	}

}
