package com.luccas71.dslist.services;

import com.luccas71.dslist.dto.GameDTO;
import com.luccas71.dslist.dto.GameMinDTO;
import com.luccas71.dslist.entities.Game;
import com.luccas71.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    // injeção de dependência
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        //precisa usar o get() para extrair o valor do optional
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<Game> findAll(){
        List<Game> games = gameRepository.findAll();
        return games;
    }
}
