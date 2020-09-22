import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MetaDataReceiverAnalog {

    public static void main(String[] args) throws SQLException {
        MetaDataReceiverAnalog meta = new MetaDataReceiverAnalog();
        List<String> tableName = meta.getTableName();
        for (String e : tableName) {
            System.out.println(e);
        }
        Vector<String> columnName = meta.getColumnNames(new String("coach"));
        for (String e : columnName) {
            System.out.println(e);
        }
        Vector<String> dataName = meta.getRowData(new String("coach"));

    }

    public Vector<String> getColumnNames(String tableName) throws SQLException {
        Connection connection = DbConnectionProvider.getConnection();
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet columns = databaseMetaData.getColumns(null, null, tableName, null);
        Vector<String> columnNames = new Vector<>();
        while (columns.next()) {
            String columnName = columns.getString("COLUMN_NAME");
            columnNames.add(columnName);
        }
        return columnNames;
    }

    public List<String> getTableName() throws SQLException {
        Connection connection = DbConnectionProvider.getConnection();
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
        List<String> tableName = new ArrayList<>();
        while (resultSet.next()) {
            //Print
            tableName.add(resultSet.getString("TABLE_NAME"));
        }
        return tableName;
    }

    public Vector<String> getRowData(String tableName) {
        List data = new ArrayList<String>();
        Vector dataVector = new Vector();
        try (Connection connection = DbConnectionProvider.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery( new String("SELECT * FROM " + tableName))) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            while (rs.next()) {
                ArrayList<Object> row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getObject(i));
                }

                data.add(row);
               // connection.close();
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

}
