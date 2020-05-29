package SingletonPatterns;


public class EagerInitializedSingleton {
	private static final EagerInitializedSingleton instance=new EagerInitializedSingleton();
	
	//private constructor
	private EagerInitializedSingleton(){
		
	}
	
	public static EagerInitializedSingleton getInstance(){
		return instance;
	}

}
