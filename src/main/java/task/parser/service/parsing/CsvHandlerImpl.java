package task.parser.service.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.common.base.Strings;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import task.parser.model.Extension;
import task.parser.model.InputModel;

@Service
public class CsvHandlerImpl implements Handler {
	
	@Override
	public void converter(String filePath) {
				
		try (BufferedReader buf = Files.newBufferedReader(Paths.get(filePath))) {
			parseExecution(buf, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void parseExecution(BufferedReader buf, String filePath) {
		try {
			List<CSVRecord> list = CSVFormat.EXCEL.parse(buf)
			.getRecords();
			
			list
			.stream()
					.filter(r -> r.size() == 4)
			.forEach(r -> parseRecord(r, filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void parseRecord(CSVRecord record, String filePath) {
		String id = record.get(0);
		String amount = record.get(1);
		String currency = record.get(2);
		String comment = record.get(3);

		InputModel inputModel = InputModel.builder()
					.orderId(id)
					.amount(amount)
					.currency(currency)
					.comment(comment)
					.build();

			createOutput(inputModel, record.getRecordNumber(), filePath);
	}

	@Override
	public String getFormatName() {
		return Extension.CSV.getNameLowerCase();
	}
}