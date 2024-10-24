package com.joschonarth.certification_project.modules.students.controllers;

import java.lang.Object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joschonarth.certification_project.modules.students.dto.StudentCertificationAnswerDTO;
import com.joschonarth.certification_project.modules.students.dto.VerifyCertificationDTO;
import com.joschonarth.certification_project.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.joschonarth.certification_project.modules.students.useCases.VerifyCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyCertificationUseCase verifyCertificationUseCase;

    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

    @PostMapping("/verifyCertification")
    public String verifyCertification(@RequestBody VerifyCertificationDTO verifyCertificationDTO) {

        var result = this.verifyCertificationUseCase.execute(verifyCertificationDTO);
        if (result) {
            return "Usuário já fez a prova";
        }
        return "Usuário pode fazer a prova";
    }

    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer(@RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) throws Exception {
        try {
            var result = studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
            return ResponseEntity.ok().body(result);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } 
    }
    
}
