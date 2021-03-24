package com.angelinatraining.doctorregistration.restTemplate;

import com.angelinatraining.doctorregistration.dto.EspecialidadesDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RequestSpecialty {
    public EspecialidadesDTO consultarEspecialidadeById(Integer id)
    {
        final String uri = "http://localhost:9093/especialidade/find/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id.toString());
        return restTemplate.getForObject(uri, EspecialidadesDTO.class, params);
        //Use the result
    }
}
