package com.fugitive.server.controller;

import com.fugitive.server.model.Fugitive;
import com.fugitive.server.service.FugitiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fugitives")
public class FugitiveController {

    private final FugitiveService fugitiveService;

    @Autowired
    public FugitiveController(FugitiveService fugitiveService) {
        this.fugitiveService = fugitiveService;
    }

    @GetMapping
    public ResponseEntity<String> mainPage(){
        return ResponseEntity.ok().body("Welcome to Fugitive API");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fugitive>> getAllFugitives(){
        return ResponseEntity.ok().body(fugitiveService.getAllFugitives());
    }

    @GetMapping("/all/{color}")
    public ResponseEntity<List<Fugitive>> getFugitivesByColor(@PathVariable String color){
        return ResponseEntity.ok().body(fugitiveService.getFugitivesByColor(color));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Fugitive> getFugitiveById(@PathVariable Integer id){
        return ResponseEntity.ok().body(fugitiveService.getFugitiveById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Fugitive> saveFugitive(@RequestBody Fugitive fugitive){
        return ResponseEntity.ok().body(fugitiveService.saveFugitive(fugitive));
    }

    @PostMapping("addAll")
    public  ResponseEntity<List<Fugitive>> saveFugitives(@RequestBody List<Fugitive> fugitives){
        fugitiveService.saveFugitives(fugitives);
        return ResponseEntity.ok().body(fugitives);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> countFugitives(){
        return ResponseEntity.ok().body(fugitiveService.countFugitives());
    }
    @GetMapping("/image/{id}")
    public ResponseEntity<String> getImageByFugitiveId(@PathVariable Integer id){
        return ResponseEntity.ok().body(fugitiveService.getImageByFugitiveId(id));
    }


}
