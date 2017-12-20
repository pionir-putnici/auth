package com.hellokoding.auth.service;


import com.hellokoding.auth.model.VrsteMagacina;
//import com.hellokoding.auth.model.User;
//import com.hellokoding.auth.repository.RoleRepository;
//import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.repository.VrsteMagacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@Service
public class VrsteMagacinaServiceImpl implements VrsteMagacinaService {
    @Autowired
    private VrsteMagacinaRepository vrsteMagacinaRepository;
    
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<VrsteMagacina> getAllVrsteMagacina() {
		return vrsteMagacinaRepository.findAll();
	}    
    
    @Override
    public void save(VrsteMagacina vrsteMagacina) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        vrsteMagacinaRepository.save(vrsteMagacina);
    }

    @Override
    public VrsteMagacina findByName(String vrsteMagacina) {
        return vrsteMagacinaRepository.findByName(vrsteMagacina);
    }

	@Override
	public VrsteMagacina findByOne(Long id) {
		return vrsteMagacinaRepository.findOne(id);
	}
	
    public void delete(Long id)
    {
    	vrsteMagacinaRepository.delete(id);
    }
    
    @Override
    public void setVrsteMagacinaInfoById(String code, String name, Long id) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        vrsteMagacinaRepository.setVrsteMagacinaInfoById(code, name, id);
    }

}
