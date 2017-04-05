package au.com.ausland.ausland_application.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import au.com.ausland.ausland_application.dao.AuslandUserRepository;
 
import au.com.ausland.ausland_application.model.AuslandUser;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);
    
    @Autowired
    private AuslandUserRepository auslandUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.debug("Authenticating user with username=" + username);
        AuslandUser user = auslandUserRepository.findByUsername(username);
        return new User(user.getUsername(),user.getPassword(), user.getActive(),user.getActive(),user.getActive(),
        user.getActive(), null);
    }

}
