package kata5.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;

public class MailListReaderFile {
    public List<Mail> read(String fileName) {
        List<Mail> list = new ArrayList<>();
        BufferedReader reader;
        FileReader fileReader;
        try {
            String line;
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            
            while ((line = reader.readLine()) != null) {
                if (isMail(line)) {
                    list.add(new Mail(line));
                }
            }
        } catch (IOException exe) {
            
        }
        return list;
    }
    
    private boolean isMail(String text) {
        return text.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}