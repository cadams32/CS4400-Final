import java.awt.EventQueue;


public class MedicalMain {
//Just seeing if I can commit properly...
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				try{
					MedicalFrame mf = new MedicalFrame();
					mf.setLocationRelativeTo(null);
					mf.setTitle("GTMRS");
					mf.setVisible(true);
					LoginPanel lp = new LoginPanel(mf);
					mf.getContentPane().add(lp);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
