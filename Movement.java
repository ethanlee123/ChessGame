package A00990753;

interface Movement {
  // Piece movement logic (ex. Knight moves in L shape)
  boolean isValidMovement(Board board, Tile fromThisTile, Tile toThisTile);

  // Returns a 2d int array, where 1 is a valid move, 0 is not a valid move.
  int[][] generateValidMovements(Board board, Tile fromThisTile);
}
