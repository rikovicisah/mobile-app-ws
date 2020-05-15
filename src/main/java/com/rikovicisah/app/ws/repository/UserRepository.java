package com.rikovicisah.app.ws.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rikovicisah.app.ws.model.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
	List<UserEntity> findByFirstName(String firstName);
	UserEntity findByUserId(String id);
    void delete(UserEntity userEntity);
}
