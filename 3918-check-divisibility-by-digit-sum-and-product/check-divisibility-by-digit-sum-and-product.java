class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int prod=1;
        int totalsum=0;
        int orignal=n;

        while(n>0){
            int rem=n%10;
            n/=10;
            sum+=rem;
            prod*=rem;
        }
        totalsum=sum+prod;
        if(orignal%totalsum==0) return true;
        return false;
    }
}