package kata5.persistence;

import kata5.model.Person;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlitePeopleLoader implements PeopleLoader {

    @Override
    public List<Person> load() {
        List<Person> people = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC"); // carga el driver de sqlite
            Connection connection = DriverManager.getConnection("jdbc:sqlite:data/people.db"); // establece la conexión con el driver
            try (Statement statement = connection.createStatement()) { // creamos una orden hacia la base de datos
                ResultSet set = statement.executeQuery("select * from people");
                while (set.next()) {
                    String name = set.getString("first_name");
                    String address = set.getString("address");
                    String email = set.getString("email");
                    people.add(new Person(name, address, email));
                    System.out.println(email);
                } 
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SqlitePeopleLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return people;
    }
}
