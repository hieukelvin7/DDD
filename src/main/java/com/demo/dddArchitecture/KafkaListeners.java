package com.demo.dddArchitecture;


import com.demo.dddArchitecture.domain.entities.Company;
import com.demo.dddArchitecture.domain.entities.CompanyChecking;
import com.demo.dddArchitecture.domain.entities.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import kafka.utils.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class KafkaListeners {

//    @Autowired
//    private OrderSaveByFeignClient orderSaveByFeignClient;


    public Object deSerializedData(String str) {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = null;
        try {
            obj = mapper.readValue(str, Object.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return obj;
    }
    @KafkaListener(topics = "topic1", groupId = "groupId")
    public void consume(String msg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws JsonProcessingException {
        //CompanyChecking companyChecking = new CompanyChecking(msg);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(msg +" from "+topic);

        List<Employee> participantJsonList = mapper.readValue(msg, new TypeReference<List<Employee>>(){});



    }

}
