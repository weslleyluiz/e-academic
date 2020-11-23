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
 
import com.fatec.eacademic.model.Student;
import com.fatec.eacademic.service.StudentService;
import com.fatec.eacademic.web.dto.StudentRegistrationDto;

@Controller
@RequestMapping("/studentRegistration")
public class StudentRegistrationController {

    @Autowired
    private StudentService studentService;

    @ModelAttribute("student")
    public StudentRegistrationDto StudentRegistrationDto() {
        return new StudentRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "studentRegistration";
    }

    @PostMapping
    public String registerStudent(@ModelAttribute("student") @Valid StudentRegistrationDto StudentDto,
        BindingResult result) {

        Student existing = studentService.findByRa(StudentDto.getRa());
        if (existing != null) {
            result.rejectValue("ra", null, "Já existe um estudante associado a esse registro de aluno");
        }

        if (result.hasErrors()) {
            return "studentRegistration";
        }

        studentService.save(StudentDto);
        return "redirect:/studentRegistration?success";
    }

    @PutMapping
    public String editStudent(@ModelAttribute("student") @Valid StudentRegistrationDto StudentDto,
        BindingResult result) {

        Student existing = studentService.findByRa(StudentDto.getRa());
        if (existing == null) {
            result.rejectValue("name", null, "Não existe um curso válido");
        }

        if (result.hasErrors()) {
            return "studentRegistration";
        }

        studentService.update(StudentDto);
        return "redirect:/studentRegistration?success";
    }

    @DeleteMapping
    public String deleteStudent(@ModelAttribute("student") @Valid StudentRegistrationDto StudentDto,
        BindingResult result) {

        Student existing = studentService.findByRa(StudentDto.getRa());
        if (existing == null) {
            result.rejectValue("name", null, "Não existe um estudante para o registro informado");
        }

        if (result.hasErrors()) {
            return "studentRegistration";
        }

        studentService.delete(StudentDto);
        return "redirect:/studentRegistration?success";
    }
}