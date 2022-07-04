package ch.bbw.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonenController {

    private final PersonenServiceImpl PersonenService;

    public PersonenController(PersonenServiceImpl PersonenService) {
        super();
        this.PersonenService = PersonenService;
    }

    @GetMapping("/personenverwaltung")
    public String listStudents(Model model) {
        model.addAttribute("students", PersonenService.getAllStudents());
        return "personenverwaltung";
    }

    @GetMapping("/personenverwaltung/erstellen")
    public String createStudentForm(Model model) {

        Personenverwaltung personenverwaltung = new Personenverwaltung();
        model.addAttribute("student", personenverwaltung);
        return "create_personenverwaltung";
    }

    @PostMapping("/personenverwaltung")
    public String saveStudent(@ModelAttribute("student") Personenverwaltung personenverwaltung) {
        PersonenService.saveStudent(personenverwaltung);
        return "redirect:/personenverwaltung";
    }

    @GetMapping("/personenverwaltung/editieren/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", PersonenService.getStudentById(id));
        return "edit_personenverwaltung";
    }

    @PostMapping("/personenverwaltung/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Personenverwaltung personenverwaltung, Model model) {
        Personenverwaltung existingStudent = PersonenService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(personenverwaltung.getFirstName());
        existingStudent.setLastName(personenverwaltung.getLastName());
        existingStudent.setEmail(personenverwaltung.getEmail());
        PersonenService.updateStudent(existingStudent);
        return "redirect:/personenverwaltung";
    }

    @GetMapping("/personenverwaltung/{id}")
    public String deleteStudent(@PathVariable Long id) {
        PersonenService.deleteStudentById(id);
        return "redirect:/personenverwaltung";
    }
}
