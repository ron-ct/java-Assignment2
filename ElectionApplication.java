import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Electorate {
    private char myVote;
    private List<Character> receivedVotes;

    public Electorate() {
        receivedVotes = new ArrayList<>();
    }

    public void inputVote() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your vote (A or B): ");
        myVote = scanner.next().charAt(0);
    }

    public void sendVote(List<Electorate> electorates) {
        for (Electorate electorate : electorates) {
            electorate.receiveVote(myVote);
        }
    }

    public void receiveVote(char vote) {
        receivedVotes.add(vote);
    }

    public void determineWinner() {
        int candidateA_votes = 0;
        int candidateB_votes = 0;

        for (char vote : receivedVotes) {
            if (vote == 'A') {
                candidateA_votes++;
            } else if (vote == 'B') {
                candidateB_votes++;
            }
        }

        char winner;
        if (candidateA_votes > candidateB_votes) {
            winner = 'A';
        } else if (candidateB_votes > candidateA_votes) {
            winner = 'B';
        } else {
            winner = 'T';
        }

        System.out.println("Winner: " + winner);
    }
}

public class ElectionApplication {
    public static void main(String[] args) {
        int numElectorates = 5;
        List<Electorate> electorates = new ArrayList<>();

        for (int i = 0; i < numElectorates; i++) {
            Electorate electorate = new Electorate();
            electorate.inputVote();
            electorates.add(electorate);
        }

        for (Electorate electorate : electorates) {
            electorate.sendVote(electorates);
        }

        for (Electorate electorate : electorates) {
            electorate.determineWinner();
        }
    }
}
