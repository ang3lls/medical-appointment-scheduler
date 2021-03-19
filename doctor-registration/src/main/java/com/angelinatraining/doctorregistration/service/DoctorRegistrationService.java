package com.angelinatraining.doctorregistration.service;

import com.angelinatraining.doctorregistration.model.Doctor;
import com.angelinatraining.doctorregistration.repository.DoctorRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorRegistrationService {

    @Autowired
    private DoctorRegistrationRepository doctorRegistrationRepository;

    public Doctor gravarMedico(Doctor doctor){
        return doctorRegistrationRepository.save(doctor);
    }

    public Doctor buscarMedicoPeloId(Integer id){
        Optional<Doctor> doctor = doctorRegistrationRepository.findById(id);
        if(doctor.isEmpty()){
            return null;
        }
        return doctor.get();
    }

    public List<Doctor> buscarTodosMedicos(){
        return doctorRegistrationRepository.findAll();
    }

    public void deletarMedico(Integer id) throws Exception {
        verificaExistenciaMedico(id);
        doctorRegistrationRepository.deleteById(id);
    }

    public Doctor verificaExistenciaMedico(Integer id) throws Exception {
        try(Doctor doctorDelete = doctorRegistrationRepository.getOne(id)) {
            return doctorDelete;
        }catch (Exception e){
            throw new Exception("Médico não encontrado");
        }
    }
}
