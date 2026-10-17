class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
       
        // Arrays.sort(bills);
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fives++;
            } else if (bills[i] == 10) {
                if (fives <= 0){
                    return false;
                }
                fives--;
                tens++;
            } else {
                if (tens>=1 && fives>=1){
                    tens--;
                    fives--;
                }
                else if (fives >= 3) {
                 
                    fives -=3;
                   
                }
                else{
                    return false;
                }
                
                
            }
        }
        return true;

    }
}