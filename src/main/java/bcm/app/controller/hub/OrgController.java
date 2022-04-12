package bcm.app.controller.hub;

import bcm.app.model.hub.Org;
import bcm.app.repository.hub.AgentRepository;
import bcm.app.repository.hub.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrgController {

    @Autowired
    private OrgRepository orgRepository;



    @GetMapping("/orgs")
    public Iterable<Org> getAll() {//получить все записи
        return orgRepository.findAll();
    }


    @PostMapping("/orgs")
    public List getAgent(@RequestBody Org org) {
        //System.out.println(org.getCodv_code());
        List<String> hh = orgRepository.getAgentByCodvCode(org.getCodv_code());
        //System.out.println(hh.get(0));
        return orgRepository.getAgentByCodvCode(org.getCodv_code());
    }
}
