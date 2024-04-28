package fr.ldnr.web;

import fr.ldnr.business.IBusinessImpl;
import fr.ldnr.dao.HeroRepository;
import fr.ldnr.entities.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HeroController {

    @Autowired
    HeroRepository heroRepository;
    @Autowired
    IBusinessImpl businessImpl;

    @GetMapping("category")
    public String categories(Long idHero, Model model) {
        Optional<Hero> optionalHero = heroRepository.findById(idHero);
        if(optionalHero.isPresent()) {
            Hero hero = optionalHero.get();
            model.addAttribute("idHero", hero.getId());
            return "redirect:/index?idHero=" + idHero;
        }
        return "items";
    }
}
