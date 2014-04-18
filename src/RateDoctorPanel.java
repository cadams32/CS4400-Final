import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JButton;


public class RateDoctorPanel extends JPanel {
	
	private MedicalFrame parent;
	private String username;
	private JButton btnRate;
	private JSlider slider;
	
	/**
	 * Create the panel.
	 */
	public RateDoctorPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[][][][][][][][][][][][][][grow]", "[][][][][][][][][]"));
		
		JLabel lblRateADoctor = new JLabel("Rate a Doctor");
		add(lblRateADoctor, "cell 13 1");
		
		JLabel lblDoctor = new JLabel("Doctor");
		add(lblDoctor, "cell 12 6,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 13 6");
		
		JLabel lblRating = new JLabel("Rating");
		add(lblRating, "cell 12 7");
		
		slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(5);
		slider.setMajorTickSpacing(1);
		add(slider, "cell 13 7");
		
		JButton btnRate = new JButton("Rate");
		add(btnRate, "cell 13 8");

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnRate) {
				double rating = slider.getValue();
				//push rating into DB
			}
			
		}
		
		
	}
	

}
