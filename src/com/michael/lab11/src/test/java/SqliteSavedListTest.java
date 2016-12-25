import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.AbstractList;
import java.util.Iterator;

public class SqliteSavedListTest
{
    @Test
    public void test1() throws Exception {

        // create list
        SavedList<String> list = new SqliteSavedList<>(new TestDatabaseHelper<>("./list1.dat"));
        list.add("One");
        list.add("Two");
        list.add("Three");
        for (int i = 0; i < 100; i++) {
            list.add(1, "Hello " + i);
        }
        list.remove("Two");

        // check contents
        Assert.assertTrue(list.contains("Hello 50"));
        Assert.assertEquals(102, list.size());
        Assert.assertEquals("One", list.get(0));
        Assert.assertEquals("Hello 99", list.get(1));
        Assert.assertEquals("Hello 0", list.get(100));

        SavedList<String> list2 = new SqliteSavedList<>(new TestDatabaseHelper<>("./list1a.dat"));
        list2.add("One");
        list2.add("Two");
        list2.add("Three");

        // retain
        ((AbstractList)list).retainAll((AbstractList)list2);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void test2() throws Exception {

        // create list
        SavedList<String> list = new SqliteSavedList<>(new TestDatabaseHelper<>("./list2.dat"));
        list.add("One");
        list.add("Two");
        list.add("Three");
        for (int i = 0; i < 100; i++) {
            list.add(1, "Hello " + i);
        }
        list.remove("Two");
        list = null;

        // load list
        SavedList<String> loadedList = new SqliteSavedList<>(new TestDatabaseHelper<>("./list2.dat"));

        Assert.assertTrue(loadedList.contains("Hello 50"));
        Assert.assertEquals(102, loadedList.size());
        Assert.assertEquals("One", loadedList.get(0));
        Assert.assertEquals("Hello 99", loadedList.get(1));
        Assert.assertEquals("Hello 0", loadedList.get(100));
    }

    @Test
    public void test3() throws Exception {

        // create list
        SavedList<String> list = new SqliteSavedList<>(new TestDatabaseHelper<>("./list3.dat"));
        list.add("One");
        list.add("Two");
        list.add("Three");
        for (int i = 0; i < 100; i++) {
            list.add(1, "Hello " + i);
        }
        list.remove("Two");

        // load list and remove elements
        TestDatabaseHelper<String> helper = new TestDatabaseHelper<>("./list3.dat");
        SavedList<String> loadedList = new SqliteSavedList<>(helper);
        for (Iterator<String> iterator = ((AbstractList)loadedList).iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            if (next.contains("8")) {
                iterator.remove();
            }
        }
        Assert.assertEquals(83, loadedList.size());

        // reload
        list.reload();
        Assert.assertFalse(((AbstractList)list).isEmpty());
        Assert.assertEquals(83, list.size());

        helper.fileDelete();

        // reload
        list.reload();
        Assert.assertTrue(((AbstractList)list).isEmpty());
        Assert.assertEquals(0, list.size());
    }


    @Test
    public void test4() throws Exception {

        // create list
        SavedList<Integer> list = new SqliteSavedList<>(new TestDatabaseHelper<>("./list4.dat"));
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(0, 999);
        list = null;

        // load list
        SavedList<Integer> loadedList = new SqliteSavedList<>(new TestDatabaseHelper<>("./list4.dat"));

        Assert.assertEquals(Integer.valueOf(999), loadedList.get(0));
        Assert.assertEquals(Integer.valueOf(2), loadedList.get(1));
        Assert.assertEquals(Integer.valueOf(3), loadedList.get(2));
        Assert.assertEquals(3, loadedList.size());
    }
}
