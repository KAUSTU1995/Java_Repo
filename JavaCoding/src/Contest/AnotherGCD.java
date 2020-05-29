package Contest;

public class AnotherGCD {
	public static void main(String[] args) {
		int[] arr={ 4,8, 3, 6 ,1 ,12 ,1, 1, 5, 10, 12,14};
		System.out.print(AnotherGCD.solve(arr));
	}

    public static int solve(int[] A) {
        int len=A.length;
        int maxCount=0;
        int currCount=0;
        int curGCD=0;
        int sum=0;
        for(int i=0;i<len-1;i++){
            sum+=A[i];
            curGCD=gcd(A[i],A[i+1]);
            if(curGCD>1){
                currCount++;
            }else{
                if(maxCount<currCount)
                maxCount=currCount;
                currCount=0;
                curGCD=0;
            }
        }
        if(currCount>maxCount)
        maxCount=currCount;
        if(sum==len)
        return -1;
        // System.out.print(gcd(6,4)+" ");
        return maxCount;
    }
    
   static int gcd(int a, int b){
        if(a==0)
        return b;
        if(b==0)
        return a;
        if(b>a)
        return gcd(b,a);
        return gcd(a%b,b);
    }


}
