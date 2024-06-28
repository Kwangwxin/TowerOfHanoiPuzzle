import java.io.*;
import java.util.*;

public class TowerOfHanoiPuzzle
{
  public static void main(String[] args)
  {
    Scanner kbd = new Scanner(System.in);
    while(true){
      System.out.println("Welcome to Tower of Hanoi Puzzle");
      System.out.println("Take a pick:" + "\n" +
        "1) Play a Tower of Hanoi Puzzle" + "\n" +
        "2) Exit");
        int pick = kbd.nextInt();
        while(true){
          while(pick != 1 && pick != 2){
            System.out.println("Invalid option!");
            System.out.println("Take a pick:" + "\n" +
              "1) Play a Tower of Hanoi Puzzle" + "\n" +
              "2) Exit");
              pick = kbd.nextInt();
          }
          if(pick == 1){
            System.out.print("How many disks would you like to play (between 1 and 64): ");
            int number = kbd.nextInt();
            while(number < 1 || number > 64){
              System.out.println("Invalid option!");
              System.out.print("How many disks would you like to play (between 1 and 64): ");
              number = kbd.nextInt();
            }
            int steps = moves(number);
            TowerOfHanoi toh = new TowerOfHanoi(number);
            System.out.println(toh);
            System.out.println("The goal is to move all " + number + " disks from pole 1 to pole 3");
            System.out.println("The least number of moves for " + number + " disks is " + steps + ".");
            System.out.print("Are you ready to play? (y/n): ");
            String ans = kbd.next();
            while(!ans.equals("y") && !ans.equals("n")){
              System.out.print("Are you ready to play? (y/n): ");
              ans = kbd.next();
            }
            if(ans.equals("n"))
            break;
            else{
             solve(toh,number,steps,kbd);
             break;
            }
          }
          else{
            System.out.println("Goodbye!");
            System.exit(0);
          }
        }
     }
  }

  public static int moves(int num)
  {
    int sum = 1;
    int times = 0;
    while(times < num){
      sum = sum * 2;
      times++;
    }
    return sum - 1;
  }

  public static void solve(TowerOfHanoi toh, int maxnum, int max, Scanner scan)
  {
    int step = 0;
    while(done(toh,maxnum) == false){
      System.out.println(toh);
      System.out.println("Number of Moves: " + step);
      System.out.print("Enter <from><space><to> to move a disk: ");
      int from = scan.nextInt();
      int to = scan.nextInt();
      if(from == 0 && to == 0)
      break;
      while((from < 1 || from > 3) || (to < 1 || to > 3)){
        System.out.println("Invalid option!");
        System.out.print("Enter <from><space><to> to move a disk: ");
        from = scan.nextInt();
        to = scan.nextInt();
      }

       if(toh.getNumberOfDisks(from) != 0){
         if(toh.getNumberOfDisks(to) == 0){
           toh.move(from,to);
         }
         else if(toh.peekTopDisk(from).getSize() < toh.peekTopDisk(to).getSize())
           toh.move(from,to);
         else{
           System.out.println("You cannot move the top disk from pole " + from +" to pole "+ to +".");
           System.out.println("The top disk of pole "+ from +" is larger than the top disk of pole " + to + ".");
         }
       }
       else{
         System.out.println("You cannot move the top disk from pole " + from +" to pole "+ to +".");
         System.out.println("Pole "+ from +" is empty!");
       }
      step++;
    }
    if(done(toh,maxnum) == true){
      System.out.println(toh);
      System.out.println("Congratulaions!!!");
      System.out.println("Number of Moves: " + step);
      System.out.println("The least number of moves for " + maxnum + " disks is " + max + ".");
    }
  }

  public static boolean done(TowerOfHanoi toh, int maxnum)
  {
    if(toh.getNumberOfDisks(1) == 0 && toh.getNumberOfDisks(2) == 0 && toh.getNumberOfDisks(3) == maxnum){
      return true;
    }else
    return false;
  }
}
