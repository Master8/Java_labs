import org.sqlite.JDBC;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqliteDatabaseHelper<E extends Serializable> implements DatabaseHelper<E>
{
    private String filename;

    public SqliteDatabaseHelper(String filename) throws SQLException
    {
        this.filename = filename;

        Driver driver = new JDBC();
        DriverManager.registerDriver(driver);
    }

    @Override
    public List<E> loadElements() throws SQLException
    {

        ArrayList<E> elements = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
             Statement statement = connection.createStatement())
        {
            connection.setAutoCommit(true);

            ResultSet result = statement.executeQuery("select * from elements;");

            while(result.next())
            {
                Object element = result.getObject("element");
                elements.add((E)element);
            }

            result.close();
        }

        return elements;
    }

    @Override
    public void saveElements(List<E> elements) throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
             Statement statement = connection.createStatement())
        {
            connection.setAutoCommit(true);

            statement.execute("delete from elements;");

            for (int i = 0; i < elements.size(); i++)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into elements values (?, ?)");
                preparedStatement.setInt(1, i);
                preparedStatement.setObject(2, elements.get(i));
                preparedStatement.executeUpdate();
            }
        }
    }
}
