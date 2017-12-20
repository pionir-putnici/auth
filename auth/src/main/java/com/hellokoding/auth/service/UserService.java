package com.hellokoding.auth.service;

import java.util.List;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.VrsteArtikala;

public interface UserService {
	
    void save(User user);

    User findByUsername(String username);
    
    public List<User> getAllUsers();
}
