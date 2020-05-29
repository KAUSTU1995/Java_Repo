package BuilderPattern;

public class Employee {
	private int id;
	private String name;
	private String designation;
	private double salary;
	
	public Employee(Builder b){
		this.id=b.id;
		this.name=b.name;
		this.designation=b.designation;
		this.salary=b.salary;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public static void main(String[] args) {
		Employee.Builder b=new Employee.Builder().setId(1).setName("Kaustubh").setDesignation("SSE").setSalary(1234000);
		System.out.print(b.id+" "+b.name+" "+b.designation+" "+b.salary);
	}

	static class Builder{
		private int id;
		private String name;
		private String designation;
		private double salary;
		public Employee build(){
			Employee e=new Employee(this);
			return e;
		}
		
		public Builder setId(int id){
			this.id=id;
			return this;
		}
		public Builder setName(String name) {
			this.name=name;
			return this;
		}
		public Builder setDesignation(String designation){
			this.designation=designation;
			return this;
		}
		public Builder setSalary(double salary){
			this.salary=salary;
			return this;
		}
	}

}
