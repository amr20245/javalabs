public class Cell {
    private boolean hasShip;
    private boolean isHit;

    public Cell() {
        hasShip = false;
        isHit = false;
    }

    public boolean hasShip() {
        return hasShip;
    }

    public void placeShip() {
        hasShip = true;
    }

    public boolean isHit() {
        return isHit;
    }

    public void hit() {
        isHit = true;
    }
}
