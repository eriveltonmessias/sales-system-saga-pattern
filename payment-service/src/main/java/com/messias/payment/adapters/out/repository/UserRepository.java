package com.messias.payment.adapters.out.repository;

import com.messias.payment.adapters.out.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
