package com.luccas71.dslist.controllers;

import com.luccas71.dslist.dto.GameDTO;
import com.luccas71.dslist.dto.GameMinDTO;
import com.luccas71.dslist.entities.Game;
import com.luccas71.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<Game> games = gameService.findAll();
        //transformando uma lista de games em uma lista de GameMinDTO
        List<GameMinDTO> dto = games.stream().map(GameMinDTO::new).toList();
        return dto;
    }
}
