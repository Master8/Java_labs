import org.sqlite.JDBC;

import java.io.File;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class SqliteSavedList<E extends Serializable> implements SavedList<E>
{
    private ArrayList<E> elements;
    private String filename;

    public SqliteSavedList(String filename) throws SQLException
    {
        this.filename = filename;
        this.elements = new ArrayList<E>();

        Driver driver = new JDBC();
        DriverManager.registerDriver(driver);

        reload();
    }

    @Override
    public void reload() {

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

        } catch (SQLException e) {
            throw new FileOperationException(e);
        }
    }

    private void saveElements()
    {
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

        } catch (SQLException e) {
            throw new FileOperationException(e);
        }
    }

    @Override
    public E get(int index) {
        if (elements.isEmpty())
            return null;

        return elements.get(index);
    }

    @Override
    public E set(int index, E element) {
        E newElement = elements.set(index, element);
        saveElements();

        return newElement;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(int index, E element) {

        elements.add(index, element);
        saveElements();
    }

    @Override
    public E remove(int index) {
        E element = elements.remove(index);
        saveElements();

        return element;
    }
}
