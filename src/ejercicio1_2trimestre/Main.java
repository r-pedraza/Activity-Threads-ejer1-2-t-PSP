package ejercicio1_2trimestre;
/**
 * 
 * @author Raúl Pedraza
 *
 */
public class Main {

	public static void main(String[] args) {

		// Thread Student
		Student student = new Student(0);

		// Thread Teacher
		Teacher p = new Teacher(student.numStudent());
		//Start threads
		p.start();
		student.start();

	}
}
