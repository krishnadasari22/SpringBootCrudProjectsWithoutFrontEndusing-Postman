package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Template;
import com.example.demo.repository.TemplateRepository;

@RestController
@RequestMapping()
public class TemplateController {

    @Autowired
    TemplateRepository templateRepository;

    @GetMapping("/templates")
    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    @PostMapping("/templates")
    public Template createTemplate(@RequestBody Template template) {
        return templateRepository.save(template);
    }

    @GetMapping("/templates/{id}")
    public Optional<Template> getTemplateById(@PathVariable(value = "id") Integer id) {
        return templateRepository.findById(id);
        
    }

    @PutMapping("/templates/{id}")
    public Template updateTemplate(@PathVariable(value = "id") Integer id, @RequestBody Template templateDetails) {

        Template template = templateRepository.findById(id)
                .orElseThrow();

        template.setInstrument_type_id(templateDetails.getInstrument_type_id());
        template.setUser_id(templateDetails.getUser_id());
        template.setRegion_id(templateDetails.getRegion_id());
        template.setTemplate_name(templateDetails.getTemplate_name());
        template.setUpdated_at(templateDetails.getUpdated_at());
        template.setCreated_at(templateDetails.getCreated_at());

        Template updatedTemplate = templateRepository.save(template);
        return updatedTemplate;
    }

    @DeleteMapping("/templates/{id}")
    public ResponseEntity<?> deleteTemplate(@PathVariable(value = "id") Integer id) {
        Template template = templateRepository.findById(id)
                .orElseThrow();

        templateRepository.delete(template);

        return ResponseEntity.ok().build();
    }
}
