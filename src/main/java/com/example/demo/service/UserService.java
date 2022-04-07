package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


public interface UserService{
    User create(User user);

    User getCurrentUser();
}
