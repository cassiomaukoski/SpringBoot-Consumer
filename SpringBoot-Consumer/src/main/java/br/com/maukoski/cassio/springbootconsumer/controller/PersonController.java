package br.com.maukoski.cassio.springbootconsumer.controller;

import br.com.maukoski.cassio.springbootconsumer.model.Person;
import br.com.maukoski.cassio.springbootconsumer.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person/form";
    }

    @GetMapping("")
    public String listPerson(Model model) {
        model.addAttribute("listPerson", personService.findAll());
        return "person/list";
    }

    @GetMapping("/edit")
    public String editPerson(@RequestParam("id") int id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "person/form";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") Person person) {
        personService.save(person);
        return "redirect:/person";
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam("id") int id) {
        personService.delete(id);
        return "redirect:/person";
    }

}
