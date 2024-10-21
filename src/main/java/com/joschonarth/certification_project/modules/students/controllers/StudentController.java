package com.joschonarth.certification_project.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joschonarth.certification_project.modules.students.dto.VerifyCertificationDTO;
import com.joschonarth.certification_project.modules.students.useCases.VerifyCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyCertificationUseCase verifyCertificationUseCase;

    @PostMapping("/verifyCertification")
    public String verifyCertification(@RequestBody VerifyCertificationDTO verifyCertificationDTO) {

        var result = this.verifyCertificationUseCase.execute(verifyCertificationDTO);
        if (result) {
            return "Usuário já fez a prova";
        }
        return "Usuário pode fazer a prova";

    }
    
}
