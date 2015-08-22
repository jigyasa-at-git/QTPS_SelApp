import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// calling method whose name we store in a variable
public class ReflectionAPI {
	
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		//sampleTest("xxxXX");
			String x="sampleTest";
			//String meth=read name from xls file
			Method method= ReflectionAPI.class.getMethod(x, String.class);
			method.invoke(method, "hello");
			
			
	        System.out.println("end");
		}
		
		public static void sampleTest(String x){
			System.out.println("in sample test-- "+x);
		}

	}

