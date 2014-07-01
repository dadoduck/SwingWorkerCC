import javax.swing.SwingWorker;


public class SearchWorker extends SwingWorker<String, Void> {
	
	private String numeroConto;
	private String pin;
	private SearchFrame frame;
	
	public SearchWorker(String conto, String pin, SearchFrame frame) {
		numeroConto = conto;
		this.pin = pin;
		this.frame = frame;
	}

	@Override
	protected String doInBackground() throws Exception {
		System.out.println("Ciao, sono " + Thread.currentThread().getName() + 
				" - ed eseguo doInBackground");
		if(!isCancelled()) {
			try {
				Thread.sleep(10000);
				return "" + (int) (10000.0 * Math.random());
			} catch (Exception e ) {
				System.out.println("Ciao, sono " + Thread.currentThread().getName() + 
				" - e sono stato interrotto mentre eseguivo doInBackground");
				return "";
			} 
		} else {
			return "";
		}
	}
	
	@Override
	protected void done() {
		System.out.println("Ciao, sono " + Thread.currentThread().getName() + 
				" - ed eseguo done");
		frame.cerca.setEnabled(true);
		frame.cancella.setEnabled(false);
		if(isCancelled()) {
			frame.statoRicerca.setText("Ricerca Annullata");
		} else {
			frame.statoRicerca.setText("Ricerca Completata!");
			String result;
			try {
				result = get();
				frame.valoreCredito.setText(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
	}
	
	

}
