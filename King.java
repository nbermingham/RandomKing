package com.company;

import com.company.Board;

import java.util.LinkedList;
import java.util.List;

public class King extends Piece {

    public King(Square currentSquare){
        super(currentSquare);
    }

    @Override
    public String toString(){
        return "King";
    }

    @Override
    public LinkedList<Square> getPossibleMoves(Board b){
        LinkedList<Square> possibleMoves = new LinkedList<Square>();
        Square[][] board = b.getSquareArray(); // get the board array
        int x = this.getPosition().getXNum(); // get x position of king
        int y = this.getPosition().getYNum(); // get y position of king

        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++){
                if(!(i == 0 && j == 0)) {
                    try {
                        possibleMoves.add(board[x + i][y + j]);
                    } catch (ArrayIndexOutOfBoundsException e){
                        continue;
                    }
                }
            }
        }
        return possibleMoves;
    }

}
