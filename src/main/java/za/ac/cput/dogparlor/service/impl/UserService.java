package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.config.UserInfoUserDetails;
import za.ac.cput.dogparlor.domain.User;
import za.ac.cput.dogparlor.repository.UserRepository;
import za.ac.cput.dogparlor.service.IService;

import java.util.Optional;

@Service
public class UserService implements IService<User, String>, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User read(String username) {
        return repository.findById(username).orElse(null);
    }

    @Override
    public User update(User user) {
        if (repository.existsById(user.getUsername()))
            return repository.save(user);
        return null;
    }

    @Override
    public boolean delete(String username) {
        if (repository.existsById(username)) {
            repository.deleteById(username);
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("We are here now");
        Optional<User> userInfo = repository.findByUsername(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
    }
}
