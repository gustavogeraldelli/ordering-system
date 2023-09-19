package com.gustavogeraldelli.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gustavogeraldelli.course.entities.User;
import com.gustavogeraldelli.course.repositories.UserRepository;
import com.gustavogeraldelli.course.services.exceptions.DatabaseException;
import com.gustavogeraldelli.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User u) {
		return userRepository.save(u);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User u) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity, u);
			return userRepository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User u) {
		entity.setName(u.getName());
		entity.setEmail(u.getEmail());
		entity.setPhone(u.getPhone());
	}
}
