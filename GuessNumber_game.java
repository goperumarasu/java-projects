import java.util.Random;
import java.util.Scanner;

public class GuessNumber_game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String play="yes";
        while(play.equals("yes"))
        {
            Random random=new Random();
            int num= random.nextInt(100);
            int guess=-1;
            int tries=0;
            while(guess!=num)
            {
                System.out.print("Enter the number between 1 and 100:");
                guess=sc.nextInt();
                tries++;
                if(guess==num)
                {
                    System.out.println("Awesome! you guessed the number");
                    System.out.println("you've won in only "+tries +" tries");
                    System.out.println("if you want to play again? enter yes");
                    System.out.println("if you want to end the game? enter no");
                    play=sc.next().toLowerCase();
                } else if (guess>num) {
                    System.out.println("you've entered the higher number!");

                }
                else {
                    System.out.println("you've entered the lower number!");
                }

            }
        }
        sc.close();
    }
}
