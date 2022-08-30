package com.demo.dddArchitecture;


import com.demo.dddArchitecture.domain.entities.CompanyChecking;
import com.demo.dddArchitecture.domain.entities.Employee;
import com.demo.dddArchitecture.infrastructure.repository.CompanyCheckingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service @AllArgsConstructor @Slf4j
public class KafkaListeners {
    private final CompanyCheckingRepository companyCheckingRepository;



    @KafkaListener(topics = "topic1", groupId = "groupId")
    public void consume(String msg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> participantJsonList = mapper.readValue(msg, new TypeReference<List<Employee>>(){});
        for (int i =0 ; i<participantJsonList.size(); i++) {
            Long id = participantJsonList.get(i).getId();//lay id tung nv
            long idcompany = participantJsonList.get(i).getCompany().getId();
            List<CompanyChecking> isCompany = companyCheckingRepository.findCompanyId(idcompany);
            List<CompanyChecking> isEmployee = companyCheckingRepository.findEmployeeId(id);

            if (!isCompany.isEmpty()) {
                if (isEmployee.isEmpty()) {
                        CompanyChecking companyChecking = new CompanyChecking(participantJsonList.get(i), participantJsonList.get(i).getCompany().getId());
                        companyCheckingRepository.save(companyChecking);
                }
            } else {
                CompanyChecking companyChecking = new CompanyChecking(participantJsonList.get(i), participantJsonList.get(i).getCompany().getId());
                companyCheckingRepository.save(companyChecking);
            }
        }

    }

}
