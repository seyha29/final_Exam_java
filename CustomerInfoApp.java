import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfoApp extends JFrame implements ActionListener {
    // Define components
    private JTextField idField, lastNameField, firstNameField, phoneField;
    private JButton addButton, clearButton, showTableButton;
    private DefaultTableModel tableModel;
    private JPanel formPanel, tablePanel;

    public CustomerInfoApp() {
        // Set up the JFrame
        setTitle("Customer Information");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        // Initialize form components
        idField = new JTextField(10);
        lastNameField = new JTextField(10);
        firstNameField = new JTextField(10);
        phoneField = new JTextField(10);

        addButton = new JButton("Add");
        clearButton = new JButton("Clear");
        showTableButton = new JButton("Show Table");

        // Add action listeners
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        showTableButton.addActionListener(this);

        // Create the form panel
        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        formPanel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        formPanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        formPanel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        formPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(addButton, gbc);
        gbc.gridx = 1;
        formPanel.add(clearButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(showTableButton, gbc);

        // Initialize table components
        String[] columnNames = {"Customer ID", "Last Name", "First Name", "Phone"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable customerTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(customerTable);

        // Create the table panel
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to the frame
        add(formPanel, "Form");
        add(tablePanel, "Table");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String id = idField.getText();
            String lastName = lastNameField.getText();
            String firstName = firstNameField.getText();
            String phone = phoneField.getText();

            if (id.isEmpty() || lastName.isEmpty() || firstName.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Object[] row = {id, lastName, firstName, phone};
                tableModel.addRow(row);

                // Clear input fields after adding the data
                idField.setText("");
                lastNameField.setText("");
                firstNameField.setText("");
                phoneField.setText("");
            }
        } else if (e.getSource() == clearButton) {
            idField.setText("");
            lastNameField.setText("");
            firstNameField.setText("");
            phoneField.setText("");
        } else if (e.getSource() == showTableButton) {
            CardLayout cl = (CardLayout) getContentPane().getLayout();
            cl.show(getContentPane(), "Table");
        }
    }

    public static void main(String[] args) {
        new CustomerInfoApp();
    }
}
