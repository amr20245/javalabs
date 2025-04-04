import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
    public static final int SIZE = 10;
    private Cell[][] grid;
    private ArrayList<Ship> ships;

    public GameBoard() {
        grid = new Cell[SIZE][SIZE];
        ships = new ArrayList<>();

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                grid[i][j] = new Cell();

        placeShips();
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean fire(int row, int col) {
        Cell cell = getCell(row, col);
        if (cell.isHit()) return false;

        cell.hit();
        if (cell.hasShip()) {
            for (Ship ship : ships) {
                for (int[] coord : ship.getCoordinates()) {
                    if (coord[0] == row && coord[1] == col) {
                        ship.registerHit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void placeShips() {
        int[] shipSizes = {5, 4, 3, 3, 2};
        Random rand = new Random();

        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                boolean horizontal = rand.nextBoolean();
                int row = rand.nextInt(SIZE);
                int col = rand.nextInt(SIZE);

                if (canPlace(row, col, size, horizontal)) {
                    Ship ship = new Ship(size);
                    for (int i = 0; i < size; i++) {
                        int r = row + (horizontal ? 0 : i);
                        int c = col + (horizontal ? i : 0);
                        grid[r][c].placeShip();
                        ship.addCoordinate(r, c);
                    }
                    ships.add(ship);
                    placed = true;
                }
            }
        }
    }

    private boolean canPlace(int row, int col, int size, boolean horizontal) {
        for (int i = 0; i < size; i++) {
            int r = row + (horizontal ? 0 : i);
            int c = col + (horizontal ? i : 0);
            if (r >= SIZE || c >= SIZE || grid[r][c].hasShip()) return false;
        }
        return true;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }
}
