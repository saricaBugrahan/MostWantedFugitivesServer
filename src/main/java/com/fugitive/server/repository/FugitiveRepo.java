package com.fugitive.server.repository;

import com.fugitive.server.model.Fugitive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FugitiveRepo extends JpaRepository<Fugitive, Integer> {

    @Query("SELECT f FROM Fugitive f WHERE f.color = :color")
    List<Fugitive> getFugitivesByColor(@Param("color") String color);
}
