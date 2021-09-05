package by.kalesnikau.petmilitaryunit.service;


import by.kalesnikau.petmilitaryunit.model.AuthorityEntity;
import by.kalesnikau.petmilitaryunit.model.UserEntity;
import by.kalesnikau.petmilitaryunit.repository.AuthorityRepository;
import by.kalesnikau.petmilitaryunit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MainUserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         return userRepository.findByUsername(username)
                         .orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
    }

    public void registerUser(UserEntity user) {
        userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public List<AuthorityEntity> getAllAuthorities() {
        return authorityRepository.findAll();
    }


}
