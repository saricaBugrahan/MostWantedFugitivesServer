package com.fugitive.server.controller;

import com.fugitive.server.model.Fugitive;
import com.fugitive.server.service.FugitiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

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
    public ResponseEntity<Iterable<Fugitive>> getAllFugitives(){
        return ResponseEntity.ok().body(fugitiveService.getAllFugitives());
    }

    @GetMapping("/all/{color}")
    public ResponseEntity<List<Fugitive>> findAllByColor(@PathVariable String color){
        return ResponseEntity.ok().body(fugitiveService.findFugitivesByColor(color));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Optional<Fugitive>> getFugitiveById(@PathVariable Integer id){
        return ResponseEntity.ok().body(fugitiveService.getFugitiveById(id));
    }


    @GetMapping("/count")
    public ResponseEntity<Long> countFugitives(){
        return ResponseEntity.ok().body(fugitiveService.countFugitives());
    }
    @GetMapping("/image/{id}")
    public ResponseEntity<String> getImageByFugitiveId(@PathVariable Integer id){
        return ResponseEntity.ok().body(fugitiveService.getImageByFugitiveId(id));
    }
}
