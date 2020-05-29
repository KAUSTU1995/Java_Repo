package InterfacesConcept;

public class Test implements Circle,CircleTwo{

	@Override
	public void area() {
		// TODO Auto-generated method stub
//		return 0;
		System.out.println(Circle.pi);
		System.out.println(CircleTwo.pi);
	}
	

}
