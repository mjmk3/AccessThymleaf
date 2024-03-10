package app.auth.Controller;

import app.auth.Domain.User;
import app.auth.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signUp")
    public String SignUp(Model model){
        model.addAttribute("signUpRequest", new User());
        return "sign_Up";
    }

    @GetMapping("/signIn")
    public String SignIn(Model model){
        model.addAttribute("signInRequest", new User());
        return "sign_In";
    }

    @PostMapping("/signUp")
    public String SignUp(@ModelAttribute User user){
        System.out.println("SignUp Request" + user);
        User signedUp = userService.SignUp(user.getPhone(), user.getPassword());
        return signedUp == null ? "error" : "redirect/signIn";
    }
}
