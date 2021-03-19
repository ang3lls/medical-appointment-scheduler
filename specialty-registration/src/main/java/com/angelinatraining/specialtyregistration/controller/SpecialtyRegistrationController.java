package com.angelinatraining.specialtyregistration.controller;

import com.angelinatraining.specialtyregistration.dto.SpecialtyDTO;
import com.angelinatraining.specialtyregistration.model.Specialty;
import com.angelinatraining.specialtyregistration.service.SpecialtyRegistationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/especialidade")
public class SpecialtyRegistrationController {

    @Autowired
    private SpecialtyRegistationService specialtyRegistationService;

    @PostMapping(name = "/save")
    public ResponseEntity<Specialty> saveSpecialty(@RequestBody Specialty specialty){
        return ResponseEntity.status(HttpStatus.CREATED).body(specialtyRegistationService.gravarEspecialidade(specialty));
    }

    @GetMapping(name = "/find/{id}")
    public ResponseEntity<SpecialtyDTO> findSpecialty(@PathVariable Integer id){
        Specialty specialty = specialtyRegistationService.buscarEspecialidadePeloId(id);

        SpecialtyDTO specialtyDTO = null;
        if(specialty == null){
            specialtyDTO = new SpecialtyDTO();
        }
        else{
            specialtyDTO = new SpecialtyDTO(specialty.getId(), specialty.getDescricao());
        }
        return ResponseEntity.status(HttpStatus.OK).body(specialtyDTO);
    }

    @GetMapping(name = "/find-all")
    public List<Specialty> findAllSpecialty(){
        return specialtyRegistationService.buscarTodasEspecialidades();
    }

    @DeleteMapping(name = "/delete/{id}")
    public ResponseEntity<Specialty> deleteSpecialty(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
