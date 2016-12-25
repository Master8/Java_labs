import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maste on 25.12.2016.
 */
public class TestDatabaseHelper<E extends Serializable> implements DatabaseHelper<E>
{
    private static Map<String, List<String>> files = new HashMap<>();

    private String filename;

    public TestDatabaseHelper(String filename)
    {
        this.filename = filename;

        if (!files.containsKey(filename))
        {
            files.put(filename, new ArrayList<>());
        }
    }

    @Override
    public List<E> loadElements() throws SQLException {
        return (List<E>)files.get(filename);
    }

    @Override
    public void saveElements(List<E> elements) throws SQLException {
        this.files.get(filename).clear();
        this.files.get(filename).addAll((List<String>)elements);
    }

    public void fileDelete()
    {
        this.files.get(filename).clear();
    }
}
