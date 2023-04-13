package com.ey.model.repository;

import com.ey.model.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUserMail(String userMail);

    @Modifying
    @Query(value = "update User u " +
            "set u.userName = :userName, u.userMail = :userMail, u.userPasswd = :userPasswd, u.dateUpdate = :dateUpdate " +
            "where u.userId = :userId")
    public int updateUser(@Param("userName") String userName,
                          @Param("userMail") String userMail,
                          @Param("userPasswd") String userPasswd,
                          @Param("dateUpdate") Date dateUpdate,
                          @Param("userId") Integer userId);

    public Optional<User> findOneByUserMail(String userEmail);

    @Modifying
    @Query(value = "update User u set u.dateUpdate = :dateUpdate where u.userId = :userId")
    public int updateDateLastLogin(@Param("dateUpdate") Date dateUpdate, @Param("userId") Integer userId);
}
