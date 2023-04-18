// N-Queens problem solver
function solveNQueens(n) {
  const board = Array.from({ length: n }, () =>
    Array.from({ length: n }, () => 0)
  );
  const result = [];
  placeQueens(board, 0, result);
  return result;
}

function placeQueens(board, row, result) {
  if (row === board.length) {
    const solution = board.map((row) => row.join(""));
    result.push(solution);
    return;
  }

  for (let col = 0; col < board.length; col++) {
    if (isValid(board, row, col)) {
      board[row][col] = 1;
      placeQueens(board, row + 1, result);
      board[row][col] = 0;
    }
  }
}

function isValid(board, row, col) {
  for (let i = 0; i < row; i++) {
    if (board[i][col] === 1) {
      return false;
    }
    const diagonalRow = row - i;
    if (col - diagonalRow >= 0 && board[i][col - diagonalRow] === 1) {
      return false;
    }
    if (col + diagonalRow < board.length && board[i][col + diagonalRow] === 1) {
      return false;
    }
  }
  return true;
}

// Example usage
const solutions = solveNQueens(8);
const solutionsDiv = document.getElementById("solutions");
solutions.forEach((solution) => {
  const boardDiv = document.createElement("div");
  boardDiv.classList.add("board");
  boardDiv.style.setProperty("--n", solution.length);
  solution.forEach((row) => {
    const rowDiv = document.createElement("div");
    for (let i = 0; i < row.length; i++) {
      const cellDiv = document.createElement("div");
      if (row[i] === "1") {
        cellDiv.classList.add("queen");
      }
      rowDiv.appendChild(cellDiv);
    }
    boardDiv.appendChild(rowDiv);
  });
  solutionsDiv.appendChild(boardDiv);
});
