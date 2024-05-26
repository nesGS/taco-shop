package com.nestor.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nestor.data.TacoRepository;
import com.nestor.model.Taco;

@RestController
@RequestMapping(path="/api", produces="application/json")
@CrossOrigin(origins="*")
public class TacoControllerApi {
	
	@Autowired
	private TacoRepository tacoRepo;
	
	
//	@GetMapping("/{id}")
//	public Taco tacoById(@PathVariable("id") Long id) {
//		Optional<Taco> optTaco = tacoRepo.findById(id);
//		if(optTaco.isPresent()) {
//			return optTaco.get();
//		}
//		return null;
//	}
	
	@GetMapping("/taco/{id}")
	public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
		Optional<Taco> optTaco = tacoRepo.findById(id);
		if(optTaco.isPresent()) {
			return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping(path="/taco", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Taco postTaco(@RequestBody Taco taco) {
		return tacoRepo.save(taco);
	}
	
	
	@GetMapping("/taco")
	public Iterable<Taco> allTacos(){
		return tacoRepo.findAll();
	}
	
	@PutMapping("/taco")
	public Taco updateTaco(@RequestBody Taco taco) {
		return tacoRepo.save(taco);
	}
	
	
	@GetMapping("/taco/recents/{pag}/{qtty}")
	public Iterable<Taco> recentTacos(@PathVariable("pag") int pag, @PathVariable("qtty") int qtty){
		PageRequest page = PageRequest.of(pag, qtty, Sort.by("createdAt").descending());
		return tacoRepo.findAll(page);
	}
	
}
