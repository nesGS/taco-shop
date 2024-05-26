package com.nestor.data;

import org.springframework.data.repository.CrudRepository;

import com.nestor.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
