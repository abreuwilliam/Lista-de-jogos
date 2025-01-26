package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.DTO.GameListDTO;
import com.devsuperior.dslist.DTO.GameMinDTO;
import com.devsuperior.dslist.DTO.ReplacementDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}

	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findGames(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByGameList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public ResponseEntity<?> move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		System.out.println("Recebido listId: " + listId);  // Verifique se o listId está sendo passado corretamente
		System.out.println("Conteúdo recebido no corpo: " + body); // Log do corpo da requisição (verifique os dados do body)
	
	
		try {
			// Verifique os índices de origem e destino
			System.out.println("Source Index: " + body.getSourceIndex());
			System.out.println("Destination Index: " + body.getDestinationIndex());
	
			// Chama o serviço para atualizar a ordem
			gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
			System.out.println("Ordem movida com sucesso!"); // Confirma que a ordem foi movida
	
			return ResponseEntity.ok("Ordem atualizada com sucesso!");
		} catch (Exception e) {
			System.err.println("Erro ao atualizar a ordem: " + e.getMessage());
			e.printStackTrace(); // Log completo da exceção
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar a ordem.");
		}
	}}