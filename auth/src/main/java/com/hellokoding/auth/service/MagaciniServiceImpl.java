package com.hellokoding.auth.service;


import com.hellokoding.auth.model.Magacini;
//import com.hellokoding.auth.model.User;
//import com.hellokoding.auth.repository.RoleRepository;
//import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.repository.MagaciniRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class MagaciniServiceImpl implements MagaciniService {
    @Autowired
    private MagaciniRepository magaciniRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//	@Autowired
//	private EmployeeRepository employeeRepository;

	@Override
	public List<Magacini> getAllMagacini() {
		return magaciniRepository.findAll();
	}    
    
    @Override
    public void save(Magacini magacini) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
    	magaciniRepository.save(magacini);
    }

    @Override
    public Magacini findByName(String magacini) {
        return magaciniRepository.findByName(magacini);
    }

	@Override
	public Magacini findByOne(Long id) {
		return magaciniRepository.findOne(id);
	}
	
//    public void delete(VrstePaleta vrstePaleta) {
////      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
////      user.setRoles(new HashSet<>(roleRepository.findAll()));
//      vrstePaletaRepository.delete(vrstePaleta);
//  }	
    

    public void delete(Long id)
    {
    	magaciniRepository.delete(id);
    }
    
	@Override
	public List<Magacini> findMagacinisWithoutRelations() {
		return magaciniRepository.findMagacinisWithoutRelations();		
	}

	@Override
	public List<Magacini> findInterniObjekti() {
		return magaciniRepository.findInterniObjekti();		
	}

	
//	@Override
//	public List<Magacini> rptMagacini() {
//		return magaciniRepository.rtpMagacini();
//	}
    

}
