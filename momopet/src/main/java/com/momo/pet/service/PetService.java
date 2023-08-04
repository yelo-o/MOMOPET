package com.momo.pet.service;


import com.momo.exception.AddException;
import com.momo.pet.dao.PetRepository;
import com.momo.pet.dto.Pet;

public class PetService {
	private static PetService service = new PetService();
	private PetRepository repository;

	private PetService() {
		repository = new PetRepository();
	}
	public static PetService getInstance() {
		return service;
	}
	
	public void signup(Pet p) throws AddException {
		try {
			repository.insert(p);
		} catch (AddException e) {
			throw new AddException("펫등록 실패");
		} 
	}
	
	
}
