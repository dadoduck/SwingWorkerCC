import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SearchFrame extends JFrame {
	
	JTextField numeroConto;
	JPasswordField numeroPin;
	JTextField valoreCredito;
	JButton cerca;
	JButton cancella;
	JLabel statoRicerca;
	
	public SearchFrame() {
		super("Conto Corrente");
		System.out.println("Ciao, sono: " + Thread.currentThread().getName() + " e creo la GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel conto = new JLabel("Numero conto: ");
		numeroConto = new JTextField(10);
		JLabel pin = new JLabel("PIN: ");
		numeroPin = new JPasswordField(5);
		JLabel credito = new JLabel("Credito: ");
		valoreCredito = new JTextField(7);
		valoreCredito.setEditable(false);
		
		JPanel pannelloSuperiore = new JPanel();
		pannelloSuperiore.add(conto);
		pannelloSuperiore.add(numeroConto);
		pannelloSuperiore.add(pin);
		pannelloSuperiore.add(numeroPin);
		pannelloSuperiore.add(credito);
		pannelloSuperiore.add(valoreCredito);
		
		cerca = new JButton("Cerca");
		cancella = new JButton("Cancella");
		cancella.setEnabled(false);
		MyListener listener = new MyListener(this);
		cerca.setActionCommand("cerca");
		cerca.addActionListener(listener);
		cancella.setActionCommand("cancella");
		cancella.addActionListener(listener);
		JPanel pannelloBottoni = new JPanel();
		pannelloBottoni.add(cerca);
		pannelloBottoni.add(cancella);
		
		JLabel labelRicerca = new JLabel("Stato: ");
		JPanel pannelloStato = new JPanel();
		statoRicerca = new JLabel("Inserire i dati: ");
		pannelloStato.add(labelRicerca);
		pannelloStato.add(statoRicerca);
		
		JPanel pannelloInferiore = new JPanel(new BorderLayout());
		pannelloInferiore.add(pannelloBottoni, BorderLayout.PAGE_START);
		pannelloInferiore.add(pannelloStato, BorderLayout.PAGE_END);
		
		getContentPane().add(pannelloSuperiore, BorderLayout.PAGE_START);
		getContentPane().add(pannelloInferiore, BorderLayout.PAGE_END);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
