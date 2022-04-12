package bcm.app.controller;

import bcm.app.model.hub.SapBuf;
import bcm.app.repository.agent02.BoutRepository;
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

    @Autowired
    private BoutRepository boutRepository;
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
    @PostMapping("/")
    public String sapbufSubmit(@ModelAttribute SapBuf sapbuf, Model model) {
        model.addAttribute("sapbuf", sapbuf);
        String sap =sapbuf.getSap();
        //String bufer =sapbuf.getBufer();
        String agent = orgRepository.getAgentByCodvCode(sap);

        System.out.println(agent);
        return "index";

 */

@GetMapping("/")
public String index(Model model) {
    model.addAttribute("message", "message");
    model.addAttribute("sapbuf", new SapBuf());
    return "index";
}

    @GetMapping("/bacchus")
    public String bacchus(Model model) {
        model.addAttribute("message", "message");
        model.addAttribute("sapbuf", new SapBuf());
        return "bacchus";
    }

    //0186 865785
    @PostMapping("/bacchus")
    public String sapbufSubmit(@ModelAttribute SapBuf sapbuf, Model model) {
        model.addAttribute("sapbuf", sapbuf);
        String sap =sapbuf.getSap();
        String bufer =sapbuf.getBufer();
        String agent = orgRepository.getAgentByCodvCode(sap);

        if(agent.equals("2")){
            Long codv_id = orgRepository.getCodvIdByCodvCode(sapbuf.getSap());
            List<String> buferInfo = boutRepository.getBuferInfoFromAgent(codv_id,bufer);
            System.out.println(buferInfo.get(0));
            String[] bInfo = buferInfo.get(0).split(",");

            model.addAttribute("agent", agent);
            model.addAttribute("bufer", bInfo[0]);
            model.addAttribute("ddate", bInfo[1]);
            model.addAttribute("wayb", bInfo[2]);
            model.addAttribute("status", bInfo[3]);
            //smodel.getAttribute("bufer",buferInfo);

        }else{
            System.out.println("no agent");
        }



        return "bacchus";

    }

}


