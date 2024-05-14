package com.fugitive.server.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fugitive.server.model.Fugitive;
import com.fugitive.server.repository.FugitiveRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.Transient;
import java.time.LocalDateTime;

@Component
@Slf4j
public class FugitiveQueueConsumer {

    FugitiveRepo fugitiveRepo;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    public FugitiveQueueConsumer(FugitiveRepo fugitiveRepo) {
        this.fugitiveRepo = fugitiveRepo;
    }

    @RabbitListener(queues = "fugitives")
    @Transient
    public void receiveMessage(String message){
        Fugitive fugitive = transformMessageIntoFugitive(message);
        if (fugitive == null){
            log.error("Error while transforming message into Fugitive object");
            return;
        }
        fugitiveRepo.save(fugitive);
    }

    public Fugitive transformMessageIntoFugitive(String message){
        try {
            Fugitive fugitive  = objectMapper.readValue(message, Fugitive.class);
            fugitive.setCreatedDate(LocalDateTime.now());
            return fugitive;
        } catch (JsonProcessingException e) {
            log.error("Error while transforming message into Fugitive object: {}", e.getMessage());
            return null;
        }
    }
}
