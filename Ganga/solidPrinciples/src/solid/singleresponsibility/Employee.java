// This is an example of Single Responsibility Principle where class is performing only 1 task.

package solid.singleresponsibility;

public class Employee {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.work();	
	}
	public void work() {
		System.out.println("Employee works 8 hours a day");
	}
}
