public class Test {
  public static void main(String sp[]) {
    (new Test()).go();
  }

  
  public void go() {
	double f1 = 0.1d;

	double sum = 0.0d;

	for (int i = 0; i< 10; i++) {
		sum += f1;
	}

	double prod = f1 * 10.0d;
	System.out.println(sum);
	System.out.println(prod);

  }
}


        
