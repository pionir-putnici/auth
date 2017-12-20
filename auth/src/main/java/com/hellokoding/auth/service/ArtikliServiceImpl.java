package com.hellokoding.auth.service;


import com.hellokoding.auth.model.Artikli;
//import com.hellokoding.auth.model.User;
//import com.hellokoding.auth.repository.RoleRepository;
//import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.repository.ArtikliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@Service
public class ArtikliServiceImpl implements ArtikliService {
    @Autowired
    private ArtikliRepository artikliRepository;
    
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<Artikli> getAllArtikli() {
		return artikliRepository.findAll();
	}    
    
    @Override
    public void save(Artikli artikli) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        artikliRepository.save(artikli);
    }

    @Override
    public Artikli findByName(String artikli) {
        return artikliRepository.findByName(artikli);
    }

	@Override
	public Artikli findByOne(Long id) {
		return artikliRepository.findOne(id);
	}
	
    public void delete(Long id)
    {
    	artikliRepository.delete(id);
    }

}
