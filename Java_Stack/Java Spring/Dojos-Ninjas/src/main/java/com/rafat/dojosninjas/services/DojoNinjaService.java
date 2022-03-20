package com.rafat.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rafat.dojosninjas.models.Dojo;
import com.rafat.dojosninjas.models.Ninja;
import com.rafat.dojosninjas.repositories.DojoRepo;
import com.rafat.dojosninjas.repositories.NinjaRepo;

@Service
public class DojoNinjaService {
	// Attributes
	private final DojoRepo dRepo;
	private final NinjaRepo nRepo;
	
	// Constructors
	public DojoNinjaService(DojoRepo dRepo, NinjaRepo nRepo) {
		this.dRepo = dRepo;
		this.nRepo = nRepo;
	}
	
	public List<Dojo> getAllDojos(){
		return dRepo.findAll();
	}
	public List<Ninja> getAllNinjas() {
		return nRepo.findAll();
	}
	
	// SELECT * FROM " " WHERE id
	public Dojo findDojoById(Long id) {
		Optional<Dojo> dojo = dRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}else {
			return null;
		}
	}
	public Ninja findNinja(Long id) {
		// Optional to determine existence
		Optional<Ninja> oNinja = nRepo.findById(id);
		if(oNinja.isPresent()) {
			return oNinja.get();
		} else {
			return null;
		}
	}
	
	// INSERT INTO
	public void createNinja(Ninja ninja) {
		nRepo.save(ninja);
	}
	public void createDojo(Dojo dojo) {
		dRepo.save(dojo);
	}
}
