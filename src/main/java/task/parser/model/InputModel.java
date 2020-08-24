package task.parser.model;

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
public class InputModel /* extends Model */{
	String orderId;
	String amount;
	String currency;
	String comment;
	
//	@Builder
//	public InputModel(String orderId, String amount, String currency, String comment) {
//		super(currency, comment);
//		this.orderId = orderId;
//		this.amount = amount;
//		this.currency = currency;
//		this.comment = comment;
//	}
}