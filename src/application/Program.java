package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome do departamento: ");
		String nameDepartment = sc.next();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();

		Address address = new Address(email, phone);
		Department dept = new Department(nameDepartment, payDay, address);

		System.out.print("\nQuantos funcionários tem o departamento: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("\nDados do funcionário %d: ", i + 1);
			sc.nextLine();
			String nameEmployee = sc.nextLine();
			System.out.print("Salário: ");
			Double salary = sc.nextDouble();

			Employee employees = new Employee(nameEmployee, salary);
			dept.addEmployee(employees);
		}

		System.out.print("\nFOLHA DE PAGAMENTO:\n");
		showReport(dept);

		sc.close();
	}

	private static void showReport(Department dept) {
		System.out.printf("Departamento %s = R$ %.2f\n", dept.getName(), dept.payroll());
		System.out.printf("Pagamento realizado no dia %d\n", dept.getPayDay());
		System.out.println("Funcionários:");
		for (Employee emp : dept.getEmployees()) {
			System.out.println(emp.getName());
		}
		System.out.printf("Para dúvidas favor entrar em contato: %s", dept.getAddress().getEmail());
	}

}
