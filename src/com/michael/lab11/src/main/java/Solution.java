import java.sql.*;

public class Solution
{
    public static void main(String[] args) throws SQLException {
        SqliteSavedList<Integer> list = new SqliteSavedList<>(new SqliteDatabaseHelper<>("C:\\Users\\maste\\Documents\\SQLite DataBases\\testdb.s3db"));
        list.add(0, 3424);
        list.add(1, 34);
        list.add(2, 45);

        list.remove(1);

        list.set(0, 5);
    }
}
