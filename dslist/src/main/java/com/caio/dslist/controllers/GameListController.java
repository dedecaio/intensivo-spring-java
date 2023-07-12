package com.caio.dslist.controllers;

import com.caio.dslist.dto.GameDTO;
import com.caio.dslist.dto.GameListDTO;
import com.caio.dslist.dto.GameMinDTO;
import com.caio.dslist.services.GameListService;
import com.caio.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {
    @Autowired
    private GameListService service;



    @Autowired
    private GameService gameService;


    @GetMapping
    public List<GameListDTO> findAll(){
        return service.listAllGamesList();
    }
    @GetMapping("/{id}/games")
    public List<GameMinDTO> listGameBylists(@PathVariable Long id){
        return gameService.findByList(id);
    }
}
