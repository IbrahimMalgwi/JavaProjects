package polling;

public class Poll {
    private String[] topics = {"Financial", "Psychological issues", "Gender Issues", "Hunger", "Breakfast"};
    private int[][] responses = new int[5][10];
    private double averageRatings;

    public int[][] getResponses() {
        return responses;
    }

    public void setResponses(int[][] responses) {
        this.responses = responses;
    }

    public double getAverageRatings() {
        return averageRatings;
    }

    public void setAverageRatings(double averageRatings) {
        this.averageRatings = averageRatings;
    }

    public void calculateAverage(int... pollNumbers) {
        int totalOfRating= 0;
        for (int pollNUmber : pollNumbers) {
            totalOfRating+= pollNUmber;

        }
        averageRatings = totalOfRating / pollNumbers.length;
    }

    public int getHighestPoint(int... pollNumbers) {
        int highestNumber = pollNumbers[0];
        for (int i = 0; i < pollNumbers.length ; i++) {
            if (pollNumbers[i] > highestNumber){
                highestNumber = pollNumbers[i];
            }
        }
        return highestNumber;
    }

    public int getLowestPoint(int... pollNumbers) {
        int lowestPoint = pollNumbers[0];
        for (int i = 0; i < pollNumbers.length ; i++) {
            if (pollNumbers[i] < lowestPoint) {
                lowestPoint = pollNumbers[i];
            }
        }
        return lowestPoint;
    }
}
