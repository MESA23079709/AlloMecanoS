package com.alibou.security.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
  void deleteUserById(Long id);

  Optional<User> findUserById(Long id);

}
