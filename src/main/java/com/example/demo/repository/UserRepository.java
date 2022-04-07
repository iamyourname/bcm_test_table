package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> findByLogin(@Param("login") String login);

}
