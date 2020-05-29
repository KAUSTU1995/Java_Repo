package SingletonPatterns;

public class ThreadSafeBetterSingleton {
	private static ThreadSafeBetterSingleton instance;
	
	private ThreadSafeBetterSingleton(){}
	
	public static ThreadSafeBetterSingleton getInstance(){
		if(instance==null){
			synchronized (ThreadSafeBetterSingleton.class) {
				if(instance==null){
					instance=new ThreadSafeBetterSingleton();
				}
			}
		}
		return instance;
	}

}
