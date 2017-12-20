package com.hellokoding.auth.service;


import com.hellokoding.auth.model.PoreskeGrupe;
//import com.hellokoding.auth.model.User;
//import com.hellokoding.auth.repository.RoleRepository;
//import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.repository.PoreskeGrupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@Service
public class PoreskeGrupeServiceImpl implements PoreskeGrupeService {
    @Autowired
    private PoreskeGrupeRepository poreskeGrupeRepository;
    
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<PoreskeGrupe> getAllPoreskeGrupe() {
		return poreskeGrupeRepository.findAll();
	}    
    
    @Override
    public void save(PoreskeGrupe poreskeGrupe) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        poreskeGrupeRepository.save(poreskeGrupe);
    }

    @Override
    public PoreskeGrupe findByName(String poreskeGrupe) {
        return poreskeGrupeRepository.findByName(poreskeGrupe);
    }

	@Override
	public PoreskeGrupe findByOne(Long id) {
		return poreskeGrupeRepository.findOne(id);
	}
	
    public void delete(Long id)
    {
    	poreskeGrupeRepository.delete(id);
    }

}
