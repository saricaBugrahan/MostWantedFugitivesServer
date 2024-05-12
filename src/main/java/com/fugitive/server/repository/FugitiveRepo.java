package com.fugitive.server.repository;

import com.fugitive.server.model.Fugitive;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FugitiveRepo extends JpaRepository<Fugitive, Integer> {
    List<Fugitive> findAllByColor(String color);
}
