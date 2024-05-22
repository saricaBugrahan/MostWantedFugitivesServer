package com.fugitive.server.service;
import com.fugitive.server.model.Fugitive;
import com.fugitive.server.repository.FugitiveRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class FugitiveServiceTest {

    @Mock
    private FugitiveRepo fugitiveRepo;

    private  FugitiveService fugitiveService;

    @BeforeEach
    public void setUp(){
        this.fugitiveService = new FugitiveService(fugitiveRepo);
    }

    @Test
    void contextLoads() {
        assertThat(fugitiveService).isNotNull();
    }

    @Test
    void getAllFugitives(){
        Mockito.when(fugitiveRepo.findAll()).thenReturn(
                Arrays.asList(
                        new Fugitive(1,"bugra","sarica",null,null,"red",null,null,null),
                        new Fugitive(1,"test","test",null,null,"red",null,null,null)
                )
        );
        Iterable<Fugitive> allFugitives = fugitiveService.getAllFugitives();
        assertEquals(allFugitives.iterator().next().getName(),"bugra");

    }

    @Test
    void findFugitivesByColor() {
        List<Fugitive> redList = new ArrayList<>();
        redList.add(new Fugitive(1,"bugra","sarica",null,null,"red",null,null,null));
        redList.add(new Fugitive(1,"test","test",null,null,"red",null,null,null));
        Mockito.when(fugitiveRepo.findFugitivesByColor("red")).thenReturn(redList);
        assertEquals(fugitiveService.findFugitivesByColor("red").size(),redList.size());
        assertEquals(fugitiveService.findFugitivesByColor("red"),redList);
    }


    @Test
    void getFugitiveById() {
        Mockito.when(fugitiveRepo.findById(1)).thenReturn(
                Optional.of(new Fugitive(1, "Bugra", "Sarica",
                        null, null, null, null, null, null))
        );
        Optional<Fugitive> inRepoFugitive = fugitiveService.getFugitiveById(1);
        Optional<Fugitive>  notInRepoFugitive = fugitiveService.getFugitiveById(2);

        assertEquals(inRepoFugitive.orElseThrow().getName(),"Bugra");
        assertEquals(inRepoFugitive.orElseThrow().getSurname(),"Sarica");
        assertTrue(notInRepoFugitive.isEmpty());
    }

    @Test
    void deleteFugitiveById() {
        //TODO
    }

    @Test
    void countFugitives() {
        Mockito.when(fugitiveRepo.count()).thenReturn(10L);
        long countOfFugitives = fugitiveService.countFugitives();
        Mockito.verify(fugitiveRepo,times(1)).count();
        assertEquals(countOfFugitives,10L);
    }

    @Test
    void getImageByFugitiveId() {
        //TODO
    }
}