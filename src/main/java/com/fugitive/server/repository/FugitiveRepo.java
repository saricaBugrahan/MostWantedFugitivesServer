package com.fugitive.server.repository;

import com.fugitive.server.model.Fugitive;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FugitiveRepo extends JpaRepository<Fugitive, Integer> {

   @Transactional
   List<Fugitive> findFugitivesByColor(String color);
}
