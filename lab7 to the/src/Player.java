public class Player {
    private int missCounter;
    private int strikeCounter;
    private int totalMisses;
    private int totalHits;

    public void hit() {
        missCounter = 0;
        totalHits++;
    }

    public void miss() {
        missCounter++;
        totalMisses++;
        if (missCounter == 5) {
            strikeCounter++;
            missCounter = 0;
        }
    }

    public boolean lost() {
        return strikeCounter >= 3;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public int getTotalMisses() {
        return totalMisses;
    }

    public int getMissCounter() {
        return missCounter;
    }

    public int getStrikeCounter() {
        return strikeCounter;
    }

    public void reset() {
        missCounter = strikeCounter = totalMisses = totalHits = 0;
    }
}
