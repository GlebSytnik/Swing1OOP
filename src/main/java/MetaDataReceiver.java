import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MetaDataReceiver extends JFrame {
    // public static String sqlQueryGetColumnName =

  /*  public static void main(String[] args) throws SQLException {
        MetaDataReceiver meta = new MetaDataReceiver();
        Vector<String> columnName = meta.getColumnNames( new String("coach"));

    }*/

    public Vector<String> getColumnNames(String sqlQueryGetColumnName) throws SQLException {

        List<String> columnNames = new ArrayList<>();
        Vector<String> columnNamesVector = new Vector();
        try (Connection connection = DbConnectionProvider.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQueryGetColumnName)) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));

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
             Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlRequest);
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
    public JTable createJTable(String sqlRequest) throws SQLException {
        Vector dataVector = new Vector();
        Vector columnNamesVector = new Vector();
        dataVector = getRowData("select * from " + sqlRequest);
        columnNamesVector = getColumnNames("select * from " + sqlRequest);
        JTable table = new JTable(dataVector, columnNamesVector);
        return table;
    }

    public JScrollPane createJScrollPane(String sqlRequest) throws SQLException {
        JTable table = createJTable(sqlRequest);


        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        return scrollPane;
    }


}