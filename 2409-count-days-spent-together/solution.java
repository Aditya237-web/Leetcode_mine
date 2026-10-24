class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

      
        String start = arriveAlice.compareTo(arriveBob) > 0
                ? arriveAlice : arriveBob;

        String end = leaveAlice.compareTo(leaveBob) < 0
                ? leaveAlice : leaveBob;

        int startDay = toDays(start, days);
        int endDay = toDays(end, days);

        return Math.max(0, endDay - startDay + 1);
    }

    private int toDays(String date, int[] days) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));

        int total = day;

        for (int i = 0; i < month - 1; i++) {
            total += days[i];
        }

        return total;
    }
}