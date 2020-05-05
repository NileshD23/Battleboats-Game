// written by Nilesh Domah

import java.util.Scanner;

public class BattleBoatsBoard {
    private int Rows;
    private int Cols;
    private char[][] Board;
    private int[][] boats;
    private int fiveRow1 = 0, fiveCol1 = 0, fourRow1 = 0, fourCol1 = 0, threeRow1 = 0, threeCol1 = 0, twoRow1 = 0, twoCol1 = 0, threeRow2 = 0, threeCol2 = 0;
    private int fiveRow2 = 0, fiveCol2 = 0, fourRow2 = 0, fourCol2 = 0, threeRow4 = 0, threeCol4 = 0, twoRow2 = 0, twoCol2 = 0, threeRow3 = 0, threeCol3 = 0;
    private int hit05 = 0, hit15 = 0, hit04 = 0, hit14 = 0, hit03 = 0, hit13 = 0, hit23 = 0, hit33 = 0, hit43 = 0, hit02 = 0, hit12 = 0;
    private int[][] turns=new int[100][2];
    private char[] orient = new char[10];
    private int count=0;
    private boolean fromDrone=false;
    private int value;

    public BattleBoatsBoard(int rows, int cols) {
        Rows = rows;
        Cols = cols;
        Board = new char[rows][cols];

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                Board[i][j] = '-';
            }
        }
    }//end Constructor


    // This is where is all starts.
    public void placeBoats() {
        boats = new int[Rows][Cols];

        int rand = (int) Math.floor(Math.random() * 100);
        String play = "";
        boolean keepGoing = true, first5 = true, sec5 = true, first4 = false, sec4 = false, first3 = true, sec3 = true, third3 = true, fourth3 = true, first2 = true, sec2 = true;
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                boats[i][j] = 0;
            }
        }//Create a Boats array to hold your boats

        if (Rows == 8) {
            int time = 5, size = 5;
            boolean tres = true;

            while (keepGoing) {
                //
                if (rand % 2 == 0) {
                    if (size == 5) {
                        fiveRow1 = (int) Math.floor(Math.random() * 10);
                        fiveCol1 = (int) Math.floor(Math.random() * 10);
                        while ((fiveRow1 > 7) || (fiveCol1 > 3)) {
                            fiveRow1 = (int) Math.floor(Math.random() * 10);
                            fiveCol1 = (int) Math.floor(Math.random() * 10);

                        }
                        orient[0] = 'h';
                        boats[fiveRow1][fiveCol1] = boats[fiveRow1][fiveCol1 + 1] = boats[fiveRow1][fiveCol1 + 2] = boats[fiveRow1][fiveCol1 + 3] = boats[fiveRow1][fiveCol1 + 4] = 5;
                    }

                    if (size == 4) {
                        fourRow1 = (int) Math.floor(Math.random() * 10);
                        fourCol1 = (int) Math.floor(Math.random() * 10);
                        while ((((fourRow1 > 7) || (fourRow1 == fiveRow1)) || (fourCol1 > 4)) || (boats[fourRow1][fourCol1] != 0) || (boats[fourRow1][fourCol1 + 1] != 0) || (boats[fourRow1][fourCol1 + 2] != 0) || (boats[fourRow1][fourCol1 + 3] != 0)) {
                            fourRow1 = (int) Math.floor(Math.random() * 10);
                            fourCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        boats[fourRow1][fourCol1] = boats[fourRow1][fourCol1 + 1] = boats[fourRow1][fourCol1 + 2] = boats[fourRow1][fourCol1 + 3] = 4;
                        orient[1] = 'h';
                    }
                    if (size == 3) {
                        if (tres) {
                            threeRow1 = (int) Math.floor(Math.random() * 10);
                            threeCol1 = (int) Math.floor(Math.random() * 10);
                            while (((threeRow1 > 7) || threeCol1 > 5) || (boats[threeRow1][threeCol1] != 0) || (boats[threeRow1][threeCol1 + 1] != 0) || (boats[threeRow1][threeCol1 + 2] != 0)) {
                                threeRow1 = (int) Math.floor(Math.random() * 10);
                                threeCol1 = (int) Math.floor(Math.random() * 10);
                            }
                            tres = false;
                            boats[threeRow1][threeCol1] = boats[threeRow1][threeCol1 + 1] = boats[threeRow1][threeCol1 + 2] = 3;
                            orient[2] = 'h';
                            size = 4;
                        } else {
                            threeRow2 = (int) Math.floor(Math.random() * 10);
                            threeCol2 = (int) Math.floor(Math.random() * 10);
                            while (((threeRow2 > 7) || threeCol2 > 5) || (boats[threeRow2][threeCol2] != 0) || (boats[threeRow2][threeCol2 + 1] != 0) || (boats[threeRow2][threeCol2 + 2] != 0)) {
                                threeRow2 = (int) Math.floor(Math.random() * 10);
                                threeCol2 = (int) Math.floor(Math.random() * 10);
                            }
                            boats[threeRow2][threeCol2] = boats[threeRow2][threeCol2 + 1] = boats[threeRow2][threeCol2 + 2] = 3;
                            orient[3] = 'h';
                        }
                    }
                    if (size == 2) {
                        twoRow1 = (int) Math.floor(Math.random() * 10);
                        twoCol1 = (int) Math.floor(Math.random() * 10);
                        while (((twoRow1 > 7) || twoCol1 > 6) || (boats[twoRow1][twoCol1] != 0) || (boats[twoRow1][twoCol1 + 1] != 0)) {
                            twoRow1 = (int) Math.floor(Math.random() * 10);
                            twoCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        boats[twoRow1][twoCol1] = boats[twoRow1][twoCol1 + 1] = 2;
                        keepGoing = false;
                        orient[4] = 'h';
                    }
                } else {
                    if (size == 5) {
                        fiveRow1 = (int) Math.floor(Math.random() * 10);
                        fiveCol1 = (int) Math.floor(Math.random() * 10);
                        while ((fiveRow1 > 3) || (fiveCol1 > 7)) {
                            fiveRow1 = (int) Math.floor(Math.random() * 10);
                            fiveCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        boats[fiveRow1][fiveCol1] = boats[fiveRow1 + 1][fiveCol1] = boats[fiveRow1 + 2][fiveCol1] = boats[fiveRow1 + 3][fiveCol1] = boats[fiveRow1 + 4][fiveCol1] = 5;
                        orient[0] = 'v';
                    }

                    if (size == 4) {
                        fourRow1 = (int) Math.floor(Math.random() * 10);
                        fourCol1 = (int) Math.floor(Math.random() * 10);
                        while ((((fourRow1 > 4) || (fourCol1 == fiveCol1)) || (fourCol1 > 7)) || (boats[fourRow1][fourCol1] != 0) || (boats[fourRow1 + 1][fourCol1] != 0) || (boats[fourRow1 + 2][fourCol1] != 0) || (boats[fourRow1 + 3][fourCol1] != 0)) {
                            fourRow1 = (int) Math.floor(Math.random() * 10);
                            fourCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        boats[fourRow1][fourCol1] = boats[fourRow1 + 1][fourCol1] = boats[fourRow1 + 2][fourCol1] = boats[fourRow1 + 3][fourCol1] = 4;
                        orient[1] = 'v';
                    }

                    if (size == 3) {
                        if (tres) {
                            threeRow1 = (int) Math.floor(Math.random() * 10);
                            threeCol1 = (int) Math.floor(Math.random() * 10);
                            while (((threeRow1 > 5) || threeCol1 > 7) || (boats[threeRow1][threeCol1] != 0) || (boats[threeRow1 + 1][threeCol1] != 0) || (boats[threeRow1 + 2][threeCol1] != 0)) {
                                threeRow1 = (int) Math.floor(Math.random() * 10);
                                threeCol1 = (int) Math.floor(Math.random() * 10);
                            }
                            tres = false;
                            boats[threeRow1][threeCol1] = boats[threeRow1 + 1][threeCol1] = boats[threeRow1 + 2][threeCol1] = 3;
                            size = 4;
                            orient[2] = 'v';
                        } else {
                            threeRow2 = (int) Math.floor(Math.random() * 10);
                            threeCol2 = (int) Math.floor(Math.random() * 10);
                            while (((threeRow2 > 5) || threeCol2 > 7) || (boats[threeRow2][threeCol2] != 0) || (boats[threeRow2 + 1][threeCol2] != 0) || (boats[threeRow2 + 2][threeCol2] != 0)) {
                                threeRow2 = (int) Math.floor(Math.random() * 10);
                                threeCol2 = (int) Math.floor(Math.random() * 10);
                            }
                            boats[threeRow2][threeCol2] = boats[threeRow2 + 1][threeCol2] = boats[threeRow2 + 2][threeCol2] = 3;
                            orient[3] = 'v';
                        }
                    }

                    if (size == 2) {
                        twoRow1 = (int) Math.floor(Math.random() * 10);
                        twoCol1 = (int) Math.floor(Math.random() * 10);
                        while (((twoRow1 > 6) || twoCol1 > 7) || (boats[twoRow1][twoCol1] != 0) || (boats[twoRow1 + 1][twoCol1] != 0)) {
                            twoRow1 = (int) Math.floor(Math.random() * 10);
                            twoCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        boats[twoRow1][twoCol1] = boats[twoRow1 + 1][twoCol1] = 2;
                        orient[4] = 'v';
                        System.out.println("Location of 2 row and col"+twoRow1+ ""+ twoCol1 +"\n");
                        keepGoing = false;

                    }
                }
                size = size - 1;
                rand = (int) Math.floor(Math.random() * 100);
                time = time - 1;

            }

            for (int i = 0; i < Rows; i++) {
                for (int j = 0; j < Cols; j++) {
                    play += boats[i][j] + " ";
                }
                play += "\n";
            }

        } else {
            int time = 10;
            boolean boat1 = true, boat3 = true;
            while (keepGoing) {
                if (rand % 2 == 0) {
                    if (time == 10) {
                        fiveRow1 = (int) Math.floor(Math.random() * 10);
                        fiveCol1 = (int) Math.floor(Math.random() * 10);
                        while ((fiveRow1 > 11) || (fiveCol1 > 7)) {
                            fiveRow1 = (int) Math.floor(Math.random() * 10);
                            fiveCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[0] = 'h';
                        boats[fiveRow1][fiveCol1] = boats[fiveRow1][fiveCol1 + 1] = boats[fiveRow1][fiveCol1 + 2] = boats[fiveRow1][fiveCol1 + 3] = boats[fiveRow1][fiveCol1 + 4] = 5;
                    }
                    if (time == 9) {
                        fiveRow2 = (int) Math.floor(Math.random() * 10);
                        fiveCol2 = (int) Math.floor(Math.random() * 10);
                        while (((fiveRow2 > 11) || (fiveCol2 > 7)) || (boats[fiveRow2][fiveCol2] != 0) || (boats[fiveRow2][fiveCol2 + 1] != 0) || (boats[fiveRow2][fiveCol2 + 2] != 0) || (boats[fiveRow2][fiveCol2 + 3] != 0) || (boats[fiveRow2][fiveCol2 + 4] != 0)) {
                            fiveRow2 = (int) Math.floor(Math.random() * 10);
                            fiveCol2 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[5] = 'h';
                        boats[fiveRow2][fiveCol2] = boats[fiveRow2][fiveCol2 + 1] = boats[fiveRow2][fiveCol2 + 2] = boats[fiveRow2][fiveCol2 + 3] = boats[fiveRow2][fiveCol2 + 4] = 5;
                    }
                    if (time == 8) {
                        fourRow1 = (int) Math.floor(Math.random() * 10);
                        fourCol1 = (int) Math.floor(Math.random() * 10);
                        while (((fourRow1 > 11) || (fourCol1 > 8)) || (boats[fourRow1][fourCol1] != 0) || (boats[fourRow1][fourCol1 + 1] != 0) || (boats[fourRow1][fourCol1 + 2] != 0) || (boats[fourRow1][fourCol1 + 3] != 0)) {
                            fourRow1 = (int) Math.floor(Math.random() * 10);
                            fourCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        boats[fourRow1][fourCol1] = boats[fourRow1][fourCol1 + 1] = boats[fourRow1][fourCol1 + 2] = boats[fourRow1][fourCol1 + 3] = 4;
                        orient[1] = 'h';
                    }
                    if (time == 7) {
                        fourRow2 = (int) Math.floor(Math.random() * 10);
                        fourCol2 = (int) Math.floor(Math.random() * 10);
                        while (((fourRow2 > 11) || (fourCol2 > 8)) || (boats[fourRow2][fourCol2] != 0) || (boats[fourRow2][fourCol2 + 1] != 0) || (boats[fourRow2][fourCol2 + 2] != 0) || (boats[fourRow2][fourCol2 + 3] != 0)) {
                            fourRow2 = (int) Math.floor(Math.random() * 10);
                            fourCol2 = (int) Math.floor(Math.random() * 10);
                        }
                        boats[fourRow2][fourCol2] = boats[fourRow2][fourCol2 + 1] = boats[fourRow2][fourCol2 + 2] = boats[fourRow2][fourCol2 + 3] = 4;
                        orient[6] = 'h';
                    }
                    if (time == 6) {
                        threeRow1 = (int) Math.floor(Math.random() * 10);
                        threeCol1 = (int) Math.floor(Math.random() * 10);
                        while (((threeRow1 > 11) || threeCol1 > 9) || (boats[threeRow1][threeCol1] != 0) || (boats[threeRow1][threeCol1 + 1] != 0) || (boats[threeRow1][threeCol1 + 2] != 0)) {
                            threeRow1 = (int) Math.floor(Math.random() * 10);
                            threeCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        boats[threeRow1][threeCol1] = boats[threeRow1][threeCol1 + 1] = boats[threeRow1][threeCol1 + 2] = 3;
                        orient[2] = 'h';
                    }

                    if (time == 5) {
                        threeRow2 = (int) Math.floor(Math.random() * 10);
                        threeCol2 = (int) Math.floor(Math.random() * 10);
                        while (((threeRow2 > 11) || threeCol2 > 9) || (boats[threeRow2][threeCol2] != 0) || (boats[threeRow2][threeCol2 + 1] != 0) || (boats[threeRow2][threeCol2 + 2] != 0)) {
                            threeRow2 = (int) Math.floor(Math.random() * 10);
                            threeCol2 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[3] = 'h';
                        boats[threeRow2][threeCol2] = boats[threeRow2][threeCol2 + 1] = boats[threeRow2][threeCol2 + 2] = 3;
                    }

                    if (time == 4) {
                        threeRow3 = (int) Math.floor(Math.random() * 10);
                        threeCol3 = (int) Math.floor(Math.random() * 10);
                        while (((threeRow3 > 11) || threeCol3 > 9) || (boats[threeRow3][threeCol3] != 0) || (boats[threeRow3][threeCol3 + 1] != 0) || (boats[threeRow3][threeCol3 + 2] != 0)) {
                            threeRow3 = (int) Math.floor(Math.random() * 10);
                            threeCol3 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[7] = 'h';
                        boats[threeRow3][threeCol3] = boats[threeRow3][threeCol3 + 1] = boats[threeRow3][threeCol3 + 2] = 3;
                    }

                    if (time == 3) {
                        threeRow4 = (int) Math.floor(Math.random() * 10);
                        threeCol4 = (int) Math.floor(Math.random() * 10);
                        while (((threeRow4 > 11) || threeCol4 > 9) || (boats[threeRow4][threeCol4] != 0) || (boats[threeRow4][threeCol4 + 1] != 0) || (boats[threeRow4][threeCol4 + 2] != 0)) {
                            threeRow4 = (int) Math.floor(Math.random() * 10);
                            threeCol4 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[8] = 'h';
                        boats[threeRow4][threeCol4] = boats[threeRow4][threeCol4 + 1] = boats[threeRow4][threeCol4 + 2] = 3;
                    }

                    if (time == 2) {
                        twoRow1 = (int) Math.floor(Math.random() * 10);
                        twoCol1 = (int) Math.floor(Math.random() * 10);
                        while (((twoRow1 > 11) || twoCol1 > 10) || (boats[twoRow1][twoCol1] != 0) || (boats[twoRow1][twoCol1 + 1] != 0)) {
                            twoRow1 = (int) Math.floor(Math.random() * 10);
                            twoCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[4] = 'h';
                        boats[twoRow1][twoCol1] = boats[twoRow1][twoCol1 + 1] = 2;
                    }

                    if (time == 1) {
                        twoRow2 = (int) Math.floor(Math.random() * 10);
                        twoCol2 = (int) Math.floor(Math.random() * 10);
                        while (((twoRow2 > 11) || twoCol2 > 10) || (boats[twoRow2][twoCol2] != 0) || (boats[twoRow2][twoCol2 + 1] != 0)) {
                            twoRow2 = (int) Math.floor(Math.random() * 10);
                            twoCol2 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[9] = 'h';
                        boats[twoRow2][twoCol2] = boats[twoRow2][twoCol2 + 1] = 2;
                        keepGoing = false;
                    }
                } else {
                    if (time == 10) {
                        fiveRow1 = (int) Math.floor(Math.random() * 10);
                        fiveCol1 = (int) Math.floor(Math.random() * 10);
                        while ((fiveRow1 > 7) || (fiveCol1 > 11)) {
                            fiveRow1 = (int) Math.floor(Math.random() * 10);
                            fiveCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        boats[fiveRow1][fiveCol1] = boats[fiveRow1 + 1][fiveCol1] = boats[fiveRow1 + 2][fiveCol1] = boats[fiveRow1 + 3][fiveCol1] = boats[fiveRow1 + 4][fiveCol1] = 5;
                        orient[0] = 'v';
                    }
                    if (time == 9) {
                        fiveRow2 = (int) Math.floor(Math.random() * 10);
                        fiveCol2 = (int) Math.floor(Math.random() * 10);
                        while (((fiveRow2 > 7) || (fiveCol2 > 11)) || (boats[fiveRow2][fiveCol2] != 0) || (boats[fiveRow2 + 1][fiveCol2] != 0) || (boats[fiveRow2 + 2][fiveCol2] != 0) || (boats[fiveRow2 + 3][fiveCol2] != 0) || (boats[fiveRow2 + 4][fiveCol2] != 0)) {
                            fiveRow2 = (int) Math.floor(Math.random() * 10);
                            fiveCol2 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[5] = 'v';
                        boats[fiveRow2][fiveCol2] = boats[fiveRow2 + 1][fiveCol2] = boats[fiveRow2 + 2][fiveCol2] = boats[fiveRow2 + 3][fiveCol2] = boats[fiveRow2 + 4][fiveCol2] = 5;
                    }

                    if (time == 8) {
                        fourRow1 = (int) Math.floor(Math.random() * 10);
                        fourCol1 = (int) Math.floor(Math.random() * 10);
                        while (((fourRow1 > 8) || (fourCol1 > 11)) || (boats[fourRow1][fourCol1] != 0) || (boats[fourRow1 + 1][fourCol1] != 0) || (boats[fourRow1 + 2][fourCol1] != 0) || (boats[fourRow1 + 3][fourCol1] != 0)) {
                            fourRow1 = (int) Math.floor(Math.random() * 10);
                            fourCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[1] = 'v';
                        boats[fourRow1][fourCol1] = boats[fourRow1 + 1][fourCol1] = boats[fourRow1 + 2][fourCol1] = boats[fourRow1 + 3][fourCol1] = 4;
                    }
                    if (time == 7) {
                        fourRow2 = (int) Math.floor(Math.random() * 10);
                        fourCol2 = (int) Math.floor(Math.random() * 10);
                        while (((fourRow2 > 8) || (fourCol2 > 11)) || (boats[fourRow2][fourCol2] != 0) || (boats[fourRow2 + 1][fourCol2] != 0) || (boats[fourRow2 + 2][fourCol2] != 0) || (boats[fourRow2 + 3][fourCol2] != 0)) {
                            fourRow2 = (int) Math.floor(Math.random() * 10);
                            fourCol2 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[6] = 'v';
                        boats[fourRow2][fourCol2] = boats[fourRow2 + 1][fourCol2] = boats[fourRow2 + 2][fourCol2] = boats[fourRow2 + 3][fourCol2] = 4;
                    }
                    if (time == 6) {
                        threeRow1 = (int) Math.floor(Math.random() * 10);
                        threeCol1 = (int) Math.floor(Math.random() * 10);
                        while (((threeRow1 > 9) || threeCol1 > 11) || (boats[threeRow1][threeCol1] != 0) || (boats[threeRow1 + 1][threeCol1] != 0) || (boats[threeRow1 + 2][threeCol1] != 0)) {
                            threeRow1 = (int) Math.floor(Math.random() * 10);
                            threeCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[2] = 'v';
                        boats[threeRow1][threeCol1] = boats[threeRow1 + 1][threeCol1] = boats[threeRow1 + 2][threeCol1] = 3;
                    }
                    if (time == 5) {
                        threeRow2 = (int) Math.floor(Math.random() * 10);
                        threeCol2 = (int) Math.floor(Math.random() * 10);
                        while (((threeRow2 > 9) || threeCol2 > 11) || (boats[threeRow2][threeCol2] != 0) || (boats[threeRow2 + 1][threeCol2] != 0) || (boats[threeRow2 + 2][threeCol2] != 0)) {
                            threeRow2 = (int) Math.floor(Math.random() * 10);
                            threeCol2 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[3] = 'v';
                        boats[threeRow2][threeCol2] = boats[threeRow2 + 1][threeCol2] = boats[threeRow2 + 2][threeCol2] = 3;
                    }

                    if (time == 4) {
                        threeRow3 = (int) Math.floor(Math.random() * 10);
                        threeCol3 = (int) Math.floor(Math.random() * 10);
                        while (((threeRow3 > 9) || threeCol3 > 11) || (boats[threeRow3][threeCol3] != 0) || (boats[threeRow3 + 1][threeCol3] != 0) || (boats[threeRow3 + 2][threeCol3] != 0)) {
                            threeRow3 = (int) Math.floor(Math.random() * 10);
                            threeCol3 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[7] = 'v';
                        boats[threeRow3][threeCol3] = boats[threeRow3 + 1][threeCol3] = boats[threeRow3 + 2][threeCol3] = 3;
                    }

                    if (time == 3) {
                        threeRow4 = (int) Math.floor(Math.random() * 10);
                        threeCol4 = (int) Math.floor(Math.random() * 10);
                        while (((threeRow4 > 11) || threeCol4 > 9) || (boats[threeRow4][threeCol4] != 0) || (boats[threeRow4 + 1][threeCol4] != 0) || (boats[threeRow4 + 2][threeCol4] != 0)) {
                            threeRow4 = (int) Math.floor(Math.random() * 10);
                            threeCol4 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[8] = 'v';
                        boats[threeRow4][threeCol4] = boats[threeRow4 + 1][threeCol4] = boats[threeRow4 + 2][threeCol4] = 3;
                    }

                    if (time == 2) {
                        twoRow1 = (int) Math.floor(Math.random() * 10);
                        twoCol1 = (int) Math.floor(Math.random() * 10);
                        while (((twoRow1 > 10) || twoCol1 > 11) || (boats[twoRow1][twoCol1] != 0) || (boats[twoRow1 + 1][twoCol1] != 0)) {
                            twoRow1 = (int) Math.floor(Math.random() * 10);
                            twoCol1 = (int) Math.floor(Math.random() * 10);
                        }
                        orient[4] = 'v';
                        boats[twoRow1][twoCol1] = boats[twoRow1 + 1][twoCol1] = 2;
                    }

                    if (time == 1) {
                        twoRow2 = (int) Math.floor(Math.random() * 10);
                        twoCol2 = (int) Math.floor(Math.random() * 10);
                        while (((twoRow2 > 10) || twoCol2 > 11) || (boats[twoRow2][twoCol2] != 0) || (boats[twoRow2 + 1][twoCol2] != 0)) {
                            twoRow2 = (int) Math.floor(Math.random() * 10);
                            twoCol2 = (int) Math.floor(Math.random() * 10);
                        }
                        boats[twoRow2][twoCol2] = boats[twoRow2 + 1][twoCol2] = 2;
                        orient[9] = 'v';
                        keepGoing = false;
                    }
                }
                time = time - 1;
                rand = (int) Math.floor(Math.random() * 100);
            }
            for (int i = 0; i < Rows; i++) {
                for (int j = 0; j < Cols; j++) {
                    play += boats[i][j] + " ";
                }
                play += "\n";
            }
        }
    }//end placeBoats
    // This is where it all ends

    public String display() {
        String play = "";
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                play += Board[i][j] + " ";
            }
            play += "\n";
        }
        return play;
    }// end display

    public String fire(int x, int y) {
        turns[count][0] = x;
        turns[count][1] = y;
        /*if((count==0)&&(fromDrone)){
            //System.out.println("only");
          return "only";
        }
        if((fromDrone)){
            for(int i=0; i<count-1;i++){
                if((turns[i][0]== x)){
                   if ((turns[i][1] == y)){
                       System.out.println("got to the hit");
                       return "hit";
                   }
                }
            }
            return "no hit";
        }*/
        count++;
        // System.out.println("not only " + count);
        if (boats[x][y] != 0) {
            if (boats[x][y] == 5) {
                if ((orient[0] == 'h') || (orient[5] == 'h')) {
                    if (((x == fiveRow1) && (y == fiveCol1)) || ((x == fiveRow1) && (y == fiveCol1 + 1)) || ((x == fiveRow1) && (y == fiveCol1 + 2)) || ((x == fiveRow1) && (y == fiveCol1 + 3)) || ((x == fiveRow1) && (y == fiveCol1 + 4))) {
                        hit05++;
                        // System.out.println("hit05 "+ hit05);
                        Board[x][y] = '5';
                        if (hit05 >= 5) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == fiveRow2) && (y == fiveCol2)) || ((x == fiveRow2) && (y == fiveCol2 + 1)) || ((x == fiveRow2) && (y == fiveCol2 + 2)) || ((x == fiveRow2) && (y == fiveCol2 + 3)) || ((x == fiveRow2) && (y == fiveCol2 + 4))) {
                        hit15++;
                        //System.out.println("hit15 "+ hit15);
                        Board[x][y] = '5';
                        if (hit15 >= 5) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                } else if ((orient[0] == 'v') || (orient[5] == 'v')) {
                    if (((x == fiveRow1) && (y == fiveCol1)) || ((x == fiveRow1 + 1) && (y == fiveCol1)) || ((x == fiveRow1 + 2) && (y == fiveCol1)) || ((x == fiveRow1 + 3) && (y == fiveCol1)) || ((x == fiveRow1 + 4) && (y == fiveCol1))) {
                        hit05++;
                        //System.out.println("hit05 "+ hit05);
                        Board[x][y] = '5';
                        if (hit05 >= 5) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == fiveRow2) && (y == fiveCol2)) || ((x == fiveRow2 + 1) && (y == fiveCol2)) || ((x == fiveRow2 + 2) && (y == fiveCol2)) || ((x == fiveRow2 + 3) && (y == fiveCol2)) || ((x == fiveRow2 + 4) && (y == fiveCol2))) {
                        hit15 = hit15 + 1;
                        // System.out.println("hit15 "+ hit15);
                        Board[x][y] = '5';
                        if (hit15 < 4) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                }
            }
            if (boats[x][y] == 4) {
                if ((orient[1] == 'h') || (orient[6] == 'h')) {
                    if (((x == fourRow1) && (y == fourCol1)) || ((x == fourRow1) && (y == fourCol1 + 1)) || ((x == fourRow1) && (y == fourCol1 + 2)) || ((x == fourRow1) && (y == fourCol1 + 3))) {
                        hit04++;
                        Board[x][y] = '4';
                        if (hit04 >= 4) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == fourRow2) && (y == fourCol2)) || ((x == fourRow2) && (y == fourCol2 + 1)) || ((x == fourRow2) && (y == fourCol2 + 2)) || ((x == fourRow2) && (y == fourCol2 + 3))) {
                        hit14++;
                        Board[x][y] = '4';
                        if (hit14 >= 4) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                }
                if ((orient[1] == 'v') || (orient[6] == 'v')) {
                    if (((x == fourRow1) && (y == fourCol1)) || ((x == fourRow1 + 1) && (y == fourCol1)) || ((x == fourRow1 + 2) && (y == fourCol1)) || ((x == fourRow1 + 3) && (y == fourCol1))) {
                        hit04++;
                        Board[x][y] = '4';
                        if (hit04 >= 4) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == fourRow2) && (y == fourCol2)) || ((x == fourRow2 + 1) && (y == fourCol2)) || ((x == fourRow2 + 2) && (y == fourCol2)) || ((x == fourRow2 + 3) && (y == fourCol2))) {
                        hit14++;
                        Board[x][y] = '4';
                        if (hit14 >= 4) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                }
            }
            if (boats[x][y] == 3) {
                if ((orient[2] == 'h') || (orient[7] == 'h') || ((orient[3] == 'h') || (orient[8] == 'h'))) {
                    if (((x == threeRow1) && (y == threeCol1)) || ((x == threeRow1) && (y == threeCol1 + 1)) || ((x == threeRow1) && (y == threeCol1 + 2))) {
                        hit03++;
                        Board[x][y] = '3';
                        if (hit03 >= 3) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == threeRow2) && (y == threeCol2)) || ((x == threeRow2) && (y == threeCol2 + 1)) || ((x == threeRow2) && (y == threeCol2 + 2))) {
                        hit13++;
                        Board[x][y] = '3';
                        if (hit13 >= 3) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == threeRow3) && (y == threeCol3)) || ((x == threeRow3) && (y == threeCol3 + 1)) || ((x == threeRow3) && (y == threeCol3 + 2))) {
                        hit23++;
                        Board[x][y] = '3';
                        if (hit23 >= 3) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == threeRow4) && (y == threeCol4)) || ((x == threeRow4) && (y == threeCol4 + 1)) || ((x == threeRow4) && (y == threeCol4 + 2))) {
                        hit33++;
                        Board[x][y] = '3';
                        if (hit33 >= 3) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                }
                if ((orient[2] == 'v') || (orient[7] == 'v') || ((orient[3] == 'v') || (orient[8] == 'v'))) {
                    if (((x == threeRow1) && (y == threeCol1)) || ((x == threeRow1 + 1) && (y == threeCol1)) || ((x == threeRow1 + 2) && (y == threeCol1))) {
                        hit03++;
                        Board[x][y] = '3';
                        if (hit03 >= 3) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == threeRow2) && (y == threeCol2)) || ((x == threeRow2 + 1) && (y == threeCol2)) || ((x == threeRow2 + 2) && (y == threeCol2))) {
                        hit13++;
                        Board[x][y] = '3';
                        if (hit13 >= 3) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == threeRow3) && (y == threeCol3)) || ((x == threeRow3 + 1) && (y == threeCol3)) || ((x == threeRow3 + 2) && (y == threeCol3))) {
                        hit23++;
                        Board[x][y] = '3';
                        if (hit23 >= 3) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == threeRow4) && (y == threeCol4)) || ((x == threeRow4 + 1) && (y == threeCol4)) || ((x == threeRow4 + 2) && (y == threeCol4))) {
                        hit33++;
                        Board[x][y] = '3';
                        if (hit33 >= 3) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                }
            }
            if (boats[x][y]==2) {
                if ((orient[4] == 'h') || (orient[9] == 'h')) {
                    if (((x == twoRow1) && (y == twoCol1)) || ((x == twoRow1) && (y == twoCol1 + 1))) {
                        hit02++;
                        Board[x][y] ='2';
                        if (hit02 >= 2) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == twoRow2) && (y == twoCol2)) || ((x == twoRow2) && (y == twoCol2 + 1))) {
                        hit12++;
                        Board[x][y] = '2';
                        if (hit02 >= 2) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                }
                if ((orient[4]=='v') || (orient[9] =='v')) {
                    if (((x==twoRow1)&&(y==twoCol1)) || ((x==twoRow1 + 1) && (y == twoCol1))) {
                        hit02++;
                        Board[x][y] = '2';
                        if (hit02 >= 2) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                    if (((x == twoRow2) && (y == twoCol2)) || ((x == twoRow2 + 1) && (y == twoCol2))) {
                        hit12++;
                        Board[x][y] = '2';
                        if (hit02 >= 2) {
                            value++;
                            return "sunk";
                        } else {
                            return "hit";
                        }
                    }
                }
            }
        }
        else {
            return "miss";
        }
        return"Didn't work";
    }// end fire

    public int drone(int direction, int index){
        int canHit=0; String noWorry;
        if (Rows==8){
            if(direction==0){
                for(int i=0;i<8;i++){
                    if(boats[i][index]!=0){canHit++;}
                }
               /* for(int i=0;i<8;i++){
                    fromDrone=true;
                    noWorry= fire(i,index);
                    if (noWorry.equals("hit")){
                        if(canHit>0){ canHit--;}
                       // System.out.println("returned from the hit to drone");
                    }fromDrone=false;
                }*/
            }
            if(direction==1){
                for(int i=0;i<8;i++){
                    if(boats[index][i]!=0){canHit++;}
                }
             /*   for(int i=0;i<8;i++){
                    fromDrone=true;
                    noWorry= fire(index,i);
                    if (noWorry.equals("hit")){
                        if(canHit>0){ canHit--;}
                      //  System.out.println("returned from the hit to drone");
                    }fromDrone=false;
                }*/
            }
        }
        if(Rows==12){
            if(direction==0){
                //  System.out.println("came back to drone");
                for(int i=0;i<12;i++){
                    if(boats[i][index]!=0){canHit++;}
                }
               /* for(int i=0;i<12;i++){
                    fromDrone=true;
                    noWorry= fire(i,index);
                    if (noWorry.equals("hit")){
                        if(canHit>0){ canHit--;}
                      //  System.out.println("returned from the hit to drone");
                    }fromDrone=false;
                }*/
            }
            if(direction==1){
                // System.out.println("came back to drone");
                for(int i=0;i<12;i++){
                    if(boats[index][i]!=0){canHit++;}
                }
               /*for(int i=0;i<12;i++){
                    fromDrone=true;
                    noWorry= fire(index,i);
                    if (noWorry.equals("hit")){
                        if(canHit>0){canHit--;}
                     //   System.out.println("returned from the hit to drone");
                    }fromDrone=false;
                }*/
            }

        }
        return canHit;
    }

    public String missile(int x, int y){
        return fire(x,y);
    } // end missile

} // end BattleBoatsBoard
