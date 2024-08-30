package DSA.Greedy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10= 0;
        for(int i =0; i< bills.length; i++){
            if(bills[i]==5){
                count5++; continue;
            } else if(bills[i]==10){
                if(count5>0){
                    count5--; count10++; continue;
                } else return false;
            } else {
                if(count10>0 && count5>0){
                    count10--; count5--; continue;
                } else if(count5>1){
                    count5 -= 2; continue;
                } else return false;
            }
        }
        return true;
    }
}
