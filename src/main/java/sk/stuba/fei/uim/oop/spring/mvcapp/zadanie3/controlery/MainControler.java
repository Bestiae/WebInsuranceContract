package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.controlery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.zmluvy.*;
import sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.jadro.PouzivatelAPI;
import sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.utilities.*;

@Controller
@RequestMapping("/pouzivatela")
public class MainControler {
    private final PouzivatelAPI users;

    @Autowired
    public MainControler(PouzivatelAPI users) {
        this.users = users;
        Adresa address1 = new Adresa(84104, "Bratislava", "Karlova ves", "Stare Grunty", 53);
        Adresa address2 = new Adresa(84104, "Bratislava", "Karlova ves", "Stare Grunty", 60);
        Pouzivatel u1 = new Pouzivatel(1, "Miroslav", "Mrkvicka", 123456, "miroslav@mrkvica.com", address1, address1);
        Pouzivatel u2 = new Pouzivatel(2, "Tomas", "Stanislav", 654321, "tomsa@stanislav.com", address2, address1);

        users.addUser( u1 );
        users.addUser( u2 );
    }
    @GetMapping
    public String showAllUsers(Model model)
    {
        model.addAttribute("pouzivatela", users.getAllUsers() );
        return "/pouzivatela";
    }

    @GetMapping("/pouzivatel/{id}")
    public String userDetails(@PathVariable long id, Model model)
    {
        model.addAttribute("pouzivatel", users.getUser(id));
        return "/pouzivatel";
    }

    @GetMapping("/add")
    public String addUserForm(Model model){
        model.addAttribute("pouzivatel", new Pouzivatel());
        return "pridat-pouzivatel";
    }
    @PostMapping("/add")
    public String addUserSubmit(@ModelAttribute Pouzivatel user, @ModelAttribute Adresa perm_address, @ModelAttribute Adresa corr_address)
    {
        if( user.getCorrAddress().isEmpty() )
            user.setCorrAddress(user.getPermAddress());
        user.initZmluva();
        users.addUser( user );
        return "redirect:/pouzivatela";
    }

    @GetMapping("/pouzivatel/edit/{id}")
    public String editUser(@PathVariable long id, Model model)
    {
        model.addAttribute("pouzivatel", users.getUser(id));
        return "uprav-pouzivatel";
    }

    @PostMapping("/pouzivatel/edited")
    public String submitEditing( @ModelAttribute Pouzivatel user )
    {
        if( user.getCorrAddress().isEmpty() )
            user.setCorrAddress(user.getPermAddress());
        users.editUser(user.getId(), user);
        return "redirect:/pouzivatela";
    }
////
    @GetMapping("/pouzivatel/{id}/add-contract")
    public String addZmluva(@PathVariable long id, Model model)
    {
        model.addAttribute("id", id);
        return "pridat-zlmluva-base";
    }

    @GetMapping("/pouzivatel/{id}/pridat-poistenieDomacnosti")
    public String addHousehold(@PathVariable long id, Model model)
    {
        model.addAttribute("id", id);
        model.addAttribute("zmluva", new PoistenieDomacnosti());
        return "pridat-poistenieDomacnosti";
    }

    @PostMapping("/pouzivatel/pridat-poistenieDomacnosti/{id}")
    public String addHouseholdSubmit(@PathVariable long id, @ModelAttribute PoistenieDomacnosti zmluva)
    {
        zmluva.setId(GeneratorId.newId());
        zmluva.setInsurerId(id);
        users.getUser(id).addZmluva(zmluva);
        return "redirect:/pouzivatela/pouzivatel/" + id;
    }


    @GetMapping("/pouzivatel/{id}/pridat-urazovePoistenie")
    public String addInjury(@PathVariable long id, Model model)
    {
        UrazovePoistenie zmluva = new UrazovePoistenie();
        model.addAttribute("zmluva", zmluva);
        model.addAttribute("id", id);
        model.addAttribute("pouzivatela", users.getAllUsers());
        return "pridat-urazovePoistenie";
    }

    @PostMapping("/pouzivatel/pridat-urazovePoistenie/{id}")
    public String addInjurySubmit(@PathVariable long id, @ModelAttribute UrazovePoistenie zmluva)
    {
        zmluva.setId(GeneratorId.newId());
        zmluva.setInsurerId(id);
        users.getUser(id).addZmluva(zmluva);
        return "redirect:/pouzivatela/pouzivatel/" + id;
    }

    @GetMapping("/pouzivatel/{id}/pridat-cestovnePoistenie")
    public String addTravel(@PathVariable long id, Model model)
    {
        CestovnePoistenie zmluva = new CestovnePoistenie();
        model.addAttribute("zmluva", zmluva);
        model.addAttribute("id", id);
        model.addAttribute("pouzivatela", users.getAllUsers());
        return "pridat-cestovnePoistenie";
    }

    @PostMapping("/pouzivatel/pridat-cestovnePoistenie/{id}")
    public String addTravelSubmit(@PathVariable long id, @ModelAttribute CestovnePoistenie zmluva)
    {
        zmluva.setId(GeneratorId.newId());
        zmluva.setInsurerId(id);
        users.getUser(id).addZmluva(zmluva);
        return "redirect:/pouzivatela/pouzivatel/" + id;
    }

