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
@EqualsAndHashCode(callSuper = true)
public class OutputModel extends Model{
	String id;
	BigDecimal amount;
	String filename;
	long line;
	String result;

	@Builder
	public OutputModel(String currency, String comment, String id, BigDecimal amount, String filename, long line, String result) {
		super(currency, comment);
		this.id = id;
		this.amount = amount;
		this.filename = filename;
		this.line = line;
		this.result = result;
	}

	@Override
	public String toString() {
		return "{" +
				"id='" + id + '\'' +
				", amount=" + amount +
				", currency='" + currency + '\'' +
				", comment='" + comment + '\'' +
				", filename='" + filename + '\'' +
				", line=" + line +
				", result='" + result + '\'' +
				'}';
	}
}