package app.auth.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Controller
public class UserController {

    @GetMapping("/signUp")
    public String SignUp(){
        return "Sign Up Route";
    }

    @GetMapping("/signIn")
    public String SignIn(){
        return "Sign In Route";
    }
}
