package DPRemedial;

public class Question1 {
	public static void main(String[] args) {
		Question1 obj=new Question1();
		String A="eZCHXr0CgsB4O3TCDlitYI7kH38rEElI";
		String B="UhSQsB6CWAHE6zzphz5BIAHqSWIY24D";
		String C="eUZCHhXr0SQsCgsB4O3B6TCWCDlAitYIHE7k6H3z8zrphz5EEBlIIAHqSWIY24D";
		int val=obj.isInterleave(A, B, C);
		System.out.println(val);
	}
	public int isInterleave(String A, String B, String C) {
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        char[] c=C.toCharArray();
        boolean val=isInter(a,b,c,0,0,0);
        return val?1:0;
    }
    
    boolean isInter(char[] a, char[] b, char[] c,int a_pos,int b_pos,int c_pos){
        if(c_pos==c.length){
            return true;
        }
        boolean res=false;
        if(a_pos<a.length && b_pos<b.length && c[c_pos]==a[a_pos] && c[c_pos]==b[b_pos]){
             return res|=isInter(a,b,c,a_pos+1,b_pos,c_pos+1)| isInter(a,b,c,a_pos,b_pos+1,c_pos+1);
        }else if(a_pos<a.length && c[c_pos]==a[a_pos]){
            return isInter(a,b,c,a_pos+1,b_pos,c_pos+1);
        }else if(b_pos<b.length && c[c_pos]==b[b_pos]){
             return isInter(a,b,c,a_pos,b_pos+1,c_pos+1);
        }
        else{
            return false;
        }
    }

}
    
