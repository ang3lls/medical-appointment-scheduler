package com.angelinatraining.doctorregistration.jmx;

import com.angelinatraining.doctorregistration.dto.EspecialidadesDTO;
import com.angelinatraining.doctorregistration.model.Doctor;
import com.angelinatraining.doctorregistration.service.DoctorRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ManagedResource
public class DoctorRegistrationServiceJmx {

    @Autowired
    private DoctorRegistrationService doctorRegistrationService;

    @ManagedOperation(description = "Salvar Médico")
    @ManagedOperationParameter(name = "Nome", description = "Nome do médico.")
    @ManagedOperationParameter(name = "Id Especialidade", description = "Id da sua especialidade.")
    public String salvarMedico(String nome, Integer id){
        Doctor doctor  = new Doctor();
        doctor.setNome(nome);
        doctor.setId_especialidade(id);

        try{
            Doctor doctorSalvo = doctorRegistrationService.gravarMedico(doctor);
            return "Médico salvo com sucesso! " + doctorSalvo.getNome();
        } catch (Exception ex) {
            return "Não foi possivel salvar o médico: " + ex.getMessage();
        }
    }

    @ManagedOperation(description = "Buscar médico pelo id")
    @ManagedOperationParameter(name = "Id", description = "Id identificador do médico. Ex.: 1")
    public String buscarMedicoPeloId(Integer id){
        Doctor doctor = doctorRegistrationService.buscarMedicoPeloId(id);
        if(doctor == null){
            return "Médico não encontrado";
        }
        return doctor.getNome();
    }

    @ManagedOperation(description = "Buscar todos os médicos")
    public List<Doctor> buscarTodosMedicos(){
        return doctorRegistrationService.buscarTodosMedicos();
    }

    @ManagedOperation(description = "Deletar médico pelo id")
    @ManagedOperationParameter(name = "Id", description = "Id do médico a ser deletado. Ex.: 1")
    public String deletarMedicoPeloId(Integer id) throws Exception {
        return doctorRegistrationService.deletarMedico(id);
    }
}
