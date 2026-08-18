package gitLearning;

import java.util.*;
public class vishal_game{

    public static void main(String args[]){
        System.out.println("<----WELCOME TO THIS GAME---->");
        System.out.print("guess a two digit number : ");
        int n;
        Random r=new Random();
        int rand=r.nextInt()%90+10;
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        int i=1;
        while(true){
            if(n==rand){
                System.out.println("WOW,you guesses the number in just "+i+" steps");
                break;
            }
            else if(n<rand){
                System.out.print("your number is less,guess again : ");
                i++;
            }
            else{
                System.out.print("your number is large,guess again : ");
                i++;
            }
            n=sc.nextInt();

        }
        sc.close();

    }
}