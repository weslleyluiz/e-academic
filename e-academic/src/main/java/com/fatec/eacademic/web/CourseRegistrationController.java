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

import com.fatec.eacademic.model.Course;
import com.fatec.eacademic.service.CourseService;
import com.fatec.eacademic.web.dto.CourseRegistrationDto;

@Controller
@RequestMapping("/courseRegistration")
public class CourseRegistrationController {

    @Autowired
    private CourseService courseService;

    @ModelAttribute("course")
    public CourseRegistrationDto courseRegistrationDto() {
        return new CourseRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "courseRegistration";
    }

    @PostMapping
    public String registerCourse(@ModelAttribute("course") @Valid CourseRegistrationDto courseDto,
        BindingResult result) {

        Course existing = courseService.findByName(courseDto.getName());
        if (existing != null) {
            result.rejectValue("name", null, "Já existe um curso associado a esse nome");
        }

        if (result.hasErrors()) {
            return "courseRegistration";
        }

        courseService.save(courseDto);
        return "redirect:/courseRegistration?success";
    }

    @PutMapping
    public String editCourse(@ModelAttribute("course") @Valid CourseRegistrationDto courseDto,
        BindingResult result) {

        Course existing = courseService.findByName(courseDto.getName());
        if (existing == null) {
            result.rejectValue("name", null, "Não existe um curso válido");
        }

        if (result.hasErrors()) {
            return "courseRegistration";
        }

        courseService.update(courseDto);
        return "redirect:/courseRegistration?success";
    }

    @DeleteMapping
    public String deleteCourse(@ModelAttribute("course") @Valid CourseRegistrationDto courseDto,
        BindingResult result) {

        Course existing = courseService.findByName(courseDto.getName());
        if (existing == null) {
            result.rejectValue("name", null, "Não existe um curso válido");
        }

        if (result.hasErrors()) {
            return "courseRegistration";
        }

        courseService.delete(courseDto);
        return "redirect:/courseRegistration?success";
    }
}