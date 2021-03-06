package br.com.yuri.cavalcante.tcc.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.yuri.cavalcante.tcc.domain.ApplicationDomain;
import br.com.yuri.cavalcante.tcc.services.ApplicationDomainService;

@RestController
@RequestMapping(value = "/applicationDomains")
public class ApplicationDomainController {
	
	//only admins can CREATE, UPDATE and DELETE the applicationDomains, commom user can just get them.
	
	@Autowired
	private ApplicationDomainService applicationDomainService;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ApplicationDomain applicationDomain){
	
		applicationDomain = applicationDomainService.insert(applicationDomain);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(applicationDomain.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<ApplicationDomain>> findAll(){
		
		List<ApplicationDomain> applicationDomainList = new ArrayList<>();
		applicationDomainList = applicationDomainService.findAll();
		
		return ResponseEntity.ok().body(applicationDomainList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ApplicationDomain> find(@PathVariable Integer id){
		
		ApplicationDomain applicationDomain = applicationDomainService.find(id);
		return ResponseEntity.ok().body(applicationDomain);
		
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody ApplicationDomain applicationDomain, @PathVariable Integer id){
		
		applicationDomain.setId(id);
		applicationDomain = applicationDomainService.update(applicationDomain);
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		applicationDomainService.delete(id);
		return ResponseEntity.noContent().build();
	}
	}
