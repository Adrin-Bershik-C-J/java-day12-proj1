package com.example.IssueTrackerORM.service;

import java.util.List;
import com.example.IssueTrackerORM.domain.User;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);
}
