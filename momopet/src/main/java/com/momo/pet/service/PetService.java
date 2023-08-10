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
	
	public void signup(String userId, String petType, String petName, 
					   String petSex, String petBreed, String petBirth,
					   String petRemarks) throws AddException {
		try {
			repository.insert(userId, petType, petName, petSex, petBreed, petBirth, petRemarks);
		} catch (AddException e) {
			throw new AddException("펫등록 실패");
		} 
	}
	
	
}
