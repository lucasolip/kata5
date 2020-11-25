package kata5;

import java.sql.*;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReader;
import kata5.view.MailListReaderBD;
import kata5.view.SwingHistogramDisplay;

public class Kata5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MailListReader reader = new MailListReaderBD();
        MailHistogramBuilder builder = new MailHistogramBuilder();
        HistogramDisplay histogramDisplay = new SwingHistogramDisplay("Histogram", builder.build(reader.read()));
        histogramDisplay.execute();
    }
}