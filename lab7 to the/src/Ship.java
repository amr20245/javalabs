import java.util.ArrayList;

public class Ship {
    private int size;
    private ArrayList<int[]> coordinates;
    private int hits;

    public Ship(int size) {
        this.size = size;
        this.coordinates = new ArrayList<>();
        this.hits = 0;
    }

    public void addCoordinate(int row, int col) {
        coordinates.add(new int[]{row, col});
    }

    public boolean isSunk() {
        return hits >= size;
    }

    public void registerHit() {
        hits++;
    }

    public ArrayList<int[]> getCoordinates() {
        return coordinates;
    }

    public int getSize() {
        return size;
    }
}
