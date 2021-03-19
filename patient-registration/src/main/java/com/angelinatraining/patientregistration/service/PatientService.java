package com.angelinatraining.patientregistration.service;

import com.angelinatraining.patientregistration.model.Patient;
import com.angelinatraining.patientregistration.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public boolean validarCPF(String cpf){
        Patient patient = new Patient();
        return ValidaCPF.ok(patient.getCpf());
    }

    public Patient gravarPaciente(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient buscarPacientePeloId(Integer id){
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isEmpty()){
            return null;
        }
        return patient.get();
    }

    public List<Patient> buscarPorTodosPacientes(){
        return patientRepository.findAll();
    }
}
