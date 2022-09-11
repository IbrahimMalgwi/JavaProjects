package polling;

import java.util.Scanner;

public class Main {
    private static Poll poll = new Poll();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] topics = poll.getTopics();
        int numberOfTopics = topics.length;

        System.out.println("Welcome to Unicorn's pools");

        var response = "yes";
        while (response.equals("yes")){
            for (int index = 0; index <numberOfTopics ; index++) {
                System.out.println("Rate this Issues between 1 to 10 " + topics[index]);
                int userRating = input.nextInt();

                if (userRating < 1  || userRating > 10)
                    throw new UserFitNoGetSenseException("abeg try get sense!!");
            }
        }

        poll.displayTabularReports();
        System.out.println();
    }

    private static void saveRating(int issueNumber, int userRating ){
        int [][] responseDb = poll.getResponses();

        for (int index = 0; index < responseDb.length; index++) {
            for (int secondIndex = 0; secondIndex <responseDb[index].length ; secondIndex++) {
                responseDb[issueNumber][userRating] = responseDb[issueNumber][userRating]+1;
            }
        }
    }
}
