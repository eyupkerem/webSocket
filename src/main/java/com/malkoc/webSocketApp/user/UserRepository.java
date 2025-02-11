package com.malkoc.webSocketApp.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,String> {
    List<Users> findByStatus(Status status);
    Optional<Users> findByFullName(String senderId);
}
