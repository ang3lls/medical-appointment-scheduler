package com.angelinatraining.specialtyregistration.service;

import com.angelinatraining.specialtyregistration.model.Specialty;
import com.angelinatraining.specialtyregistration.repository.SpecialtyRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyRegistationService {

    @Autowired
    private SpecialtyRegistrationRepository specialtyRegistrationRepository;

    public Specialty gravarEspecialidade(Specialty specialty){
        return specialtyRegistrationRepository.save(specialty);
    }

    public Specialty buscarEspecialidadePeloId(Integer id){
        Optional<Specialty> specialty = specialtyRegistrationRepository.findById(id);
        if(specialty.isEmpty()){
            return null;
        }
        return specialty.get();
    }

    public List<Specialty> buscarTodasEspecialidades(){
        return specialtyRegistrationRepository.findAll();
    }

    public Specialty deletarEspecialidade(Integer id) throws Exception {
        verificaExistenciaEspecialidade(id);
        specialtyRegistrationRepository.deleteById(id);
        return verificaExistenciaEspecialidade(id);
    }

    public Specialty verificaExistenciaEspecialidade(Integer id) throws Exception {
        try{
            Specialty specialtyDelete = specialtyRegistrationRepository.getOne(id);
            return specialtyDelete;
        }catch (Exception e){
            throw new Exception("Especialidade não encontrada");
        }
    }
}
