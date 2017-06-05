package Main;

import javax.swing.UIManager;

public class Arranque {

	public static void main(String[] args) {
		Gui.Entrada window = new Gui.Entrada();
		 for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
	            if("Nimbus".equals(laf.getName()))
	                try {
	                UIManager.setLookAndFeel(laf.getClassName());
	            } catch (Exception ex) {
	            }
	        }
		window.frame.setVisible(true);

	}

	}


