package com.witoraugusto.project.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.witoraugusto.project.entities.User;
import com.witoraugusto.project.repositories.UserRepository;
import com.witoraugusto.project.services.exceptions.DatabaseException;
import com.witoraugusto.project.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired // fazer injeção transparente
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();// buscar todos!
	}

	// retornando por ID
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		//return obj.get();
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	// inserir no bd
	public User insert(User obj) {
		return repository.save(obj);
	}

	// removendo item
	public void delete(Long id) {
		try {
		repository.deleteById(id);
	}catch(EmptyResultDataAccessException e) {
		throw new ResourceNotFoundException(id);
	}catch(DataIntegrityViolationException e) {
		throw new DatabaseException(e.getMessage());
	}
}

// atualizando dado
	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {			 
			 throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
