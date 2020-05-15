package com.rikovicisah.app.ws.ui.controller;

import com.rikovicisah.app.ws.exceptions.UserServiceException;
import com.rikovicisah.app.ws.ui.model.response.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.rikovicisah.app.ws.service.impl.UserServiceImpl;
import com.rikovicisah.app.ws.shared.dto.UserDTO;
import com.rikovicisah.app.ws.ui.model.request.UserRequestModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users/v1")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;

	//Get All
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<UserResponseModel> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
										  @RequestParam(value = "limit", defaultValue = "25") int limit) {
		List<UserResponseModel> returnValue = new ArrayList<>();
		List<UserDTO> userDTOList = userService.getUsers(page, limit);

		for (UserDTO userDTO :
				userDTOList) {
			UserResponseModel responseModel = new UserResponseModel();
			BeanUtils.copyProperties(userDTO, responseModel);
			returnValue.add(responseModel);
		}

		return returnValue;
	}
	
	//Get User By Id
	@GetMapping(value = "/{id}",
				produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public UserResponseModel getUserById(@PathVariable("id") String id) {
		UserResponseModel returnValue = new UserResponseModel();
		UserDTO userDTO = userService.findByUserId(id);
		BeanUtils.copyProperties(userDTO, returnValue);
		return returnValue;
	}

	//Create User
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public UserResponseModel createUser(@RequestBody UserRequestModel userVOModel) throws Exception {
		UserResponseModel responseModel = new UserResponseModel();

		if(userVOModel.getFirstName().isEmpty())
			throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

		//UserDTO userDTO = new UserDTO();
		//BeanUtils.copyProperties(userVOModel, userDTO);
		ModelMapper modelMapper = new  ModelMapper();
		UserDTO userDTO = modelMapper.map(userVOModel, UserDTO.class);

		UserDTO createdUser = userService.createUser(userDTO);
//		BeanUtils.copyProperties(createdUser, responseModel);
		responseModel = modelMapper.map(createdUser, UserResponseModel.class);
		return responseModel;
	}
	
	//Delete User
	@DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public OperationStatusModel deleteUser(@PathVariable("id") String id) {
		OperationStatusModel statusModel = new OperationStatusModel();

		userService.deleteUser(id);

		statusModel.setOperationNamel(RequestOperationName.DELETE.name());
		statusModel.setOperationResult(RequestOperationStatus.SUCCESS.name());
		return statusModel;
	}
	
	//Update User
	@PutMapping(path = "/{id}",
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public UserResponseModel  updateUser(@PathVariable("id") String id, @RequestBody UserRequestModel userVOModel) {
		UserResponseModel returnValue = new UserResponseModel();

		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userVOModel, userDTO);

		UserDTO updatedUser = userService.updateUser(id, userDTO);
		BeanUtils.copyProperties(updatedUser, returnValue);
		return returnValue;
	}
	
	@PatchMapping
	public String updateColumnUser() {
		return "Update column user method was called";
	}
}
