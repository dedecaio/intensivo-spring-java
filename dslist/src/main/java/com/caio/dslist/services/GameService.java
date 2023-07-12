package com.caio.dslist.services;

import com.caio.dslist.dto.GameDTO;
import com.caio.dslist.dto.GameMinDTO;
import com.caio.dslist.entities.Game;
import com.caio.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private GameRepository repository;

    @Autowired
    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> listAllGames(){
        List<Game> games = repository.findAll();
        List<GameMinDTO> gameMinDTOList = new ArrayList<>();
        for(Game game : games){
            GameMinDTO gameMinDTO = new GameMinDTO(game);
            gameMinDTOList.add(gameMinDTO);
        }
        return gameMinDTOList;

    }


    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Optional<Game> game = repository.findById(id);
        if(game == null){
            throw new RuntimeException("Game not found - "+ id);
        }else {
            return new GameDTO(game.get());
        }

    }
}
