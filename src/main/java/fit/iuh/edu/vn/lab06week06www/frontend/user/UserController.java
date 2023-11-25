package fit.iuh.edu.vn.lab06week06www.frontend.user;

import fit.iuh.edu.vn.lab06week06www.backend.modules.User;
import fit.iuh.edu.vn.lab06week06www.backend.responsitory.UserResponsitory;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserResponsitory userResponsitory;


    @GetMapping("/login")
    public String getlogin(Model model){
        model.addAttribute("acount",new User());
        return "user/login";
    }

    @GetMapping("/register")
    public String getregister(Model model){
        model.addAttribute("user",new User());
        return "user/register";
    }

    @PostMapping("/add")
    public String getAddUser(@ModelAttribute("user") User user){
        User user1 = new User(user.getFirstName(), user.getMiddleName(), user.getLastName(),
                "mobile", user.getEmail(), user.getPasswordHash(),
                Instant.now(),null, user.getIntro(), "");
        userResponsitory.save(user1);
        return "user/login";
    }

    @GetMapping("/login-action")
    public String getLoginAction(@ModelAttribute("acount") User user, HttpSession session){
        String url = "";
        Optional<User> optional = userResponsitory.getloginAcount(user.getEmail(),user.getPasswordHash());
        if(optional.isPresent()){
            session.setAttribute("userInfo",optional.get());
            url = "user/home";
        }else{
            url = "user/login";
        }
        return url;
    }

    @GetMapping("/logout")
    public String getLogout(HttpSession session){
//        session.removeAttribute("userInfo");
        return "redirect:/user/login";
    }

}
