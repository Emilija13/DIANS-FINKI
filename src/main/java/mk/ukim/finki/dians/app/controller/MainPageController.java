package mk.ukim.finki.dians.app.controller;

import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.dians.app.model.Heritage;
import mk.ukim.finki.dians.app.service.HeritageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mainPage")
public class MainPageController {

    @Autowired
    private HeritageService heritageService;
    //public final HeritageService heritageService;

    //public MainPageController(HeritageService heritageService) {
     //   this.heritageService = heritageService;
    //}

    @GetMapping
    public String  getMainPage(Model model)
    {
        List<Heritage> allHeritages = heritageService.findAll();
        //System.out.println("Number of heritages found: " + allHeritages.size());
        model.addAttribute("cities",heritageService.findAllCities());
        model.addAttribute("categories",heritageService.findAllCategories());
        model.addAttribute("heritages",heritageService.findAll());
        return "mainPage";
    }

    @GetMapping("/search")
    public String searchHeritage(@RequestParam(name = "name", required = false) String name,@RequestParam(name = "city", required = false) String city,@RequestParam(name = "category", required = false) String category, Model model) {
        model.addAttribute("cities",heritageService.findAllCities());
        model.addAttribute("categories",heritageService.findAllCategories());
        model.addAttribute("heritages", heritageService.search(name,city,category));
        return "mainPage";
    }

    @GetMapping("/edit-form/{id}")
    public String editMoviePage(@PathVariable Long id, Model model) {
        if (this.heritageService.findById(id).isPresent()) {
            Heritage heritage = this.heritageService.findById(id).get();
            List<String> cities = heritageService.findAllCities();
            List<String> categories = heritageService.findAllCategories();
            model.addAttribute("cities", cities);
            model.addAttribute("categories", categories);
            model.addAttribute("heritage", heritage);
            return "heritageForm";
        }
        return "redirect:/mainPage";
    }

    @GetMapping("/add-heritage")
    public String addHeritage(Model model){
        List<String> cities = heritageService.findAllCities();
        List<String> categories = heritageService.findAllCategories();
        model.addAttribute("cities", cities);
        model.addAttribute("categories", categories);
        return "heritageForm";
    }

    @PostMapping("/save")
    public String saveHeritage(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String city){

        if(id==null){
            heritageService.save(name, city, "Споменик/Градба", 42.0191255, 20.9616728);
        }else{
            heritageService.update(id, name, city, "Споменик/Градба", 42.0191255, 20.9616728);
        }
        return "redirect:/mainPage";
    }
}
