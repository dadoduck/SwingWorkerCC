import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyListener implements ActionListener {

	private SearchFrame frame;
	private SearchWorker worker;
	
	public MyListener(SearchFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command == "cerca") {
			cerca();
		} else {
			cancella();
		}
		
	}
	
	private void cerca() {
		System.out.println("Ciao, sono " + Thread.currentThread().getName() + 
				" - aggiorno la GUI e attivo lo SwingerWork");
		String numConto = frame.numeroConto.getText();
		String pin = new String(frame.numeroPin.getPassword());
		if(numConto.equals("") || pin.equals("")) {
			return;
		}
		frame.cerca.setEnabled(false);
		frame.cancella.setEnabled(true);
		frame.statoRicerca.setText("Ricerca in corso...");
		worker = new SearchWorker(numConto, pin, frame);
		worker.execute();
	}
	
	private void cancella() {
		worker.cancel(true);
	}
	
	
	
	
	
	
	
	
	
	
}
