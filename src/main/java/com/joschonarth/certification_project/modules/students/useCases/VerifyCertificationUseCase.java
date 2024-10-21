package com.joschonarth.certification_project.modules.students.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joschonarth.certification_project.modules.students.dto.VerifyCertificationDTO;
import com.joschonarth.certification_project.modules.students.repositories.CertificationStudentRepository;

@Service
public class VerifyCertificationUseCase {
    
    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyCertificationDTO dto) {
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if(!result.isEmpty()) {
            return true;
        }
        return false;
    }
}
