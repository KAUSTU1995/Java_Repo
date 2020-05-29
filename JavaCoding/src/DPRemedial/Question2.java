package DPRemedial;

public class Question2 {

	public static void main(String[] args) {
		Question2 obj=new Question2();
		String A="aabbb";
		int val=obj.anytwo(A);
		System.out.println(val);

	}
	public int anytwo(String A) {
        
        int len=A.length();
        char[] arr=A.toCharArray();
        if(len<=2)
        return 0;
        for(int i=0;i<len-2;i++){
            char a=arr[i];
            char b=arr[i+1];
            if((i+2)<len){
                char c=arr[i+2];
                if(a==b && b==c){
                    return 1;
                }
            }
            int l=0;
            int k=i+2;
            while(l<i-1 || k<len-1){
            	if(arr[l]==a && arr[l+1]==b){
            		return 1;
            	}
            	l++;
            	if(arr[k]==a && arr[k+1]==b){
            		return 1;
            	}
            	k++;
            }
            if(l==i-1){
            	if(arr[l]==a && arr[i+2]==b){
            		return 1;
            	}
            }
        }
        return 0;
    
    }

}
