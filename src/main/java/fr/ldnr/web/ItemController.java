package fr.ldnr.web;

import fr.ldnr.business.IBusinessImpl;
import fr.ldnr.dao.HeroRepository;
import fr.ldnr.dao.ItemRepository;
import org.springframework.validation.BindingResult;
import fr.ldnr.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    HeroRepository heroRepository;

    @Autowired
    private IBusinessImpl businessImpl;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name="page", defaultValue = "0") int page,
                                     @RequestParam(name="idHero", defaultValue = "0") Long idHero) {
        int pageSize = 2;
        Page<Item> itemList = null;
        if(idHero > 0) {
            itemList = businessImpl.findItemsByHeroIdByPage(idHero, page, pageSize);
        } else {
            itemList = businessImpl.findAllItemsByPage(page, pageSize);
        }
        model.addAttribute("itemList", itemList);
        model.addAttribute("heroList", heroRepository.findAll());
        model.addAttribute("currentPage", page);
        model.addAttribute("pages", new int[itemList.getTotalPages()]);
        model.addAttribute("idHero", idHero);

        return "items";
    }

    @GetMapping("/item")
    public String article(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("heroList", heroRepository.findAll());
        return "item";
    }

    @PostMapping("/save")
    public String save(@Valid Item item, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("heroList", heroRepository.findAll());
            return "item";
        }
        itemRepository.save(item);
        return "redirect:/index";
    }
}
