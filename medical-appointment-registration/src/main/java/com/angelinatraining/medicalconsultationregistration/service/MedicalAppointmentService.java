package com.angelinatraining.medicalconsultationregistration.service;

import com.angelinatraining.medicalconsultationregistration.model.MedicalAppointment;
import com.angelinatraining.medicalconsultationregistration.repository.MedicalAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalAppointmentService {

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    public MedicalAppointment gravarConsulta(MedicalAppointment medicalAppointment){
        return medicalAppointmentRepository.save(medicalAppointment);
    }

    public MedicalAppointment buscarConsultaPeloid(Integer id){
        Optional<MedicalAppointment> medicalAppointment = medicalAppointmentRepository.findById(id);
        if(medicalAppointment.isEmpty()){
            return null;
        }
        return medicalAppointment.get();
    }

    public List<MedicalAppointment> buscarPorTodasConsultas(){
        return medicalAppointmentRepository.findAll();
    }

    public MedicalAppointment alterarDadosConsulta(Integer id, MedicalAppointment medicalAppointment) throws Exception {
        MedicalAppointment medicalAppointmentAtualizado = verificaExistenciaConsulta(id);
        medicalAppointmentAtualizado.setIdMedico(medicalAppointment.getIdMedico());
        medicalAppointmentAtualizado.setDataConsulta(medicalAppointment.getDataConsulta());
        medicalAppointmentAtualizado.setHoraConsulta(medicalAppointment.getHoraConsulta());
        return gravarConsulta(medicalAppointmentAtualizado);
    }

    public void deletarConsulta(Integer id) throws Exception {
        verificaExistenciaConsulta(id);
        medicalAppointmentRepository.deleteById(id);
    }

    public MedicalAppointment verificaExistenciaConsulta(Integer id) throws Exception {
        try (MedicalAppointment medicalAppointmentDelete = medicalAppointmentRepository.getOne(id)){
            return medicalAppointmentDelete;
        } catch (Exception e) {
            throw new Exception("Consulta não encontrada");
        }
    }

}
