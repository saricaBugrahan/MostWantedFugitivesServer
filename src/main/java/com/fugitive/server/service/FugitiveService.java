package com.fugitive.server.service;

import com.fugitive.server.model.Fugitive;
import com.fugitive.server.repository.FugitiveRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FugitiveService {

    private final FugitiveRepo fugitiveRepo;

    public List<Fugitive> getAllFugitives(){
        return fugitiveRepo.findAll();
    }

    public List<Fugitive> getAllFugitivesByColor(String color){
        return fugitiveRepo.findAllByColor(color);
    }

    public Fugitive saveFugitive(Fugitive fugitive){
        fugitive.setCreatedDate(LocalDateTime.now());
        fugitiveRepo.save(fugitive);
        return fugitive;
    }
    public void saveFugitives(List<Fugitive> fugitives){
        fugitives.forEach(fugitive -> fugitive.setCreatedDate(LocalDateTime.now()));
        fugitiveRepo.saveAll(fugitives);
    }

    public Fugitive getFugitiveById(Integer id){
        if (fugitiveRepo.findById(id).isPresent()){
            return fugitiveRepo.findById(id).get();
        }
        log.error("Fugitive with id: {} not found", id);
        return null;
    }

    public void deleteFugitiveById(Integer id){
        if (fugitiveRepo.findById(id).isPresent()){
            fugitiveRepo.deleteById(id);
        }
        log.error("Fugitive with id: {} not exist in the database", id);
    }
    public int countFugitives(){
        return (int) fugitiveRepo.count();
    }

    public String getImageByFugitiveId(Integer id){
        if (fugitiveRepo.findById(id).isPresent()){
            return fugitiveRepo.findById(id).get().getB64Image();
        }
        return null;
    }

}
