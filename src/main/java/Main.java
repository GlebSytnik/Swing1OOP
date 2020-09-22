import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {



    public static void main(String[] args) throws ClassNotFoundException {

        JFrame frame = new JFrame("Board");
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        final JPanel panel = new JPanel(new GridLayout(3, 3));


        JButton button = new JButton("coach");
        JButton button2 = new JButton("customers");
        JButton button3 = new JButton("workouts");
        JButton button4 = new JButton("subscription");
        JButton button5 = new JButton("administrator");



        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableFromMySqlDatabase tableFromMySqlDatabase = new TableFromMySqlDatabase();
                tableFromMySqlDatabase.getTable("coach");
                tableFromMySqlDatabase.setDefaultCloseOperation(tableFromMySqlDatabase.EXIT_ON_CLOSE);
                tableFromMySqlDatabase.pack();
                tableFromMySqlDatabase.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableFromMySqlDatabase tableFromMySqlDatabase = new TableFromMySqlDatabase();
                tableFromMySqlDatabase.getTable("customers");
                tableFromMySqlDatabase.setDefaultCloseOperation(tableFromMySqlDatabase.EXIT_ON_CLOSE);
                tableFromMySqlDatabase.pack();
                tableFromMySqlDatabase.setVisible(true);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableFromMySqlDatabase frame = new TableFromMySqlDatabase();
                frame.getTable("workouts");
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableFromMySqlDatabase frame = new TableFromMySqlDatabase();
                frame.getTable("subscription");
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableFromMySqlDatabase frame = new TableFromMySqlDatabase();
                frame.getTable("administrator");
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

