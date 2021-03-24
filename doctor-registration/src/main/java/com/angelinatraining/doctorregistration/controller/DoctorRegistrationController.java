package com.angelinatraining.doctorregistration.controller;

import com.angelinatraining.doctorregistration.dto.DoctorDTO;
import com.angelinatraining.doctorregistration.model.Doctor;
import com.angelinatraining.doctorregistration.service.DoctorRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorRegistrationController {

    @Autowired
    private DoctorRegistrationService doctorRegistrationService;

    @PostMapping("/save")
    public ResponseEntity<Doctor> saveMedico(@RequestBody Doctor doctor) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorRegistrationService.gravarMedico(doctor));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DoctorDTO> findMedico(@PathVariable Integer id){
        Doctor doctor = doctorRegistrationService.buscarMedicoPeloId(id);

        DoctorDTO doctorDTO = null;
        if(doctor == null){
            doctorDTO = new DoctorDTO();
        }
        else{
            doctorDTO = new DoctorDTO(doctor.getId_medico(), doctor.getNome(),
                    doctor.getIdsEspecialidades());
        }
        return ResponseEntity.status(HttpStatus.OK).body(doctorDTO);
    }

    @GetMapping("/find-all")
    public List<Doctor> findAllMedicos(){
        return doctorRegistrationService.buscarTodosMedicos();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Doctor> deleteMedico(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
