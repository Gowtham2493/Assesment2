package beanio;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record(order = 2)
public class Detail {

    @Field(ordinal = 1, length = 14, at = 20)
    private String referenceNo;
    @Field(ordinal = 1, length = 16, at = 40)
    private String amount;

    public Detail(String referenceNo, String amount) {
        this.referenceNo = referenceNo;
        this.amount = amount;
    }
}
