package backtracking;
import java.util.UUID;
public class NeverOutOfMemory {	
	    public static void main(String []args) {
	        while (true) {
	            System.out.println(new String(UUID.randomUUID().toString()));
	        }
	    }
	
}
