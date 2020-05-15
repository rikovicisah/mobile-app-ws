package com.rikovicisah.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rikovicisah.app.ws.shared.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService extends UserDetailsService{
	UserDTO createUser(UserDTO userDTO);
	UserDTO getUserDTO(String email);
	UserDTO getUserById(long id);
	UserDTO findByUserId(String id);
    UserDTO updateUser(String id, UserDTO userDTO);
    void deleteUser(String id);
	List<UserDTO> getUsers(int page, int limit);
}
