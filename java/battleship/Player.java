public class Player {
    Set<String> successfulHits;
    Set<String> shipPositions;

    public Player () {

    }

    public Set<String> getSuccessfulHits () {
        return successfulHits;
    }

    public void setSuccessfulHits (Set<String> successfulHits) {
        this.successfulHits = successfulHits;
    }

    public Set<String> getShipPositions () {
        return shipPositions;
    }

    public void setShipPositions (Set<String> shipPositions) {
        this.shipPositions = shipPositions;
    }

    public boolean addPosition(String position) {
        return shipPositions.add(position);
    }

    public String removePosition(String position) {
        return shipPositions.remove(position);
    }

    public boolean attemptHitOnPosiiton(String position) {
        return shipPositions.contains(position);
    }

    public boolean addHit(String hitPosition) {
        return successfulHits.add(hitPosition);
    }
}