package com.example.html.repository;

import com.example.html.domain.UserHtml;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserHtml,Long> {
}
