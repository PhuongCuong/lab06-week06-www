package fit.iuh.edu.vn.lab06week06www.frontend.post;

import fit.iuh.edu.vn.lab06week06www.backend.modules.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("post")
public class PostController {
    @GetMapping("")
    public String getListPost(){
        return "post/listpost";
    }

    @GetMapping("/mypost")
    public String getListmyPost(){
        return "post/postuser";
    }

    @GetMapping("/mypost/add")
    public String getaddmyPost(Model model){
        model.addAttribute("post",new Post());
        return "post/addpost";
    }

    @PostMapping("/mypost/add-action")
    public String getaddmyPostAction(@ModelAttribute("post") Post post){
        return "redirect:/post/mypost";
    }
}
