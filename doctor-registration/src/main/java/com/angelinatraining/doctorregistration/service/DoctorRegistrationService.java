package com.angelinatraining.doctorregistration.service;

import com.angelinatraining.doctorregistration.restTemplate.RequestSpecialty;
import com.angelinatraining.doctorregistration.dto.EspecialidadeMedicoDTO;
import com.angelinatraining.doctorregistration.dto.EspecialidadesDTO;
import com.angelinatraining.doctorregistration.model.Doctor;
import com.angelinatraining.doctorregistration.model.EspecialidadeMedico;
import com.angelinatraining.doctorregistration.repository.DoctorRegistrationRepository;
import com.angelinatraining.doctorregistration.repository.EspecialidadeMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorRegistrationService {

    @Autowired
    private DoctorRegistrationRepository doctorRegistrationRepository;

    @Autowired
    private EspecialidadeMedicoRepository especialidadeMedicoRepository;
    
    @Autowired
    private RequestSpecialty requestSpecialty;

    public Doctor gravarMedico(Doctor doctorDTO) throws Exception {
        Doctor doctor = new Doctor();
        doctor.setId_medico(doctorDTO.getId_medico());
        List<EspecialidadesDTO> especialidades =  new ArrayList<>();

        EspecialidadesDTO especialidade = new EspecialidadesDTO();
        especialidade.setIdEspecialidade(doctorDTO.getId_especialidade());
        especialidades.add(especialidade);
        doctorDTO.setIdsEspecialidades(especialidades);
        especialidades =  new ArrayList<>();

        for (EspecialidadeMedicoDTO especialidadeMedicoDTO : doctorDTO.getIdsEspecialidades()) {
            EspecialidadesDTO especialidadesDTO = requestSpecialty.consultarEspecialidadeById
                    (especialidadeMedicoDTO.getIdEspecialidade());
            especialidadesDTO.setIdEspecialidade(doctorDTO.getId_especialidade());
            if(especialidadesDTO.getIdEspecialidade() == null){
                throw new Exception("Especialidade não encontrada");
            }
            especialidades.add(especialidadesDTO);
        }
        doctor.setIdsEspecialidades(especialidades);
        
        Doctor saveDoctor = doctorRegistrationRepository.save(doctor);
        for (EspecialidadesDTO dto:especialidades) {
            EspecialidadeMedico especialidadeMedico = new EspecialidadeMedico();
            especialidadeMedico.setIdMedico(saveDoctor.getId_medico());
            especialidadeMedico.setIdEspecialidade(saveDoctor.getId_especialidade());
            especialidadeMedicoRepository.save(especialidadeMedico);
        }
        return saveDoctor;
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

    public String deletarMedico(Integer id) throws Exception {
        verificaExistenciaMedico(id);
        doctorRegistrationRepository.deleteById(id);
        return deletarMedico(id);
    }

    public Doctor verificaExistenciaMedico(Integer id) throws Exception {
        try(Doctor doctorDelete = doctorRegistrationRepository.getOne(id)) {
            return doctorDelete;
        }catch (Exception e){
            throw new Exception("Médico não encontrado");
        }
    }
}
