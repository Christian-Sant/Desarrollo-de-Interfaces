package primero;

public class Main {
	//CHRISTIAN JAY LAGO
	public static void main(String[] args) {
		SplashScreen splash = new SplashScreen();
		splash.setVisible(true);
		for (int i = 0; i <= 100; i++) {
			try {
				Thread.sleep(50); 
				splash.actualizarProgreso(i);
				} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		splash.dispose();

		PracticaEvaluativadeDesarrollodeInterfacesRA1 app = new PracticaEvaluativadeDesarrollodeInterfacesRA1();
		app.setVisible(true);
	}
}
