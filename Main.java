package com.company;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    static int dims = 8; // dimensions of the chessboard (dims x dims)
    static int trials  = 1000000; // trials

    public static void main(String[] args) {
        Random r = new Random();

        /*
        * Random walk of a king
        * */
        int[] kingTimes = new int[trials];
        for (int i = 0; i < kingTimes.length; i++) {
            Board b = new Board(dims);
            int randX = r.nextInt(dims);
            int randY = r.nextInt(dims);
            Square initSquare = b.getSquare(randX, randY);

            King myKing = new King(initSquare);
            initSquare.put(myKing);

            int numMoves = 0;
            while (!b.covered()) {

                LinkedList<Square> possibleMoves = myKing.getPossibleMoves(b);
                int ran = r.nextInt(possibleMoves.size());
                Square move = possibleMoves.get(ran);
                myKing.move(move);
                numMoves++;
            }
            kingTimes[i] = numMoves;
            System.out.println(numMoves);
        }



        /*
        * Random walk of a knight
        * */
        int[] knightTimes = new int[kingTimes.length];
        for (int i = 0; i < knightTimes.length; i++) {
            Board b = new Board(dims);
            Square[][] array = b.getSquareArray();
            int randX = r.nextInt(8);
            int randY = r.nextInt(8);
            Square initSquare = b.getSquare(randX, randY);

            Knight myKnight = new Knight(initSquare);
            initSquare.put(myKnight);

            int numMoves = 0;
            while (!b.covered()) {
                LinkedList<Square> possibleMoves = myKnight.getPossibleMoves(b);
                int ran = r.nextInt(possibleMoves.size());
                Square move = possibleMoves.get(ran);
                myKnight.move(move);
                numMoves++;
            }
            knightTimes[i] = numMoves;
            System.out.println(numMoves);
        }


        int kingSum = 0;
        int knightSum = 0;
        for (int i = 0; i < kingTimes.length; i++){
            kingSum += kingTimes[i];
            knightSum += knightTimes[i];
        }

        double kingAverage = kingSum/kingTimes.length;
        double knightAverage = knightSum/knightTimes.length;

        System.out.println("Mean cover time of a king on a chessboard (" + kingTimes.length + " trials): "
                + kingAverage + " moves");
        System.out.println("Mean cover time of a knight on a chessboard (" + knightTimes.length + " trials): "
                + knightAverage + " moves");
    }
}
