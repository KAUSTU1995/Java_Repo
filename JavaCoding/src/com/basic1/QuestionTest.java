package com.basic1;

import java.util.ArrayList;
import java.util.HashSet;

public class QuestionTest {
		public static int removeDuplicates() {
			ArrayList<Integer> a=new ArrayList<>();
			a.add(1000);
			a.add(1000);
			a.add(1000);
			a.add(1000);
			a.add(1001);
			a.add(1002);
			a.add(1003);
			a.add(1003);
			a.add(1004);
			a.add(1010);
			int ans=0;
			
		    int len= a.size();
		    if(len<=2)
		    return len;
		    
		    int j=0;
		    for(int i=0;i<len;i++){
		        if (i < len - 2 && a.get(i).equals(a.get(i + 2)) ) {
	        continue;
	      }
	    //   nums[j++] = nums[i];
	         a.set(j++,a.get(i));
		    }
		    
		    ans=j;
		    for(int i=0;i<ans;i++){
				System.out.print(a.get(i)+" ");
			}
		    return j;

		    
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int index=4;
		System.out.print(index & 0x01);
		int mask=0;
//		int i=3;
		for(int i=3;i>=0;i--){
			mask |= (1 << i);
			System.out.print(mask+" ");
		}*/
		
		int arr[] = { 8,5,12,15,2 };
		for(int i:arr)
		System.out.print((i & 8) +" ");
	    int n = arr.length; 
	    
	  
//	    System.out.println(max_xor(arr, n));
	}
	static int max_xor(int arr[], int n) 
	{ 
	    int maxx = 0, mask = 0; 
	  
	    HashSet<Integer> se = new HashSet<Integer>(); 
	  
	    for (int i = 30; i >= 0; i--)  
	    { 
	  
	        // set the i'th bit in mask 
	        // like 100000, 110000, 111000.. 
	        mask |= (1 << i); 
	  
	        for (int j = 0; j < n; ++j)  
	        { 
	  
	            // Just keep the prefix till 
	            // i'th bit neglecting all 
	            // the bit's after i'th bit 
	            se.add(arr[j] & mask); 
	        }
	        System.out.print(se.size());
	  
	        int newMaxx = maxx | (1 << i); 
	  
	        for (int prefix : se) 
	        { 
	  
	            // find two pair in set 
	            // such that a^b = newMaxx 
	            // which is the highest 
	            // possible bit can be obtained 
	            if (se.contains(newMaxx ^ prefix)) 
	            { 
	                maxx = newMaxx; 
	                break; 
	            } 
	        } 
	  
	        // clear the set for next 
	        // iteration 
	        se.clear(); 
	    } 
	    return maxx; 
	} 

}
