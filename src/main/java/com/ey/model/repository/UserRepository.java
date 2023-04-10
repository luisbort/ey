package com.ey.model.repository;

import com.ey.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUserMail(String userMail);
}
