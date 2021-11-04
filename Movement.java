package A00990753;

interface Movement {
  // Return true if we are allowed to move to "toThisTile", false otherwise.
  boolean isValidMovement(Board board, Tile fromThisTile, Tile toThisTile);

  // Returns a 2d int array, where 1 is a valid move, 0 is not a valid move.
  int[][] generateValidMovements(Board board, Tile fromThisTile);
}
