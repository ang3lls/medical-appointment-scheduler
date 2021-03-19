package com.angelinatraining.patientregistration.controller;

import com.angelinatraining.patientregistration.dto.PatientDTO;
import com.angelinatraining.patientregistration.model.Patient;
import com.angelinatraining.patientregistration.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/paciente")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(name = "/cpf/{cpf}")
    public ResponseEntity<Boolean> verificarCpfPatient(@PathVariable String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.validarCPF(cpf));
    }

    @PostMapping(name = "/save")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.gravarPaciente(patient));
    }

    @GetMapping(name = "/id/{id}")
    public ResponseEntity<PatientDTO> findByPatientId(@PathVariable Integer id){
        Patient patient = patientService.buscarPacientePeloId(id);

        PatientDTO patientDTO = null;
        if(patient == null){
            patientDTO = new PatientDTO();
        }
        else{
            patientDTO = new PatientDTO(patient.getId(), patient.getNome(), patient.getIdade(), patient.getCpf());
        }
        return ResponseEntity.status(HttpStatus.OK).body(patientDTO);
    }

    @GetMapping(name = "find-all")
    public List<Patient> findAllPatient(){
        return patientService.buscarPorTodosPacientes();
    }
}
