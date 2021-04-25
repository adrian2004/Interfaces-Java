package application01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities01.Contract;
import model.entities01.Installment;
import model.services01.ContractService;
import model.services01.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner keyboard = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = keyboard.nextInt();
		keyboard.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(keyboard.nextLine());
		System.out.print("Contract value: ");
		double totalValue = keyboard.nextDouble();
		keyboard.nextLine();
		System.out.print("Enter number of installments: ");
		int months = keyboard.nextInt();
		
		Contract contract = new Contract(number, date, totalValue);
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, months);
		
		System.out.println("INSTALLMENTS:");
		for(Installment in : contract.getInstallments()) {
			System.out.println(in.toString());
		}
		
		
		keyboard.close();
	}

}
