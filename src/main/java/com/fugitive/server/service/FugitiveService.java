package com.fugitive.server.service;

import com.fugitive.server.model.Fugitive;
import com.fugitive.server.repository.FugitiveRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FugitiveService {

    private final FugitiveRepo fugitiveRepo;

    public Iterable<Fugitive> getAllFugitives(){
        return fugitiveRepo.findAll();
    }

    public List<Fugitive> findFugitivesByColor(String color){
        return fugitiveRepo.findFugitivesByColor(color);
    }

    public Optional<Fugitive> getFugitiveById(Integer id){
        return fugitiveRepo.findById(id);
    }

    public void deleteFugitiveById(Integer id){
        if (fugitiveRepo.findById(id).isPresent()){
            fugitiveRepo.deleteById(id);
        }
        log.error("Fugitive with id: {} not exist in the database", id);
    }
    public Long countFugitives(){
        return  fugitiveRepo.count();
    }

    public String getImageByFugitiveId(Integer id){
        if (fugitiveRepo.findById(id).isPresent()){
            return fugitiveRepo.findById(id).get().getB64Image();
        }
        return null;
    }

}
