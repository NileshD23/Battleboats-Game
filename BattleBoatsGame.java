// written by domah001 and omoto011

import java.util.Scanner;

public class BattleBoatsGame {
    public static void main(String [] args){
        System.out.println("Hello welcome to BattleBoats! Please enter 1 to play in standard mode or 2 to play in expert");
        Scanner s = new Scanner(System.in);
        String level,orient,inter,local,miss;
        boolean lvl = false,wrongOrient=false,wrongInter=true,wrongLocal=true;
        int numlvl=0, turnRow=0,place=0,x,y,count=0,theD=0,nowD=0,theM=0,nowM=0,index=0,direction=0,missleHit=0,missileSunk=0;
        int[][] turns=new int[50][2];
        BattleBoatsBoard game = new BattleBoatsBoard(0, 0);
        level = s.nextLine();


        while (lvl==false) {
            lvl= true;
            try {
                numlvl = Integer.parseInt(level);
            } catch(NumberFormatException e){
                lvl = false;
                System.out.println("Invalid input. Please enter 1 to play in standard mode or 2 to play in expert\n");
                level = s.nextLine();
            } catch(NullPointerException e){
                lvl = false;
                System.out.println("Invalid input. Please enter 1 to play in standard mode or 2 to play in expert\n");
                level = s.nextLine();
            }
            if (lvl==true){
                numlvl=Integer.parseInt(level);
                if (numlvl==1) {
                    game = new BattleBoatsBoard(8, 8);
                    lvl=true;
                } else if (numlvl==2) {
                    game = new BattleBoatsBoard(12, 12);
                    lvl = true;
                }
                else {
                    System.out.println("Invalid input. Please enter 1 to play in standard mode or 2 to play in expert\n");
                    level = s.nextLine();
                    lvl = false;
                }
            }
        }
        //int math = (int) Math.floor(Math.random()*100);
        game.placeBoats();
        System.out.println(game.display());
        if(numlvl==1){ theD=1;theM=1;}
        else{theD=2;theM=2;}
        System.out.println("The levels are set, the board is set, the boats are set, enter location as numbers seperated by 1 space for a hit, or 'drone' to scan, or 'missle' to bomb");
        String action = s.nextLine();
        while (turnRow<50) {
            lvl=true;
            if (action.equals("drone")) {
                nowD++;
                if (nowD<theD+1) {
                    System.out.println("Would you like to scan a row 'r' or column 'c'?");
                    orient = s.nextLine();
                    if((orient.equals("r"))||(orient.equals("c"))){
                        if(orient.equals("r")){ direction=1; System.out.println("direction is "+ direction);}
                        else{direction=0;System.out.println("direction is "+ direction);}
                        wrongOrient=false;
                    }else{wrongOrient=true;}

                    while(wrongOrient){
                        System.out.println("Invalid input, Would you like to scan a row 'r' or column 'c'?");
                        orient = s.nextLine();
                        if((orient.equals("r"))||(orient.equals("c"))){
                            if(orient.equals("r")){ direction=1; System.out.println("direction is "+ direction);}
                            else{direction=0;System.out.println("direction is "+ direction);}
                            wrongOrient=false;
                        }else{wrongOrient=true;}
                    }
                    System.out.println("Which row or column would you like to scan?");
                    inter = s.nextLine();
                    while (wrongInter) {
                        wrongInter=false;
                        try {
                            index = Integer.parseInt(inter);
                        } catch(NumberFormatException e){
                            wrongInter = true;
                            System.out.println("Invalid input. Please enter a valid row or column\n");
                            inter = s.nextLine();
                        } catch(NullPointerException e){
                            wrongInter = true;
                            System.out.println("Invalid input. Please enter a valid row or column\n");
                            inter = s.nextLine();
                        }
                        if(!wrongInter) {
                            index=Integer.parseInt(inter);
                            if ((index <= -1)|| ((numlvl == 1) && (index > 7))|| ((numlvl == 2) && (index > 11)) ) {
                                System.out.println("Invalid Input. Please type in a number within the boundaries of the board\n");
                                wrongInter = true;
                                inter = s.nextLine();
                            }else{ System.out.println(game.drone(direction,index)); }
                        }
                    }
                    wrongInter = true;
                } else {System.out.println("Drone has been used the max amount of times.");}
                System.out.println(game.display());
            }//drone

            else if(action.equals("missile")){
                missileSunk=0;
                missleHit=0;
                nowM++;
                if (nowM<theM+1) {
                    System.out.println(" Where would you like to launch your missile?\n");
                    local = s.nextLine();
                    String[] Cord = local.split(" ");
                    while (wrongLocal) {
                        wrongLocal = false;
                        try {
                            x = Integer.parseInt(Cord[0]);
                            y = Integer.parseInt(Cord[1]);
                        }catch(NumberFormatException e){
                            wrongLocal = true;
                            System.out.println("Invalid input. Please enter a valid location in the format '1 1'\n");
                            local = s.nextLine();
                        } catch(NullPointerException e){
                            wrongLocal = true;
                            System.out.println("Invalid input. Please enter a valid location in the format '1 1'\n");
                            local = s.nextLine();
                        }
                        if(!wrongLocal) {
                            x = Integer.parseInt(Cord[0]);
                            y = Integer.parseInt(Cord[1]);
                            if(((x<=-1) || (y<=-1))||((numlvl==1)&&(x>7))||((numlvl==1)&&(y>7))||((numlvl==2)&&(x>11))||((numlvl==2)&&(y>11))){
                                System.out.println("Out of bounds, Please enter location between 0-7 for standard level, or between 0-12 for expert\n");
                                System.out.println(x+" "+y);
                                wrongLocal=true;
                                local=s.nextLine();
                                Cord = local.split(" ");
                            }else{
                                if(numlvl==1){
                                    miss=game.missile(x, y);
                                    if( miss.equals("hit")){ missleHit++;}
                                    if( miss.equals("sunk")){ missileSunk++;}
                                    if(((x-1)>=0)&&((y-1)>=0)){
                                        miss=game.missile(x-1, y-1);
                                        if( miss.equals("hit")){ missleHit++;}
                                        if(miss.equals("sunk")){ missileSunk++;}
                                    }
                                    if(((x-1)>=0)){
                                        miss=game.missile(x-1, y);
                                        if( miss.equals("hit")){missleHit++; }
                                        if( miss.equals("sunk")){missileSunk++; }
                                    }
                                    if(((x-1)>=0)&&((y+1)<=7)){
                                        miss=game.missile(x-1, y+1);
                                        if( miss.equals("hit")){missleHit++; }
                                        if( miss.equals("sunk")){missileSunk++; }
                                    }
                                    if(((y-1)>=0)){
                                        miss=game.missile(x, y-1);
                                        if(miss.equals("hit") ){missleHit++; }
                                        if( miss.equals("sunk")){missileSunk++; }
                                    }
                                    if(((y+1)<=7)){
                                        miss=game.missile(x, y+1);
                                        if( miss.equals("hit")){missleHit++; }
                                        if(miss.equals("sunk")){missileSunk++; }
                                    }
                                    if(((x+1)<=7)&&((y-1)>=0)){
                                        miss= game.missile(x+1, y-1);
                                        if(miss.equals("hit")){missleHit++;}
                                        if( miss.equals("sunk")){missileSunk++; }
                                    }
                                    if(((x+1)<=7)){
                                        miss=game.missile(x+1, y);
                                        if( miss.equals("hit")){missleHit++; }
                                        if( miss.equals("sunk")){missileSunk++; }
                                    }
                                    if(((x+1)<=7)&&((y+1)<=7)){
                                        miss=game.missile(x+1, y+1);
                                        if( miss.equals("hit")){missleHit++; }
                                        if( miss.equals("sunk")){missileSunk++; }
                                    }
                                    System.out.println("There was " + missleHit +" hits");
                                    System.out.println("There was " + missileSunk +" boats sunk by missile");
                                }
                                else{
                                    miss=game.missile(x, y);
                                    if(miss.equals("hit")){missleHit++;}
                                    if(miss.equals("sunk")){missileSunk++;}
                                    if(((x-1)>=0)&&((y-1)>=0)){
                                        miss=game.missile(x-1, y-1);
                                        if( miss.equals("hit")){ missleHit++;}
                                        if(miss.equals("sunk")){ missileSunk++;System.out.println("sunk at top left");}
                                    }
                                    if(((x-1)>=0)){
                                        miss=game.missile(x-1, y);
                                        if( miss.equals("hit")){missleHit++; }
                                        if( miss.equals("sunk")){missileSunk++; System.out.println("sunk at top mid");}
                                    }
                                    if(((x-1)>=0)&&((y+1)<=11)){
                                        miss=game.missile(x-1, y+1);
                                        if(miss.equals("hit")){missleHit++;}
                                        if(miss.equals("sunk")){missileSunk++; System.out.println("sunk at top right");}
                                    }
                                    if(((y-1)>=0)){
                                        miss=game.missile(x, y-1);
                                        if(miss.equals("hit") ){missleHit++; }
                                        if( miss.equals("sunk")){missileSunk++;System.out.println("sunk at mid left"); }
                                    }
                                    if(((y+1)<=11)){
                                        miss=game.missile(x, y+1);
                                        if( miss.equals("hit")){missleHit++; }
                                        if(miss.equals("sunk")){missileSunk++; System.out.println("sunk at mid right");}
                                    }
                                    if(((x+1)<=11)&&((y-1)>=0)){
                                        miss= game.missile(x+1, y-1);
                                        if(miss.equals("hit")){missleHit++;}
                                        if( miss.equals("sunk")){missileSunk++; System.out.println("sunk at b left");}
                                    }
                                    if(((x+1)<=11)){
                                        miss=game.missile(x+1, y);
                                        if( miss.equals("hit")){missleHit++; }
                                        if( miss.equals("sunk")){missileSunk++; System.out.println("sunk at b mid");}
                                    }
                                    if(((x+1)<=11)&&((y+1)<=11)){
                                        miss=game.missile(x+1, y+1);
                                        if( miss.equals("hit")){missleHit++; }
                                        if( miss.equals("sunk")){missileSunk++; System.out.println("sunk at b right");}
                                    }
                                    System.out.println("There was " + missleHit +" only hits");
                                    System.out.println("And there was " + missileSunk +" total boat(s) sunk by missile");
                                }
                            }
                        }
                    }
                    wrongLocal=true;
                }
                else{System.out.println("Missile has been used the max amount of times.");}

                System.out.println(game.display());}//Missile

            else if(action.equals("print")){System.out.println(game.display());}//print
            else {
                String[] Cord = action.split(" ");
                try {
                    x = Integer.parseInt(Cord[0]);
                    y = Integer.parseInt(Cord[1]);
                } catch(NumberFormatException e){
                    lvl = false;
                    System.out.println("Inavlid input please enter input in right format\n");
                    // level = s.nextLine();
                } catch(NullPointerException e){
                    lvl = false;
                    System.out.println("Inavlid input please enter input in right format\n");
                    //  level = s.nextLine();
                }catch (ArrayIndexOutOfBoundsException e){
                    lvl = false;
                    System.out.println("Inavlid input please enter input in right format\n");
                    //  level = s.nextLine();
                }

                if (lvl == true) {
                    place++;
                    x = Integer.parseInt(Cord[0]);
                    y = Integer.parseInt(Cord[1]);
                    turns[count][0] = x;
                    turns[count][1] = y;
                    if (place > 1) {
                        for (int i = 0; i<count; i++) {
                            if ((turns[i][0]==x)&&(turns[i][1]==y)) {
                                System.out.println("already guessed this location, penalty");
                                System.out.println("skipped\n");
                                count--;
                                turnRow++;
                                lvl = false;
                            }
                        }
                    }
                    if(lvl==true){
                        if(((x<=-1) || (y<=-1))||((numlvl==1)&&(x>7))||((numlvl==1)&&(y>7))||((numlvl==2)&&(x>11))||((numlvl==2)&&(y>11))){
                            System.out.println("Out of bounds penalty, Please enter location between 0-7for standard level, or between 0-12 for expert\n");
                            System.out.println("skipped\n");
                            count--;
                            turnRow++;
                        }
                        else {
                            count++;
                            System.out.println(game.fire(x, y));
                            System.out.println(x + " " + y);
                        }
                    }
                }
                System.out.println(game.display());
            }
            turnRow++;

            if(turnRow>=144){
                System.out.println("Maximum number of turns 50 is reached");
                break;
            }
            else{
                System.out.println("Please enter location as numbers separated by 1 space such as '1 1' for a hit, or 'drone' to scan, or 'missile' to bomb\n");
                action = s.nextLine();
            }
        }

    }//Main

}
