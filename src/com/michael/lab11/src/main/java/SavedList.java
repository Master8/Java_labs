import java.io.Serializable;

public interface SavedList<E extends Serializable>
{
    void reload();
    E get(int index);
    E set(int index, E element);
    int size();
    void add(int index, E element);
    E remove(int index);
}
