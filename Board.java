package com.company;

public class Board {
    private final Square[][] board;
    private String piece;
    int dims;

    public Board(int dims) {
        this.dims = dims;
        board = new Square[dims][dims];
        for (int x = 0; x < this.getDims(); x++) {
            for (int y = 0; y < this.getDims(); y++) {
                board[x][y] = new Square(this, false, x, y);
            }
        }
    }

    public Square getSquare(int x, int y){
        return board[x][y];
    }

    public Square[][] getSquareArray() {
        return this.board;
    }

    public int getDims(){
        return this.dims;
    }

    public void printBoard(){
        for (int y = 0; y < this.getDims(); y++) {
            for (int x = 0; x < this.getDims(); x++) {
                if(board[x][y].getOccupyingPiece() == null){
                    if(board[x][y].isVisited()) {
                        System.out.print("1 ");
                    }else{
                        System.out.print("0 ");
                    }
                }else{
                    if(board[x][y].getOccupyingPiece().toString() == "King") {
                        System.out.print("K ");
                    }
                    if(board[x][y].getOccupyingPiece().toString() == "Knight") {
                        System.out.print("Kn");
                    }
                }

            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean covered(){
        for (int y = 0; y < this.getDims(); y++) {
            for (int x = 0; x < this.getDims(); x++) {
                if(!board[x][y].isVisited()){
                    return false;
                }
            }
        }
        return true;
    }

}
