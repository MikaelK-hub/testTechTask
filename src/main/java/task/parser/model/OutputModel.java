package task.parser.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@EqualsAndHashCode(callSuper = true)
@EqualsAndHashCode
@ToString
public class OutputModel /* extends Model */{
	String id;
	BigDecimal amount;
	String currency;
	String comment;
	String filename;
	long line;
	String result;
	
//	@Builder
//	public OutputModel(String id, BigDecimal amount, String currency, String comment, String filename, long line,
//			String result) {
//		super(currency, comment);
//		this.id = id;
//		this.amount = amount;
//		this.filename = filename;
//		this.line = line;
//		this.result = result;
//		this.currency = currency;
//		this.comment = comment;
//	}
}