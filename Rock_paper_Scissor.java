import java.util.Random;
import java.util.Scanner;
public class Rock_paper_Scissor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        String [] rps={"rock","paper","scissor"};
        String bot=rps[r.nextInt(3)];
        String player;
        while(true)
        {
            System.out.println("Enter your move(rock,paper,scissor)");
            player=sc.next().toLowerCase();
            if(player.equals("rock")|| player.equals("paper") || player.equals("scissor"))
            {
                break;
            }
            else{
                System.out.println("invalid input");
            }
        }
        System.out.println("Bot Move:"+bot);

        if(bot.equals(player))
        {
            System.out.println("Match Tie");



        } else if(bot.equals("rock") && player.equals("paper") || bot.equals("scissor") &&
        player.equals("paper") || bot.equals("paper") && player.equals("rock")){
            System.out.println("The Bot Wins...!");

        }
        else{
            System.out.println("Hurray! You Won...!");
        }
        System.out.println("play again");
    }
}
