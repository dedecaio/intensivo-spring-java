package com.caio.dslist.controllers;

import com.caio.dslist.dto.GameMinDTO;
import com.caio.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping("")
    public List<GameMinDTO> listGames(){
        return service.listAllGames();
    }
}
