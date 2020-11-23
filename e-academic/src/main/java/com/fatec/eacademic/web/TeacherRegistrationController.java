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
 
import com.fatec.eacademic.model.Teacher;
import com.fatec.eacademic.service.TeacherService;
import com.fatec.eacademic.web.dto.TeacherRegistrationDto;

@Controller
@RequestMapping("/teacherRegistration")
public class TeacherRegistrationController {

    @Autowired
    private TeacherService TeacherService;

    @ModelAttribute("teacher")
    public TeacherRegistrationDto TeacherRegistrationDto() {
        return new TeacherRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "teacherRegistration";
    }

    @PostMapping
    public String registerTeacher(@ModelAttribute("teacher") @Valid TeacherRegistrationDto teacherDto,
        BindingResult result) {

        Teacher existing = TeacherService.findByCpf(teacherDto.getCpf());
        if (existing != null) {
            result.rejectValue("cpf", null, "Já existe uma professora ou um professor associado a esse registro");
        }

        if (result.hasErrors()) {
            return "teacherRegistration";
        }

        TeacherService.save(teacherDto);
        return "redirect:/teacherRegistration?success";
    }

    @PutMapping
    public String editTeacher(@ModelAttribute("teacher") @Valid TeacherRegistrationDto teacherDto,
        BindingResult result) {

        Teacher existing = TeacherService.findByCpf(teacherDto.getCpf());
        if (existing == null) {
            result.rejectValue("name", null, "Não existe uma professora ou um professor válido");
        }

        if (result.hasErrors()) {
            return "teacherRegistration";
        }

        TeacherService.update(teacherDto);
        return "redirect:/teacherRegistration?success";
    }

    @DeleteMapping
    public String deleteTeacher(@ModelAttribute("teacher") @Valid TeacherRegistrationDto teacherDto,
        BindingResult result) {

        Teacher existing = TeacherService.findByCpf(teacherDto.getCpf());
        if (existing == null) {
            result.rejectValue("name", null, "Não existe uma professora ou um professor para o registro informado");
        }

        if (result.hasErrors()) {
            return "teacherRegistration";
        }

        TeacherService.delete(teacherDto);
        return "redirect:/teacherRegistration?success";
    }
}