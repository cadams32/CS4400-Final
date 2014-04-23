import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class InboxPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	private MedicalFrame parent;
	private String username;
	JButton btnBack;
	
	public InboxPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[89.00][83.00,grow][][71.00][][119.00][][503.00][]", "[][][grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 1 1 7 2,grow");
		
		String[] colNames = {"Status", "Date", "From", "Message"};
		Object[][] data = {};
		table = new JTable(data, colNames);
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		//table.getColumnModel().getColumn(3).setPreferredWidth(400);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[872.00][]", "[]"));
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");
		btnBack.addActionListener(listener);

	}
	private class ButtonListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBack) {
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
		}
	}
}
	
	

}
