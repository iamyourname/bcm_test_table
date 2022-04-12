package bcm.app.controller;

import bcm.app.controller.hub.SapBuf;
import bcm.app.repository.hub.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private OrgRepository orgRepository;
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
        String sap =sapbuf.getSap();
        //String bufer =sapbuf.getBufer();
        String agent = orgRepository.getAgentByCodvCode(sap);

        System.out.println(agent);
        return "index";
    }

}
