import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JButton;

import Backend.Doctor;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.util.ArrayList;


public class RateDoctorPanel extends JPanel {
	
	private MedicalFrame parent;
	private String username;
	private JSlider slider;
	JButton btnBack, btnRate;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	
	private ArrayList<Doctor> docs;
	
	/**
	 * Create the panel.
	 */
	public RateDoctorPanel(MedicalFrame parent, String username) {
		this.parent = parent;
		this.username = username;
		this.setBounds(100, 100, 1000, 600);
		ButtonListener listener = new ButtonListener();
		
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		JLabel lblRateADoctor = new JLabel("Rate A Doctor!");
		lblRateADoctor.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblRateADoctor.setBounds(408, 33, 289, 52);
		add(lblRateADoctor);
		
		slider = new JSlider();
		slider.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(5);
		slider.setMajorTickSpacing(1);
		slider.setBounds(298, 253, 549, 52);
		add(slider);
		
		JLabel lblRating = new JLabel("Rating: ");
		lblRating.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblRating.setBounds(185, 253, 126, 47);
		add(lblRating);
		
		btnRate = new JButton("Rate");
		btnRate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnRate.setBounds(434, 373, 117, 29);
		btnRate.addActionListener(listener);
		add(btnRate);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(441, 439, 97, 25);
		btnBack.addActionListener(listener);
		add(btnBack);
		
		docs = parent.getHandler().getDoctors();
		ArrayList<String> s = new ArrayList<String>();
		for(Doctor d : docs) {
			s.add("Dr. " + d.getfName() + " " + d.getlName());
		}
		
		comboBox = new JComboBox(s.toArray());
		comboBox.setBounds(446, 163, 176, 27);
		add(comboBox);
		
		lblNewLabel = new JLabel("Doctor");
		lblNewLabel.setBounds(397, 167, 61, 16);
		add(lblNewLabel);

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnRate) {
				int rating = slider.getValue();
				int index = comboBox.getSelectedIndex();
				
				parent.getHandler().addNewDoctorRating(docs.get(index).getUsername(), username, rating);
				
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
			else if(e.getSource() == btnBack){
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
			
		}
		
		
	}
}
