package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.Enum.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departament's name: ");
		String departamentName = sc.nextLine();
		System.out.println("Enter Worker date: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName,
				                   WorkerLevel.valueOf(workerLevel),
				                   baseSalary,
				                   new Departament(departamentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.println("Enter contract #"+i+" data: ");
			System.out.print("Data (dd/MM/yyyy): ");
			Date contractDate = sdf1.parse(sc.next());
			System.out.print("Value per Hour: ");
			double valouePerHour = sc.nextDouble();
			System.out.print("Duration (Hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate,valouePerHour,hours);			
			worker.addContract(contract);
		}
		System.out.println("");
		System.out.print("Enter month and year to calculate income (MM/yyyy): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: "+worker.getName());
		System.out.println("Departament: "+worker.getDepartament().getName());
		System.out.println("Income for ("+monthAndYear+"): "+ String.format("%.2f",worker.income(year, month)));
		sc.close();
	}
}
