package task.parser.service.parsing;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import task.parser.model.InputModel;
import task.parser.model.OutputModel;

public interface Handler {
	
	public static final ObjectMapper MAPPER = new ObjectMapper();
	
	void converter(String fileName);
	
	String getFormatName();
	
	default void createOutput(InputModel inputModel, long line, String filePath) {

		OutputModel outputModel;
		String id = inputModel.getOrderId();
		BigDecimal amount = StringUtils.isNumeric(inputModel.getAmount())?new BigDecimal(inputModel.getAmount()):null;
		String currency = inputModel.getCurrency();
		String comment = inputModel.getComment();
		
		if (Strings.isNullOrEmpty(id) || amount==null ||
				Strings.isNullOrEmpty(currency) || Strings.isNullOrEmpty(comment)) {
			
			outputModel = OutputModel.builder()
					.id(id)
					.amount(null)
					.currency(null)
					.comment(null)
					.line(line)
					.filename(filePath)
					.result("ERROR: Wrong data in line " + line + ", please check input information.")
					.build();			
		} else {
			outputModel = OutputModel.builder()
					.id(id)
					.amount(amount)
					.currency(currency)
					.comment(comment)
					.line(line)
					.filename(filePath)
					.result("OK")
					.build();
		}
		printResult(outputModel);
	}
	
	default void printResult(OutputModel outputModel) {
		String output = null;
		
		try {
			output = MAPPER.writeValueAsString(outputModel);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(output);
	}
}