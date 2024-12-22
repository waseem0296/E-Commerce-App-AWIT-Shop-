package com.AWIT.shop.Repository;

import com.AWIT.shop.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    Boolean existsByEmail(String email);
}
