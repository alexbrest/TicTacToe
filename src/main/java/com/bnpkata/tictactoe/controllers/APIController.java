package com.bnpkata.tictactoe.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bnpkata.tictactoe.game.Game;
import com.bnpkata.tictactoe.game.Move;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class APIController {
	
	@Autowired
	public Game ticTacToeGame;

    @GetMapping("/")
	public String index() {
		return String.format("<a href=\"/display\">To the game</a>");
	}

	@GetMapping(value = "/game", produces = "application/json")
	public Game game() {
		return ticTacToeGame;
	}
	
	@PostMapping(value = "/makeMove", consumes = "application/json", produces = "application/json")
	public Game makeMove(@RequestBody Move move) {

		ticTacToeGame.recordMove(move);

		return ticTacToeGame;
	}

}