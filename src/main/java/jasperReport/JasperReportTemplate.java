package jasperReport;

import beanio.DataBean;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JasperReportTemplate {

    public static void main(String[] args) throws Exception {
        //create a JasperDesign object
        Path path = Paths.get("src/main/resources//template_Table.jrxml");
        JasperDesign design = JRXmlLoader.load(new File(path.toString()));

        //compile the JasperDesign object to create a JasperReport object
        File file = new File(path.toString());
        JasperReport report = JasperCompileManager.compileReport(file.toString());


        // fill out the report into a print object, ready for export.
        Map<String, Object> parameters = new HashMap<>();
        ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

        dataBeanList.add(new DataBean("25/01/2023", "1234",new BigDecimal("1500.50"),"Active","Test"));

        JRBeanCollectionDataSource beanColDataSource =
                new JRBeanCollectionDataSource(dataBeanList);
        parameters.put("ItemDataSource", beanColDataSource);
        JasperPrint print = JasperFillManager.fillReport(report,parameters,  new JREmptyDataSource());

        //save the JasperReport object to a file
        JasperExportManager.exportReportToPdfFile(print,"src/main/resources/output/report.pdf");

    }
}
