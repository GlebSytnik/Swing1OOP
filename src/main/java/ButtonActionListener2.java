import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      /*  try { MetaDataReceiver metaDataReceiver = new MetaDataReceiver();
        List<String> tableNames = new MetaDataReceiver().getTableName();
            Map<String,Object> map = new HashMap<>();

        for (String name:tableNames){
            JButton button = new JButton(name);
            map.put(name,button);
            metaDataReceiver.createJScrollPane( map.get(name).toString());
            metaDataReceiver.setDefaultCloseOperation(metaDataReceiver.EXIT_ON_CLOSE);
            metaDataReceiver.pack();
            metaDataReceiver.setVisible(true);

        }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }*/
        JButton button = new JButton();
        TableFromMySqlDatabase tableFromMySqlDatabase = new TableFromMySqlDatabase();
        tableFromMySqlDatabase.getTable(button.getText());
        tableFromMySqlDatabase.setDefaultCloseOperation(tableFromMySqlDatabase.EXIT_ON_CLOSE);
        tableFromMySqlDatabase.pack();
        tableFromMySqlDatabase.setVisible(true);
    }
}

