package Comparable;

public class StudentClass implements Comparable<StudentClass> {
	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	private int rollNum;
	private String name;
	private String classroom;
	public StudentClass(int rollNum, String name, String classroom) {
		this.rollNum=rollNum;
		this.name=name;
		this.classroom=classroom;
	}
	
	@Override
	public int compareTo(StudentClass o) {
		// TODO Auto-generated method stub
		int i= this.name.compareTo(o.name);
		return i;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("The details of student is: "+ this.rollNum+ " "+ this.name+" "+this.classroom);
		return "";
	}
	

}
