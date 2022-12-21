import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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

        class Msg extends Exception {
            public Msg (String message) {
                super(message);
            }
        }


        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int age = Integer.parseInt(tfAge.getText());

                    if (age < 0){
                        throw (new Msg("Age is invalid."));
                    }

                    boolean numeric = true;

                    try {
                        Double num = Double.parseDouble(tfName.getText());
                    } catch (NumberFormatException name) {
                        numeric = false;
                    }

                    if(numeric)
                        throw (new Msg("Enter a valid name."));


                    if (rbCustomer.isSelected()) {
                        persons.add(new Customer(tfName.getText(), age));
                    } else if (rbClerk.isSelected()) {
                        int months = Integer.parseInt(tfMonths.getText());
                        double salary = Double.parseDouble(tfSalary.getText());

                        persons.add(new Clerk(tfName.getText(), age, months, salary));
                    } else if (rbManager.isSelected()) {
                        int months = Integer.parseInt(tfMonths.getText());
                        double salary = Double.parseDouble(tfSalary.getText());

                        persons.add(new Manager(tfName.getText(), age, months, salary));
                    }
                } catch (Msg m) {
                    JOptionPane.showMessageDialog(null, m.getMessage());
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Enter a valid input.");
                }

                tfName.setText("");
                tfAge.setText("");
                tfMonths.setText("");
                tfSalary.setText("");
            }

        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfAge.setText("");
                tfMonths.setText("");
                tfSalary.setText("");
            }
        });
        btnSayHi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Person p : persons) {

                    taPersons.append(p.toString()+"\n");

                }
            }
        });
        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int n = Integer.parseInt(tfLoad.getText());

                    if (rbCustomer.isSelected()) {
                        taPersons.append("Name: " + persons.get(n - 1).getName() + "\n");
                        taPersons.append("Age: " + persons.get(n - 1).getAge() + "\n");
                    } else if (rbClerk.isSelected()) {

                        Clerk c = (Clerk) persons.get(n - 1);
                        taPersons.append("Name: " + persons.get(n - 1).getName() + "\n");
                        taPersons.append("Age: " + persons.get(n - 1).getAge() + "\n");
                        taPersons.append("Months Worked: " + c.getMonths_worked() + "\n");
                        taPersons.append("Salary: " + c.getSalary() + "\n");

                    } else if (rbManager.isSelected()) {

                        Manager m = (Manager) persons.get(n - 1);
                        taPersons.append("Name: " + persons.get(n - 1).getName() + "\n");
                        taPersons.append("Age: " + persons.get(n - 1).getAge() + "\n");
                        taPersons.append("Months Worked: " + m.getMonths_worked() + "\n");
                        taPersons.append("Salary: " + m.getSalary() + "\n");

                    }
                } catch (ClassCastException c) {
                    JOptionPane.showMessageDialog(null, "Select the correct type.");
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "Input a valid number.");
                } catch (IndexOutOfBoundsException i) {
                    JOptionPane.showMessageDialog(null, "Person does not exist.");
                }
            }
        });
        rbCustomer.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tfMonths.setEnabled(false);
                tfSalary.setEnabled(false);
            }
        });
        rbClerk.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tfMonths.setEnabled(true);
                tfSalary.setEnabled(true);
            }
        });
        rbManager.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tfMonths.setEnabled(true);
                tfSalary.setEnabled(true);
            }
        });
        btnReward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int n = Integer.parseInt(tfLoad.getText());

                    Employee em = (Employee) persons.get(n - 1);

                    if (em.getMonths_worked() < 12) {
                        throw (new Msg("Employee is not eligible."));
                    }

                    JOptionPane.showMessageDialog(null, em.getName() + " has " + em.thirteenthMonth() + " reward.");
                } catch (NumberFormatException xx) {
                    JOptionPane.showMessageDialog(null, "Input a number.");
                } catch (Msg mrew) {
                    JOptionPane.showMessageDialog(null, mrew.getMessage());
                } catch (ClassCastException cc) {
                    JOptionPane.showMessageDialog(null, "Person is not an employee.");
                } catch (Exception xxx) {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                }
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
