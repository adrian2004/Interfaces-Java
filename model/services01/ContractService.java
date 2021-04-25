package model.services01;

import java.util.Calendar;
import java.util.Date;

import model.entities01.Contract;
import model.entities01.Installment;

public class ContractService {

	private OnlinePaymentService ops;
	
	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}

	public void processContract(Contract contract, Integer months) {
		double basicQuota = contract.getTotalValue() / months;
		for(int i = 1; i <= months; i++) {
			double updatedQuota = ops.interest(basicQuota, i);
			double fullQuota = ops.paymentFee(updatedQuota);
			
			Date date = addMonths(contract.getDate(), i);
			contract.addInstallment(new Installment(date, fullQuota));
		}
	}
	
	private Date addMonths(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}
}
