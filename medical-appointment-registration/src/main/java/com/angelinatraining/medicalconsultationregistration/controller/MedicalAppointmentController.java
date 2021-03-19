package com.angelinatraining.medicalconsultationregistration.controller;

import com.angelinatraining.medicalconsultationregistration.dto.MedicalAppointmentDTO;
import com.angelinatraining.medicalconsultationregistration.model.MedicalAppointment;
import com.angelinatraining.medicalconsultationregistration.service.MedicalAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/consulta")
public class MedicalAppointmentController {

    @Autowired
    private MedicalAppointmentService medicalAppointmentService;

    @PostMapping(name = "/save")
    public ResponseEntity<MedicalAppointment> saveMedicalAppointment(@RequestBody MedicalAppointment medicalAppointment){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalAppointment);
    }

    @GetMapping(name = "/id/{id}")
    public ResponseEntity<MedicalAppointmentDTO> findByIdMedicalAppointment(@PathVariable Integer id){
        MedicalAppointment medicalAppointment = medicalAppointmentService.buscarConsultaPeloid(id);

        MedicalAppointmentDTO medicalAppointmentDTO = null;
        if(medicalAppointment == null){
            medicalAppointmentDTO =  new MedicalAppointmentDTO();
        }
        else{
            medicalAppointmentDTO = new MedicalAppointmentDTO(medicalAppointment.getId(),
                    medicalAppointment.getIdMedico(), medicalAppointment.getIdPaciente(),
                    medicalAppointment.getDataConsulta(), medicalAppointment.getHoraConsulta());
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicalAppointmentDTO);
    }

    @GetMapping(name = "/id/{id}")
    public List<MedicalAppointment> findAllMedicalAppointment(){
        return medicalAppointmentService.buscarPorTodasConsultas();
    }

    @PutMapping(name = "/update/{id}")
    public ResponseEntity<MedicalAppointment> updateMedicalAppointment(@RequestBody MedicalAppointment medicalAppointment){
        return ResponseEntity.status(HttpStatus.OK).body(medicalAppointment);
    }

    @DeleteMapping(name = "/delete/{id}")
    public ResponseEntity<MedicalAppointment> deleteMedicalAppointment(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
