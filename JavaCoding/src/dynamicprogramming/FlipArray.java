package dynamicprogramming;

public class FlipArray {

	static int[][] dp;
	public static void main(String[] args) {
		FlipArray obj=new FlipArray();
		int[] arr= {2,15,10,4};
		System.out.println(obj.solve(arr));
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+"  ");
			}
			System.out.println();
		}
		
		
	}

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] a) {
        // int[] a = new int[A.size()];
        // for(int i=0;i<a.length;i++){
        //     a[i] = A.get(i);
        // }
		int sum = 0;
		for(int x:a){
			sum+=x;
		}
		//find a subset with sum = sum/2 in a;
		dp = new int[sum/2+1][a.length+1];
		for(int i=0;i<=a.length;i++) {
			dp[0][i] = 0;
		}
		for(int i=1;i<=sum/2;i++){
			dp[i][0] = 1000000;
		}
		for(int i=1;i<=sum/2;i++){
			for(int j=1;j<=a.length;j++){
				dp[i][j] = dp[i][j-1];
				if(i>=a[j-1]) {
					if(dp[i][j] > dp[i-a[j-1]][j-1] + 1) {
						dp[i][j] = dp[i-a[j-1]][j-1]+1;
					}
				}
			}
		}
		int max = 0;
		for(int i=0;i<=sum/2;i++){
			if(dp[i][a.length] != 1000000){
				max=i;
			}
		}
		return dp[max][a.length];
    }

}
