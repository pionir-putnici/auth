package com.hellokoding.auth.service;


import com.hellokoding.auth.model.JediniceMera;
//import com.hellokoding.auth.model.User;
//import com.hellokoding.auth.repository.RoleRepository;
//import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.repository.JediniceMeraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@Service
public class JediniceMeraServiceImpl implements JediniceMeraService {
    @Autowired
    private JediniceMeraRepository jediniceMeraRepository;
    
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<JediniceMera> getAllJediniceMera() {
		return jediniceMeraRepository.findAll();
	}    
    
    @Override
    public void save(JediniceMera jediniceMera) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        jediniceMeraRepository.save(jediniceMera);
    }

    @Override
    public JediniceMera findByName(String jediniceMera) {
        return jediniceMeraRepository.findByName(jediniceMera);
    }

	@Override
	public JediniceMera findByOne(Long id) {
		return jediniceMeraRepository.findOne(id);
	}
	
    public void delete(Long id)
    {
    	jediniceMeraRepository.delete(id);
    }

}
