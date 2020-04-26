package com.company;

import com.company.Board;
import com.company.Piece;
import com.company.Square;

import java.util.LinkedList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Square currentSquare){
        super(currentSquare);
    }

    public String toString(){
        return "Knight";
    }

    @Override
    public LinkedList<Square> getPossibleMoves(Board b) {
        LinkedList<Square> possibleMoves = new LinkedList<Square>();
        Square[][] board = b.getSquareArray();
        int x = this.getPosition().getXNum();
        int y = this.getPosition().getYNum();

        for (int i = 2; i > -3; i--) {
            for (int k = 2; k > -3; k--) {
                if(Math.abs(i) == 2 ^ Math.abs(k) == 2) {
                    if (k != 0 && i != 0) {
                        try {
                            possibleMoves.add(board[y + k][x + i]);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }
                    }
                }
            }
        }

        return possibleMoves;
    }
}
