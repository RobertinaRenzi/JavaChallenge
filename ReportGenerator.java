package robertina.renzi.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class ReportGenerator {

	@Test
	public void testReading() throws Exception {
		File testFile = new File("test.csv");
		List<Instruction> instructions = InstructionReader.readFile(testFile);
		List<Report> settledIncoming = new ArrayList<Report>();
		List<Report> settledOutgoing = new ArrayList<Report>();
		for (Instruction instruction : instructions) {

			if (isWorkingDay(instruction.getCurrency(), instruction.getSettlementDate())) {
				double amount = instruction.getPricePerUnit() * instruction.getUnits() * instruction.getAgreedFx();
				Report report = new Report(instruction.getEntity(), instruction.getCurrency(), amount);
				if (instruction.getOperation().equals("B")) {
					settledIncoming.add(report);
				} else {
					settledOutgoing.add(report);
				}
			}
		}
		System.out.println("Amount settled incoming");
		Collections.sort(settledIncoming, Report.getCompByAmount());
		System.out.println(settledIncoming);
		System.out.println();
		System.out.println("Amount settled outgoing");
		Collections.sort(settledOutgoing, Report.getCompByAmount());
		System.out.println(settledOutgoing);

	}

	public boolean isWorkingDay(String currency, Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (currency.equals("AED") || currency.equals("SAR")) {
			if (dayOfWeek == 7 || dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4) {
				return true;
			}
			return false;
		} else {
			if (dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5) {
				return true;
			}
			return false;
		}
	}

}
