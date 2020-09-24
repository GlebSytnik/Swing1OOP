import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        JFrame frame = new JFrame("Board");
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        final JPanel panel = new JPanel(new GridLayout(3, 3));
        /* List<String> tableNames = new MetaDataReceiver().getTableName();
        for (String name:tableNames){
            JButton button = new JButton(name);
            panel.add(button);
        }*/


        JButton button = new JButton("coach");
        final JButton button2 = new JButton("customers");
        final JButton button3 = new JButton("workouts");
        final JButton button4 = new JButton("subscription");
        final JButton button5 = new JButton("administrator");


        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);

        button.addActionListener(new ButtonActionListener2());

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableFromMySqlDatabase tableFromMySqlDatabase = new TableFromMySqlDatabase();
                tableFromMySqlDatabase.getTable(button2.getText());
                tableFromMySqlDatabase.setDefaultCloseOperation(tableFromMySqlDatabase.EXIT_ON_CLOSE);
                tableFromMySqlDatabase.pack();
                tableFromMySqlDatabase.setVisible(true);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableFromMySqlDatabase frame = new TableFromMySqlDatabase();
                frame.getTable(button3.getText());
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableFromMySqlDatabase frame = new TableFromMySqlDatabase();
                frame.getTable(button4.getText());
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableFromMySqlDatabase frame = new TableFromMySqlDatabase();
                frame.getTable(button5.getText());
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

