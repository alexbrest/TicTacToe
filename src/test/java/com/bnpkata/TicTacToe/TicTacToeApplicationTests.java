package com.bnpkata.TicTacToe;

import static org.assertj.core.api.Assertions.assertThat;

import com.bnpkata.tictactoe.controllers.APIController;
import com.bnpkata.tictactoe.game.Game;
import com.bnpkata.tictactoe.game.Move;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TicTacToeApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private APIController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	//Game is loaded
	@Test
	public void gameLoaded() throws Exception {
		assertThat(controller.ticTacToeGame).isNotNull();
	}

	//Can make a move
	@Test
	public void canMakeMove() throws Exception {
		
		controller.ticTacToeGame = new Game();
		Move newMove = new Move();

		newMove.setPlayer('x');
		newMove.setRow(1);
		newMove.setCol(1);
		assertThat(controller.ticTacToeGame.recordMove(newMove)).isTrue();
	}

	//Can't make a move in filled field
	@Test
	public void cantReplaceMove() throws Exception {
		
		controller.ticTacToeGame = new Game();
		Move newMove = new Move();

		newMove.setPlayer('x');
		newMove.setRow(1);
		newMove.setCol(1);
		controller.ticTacToeGame.recordMove(newMove);
		
		newMove.setPlayer('o');
		
		assertThat(controller.ticTacToeGame.recordMove(newMove)).isFalse();
	}

	//Game ends on win
	@Test
	public void gameEndsOnWin() throws Exception {
		
		controller.ticTacToeGame = new Game();
		Move newMove = new Move();

		newMove.setPlayer('x');
		newMove.setRow(0);
		newMove.setCol(0);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('o');
		newMove.setRow(0);
		newMove.setCol(1);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('x');
		newMove.setRow(1);
		newMove.setCol(0);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('o');
		newMove.setRow(0);
		newMove.setCol(2);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('x');
		newMove.setRow(2);
		newMove.setCol(0);
		controller.ticTacToeGame.recordMove(newMove);
		
		assertThat(controller.ticTacToeGame.getWinner() == 'x').isTrue();
	}

	//Game ends on draw
	@Test
	public void gameEndsOnDraw() throws Exception {
	
		controller.ticTacToeGame = new Game();
		Move newMove = new Move();

		newMove.setPlayer('x');
		newMove.setRow(0);
		newMove.setCol(0);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('o');
		newMove.setRow(1);
		newMove.setCol(0);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('x');
		newMove.setRow(0);
		newMove.setCol(1);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('o');
		newMove.setRow(1);
		newMove.setCol(1);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('x');
		newMove.setRow(1);
		newMove.setCol(2);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('o');
		newMove.setRow(0);
		newMove.setCol(2);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('x');
		newMove.setRow(2);
		newMove.setCol(0);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('o');
		newMove.setRow(2);
		newMove.setCol(1);
		controller.ticTacToeGame.recordMove(newMove);

		newMove.setPlayer('x');
		newMove.setRow(2);
		newMove.setCol(2);
		controller.ticTacToeGame.recordMove(newMove);
		
		assertThat(controller.ticTacToeGame.getWinner() == 'd').isTrue();
	}

}
