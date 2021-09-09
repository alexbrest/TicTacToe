//Parse game state
function parseGameState(gameState){
    //Handle cells
    var cells = document.getElementsByClassName("cell");
    for(var i=0; i < cells.length; i++) {
        
        col = i % 3;
        row = (i - col) / 3;

        cellValue = gameState.gameState[row][col];

        if(cellValue != ' ')
            cells[i].classList.add(gameState.gameState[row][col]);
        else
            cells[i].classList.remove('x', 'o');

        cells[i].dataset.row = row;
        cells[i].dataset.col = col;

        cells[i].onclick = function(){
            makeMove(gameState.playerTurn);
        }
    }

    //Handle next player
    var gameDiv = document.getElementById("game");
    gameDiv.classList.remove("nextx", "nexto");
    gameDiv.classList.add("next" + gameState.playerTurn);

    //Display last result
    if(gameState.winner == 'x' || gameState.winner == 'o'){
        document.getElementById("lastgame").classList.remove("hidden");
        document.getElementById("lastgame").innerHTML = "<p>Last game was won by: <span class=\"result_image " + gameState.winner + "\"></span></p>";
    }
    else if(gameState.winner == 'd'){
        document.getElementById("lastgame").classList.remove("hidden");
        document.getElementById("lastgame").innerHTML = "Last game was won by: Draw";
    }
        
}

//Load game on page load
function loadGameState(){
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var gameState = JSON.parse(this.responseText);
            parseGameState(gameState);
        }
    };
    xmlhttp.open("GET", "/game", true);
    xmlhttp.send();
}

//Make Move
function makeMove(playerTurn){
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var gameState = JSON.parse(this.responseText);
            parseGameState(gameState);
        }
    };
    xmlhttp.open("POST", "/makeMove", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({ "player": playerTurn, "row": event.currentTarget.dataset.row, "col": event.currentTarget.dataset.col}));
}

//Load the game data
loadGameState();