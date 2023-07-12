package com.caio.dslist.services;

import com.caio.dslist.dto.GameListDTO;
import com.caio.dslist.entities.GameList;
import com.caio.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    public GameListService(GameListRepository repository) {
        this.gameListRepository = repository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> listAllGamesList(){
        List<GameList> games = gameListRepository.findAll();
        List<GameListDTO> gameMinDTOList = new ArrayList<>();
        for(GameList game : games){
            GameListDTO gameListDTO = new GameListDTO(game);
            gameMinDTOList.add(gameListDTO);
        }
        return gameMinDTOList;

    }



}
