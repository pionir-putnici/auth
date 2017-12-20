package com.hellokoding.auth.service;


import com.hellokoding.auth.model.Klasifikacije;
//import com.hellokoding.auth.model.User;
//import com.hellokoding.auth.repository.RoleRepository;
//import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.repository.KlasifikacijeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@Service
public class KlasifikacijeServiceImpl implements KlasifikacijeService {
    @Autowired
    private KlasifikacijeRepository klasifikacijeRepository;
    
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<Klasifikacije> getAllKlasifikacije() {
		return klasifikacijeRepository.findAll();
	}    



    @Override
    public void save(Klasifikacije klasifikacije) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        klasifikacijeRepository.save(klasifikacije);

    }

    @Override
    public Klasifikacije findByName(String klasifikacije) {
        return klasifikacijeRepository.findByName(klasifikacije);
    }

	@Override
	public Klasifikacije findByOne(Long id) {
		return klasifikacijeRepository.findOne(id);
	}
	
    public void delete(Long id)
    {
    	klasifikacijeRepository.delete(id);
    }






	@Override
	public List<Klasifikacije> getAllKlasifikacijeOrderByCode() {
		// TODO Auto-generated method stub
		return null;
	}
    


}
