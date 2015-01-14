package ejercicio1_2trimestre;

public class Student extends Thread {

	// CONSTANTES
	final static String ERROR = "Error";
	// ATRIBUTOS
	private int sleep;
	private int num = 0;
	Teacher p;
	boolean activo;

	// CONSTRUCTOR
	Student(int sleep) {
		// Says time to sleep thread
		this.sleep = sleep;
		// create thread
		new Thread(this, "Student");
	}

	/**
	 * The Thread need method to run
	 */
	public void run() {
		synchronized (this) {
			studentPresentation();
			numStudent();

			if (num == 10)
				notify();

			try {
				wait();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// if (num != 10) {
		// numStudent();
		//
		// }
		// if (num == 10){
		// notifyAll();
		// } else {
		// try {
		// wait();
		// } catch (InterruptedException e) {
		// System.err.println(ERROR);
		// }
		// }

	}

	/**
	 * This method contains the arrived of Students
	 * 
	 * @return integer
	 */

	public int numStudent() {
		System.out.println(" STUDENT ARRIVED ");
		System.out.println("------------------------");
		while (num <= 10)
			try {

				System.out.println("Student " + (num + 1) + " arrived");
				Thread.sleep((int) (Math.random() * sleep));

				num++;

			} catch (Exception e) {
			}
		return num;
	}
/**
 * This method contains the presentation of Students
 */
	public synchronized void studentPresentation() {

		while (num != 11)
			try {
				wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (num == 11)

			System.out.println(" STUDENT PRESENTATION ");
		System.out.println("------------------------");
		for (int i = 1; i < 12; i++)

			System.out.println("Presentation Student " + i + " arrived");

		try {
			Thread.sleep((int) (Math.random() * sleep));
		} catch (InterruptedException e) {
			System.err.println(ERROR);
		}

	}

}
