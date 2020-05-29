final class Tuple {
    private boolean first;
    private char second;

    public Tuple(boolean first, char second) {
        this.first = first;
        this.second = second;
    }

    public boolean getFirst() {
        return first;
    }

    public char getSecond() {
        return second;
    }
    public void changeTuple(boolean first, char second){
        this.first = first;
        this.second = second;


    }
}
