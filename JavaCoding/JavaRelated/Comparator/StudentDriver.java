package Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class StudentDriver {
	public static void main(String[] args) {
		StudentClass s1=new StudentClass(15, "Ram", "8th");
		StudentClass s2=new StudentClass(25, "Syam", "4th");
		StudentClass s3=new StudentClass(5, "Sita", "5th");
		StudentClass s4=new StudentClass(12, "Hanuman", "10th");
		StudentClass[] arr= {s1,s2,s3,s4};
		Arrays.sort(arr,new Comparator<StudentClass>() {

			@Override
			public int compare(StudentClass a,StudentClass b) {
//				a.
				if(a.getRollNum()<b.getRollNum()) {
					return -1;
				}else if(a.getRollNum()>b.getRollNum()) {
					return 1;
				}
				else {
					return 0;
				}
//				return a.compareTo(b);
			}
			
		});
		for(StudentClass s:arr) {
			print(s);
			System.out.println();
		}
//		System.out.println(s1.hashCode());
	}

	private static void print(StudentClass s) {
		s.toString();
	}

}
