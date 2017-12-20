package com.hellokoding.auth.service;


import com.hellokoding.auth.model.VrsteArtikala;
//import com.hellokoding.auth.model.User;
//import com.hellokoding.auth.repository.RoleRepository;
//import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.repository.VrsteArtikalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@Service
public class VrsteArtikalaServiceImpl implements VrsteArtikalaService {
    @Autowired
    private VrsteArtikalaRepository vrsteArtikalaRepository;
    
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<VrsteArtikala> getAllVrsteArtikala() {
		return vrsteArtikalaRepository.findAll();
	}    
    
    @Override
    public void save(VrsteArtikala vrsteArtikala) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        vrsteArtikalaRepository.save(vrsteArtikala);
    }

    @Override
    public VrsteArtikala findByName(String vrsteArtikala) {
        return vrsteArtikalaRepository.findByName(vrsteArtikala);
    }

	@Override
	public VrsteArtikala findByOne(Long id) {
		return vrsteArtikalaRepository.findOne(id);
	}
	
    public void delete(Long id)
    {
    	vrsteArtikalaRepository.delete(id);
    }

}
