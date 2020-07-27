package Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StudentDriver2 {
	public static void main(String[] args) {
		StudentClass s1=new StudentClass(15, "Ram", "8th");
		StudentClass s2=new StudentClass(25, "Syam", "4th");
		StudentClass s3=new StudentClass(5, "Sita", "5th");
		StudentClass s4=new StudentClass(12, "Hanuman", "10th");
		StudentClass[] arr= {s1,s2,s3,s4};
		StudentClass[] arr2= {s2,s1,s3,s4};
		//Object sorting
		Comparator<StudentClass> obj=(StudentClass q1,StudentClass q11) -> q1.getName().compareTo(q11.getName());
		Arrays.sort(arr,obj);
		List<StudentClass[]> list=new ArrayList<>();
		list.add(arr);
		list.add(arr2);
//		list.sort(null);
		
		//List sorting
		Comparator<StudentClass[]> ss=(a,b) ->b[0].getName().compareTo(a[0].getName());
		list.sort(ss);
		for(StudentClass[] as:list) {
			for(StudentClass aq:as)
			System.out.println(aq.toString());
			
			System.out.println("--------------"); 
		}
		
		System.out.println("Array section------------------");
		StudentClass[][] array=new StudentClass[2][2];
		array[0]=arr;
		array[1]=arr2;
		System.out.println("Size: "+ array[0].length);
//		Comparator<>
		Comparator<StudentClass[]> arraycomp= new Comparator<StudentClass[]>() {
			@Override
			public int compare(StudentClass[] d1,StudentClass[] d2) {
				return d1[0].getName().compareTo(d2[0].getName());
			}
		};
		Arrays.sort(array,arraycomp);
		for(StudentClass[] zz:array) {
			for(StudentClass s:zz) {
				System.out.print(s.toString()+"    ");
			}
			System.out.println("----------------------------");
		}
	}

}
