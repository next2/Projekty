import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.io.*; 

public class GUIClijent extends JFrame {
	private DefaultListModel model;
	private JTextArea textArea2;
	private JTextField textArea;
	public GUIClijent()
	{
		setTitle("Gui Clienta");
		setSize(300,300);
		Int();
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public final void Int(){
		JPanel panel = new JPanel();
       getContentPane().add(panel);

       panel.setLayout(null);
      textArea2 = new JTextArea(5, 20);
      

      textArea=new JTextField(270);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(true);
		JScrollPane scrollPane2 = new JScrollPane(textArea2); 
		textArea2.setEditable(false);
       JButton quitButton = new JButton("Wyszli wiadomosz");
       JLabel ClientLabel = new JLabel("Clien");
       JLabel ServerLabel = new JLabel("Server");
       ClientLabel.setBounds(0,0,270,10);
       
       textArea.setBounds(10,10,270,30);
       ServerLabel.setBounds(0,40,270,10);
       textArea2.setBounds(10,50,270,180);
       quitButton.setBounds(50, 240, 180, 30);
          System.setProperty("java.security.policy", "client.policy");
          if (System.getSecurityManager() == null) 
            System.setSecurityManager(new RMISecurityManager());
       quitButton.setToolTipText("Clikiniy na button");
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
           
	
        
	
	try {
	    ServerIntf obj = (ServerIntf) Naming.lookup("//localhost/some_name");
	    
	    
	    
		obj.setMessage(textArea.getText());
		textArea.setText("");
	    textArea2.append(obj.getMessage());
	     textArea2.append("");
	} catch (Exception e) {
	    System.out.println(e.getMessage());	    
	}
          }
       });
       panel.add( ClientLabel);
       panel.add( ServerLabel);
       panel.add(textArea);
       panel.add(textArea2);
       panel.add(quitButton);
	}
	
	public static void main (String args[]) {
		GUIClijent Gui=new GUIClijent();
		Gui.setVisible(true);
	}
}

