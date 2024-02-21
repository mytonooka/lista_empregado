package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List <Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		Integer n = sc.nextInt();

		for (int i = 0;i<n;i++) {

			System.out.println();
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			// chama a classe Employee
			Employee emp = new Employee(id, name, salary);

			// Adiciona a lista digitada
			list.add(emp);

		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase : ");
		int idSalary = sc.nextInt();


		//Comment: Create class static "pos" to find Id in list:
		//Integer pos = position(list, idSalary);

		//Other option to resolve: Find Id in list using "Lambda"
		Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

		//if (pos == null) {
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the porcentage: ");
			Double percentage = sc.nextDouble();

			//list.get(pos).increaseSalary(percentage);
			emp.increaseSalary(percentage);
		}

		System.out.println();
		System.out.println("List of Employyes:");
		for (Employee e : list) {
			System.out.println(e);
		}

		sc.close();

	}

	//Comment: Create class static "pos" to find Id in list:
	public static Integer position(List <Employee> list, int id) {
		for (int i=0; i < list.size(); i++) {
			if (list.get(i).getId() == id){
				return i;
			}
		}
		return null;
	}

}
