package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.DTO.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;


@Service
public class GameListService {
	@Autowired
	private GameListRepository gameRepository;
	
	
	public List<GameListDTO> findAll(){
	List<GameList>	result = gameRepository.findAll();
	return  result.stream().map(x -> new GameListDTO(x)).toList();
	
	}
}
