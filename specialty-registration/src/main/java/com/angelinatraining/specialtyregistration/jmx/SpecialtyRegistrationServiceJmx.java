package com.angelinatraining.specialtyregistration.jmx;

import com.angelinatraining.specialtyregistration.model.Specialty;
import com.angelinatraining.specialtyregistration.service.SpecialtyRegistationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ManagedResource
public class SpecialtyRegistrationServiceJmx {

    @Autowired
    private SpecialtyRegistationService specialtyRegistationService;

    @ManagedOperation(description = "Salvar Especialidade")
    @ManagedOperationParameter(
            name = "Descrição", description = "Tipo de especialidade médica. Ex.: Cardiologia")
    public String salvarEspecialidade(String descricao){
        Specialty specialty = new Specialty();
        specialty.setDescricao(descricao);

        try {
            Specialty salvaspecialty = specialtyRegistationService.gravarEspecialidade(specialty);
            return "Especialidade salva com sucesso! " + salvaspecialty.getDescricao();
        }catch (Exception ex){
            return "Não foi possivel gravar a sua especialidade! " + ex.getMessage();
        }
    }

    @ManagedOperation(description = "Buscar por especialidade pelo id")
    @ManagedOperationParameter(name = "Id", description = "Id identificador da especialidade. Ex.: 1")
    public String buscarEspecialidadePeloId(Integer id){
        Specialty specialty = specialtyRegistationService.buscarEspecialidadePeloId(id);
        if(specialty == null){
            return "Essa especialidade não existe";
        }
        return specialty.getDescricao();
    }

    @ManagedOperation(description = "Buscar todas as especialidades")
    public List<Specialty> buscarTodasEspecialidades(){
        return specialtyRegistationService.buscarTodasEspecialidades();
    }

    @ManagedOperation(description = "Deletar especialidade pelo id")
    @ManagedOperationParameter(name = "id", description = "id da especialidade a ser deletada. Ex.: 1")
    public String deletarEspecialidadePeloId(Integer id) throws Exception {
        Specialty newspecialty = specialtyRegistationService.deletarEspecialidade(id);
        if(newspecialty.getId() == null){
            return "Essa especialidade não existe";
        }
        return newspecialty.getDescricao() + " Deletado!";
    }
}
