import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;

public class FileSavedList<E extends Serializable> extends AbstractList<E> implements Reloadable, SavedList<E> {

    private ArrayList<E> elements;
    private File file;

    public FileSavedList(File file)
    {
        this.file = file;
        reload();
    }

    public void reload() throws FileOperationException {

        if (file.exists())
        {
            try
            {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
                elements = (ArrayList<E>)inputStream.readObject();
                inputStream.close();
            }
            catch (Exception e)
            {
                throw new FileOperationException(e);
            }
        }
        else
        {
            elements = new ArrayList<E>();
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

    private void saveElements()
    {
        try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));

            outputStream.writeObject(elements);

            outputStream.close();
        }
        catch (Exception e)
        {
            throw new FileOperationException(e);
        }
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(int index, E element)
    {
        elements.add(index, element);
        saveElements();
    }

    @Override
    public boolean add(E element)
    {
        boolean result = elements.add(element);
        saveElements();

        return result;
    }

    @Override
    public E remove(int index) {
        E element = elements.remove(index);
        saveElements();

        return element;
    }

    @Override
    public boolean remove(E element) {
        boolean result = elements.remove(element);

        saveElements();

        return result;
    }

    @Override
    public boolean contains(E element) {
        return super.contains(element);
    }
}