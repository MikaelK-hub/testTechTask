package task.parser.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class InputModel extends Model{
	String orderId;
	String amount;

	@Builder
	public InputModel(String currency, String comment, String orderId, String amount) {
		super(currency, comment);
		this.orderId = orderId;
		this.amount = amount;
	}
}