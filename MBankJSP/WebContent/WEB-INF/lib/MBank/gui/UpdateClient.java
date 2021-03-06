package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;








import MBank.core.Account;
import MBank.core.ActionAdmin;
import MBank.core.Client;
import MBank.core.ClientDBManager;
import MBank.core.MBankST;
import MBank.core.STConnection;

public class UpdateClient  extends JInternalFrame implements ActionListener{
	private JButton btSave;
	
	private JLabel lbID;
	private JLabel lbName;
	private JLabel lbType;
	private JLabel lbEmail;
	private JLabel lbPass;
	private JLabel lbAdress;
	private JLabel lbPhone;
	private JLabel lbComment;
	
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPass;
	private JTextField txtAdress;
	private JTextField txtPhone;
	private JTextField txtComment;
	private JComboBox cbType;
	private String[] typeName = {"Regular","Gold","Platinum"};
	
	private AdminFrame parentFrame;
	
	
	Client client= new Client();
	Account account =new Account();
	public UpdateClient(AdminFrame parentFrame, String title)
	{
		
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		JPanel idp = new JPanel();
		idp.setLayout(new FlowLayout());
		
		JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();

        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p4.setLayout(new FlowLayout());
        p5.setLayout(new FlowLayout());
        p6.setLayout(new FlowLayout());
        p7.setLayout(new FlowLayout());
        p8.setLayout(new FlowLayout());
        
        lbID = new JLabel("Enter client ID");
		txtID = new JTextField(10);
		JButton jb =new JButton("OK");
		jb.addActionListener(this);
		idp.add(jb);
		idp.add(lbID);
		idp.add(txtID);
		
		
		lbName = new JLabel("Client Name");
		txtName = new JTextField(20);
		p1.add(lbName);
		p1.add(txtName);
		//line 2
		lbPass = new JLabel("Password");
		txtPass = new JTextField(20);
		p2.add(lbPass);
		p2.add(txtPass);
		
		//line 4
		lbAdress = new JLabel("Adress     ");
		txtAdress = new JTextField(20);
		p4.add(lbAdress);
		p4.add(txtAdress);
		
		//line 5
		lbEmail = new JLabel("      Email      ");
		txtEmail = new JTextField(20);
		p5.add(lbEmail);
		p5.add(txtEmail);
		
		//line 6
		lbPhone = new JLabel("Phone      ");
		txtPhone = new JTextField(20);
		p6.add(lbPhone);
		p6.add(txtPhone);
		//line 7
		lbComment = new JLabel("Comment    ");
		txtComment = new JTextField(20);
		p7.add(lbComment);
		p7.add(txtComment);
		//line 8
		lbType= new JLabel("Type");
		cbType = new JComboBox(typeName);
		p8.add(lbType);
		p8.add(cbType);
		btSave = new JButton("Save");
		btSave.addActionListener(this);
		p8.add(btSave);
		p8.add(new JLabel() );
        

        this.setLayout(new GridLayout(5,2));
        this.add(idp);
		this.add(p1);
		this.add(p2);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		this.add(p7);
		this.add(p8);
		this.setVisible(true);
		this.setSize(650, 250);
        
        
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK"))
		{
			
			int client_id = Integer.parseInt(txtID.getText());
			client=MBankST.getInstance().getAction().getClient(client_id);
			txtName.setText(client.getUsername());
			cbType.setSelectedItem(client.getType());
			txtEmail.setText(client.getEmail());
			txtPass.setText(client.getPassword());
			txtAdress.setText(client.getAddress());
			txtPhone.setText(client.getPhone());
			txtComment.setText(client.getComment());
		}
		if(e.getActionCommand().equals("Save"))
		{
			client.setPassword(txtPass.getText());
			client.setUsername(txtName.getText());
			client.setType(String.valueOf(cbType.getSelectedItem()));
			client.setEmail(txtEmail.getText());
			client.setAddress(txtAdress.getText());
			client.setPhone(txtPhone.getText());
			client.setComment(txtComment.getText());
			client.setClient_id(Integer.parseInt(txtID.getText()));
			MBankST.getInstance().getAction().updateClient(client);
			JOptionPane.showMessageDialog(null, "Updata complit");
			
			txtID.setText("");
			txtName.setText("");
			txtEmail.setText("");
			txtPass.setText("");
			txtAdress.setText("");
			txtPhone.setText("");
			txtComment.setText("");
		}
		
	}
	

}
