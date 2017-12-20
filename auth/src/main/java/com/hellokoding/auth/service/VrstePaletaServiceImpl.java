package com.hellokoding.auth.service;


import com.hellokoding.auth.model.VrstePaleta;
//import com.hellokoding.auth.model.User;
//import com.hellokoding.auth.repository.RoleRepository;
//import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.repository.VrstePaletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@Service
public class VrstePaletaServiceImpl implements VrstePaletaService {
    @Autowired
    private VrstePaletaRepository vrstePaletaRepository;
    
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;



	@Override
	public List<VrstePaleta> getAllVrstePaleta() {
		return vrstePaletaRepository.findAll();
	}    
    
    @Override
    public void save(VrstePaleta vrstePaleta) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        vrstePaletaRepository.save(vrstePaleta);
    }

    @Override
    public VrstePaleta findByName(String vrstePaleta) {
        return vrstePaletaRepository.findByName(vrstePaleta);
    }

	@Override
	public VrstePaleta findByOne(Long id) {
		return vrstePaletaRepository.findOne(id);
	}
	
    public void delete(Long id)
    {
    	vrstePaletaRepository.delete(id);
    }

}
