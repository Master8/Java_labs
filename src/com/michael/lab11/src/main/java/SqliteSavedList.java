import org.sqlite.JDBC;

import java.io.File;
import java.io.Serializable;
import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;

public class SqliteSavedList<E extends Serializable> extends AbstractList<E> implements SavedList<E>, Reloadable
{
    private ArrayList<E> elements;
    private DatabaseHelper<E> databaseHelper;

    public SqliteSavedList(DatabaseHelper<E> databaseHelper)
    {
        this.databaseHelper = databaseHelper;
        this.elements = new ArrayList<>();

        reload();
    }

    @Override
    public void reload() {

        try
        {
            elements.clear();
            elements.addAll(databaseHelper.loadElements());

        } catch (SQLException e) {
            throw new FileOperationException(e);
        }
    }

    private void saveElements()
    {
        try
        {
           databaseHelper.saveElements(elements);

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
    public boolean contains(E element) {
        return super.contains(element);
    }

    @Override
    public boolean remove(E element) {
        boolean result = elements.remove(element);

        saveElements();

        return result;
    }
}
