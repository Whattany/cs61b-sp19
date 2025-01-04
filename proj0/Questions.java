public class Questions {
    public static void main(String args[]){
        int secret = 1 + (int)(Math.random() * 10);
        StdOut.print("I'm thinking of a number.");
        StdOut.println("between 1 and 10");
        int guess = 0;
        while (guess != secret){
            StdOut.println("what's your guess?");
            guess = StdIn.readInt();
            if (guess > secret) {
                StdOut.println("Too Low!");
            } else if (guess < secret){
                StdOut.println("Too high!");
            } else {
                StdOut.printf("You win!!");
            }
        }
    }
}

