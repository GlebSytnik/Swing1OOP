import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

/*public class TableFromMySqlDatabase extends JFrame {
    public TableFromMySqlDatabase() {

    }

    public static void main(String[] args) {
        TableFromMySqlDatabase frame = new TableFromMySqlDatabase();
        frame.getTable();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JTable getTable() {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();


        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program
        // is finished with them
        try (Connection connection = DbConnectionProvider.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(Main.GET_COACH)) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
            }

            //  Get row data
            while (rs.next()) {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getObject(i));
                }

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++)
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data
        JTable table = new JTable(dataVector, columnNamesVector) ;
        return table;

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
}*/

