package ninja.hara.springwebmvc.controller;

import ninja.hara.springwebmvc.model.Jedi;
import ninja.hara.springwebmvc.repository.JediRepository;
import ninja.hara.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class JediController {

   @Autowired
   private JediRepository repository; //com o autowired teremos uma referência a uma instância gerenciada


    @GetMapping("/jedi")
    public ModelAndView jedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        //final Jedi jediLuke= new Jedi("Luke", "Skywalker");
        modelAndView.addObject("allJedi", repository.getAllJedi());
        return modelAndView;

    }
    @GetMapping("/new-jedi")
    public ModelAndView newJedi(){
        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("new-jedi"); //arquivo da view (nome do html - recurso de visualização)
        modelAndView.addObject("jedi",new Jedi());

        return modelAndView;
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            return "new-jedi";
        }

        repository.add(jedi);

        redirect.addFlashAttribute("message","Jedi cadastrado com sucesso!");
        return "redirect:jedi";
    }
}
