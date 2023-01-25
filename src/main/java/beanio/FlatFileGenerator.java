package beanio;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class FlatFileGenerator {

    public static void main(String[] args) throws Exception {
        //create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        //load the mapping file
        factory.load("src/main/resources/mapping.xml");

        //use a BeanWriter to write the flat file
        BeanWriter out = factory.createWriter("mapping", new FileWriter("src/main/resources/output/flatFile.txt"));

        //create a list of detail objects
        List<Detail> details = Arrays.asList(
                new Detail("6813162459", "RM2.00"),
                new Detail("2039229524", "RM10.00")
        );

        Header header = new Header("H","FLAT_FILE");
        out.write("header", header);

        //write the detail objects to the flat file
        for (Detail detail : details) {
            out.write(detail);
        }

        Trailer trailer = new Trailer("T","FLAT_FILE");
        out.write("trailer", trailer);


        out.flush();
        out.close();
    }
}
