package robertina.renzi.test;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class InstructionReader {
	public static List<Instruction> readFile(File csvFile) throws Exception {
		
		CsvSchema schema = CsvSchema.builder()
				.addColumn("Entity")
				.addColumn("Buy/Sell")
				.addColumn("AgreedFx")
				.addColumn("Currency")
				.addColumn("InstructionDate")
				.addColumn("SettlementDate")
				.addColumn("Units",CsvSchema.ColumnType.NUMBER)
				.addColumn("Price per unit",CsvSchema.ColumnType.NUMBER)				
				.build().withHeader()
				.withColumnSeparator(';');
		CsvMapper csvMapper = new CsvMapper();
		MappingIterator<Instruction> instructionIter = csvMapper.readerFor(Instruction.class).with(schema).readValues(csvFile);
		
		return instructionIter.readAll();
	}

}