    @GetMapping("/pouzivatel/{id}/pridat-poistenieDomuBytu")
    public String addResidence(@PathVariable long id, Model model)
    {
        PoistenieDomuBytu zmluva = new PoistenieDomuBytu();
        model.addAttribute("zmluva", zmluva);
        model.addAttribute("id", id);
        return "pridat-poistenieDomuBytu";
    }

    @PostMapping("/pouzivatel/pridat-poistenieDomuBytu/{id}")
    public String addResidenceSubmit(@PathVariable long id, @ModelAttribute PoistenieDomuBytu zmluva)
    {
        zmluva.setId(GeneratorId.newId());
        zmluva.setInsurerId(id);
        users.getUser(id).addZmluva(zmluva);
        return "redirect:/pouzivatela/pouzivatel/" + id;
    }

    ////
    ////
//    @GetMapping("/pouzivatel/{uid}/travel/{id}")
//    public String showTravelDetail(@PathVariable long uid, @PathVariable long id, Model model)
//    {
//        model.addAttribute("zmluva", users.getUser(uid).getZmluva(id));
//        return "cestovne-info";
//    }

    @GetMapping("/pouzivatel/{uid}/travel/{id}")
    public String showTravelDetail(@PathVariable long uid, @PathVariable long id, Model model)
    {
        model.addAttribute("zmluva", users.getUser(uid).getZmluva(id));
        return "cestovne-info";
    }
//
    @GetMapping("/pouzivatel/{uid}/injury/{id}")
    public String showInjuryDetail(@PathVariable long uid, @PathVariable long id, Model model)
    {
        model.addAttribute("zmluva", users.getUser(uid).getZmluva(id));
        return "urazovy-info";
    }

    @GetMapping("/pouzivatel/{uid}/residence/{id}")
    public String showResidenceDetail(@PathVariable long uid, @PathVariable long id, Model model)
    {
        model.addAttribute("zmluva", users.getUser(uid).getZmluva(id));
        return "domubytu-info";
    }

    @GetMapping("/pouzivatel/{uid}/household/{id}")
    public String showHouseholdDetail(@PathVariable long uid, @PathVariable long id, Model model)
    {
        model.addAttribute("zmluva", users.getUser(uid).getZmluva(id));
        return "domacnosti-info";
    }

    @GetMapping("/pouzivatel/{uid}/travel/{id}/edit")
    public String editTravel(@PathVariable long uid, @PathVariable long id, Model model)
    {
        model.addAttribute("uid", uid);
        model.addAttribute("id", id);
        model.addAttribute("zmluva", users.getUser(uid).getZmluva(id));
        model.addAttribute("pouzivatela", users.getAllUsers());
        return "uprav-cestovne";
    }
    @PostMapping("/pouzivatel/{uid}/travel/{id}/edited")
    public String editTravelSubmit(@PathVariable long uid, @PathVariable long id, @ModelAttribute CestovnePoistenie zmluva )
    {
        users.getUser(uid).getZmluva(id).edit( zmluva );
        return "redirect:/pouzivatela/pouzivatel/" + uid;
    }
    @GetMapping("/pouzivatel/{uid}/injury/{id}/edit")
    public String editInjury(@PathVariable long uid, @PathVariable long id, Model model)
    {
        model.addAttribute("uid", uid);
        model.addAttribute("id", id);
        model.addAttribute("zmluva", users.getUser(uid).getZmluva(id));
        model.addAttribute("pouzivatela", users.getAllUsers());
        return "uprav-urazove";
    }
    @PostMapping("/pouzivatel/{uid}/injury/{id}/edited")
    public String editInjurySubmit(@PathVariable long uid, @PathVariable long id, @ModelAttribute UrazovePoistenie zmluva )
    {
        users.getUser(uid).getZmluva(id).edit( zmluva );
        return "redirect:/pouzivatela/pouzivatel/" + uid;
    }

    @GetMapping("/pouzivatel/{uid}/residence/{id}/edit")
    public String editResidence(@PathVariable long uid, @PathVariable long id, Model model)
    {
        model.addAttribute("uid", uid);
        model.addAttribute("id", id);
        model.addAttribute("zmluva", users.getUser(uid).getZmluva(id));
        return "uprav-domubytu";
    }
    @PostMapping("/pouzivatel/{uid}/residence/{id}/edited")
    public String editResidenceSubmit(@PathVariable long uid, @PathVariable long id, @ModelAttribute PoistenieDomuBytu zmluva )
    {
        users.getUser(uid).getZmluva(id).edit( zmluva );
        return "redirect:/pouzivatela/pouzivatel/" + uid;
    }

    @GetMapping("/pouzivatel/{uid}/household/{id}/edit")
    public String editHousehold(@PathVariable long uid, @PathVariable long id, Model model)
    {
        model.addAttribute("uid", uid);
        model.addAttribute("id", id);
        model.addAttribute("zmluva", users.getUser(uid).getZmluva(id));
        return "uprava-domacnosti";
    }
    @PostMapping("/pouzivatel/{uid}/household/{id}/edited")
    public String editHouseholdSubmit(@PathVariable long uid, @PathVariable long id, @ModelAttribute PoistenieDomacnosti zmluva )
    {
        users.getUser(uid).getZmluva(id).edit(zmluva);
        return "redirect:/pouzivatela/pouzivatel/" + uid;
    }
}
