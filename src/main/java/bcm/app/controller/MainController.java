package bcm.app.controller;

import bcm.app.controller.hub.SapBuf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
/*
 @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "message");
        model.addAttribute("sapbuf", new SapBuf());
        return "index";
    }

    @PostMapping("/")
    public void sapbufSubmit(@ModelAttribute SapBuf sapbuf, Model model) {
        model.addAttribute("sapbuf", sapbuf);
        System.out.println(sapbuf.getSap());

    }
 */
@GetMapping("/")
public String index(Model model) {
    model.addAttribute("message", "message");
    model.addAttribute("sapbuf", new SapBuf());
    return "index";
}

    @PostMapping("/")
    public String sapbufSubmit(@ModelAttribute SapBuf sapbuf, Model model) {
        model.addAttribute("sapbuf", sapbuf);
        model.addAttribute("message", "message");
        System.out.println(sapbuf.getSap());
        return "index";
    }

}
