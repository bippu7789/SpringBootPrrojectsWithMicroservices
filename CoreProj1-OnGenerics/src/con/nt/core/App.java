package con.nt.core;

import java.sql.Date;
import java.util.ArrayList;

public class App {
	public <T> T showDetails(Class<T> clazz) throws Exception {
		// return (T) clazz.getDeclaredConstructors()[0].newInstance(); picup first
		// constructor from list of constructor not mandrotry o0 param constructor

		return (T) clazz.getDeclaredConstructor(new Class[] {}).newInstance();// pics up only 0 param constructor
	}

	public <T extends Person> T showDetails1(Class<T> clazz) throws Exception {
		return (T) clazz.getDeclaredConstructor(new Class[] {}).newInstance();// pics up only 0 param constructor

	}

	public static void main(String[] args) throws Exception {
		App app = new App();
		// Invoking show details method
		Student st = app.showDetails(Student.class);
		System.out.println(st);
		Employee emp = app.showDetails(Employee.class);
		System.out.println(emp);
		Date d = app.showDetails(Date.class);
		System.out.println(d);
		ArrayList list = app.showDetails(ArrayList.class);
		System.out.println(list);

		System.out.println("================================");
		// Invoking show details method
		Student st1 = app.showDetails1(Student.class);
		System.out.println(st);
		Employee emp1 = app.showDetails1(Employee.class);
		System.out.println(emp);
//		Date d1 = app.showDetails1(Date.class);
//		System.out.println(d1);
//		ArrayList list1 = app.showDetails1(ArrayList.class);
//		System.out.println(list1);
	}

}
