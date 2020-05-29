package SingletonPatterns;
public class StaticBlockSingleton {
	private static StaticBlockSingleton instance;
	
	private StaticBlockSingleton(){
		
	}
	
	static{
		try{
		if(instance==null){
			instance=new StaticBlockSingleton();
		}
		}catch(Exception e){
			throw new RuntimeException("Exception in creating singleton object");
		}
	}
	
	public static StaticBlockSingleton getInstance(){
		return instance;
	}

}
