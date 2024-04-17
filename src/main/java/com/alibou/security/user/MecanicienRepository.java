package com.alibou.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MecanicienRepository extends JpaRepository<Mecanicien, Long > {
    void deleteMecanicienById(Long id);

    Optional<Mecanicien> findMecanicienById(Long id);
}
