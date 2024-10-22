package com.joschonarth.certification_project.modules.students.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joschonarth.certification_project.modules.questions.entities.QuestionEntity;
import com.joschonarth.certification_project.modules.questions.repositories.QuestionRepository;
import com.joschonarth.certification_project.modules.students.dto.StudentCertificationAnswerDTO;
import com.joschonarth.certification_project.modules.students.repositories.StudentRepository;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public void execute(StudentCertificationAnswerDTO dto) throws Exception {
        
        var student = studentRepository.findByEmail(dto.getEmail());

        if(student.isEmpty()) {
            throw new Exception("Email incorrect");
        }

        List<QuestionEntity> questionsEntity = questionRepository.findByTechnology(dto.getTechnology());

        dto.getQuestionAnswers().stream().forEach(questionAnswer -> {
            var question = questionsEntity.stream().filter(q -> q.getId().equals(questionAnswer.getQuestionID()))
                .findFirst().get();

            var findCorrectAlternative = question.getAlternatives().stream()
                .filter(alternative -> alternative.isCorrect()).findFirst().get();

            if (findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID())) {
                questionAnswer.setCorrect(true);
            } else {
                questionAnswer.setCorrect(false);
            }
        });
    }    
}
