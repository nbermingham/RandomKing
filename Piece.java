package com.company;

import java.util.List;
import java.util.Random;

public abstract class Piece {
    private Square currentSquare;

    public Piece(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public boolean move(Square finSquare){
        this.currentSquare.setVisited();
        this.currentSquare.remove();
        this.currentSquare = finSquare;
        currentSquare.put(this);
        return true;
    }

    public Square getPosition(){
        return currentSquare;
    }

    public void setPosition(Square sq) {
        this.currentSquare = sq;
    }

    public abstract List<Square> getPossibleMoves(Board b);
    public abstract String toString();

}
