package com.caio.dslist.services;

import com.caio.dslist.dto.GameMinDTO;
import com.caio.dslist.entities.Game;
import com.caio.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private GameRepository repository;

    @Autowired
    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<GameMinDTO> listAllGames(){
        List<Game> games = repository.findAll();
        List<GameMinDTO> gameMinDTOList = new ArrayList<>();
        for(Game game : games){
            GameMinDTO gameMinDTO = new GameMinDTO(game);
            gameMinDTOList.add(gameMinDTO);
        }
        return gameMinDTOList;
    }

}
