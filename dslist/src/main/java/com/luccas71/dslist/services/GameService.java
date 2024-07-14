package com.luccas71.dslist.services;

import com.luccas71.dslist.dto.GameMinDTO;
import com.luccas71.dslist.entities.Game;
import com.luccas71.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    // injeção de dependência
    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll(){
        List<Game> games = gameRepository.findAll();
        return games;
    }
}
