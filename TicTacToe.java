import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char [][]board=new char[3][3];
        for(int row=0;row<board.length;row++)
        {
            for(int col=0;col<board[row].length;col++)
            {
                board[row][col]=' ';

            }
        }
        char player='X';
        boolean gameover=false;
        Scanner scanner=new Scanner(System.in);
        while (!gameover){
            printboard(board);
            System.out.println("player="+player + " enter the place :" );
            int row=scanner.nextInt()-1;
            int col= scanner.nextInt()-1;
            if(board[row][col]==' ')
            {
                board[row][col]=player;
                gameover=havewin(board,player);
                if(gameover)
                {
                    System.out.println(player+ " has won");
                }
                else{
                    player=(player=='X')? 'O':'X';
                }

            }
            else {
                System.out.println("invalid move");
            }
        }
        printboard(board);

     }
     public static boolean havewin(char [][]board,char player)
     {
         for(int row=0;row<board.length;row++)
         {
             if(board[row][0]==player && board[row][1]==player && board[row][2]==player)
             {
                 return true;
             }
         }
         for(int col=0;col<board.length;col++)
         {
             if(board[0][col]==player && board[1][col]==player && board[2][col]==player)
             {
                 return true;
             }
         }
         if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
         {
             return true;
         }
         if(board[0][2]==player && board[1][1]==player && board[2][0]==player)
         {
             return true;
         }
         return false;

     }
    public static void printboard(char board [][])
    {
        for(int row=0;row< board.length;row++)
        {
            for(int col=0;col< board.length;col++)
            {
                System.out.print(board[row][col] + " |  ");

            }
            System.out.println();
        }

    }

}
