class Solution {
    public int maximumPopulation(int[][] logs) {

        int[] count = new int[101]; 

        for (int[] log : logs) {
            count[log[0] - 1950]++;
            count[log[1] - 1950]--;
        }

        int population = 0;
        int maxPopulation = 0;
        int answer = 1950;

        for (int i = 0; i < 101; i++) {
            population += count[i];

            if (population > maxPopulation) {
                maxPopulation = population;
                answer = 1950 + i;
            }
        }

        return answer;
    }
}