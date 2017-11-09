package com.poko.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poko.cloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
