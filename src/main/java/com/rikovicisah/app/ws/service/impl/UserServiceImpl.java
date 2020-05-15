package com.rikovicisah.app.ws.service.impl;

import com.rikovicisah.app.ws.exceptions.UserServiceException;
import com.rikovicisah.app.ws.shared.dto.AddressDTO;
import com.rikovicisah.app.ws.ui.model.response.ErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rikovicisah.app.ws.model.UserEntity;
import com.rikovicisah.app.ws.repository.UserRepository;
import com.rikovicisah.app.ws.service.UserService;
import com.rikovicisah.app.ws.shared.dto.UserDTO;
import com.rikovicisah.app.ws.shared.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDTO createUser(UserDTO userDTO) {

		UserEntity userEntity = new UserEntity();
		ModelMapper modelMapper = new  ModelMapper();

		for (int i = 0; i < userDTO.getAddresses().size(); i++) {
			AddressDTO addressDTO = userDTO.getAddresses().get(i);
			addressDTO.setAddressId(utils.generateAddressId(30));
			addressDTO.setUserDetails(userDTO);
			userDTO.getAddresses().set(i, addressDTO);
		}

		//BeanUtils.copyProperties(userDTO, userEntity);
		userEntity = modelMapper.map(userDTO, UserEntity.class);

		userEntity.setUserId(utils.generateUserId(30));
		userEntity.setEncriptedPass(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		UserDTO returnValue = modelMapper.map(storedUserDetails, UserDTO.class);

		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		return new User(userEntity.getEmail(), userEntity.getEncriptedPass(), new ArrayList<>());
	}

	@Override
	public UserDTO getUserDTO(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

	@Override
	public UserDTO getUserById(long id) {
		return null;
	}

	@Override
	public UserDTO findByUserId(String id) {
		Optional<UserEntity> userEntity = Optional.ofNullable(userRepository.findByUserId(id));
		if(userEntity.isEmpty()) throw new UsernameNotFoundException(id);
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(userEntity.get(), returnValue);
		return returnValue;
	}

	@Override
	public UserDTO updateUser(String id, UserDTO userDTO) {
		UserDTO returnValue = new UserDTO();
		Optional<UserEntity> userEntity = Optional.ofNullable(userRepository.findByUserId(id));

		if(userEntity.isEmpty()) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		userEntity.get().setFirstName(userDTO.getFirstName());
		userEntity.get().setLastName(userDTO.getLastName());
		userEntity.get().setEmail(userDTO.getEmail());
		UserEntity updatedUser = userRepository.save(userEntity.get());
		BeanUtils.copyProperties(updatedUser, returnValue);
		return returnValue;
	}

	@Override
	public void deleteUser(String id) {
		UserEntity userEntity = userRepository.findByUserId(id);
		if(userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		userRepository.delete(userEntity);
	}

	@Override
	public List<UserDTO> getUsers(int page, int limit) {
		List<UserDTO> returnValue = new ArrayList<>();
		if(page > 0) page -= 1;
		Pageable pageable = PageRequest.of(page, limit);
		Page<UserEntity> usersPage = userRepository.findAll(pageable);
		List<UserEntity> users = usersPage.getContent();

		for (UserEntity userEntity :
				users) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(userEntity, userDTO);
			returnValue.add(userDTO);
		}

		return returnValue;
	}


}
