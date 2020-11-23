
package com.fatec.eacademic.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatec.eacademic.model.Subject;
import com.fatec.eacademic.service.SubjectService;
import com.fatec.eacademic.web.dto.SubjectRegistrationDto;

@Controller
@RequestMapping("/subjectRegistration")
public class SubjectRegistrationController {

    @Autowired
    private SubjectService SubjectService;

    @ModelAttribute("subject")
    public SubjectRegistrationDto SubjectRegistrationDto() {
        return new SubjectRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "subjectRegistration";
    }

    @PostMapping
    public String registerSubject(@ModelAttribute("subject") @Valid SubjectRegistrationDto SubjectDto,
        BindingResult result) {

        Subject existing = SubjectService.findByName(SubjectDto.getName());
        if (existing != null) {
            result.rejectValue("name", null, "Já existe uma disciplina válida");
        }

        if (result.hasErrors()) {
            return "subjectRegistration";
        }

        SubjectService.save(SubjectDto);
        return "redirect:/subjectRegistration?success";
    }

    @PutMapping
    public String editSubject(@ModelAttribute("subject") @Valid SubjectRegistrationDto SubjectDto,
        BindingResult result) {

        Subject existing = SubjectService.findByName(SubjectDto.getName());
        if (existing == null) {
            result.rejectValue("name", null, "Não existe uma disciplina válida");
        }

        if (result.hasErrors()) {
            return "subjectRegistration";
        }

        SubjectService.update(SubjectDto);
        return "redirect:/subjectRegistration?success";
    }

    @DeleteMapping
    public String deleteSubject(@ModelAttribute("subject") @Valid SubjectRegistrationDto SubjectDto,
        BindingResult result) {

        Subject existing = SubjectService.findByName(SubjectDto.getName());
        if (existing == null) {
            result.rejectValue("name", null, "Não existe uma disciplina válida");
        }

        if (result.hasErrors()) {
            return "subjectRegistration";
        }

        SubjectService.delete(SubjectDto);
        return "redirect:/subjectRegistration?success";
    }
}