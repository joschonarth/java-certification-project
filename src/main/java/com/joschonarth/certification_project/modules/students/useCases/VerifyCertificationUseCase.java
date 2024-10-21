package com.joschonarth.certification_project.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.joschonarth.certification_project.modules.students.dto.VerifyCertificationDTO;

@Service
public class VerifyCertificationUseCase {
    
    public boolean execute(VerifyCertificationDTO dto) {
        if(dto.getEmail().equals("joschonarth@gmail.com") && dto.getTechnology().equals("Java")) {
            return true;
        }
        return false;
    }
}
