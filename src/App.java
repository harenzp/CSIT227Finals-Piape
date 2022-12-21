import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame{
    private JPanel pnlMain;
    private JRadioButton rbCustomer;
    private JRadioButton rbClerk;
    private JRadioButton rbManager;
    private JTextField tfName;
    private JTextArea taPersons;
    private JButton btnSave;
    private JTextField tfAge;
    private JTextField tfMonths;
    private JTextField tfSalary;
    private JButton btnClear;
    private JTextField tfLoad;
    private JButton btnLoad;
    private JButton btnSayHi;
    private JButton btnSavePerson;
    private JButton btnLoadPerson;
    private JButton btnReward;

    ButtonGroup g = new ButtonGroup();

    private List<Person> persons;

    public App() {
        g.add(rbCustomer);
        g.add(rbClerk);
        g.add(rbManager);

        persons = new ArrayList<>();
        // TODO add implementations for all milestones here


        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int age = Integer.parseInt(tfAge.getText());

                    if (age < 0){
                        throw (new NumberFormatException("Age is invalid"));
                    }

                    if (rbCustomer.isSelected()) {
                        persons.add(new Customer(tfName.getText(), age));
                    } else if (rbClerk.isSelected()) {
                        int months = Integer.parseInt(tfMonths.getText());
                        double salary = Double.parseDouble(tfSalary.getText());

                        persons.add(new Clerk(tfName.getText(), age, months, salary));
                    } else if (rbManager.isSelected()) {
                        int months = Integer.parseInt(tfMonths.getText());
                        double salary = Double.parseDouble(tfSalary.getText());

                        persons.add(new Clerk(tfName.getText(), age, months, salary));
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, nfe.getMessage());
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                }

                tfName.setText("");
                tfAge.setText("");
                tfMonths.setText("");
                tfSalary.setText("");
            }

        });
    }

    public static void main(String[] args) {
        // add here how to make GUI visible
        App app = new App();
        app.setContentPane(app.pnlMain);
        app.setSize(500, 500);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    static void giveReward(int n) {

    }
}
