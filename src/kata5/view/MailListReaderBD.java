package kata5.view;

import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;
import kata5.model.Person;
import kata5.persistence.PeopleLoader;
import kata5.persistence.SqlitePeopleLoader;

public class MailListReaderBD implements MailListReader {

    @Override
    public List<Mail> read() {
        List<Mail> mails = new ArrayList<>();
        PeopleLoader loader = new SqlitePeopleLoader();
        List<Person> people = loader.load();
        for (Person person : people) {
            mails.add(new Mail(person.getEmail()));
        }
        return mails;
    }
}
