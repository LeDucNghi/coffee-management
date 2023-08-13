package com.example.COFFEE.Repository;

import com.example.COFFEE.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Integer, UserAccount> {
    UserAccount findByUserName( String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
