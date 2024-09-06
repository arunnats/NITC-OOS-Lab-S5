import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nameOfThePost = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<String> listOfCandidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listOfCandidates.add(sc.nextLine());
        }

        int m = sc.nextInt();
        sc.nextLine();

        ArrayList<String> votesEntered = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            votesEntered.add(sc.nextLine());
        }

        ElectionPost election = new ElectionPost(nameOfThePost, listOfCandidates, votesEntered);
        election.display();
        election.ascendDisplay();
        election.descendDisplay();

        sc.close();
    }
}

interface SortVotes {
    void ascendDisplay();
    void descendDisplay();
}

class ElectionPost implements SortVotes {
    private String nameOfThePost;
    private ArrayList<String> listOfCandidates;
    private ArrayList<String> votesEntered;
    private HashMap<String, Integer> voteCount;

    public ElectionPost(String nameOfThePost, ArrayList<String> listOfCandidates, ArrayList<String> votesEntered) {
        this.nameOfThePost = nameOfThePost;
        this.listOfCandidates = listOfCandidates;
        this.votesEntered = votesEntered;
        this.voteCount = new HashMap<>();

        for (String candidate : listOfCandidates) {
            voteCount.put(candidate, 0);
        }

        for (String vote : votesEntered) {
            if (voteCount.containsKey(vote)) {
                voteCount.put(vote, voteCount.get(vote) + 1);
            }
        }
    }

    public void display() {
        System.out.println(nameOfThePost);
        Collections.sort(listOfCandidates);
        for (String candidate : listOfCandidates) {
            System.out.println(candidate);
        }
    }

    @Override
    public void ascendDisplay() {
        List<Map.Entry<String, Integer>> sortedVotes = new ArrayList<>(voteCount.entrySet());
        sortedVotes.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Integer> entry : sortedVotes) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    @Override
    public void descendDisplay() {
        List<Map.Entry<String, Integer>> sortedVotes = new ArrayList<>(voteCount.entrySet());
        sortedVotes.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : sortedVotes) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
