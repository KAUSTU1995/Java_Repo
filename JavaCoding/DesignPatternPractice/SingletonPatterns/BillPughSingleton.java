package SingletonPatterns;

public class BillPughSingleton {
//	private static BillPughSingleton instance;
	
	private BillPughSingleton(){}
	
	private static class Builder{
		private static final BillPughSingleton INSTANCE=new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance(){
		return Builder.INSTANCE;
	}

}
