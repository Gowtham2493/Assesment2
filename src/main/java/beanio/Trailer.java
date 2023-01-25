package beanio;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record(order = 3)
public class Trailer {
    @Field(ordinal = 1, length = 1, at = 0)
    private String recordType;
    @Field(ordinal = 1, length = 15, at = 14)
    private String fileType;

    public Trailer(String recordType, String fileType) {
        this.recordType = recordType;
        this.fileType = fileType;
    }
}
