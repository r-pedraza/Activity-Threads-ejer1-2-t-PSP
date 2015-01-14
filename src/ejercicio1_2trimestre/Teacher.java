package ejercicio1_2trimestre;
/**
 * 
 * @author Raúl Pedraza
 *
 */

public class Teacher extends Thread {

	// CONSTANTS
	final static String ERROR = "Error";
	boolean activo;
	// PROPERTIES
	int num;
	Student s;

	// CONSTRUCTOR
	Teacher(int num) {
		this.num = num;
		// CREATE THREAD
		new Thread(this, "Profesor");
	}

	/**
	 * THIS METHOD RUN THREAD
	 */
	public void run() {

		synchronized (this) {

			try {
				System.out.println("------------------------");
				System.out.println("  ");
				System.out.println("Welcome Student, I,m teacher");
				System.out.println("  ");
				System.out.println("------------------------");
				notifyAll();
				wait();

			} catch (InterruptedException e) {
				System.err.println(ERROR);
			}

		}
	}
}
