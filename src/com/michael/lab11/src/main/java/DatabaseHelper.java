import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseHelper<E extends Serializable>
{
    List<E> loadElements() throws SQLException;
    void saveElements(List<E> elements) throws SQLException;
}
