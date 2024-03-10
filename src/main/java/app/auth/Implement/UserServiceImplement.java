package app.auth.Implement;

import app.auth.Domain.User;
import app.auth.Repo.UserRepo;
import app.auth.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Service
@Transactional
public class UserServiceImplement implements UserService {

    private final UserRepo userRepo;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImplement(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User SignUp(String phone, String password){
        if(phone == null || password == null){
            return null;
        } else {
            User user = new User();
            user.setPhone(phone);
            user.setPassword(passwordEncoder.encode(password));
            return userRepo.save(user);
        }
    }
}
