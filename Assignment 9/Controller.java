package sample;


import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    RadioButton rdoDeposit;
    @FXML
    RadioButton rdoWithdrawal;
    @FXML
    RadioButton rdoAccountInfo;
    @FXML
    RadioButton rdoQuit;
    @FXML
    TextField txtInput;
    @FXML
    TextArea txtOutput;

    public BankAccount baMain = new BankAccount("John Doe", 12345);

    @FXML void Execute()
    {

        txtOutput.setText("Name: " + baMain.getName() + "\n" +"Account Number" + baMain.getAccountNum() + "\n" + "Balance: " + baMain.getBalance() + "\n");

        if (rdoQuit.isSelected())
            System.exit(0);

        try
        {
            double dblValue = Double.parseDouble(txtInput.getText());

            if(rdoDeposit.isSelected())
            {
                baMain.deposit(dblValue);
                txtOutput.appendText("\nYou have deposited: " + dblValue + "\nNew balance: " + baMain.getBalance() + "\n");

            }

            else if (rdoAccountInfo.isSelected())
            {
                txtOutput.appendText("\nName: " + baMain.getName() + "\n");
                txtOutput.appendText("Account number: " + baMain.getAccountNum() + "\n");
                txtOutput.appendText("Balance: " + baMain.getBalance());
            }

            else if(rdoWithdrawal.isSelected())
            {
                baMain.withdraw(dblValue);
                txtOutput.appendText("\nYou have withdrawn: " + dblValue + "\nNew balance: " + baMain.getBalance() + "\n");
            }

            else
                txtOutput.appendText("\nPlease make a selection \n");
        }

        catch(NumberFormatException e)
        {
            txtOutput.appendText("\nPlease enter a valid number \n");
        }

    }

}
