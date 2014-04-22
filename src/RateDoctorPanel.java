import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;


public class RateDoctorPanel extends JPanel {
	
	private MedicalFrame parent;
	private String username;
	private JSlider slider;
	JButton btnBack, btnRate;
	
	/**
	 * Create the panel.
	 */
	public RateDoctorPanel(MedicalFrame parent, String username) {
		this.parent = parent;
		this.username = username;
		
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		JLabel lblRateADoctor = new JLabel("Rate A Doctor!");
		lblRateADoctor.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblRateADoctor.setBounds(385, 20, 289, 52);
		add(lblRateADoctor);
		
		slider = new JSlider();
		slider.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(5);
		slider.setMajorTickSpacing(1);
		slider.setBounds(243, 216, 549, 52);
		add(slider);
		
		JLabel lblRating = new JLabel("Rating: ");
		lblRating.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblRating.setBounds(105, 201, 126, 47);
		add(lblRating);
		
		btnRate = new JButton("Rate");
		btnRate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnRate.setBounds(429, 334, 117, 29);
		add(btnRate);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(439, 404, 97, 25);
		add(btnBack);

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnRate) {
				double rating = slider.getValue();
				//push rating into DB
			}
			else if(e.getSource() == btnBack){
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
			
		}
		
		
	}
}
