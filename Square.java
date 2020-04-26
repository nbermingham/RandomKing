package com.company;

public class Square {
    private Board b;
    private boolean visited;
    private Piece occupyingPiece;

    private int xNum;
    private int yNum;

    public Square(Board b, boolean visited, int xNum, int yNum) {
        this.b = b;
        this.visited = visited;
        this.xNum = xNum;
        this.yNum = yNum;
    }

    public Piece getOccupyingPiece() {
        return occupyingPiece;
    }

    public boolean isVisited(){
        return visited;
    }

    public void setVisited(){
        this.visited = true;
    }

    public int getXNum() {
        return this.xNum;
    }

    public int getYNum() {
        return this.yNum;
    }

    public void put(Piece p) {
        this.occupyingPiece = p;
        p.setPosition(this);
    }

    public void remove() {
        this.occupyingPiece = null;
    }

    /*@Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + xNum;
        result = prime * result + yNum;
        return result;
    }*/
}
