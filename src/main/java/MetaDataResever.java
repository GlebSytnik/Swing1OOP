import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MetaDataResever {
    public static void main(String[] args) {
        MetaDataResever meta = new MetaDataResever();
       // Vector<String> vector = meta.getColumnNames();
    }

    public Vector<String> getColumnNames(String sqlRequest) throws SQLException {
        List<String> columnNames = new ArrayList<String>();
        Vector<String> columnNamesVector = new Vector();
        try (Connection connection = DbConnectionProvider.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sqlRequest)) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            //  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
                connection.close();
            }


        }
        for (int i = 0; i < columnNames.size(); i++)
            columnNamesVector.add(columnNames.get(i));
        return columnNamesVector;
    }

    public Vector<String> getRowData(String sqlRequest) {
        List data = new ArrayList<String>();
        Vector dataVector = new Vector();
        try (Connection connection = DbConnectionProvider.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sqlRequest)) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            while (rs.next()) {
                ArrayList<Object> row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getObject(i));
                }

                data.add(row);
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }
        return dataVector;

    }

    public List<String> getTableName(String sqlRequest) {
        List<String> tableNames = new ArrayList<String>();
        try (Connection connection = DbConnectionProvider.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sqlRequest)) {
            while (rs.next()) {
                System.out.print(rs.getString(1));
                tableNames.add(rs.getString(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tableNames;

    }
}