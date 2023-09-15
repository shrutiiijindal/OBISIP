import java.util.Scanner;
 class numbergame{
    public static void main(String args[]){
        System.out.println("Rules: I'll pick a number from 1 to 100, you have to guess that number");
        Scanner n = new Scanner(System.in);
        boolean playagain;
        do{
            game();
            System.out.println("you want to play again (y/n)?");
            playagain = n.nextBoolean();
        }while(playagain);

    }
    static void game() {
        int computerInput; 
        int Guess;      
        int guessCount;      
        computerInput = (int)(100 * Math.random()) + 1;
        guessCount = 0;
        System.out.println();
        System.out.println("What is your first guess?");
        Scanner sc= new Scanner(System.in);   
        while (true) {
           Guess = sc.nextInt();  
           guessCount++;
           if (Guess == computerInput) {
              System.out.println("You got it in " + guessCount
                      + " guesses!  My number was " + computerInput);
              break;  
           }
           if (guessCount == 3) {
              System.out.println("You didn't get the number in 3 guesses.");
              System.out.println("You lose.  My number was " + computerInput);
              break;  
           }
           if (Guess < computerInput)
              System.out.println("That's too low.  Try again:");
           else if (Guess > computerInput)
              System.out.println("That's too high.  Try again:");
        }
        System.out.println();
    } 
                
 } 
