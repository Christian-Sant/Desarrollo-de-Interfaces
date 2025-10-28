package primero;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegoDeBanderas extends JFrame {
	//CHRISTIAN JAY LAGO
	private JLabel lblImagen;
	private static final String[] PAISES_ISO = {
	                           "AF", "AX", "AL", "DZ", "AS", "AD", "AO", "AI", "AQ", "AG",
	                           "AR", "AM", "AW", "AU", "AT", "AZ", "BS", "BH", "BD", "BB",
	                           "BY", "BE", "BZ", "BJ", "BM", "BT", "BO", "BQ", "BA", "BW",
	                           "BV", "BR", "IO", "BN", "BG", "BF", "BI", "CV", "KH", "CM",
	                           "CA", "KY", "CF", "TD", "CL", "CN", "CX", "CC", "CO", "KM",
	                           "CG", "CD", "CK", "CR", "CI", "HR", "CU", "CW", "CY", "CZ",
	                           "DK", "DJ", "DM", "DO", "EC", "EG", "SV", "GQ", "ER", "EE",
	                           "SZ", "ET", "FK", "FO", "FJ", "FI", "FR", "GF", "PF", "TF",
	                           "GA", "GM", "GE", "DE", "GH", "GI", "GR", "GL", "GD", "GP",
	                           "GU", "GT", "GG", "GN", "GW", "GY", "HT", "HM", "VA", "HN",
	                           "HK", "HU", "IS", "IN", "ID", "IR", "IQ", "IE", "IM", "IL",
	                           "IT", "JM", "JP", "JE", "JO", "KZ", "KE", "KI", "KP", "KR",
	                           "KW", "KG", "LA", "LV", "LB", "LS", "LR", "LY", "LI", "LT",
	                           "LU", "MO", "MG", "MW", "MY", "MV", "ML", "MT", "MH", "MQ",
	                           "MR", "MU", "YT", "MX", "FM", "MD", "MC", "MN", "ME", "MS",
	                           "MA", "MZ", "MM", "NA", "NR", "NP", "NL", "NC", "NZ", "NI",
	                           "NE", "NG", "NU", "NF", "MK", "MP", "NO", "OM", "PK", "PW",
	                           "PS", "PA", "PG", "PY", "PE", "PH", "PN", "PL", "PT", "PR",
	                           "QA", "RE", "RO", "RU", "RW", "BL", "SH", "KN", "LC", "MF",
	                           "PM", "VC", "WS", "SM", "ST", "SA", "SN", "RS", "SC", "SL",
	                           "SG", "SX", "SK", "SI", "SB", "SO", "ZA", "GS", "SS", "ES",
	                           "LK", "SD", "SR", "SJ", "SE", "CH", "SY", "TW", "TJ", "TZ",
	                           "TH", "TL", "TG", "TK", "TO", "TT", "TN", "TR", "TM", "TC",
	                           "TV", "UG", "UA", "AE", "GB", "US", "UM", "UY", "UZ", "VU",
	                           "VE", "VN", "VG", "VI", "WF", "EH", "YE", "ZM", "ZW"};
	private static final String[] PAISES_NOMBRES = {
	                          "Afganistán", "Islas Åland", "Albania", "Argelia", "Samoa Americana", "Andorra", "Angola", "Anguila", "Antártida", "Antigua y Barbuda",
	                          "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Baréin", "Bangladés", "Barbados",
	                          "Bielorrusia", "Bélgica", "Belice", "Benín", "Bermudas", "Bután", "Bolivia", "Bonaire, San Eustaquio y Saba", "Bosnia y Herzegovina", "Botsuana",
	                          "Isla Bouvet", "Brasil", "Territorio Británico del Océano Índico", "Brunéi Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Camboya", "Camerún",
	                          "Canadá", "Islas Caimán", "República Centroafricana", "Chad", "Chile", "China", "Isla de Navidad", "Islas Cocos", "Colombia", "Comoras",
	                          "Congo", "República Democrática del Congo", "Islas Cook", "Costa Rica", "Côte d’Ivoire", "Croacia", "Cuba", "Curazao", "Chipre", "Chequia",
	                          "Dinamarca", "Yibuti", "Dominica", "República Dominicana", "Ecuador", "Egipto", "El Salvador", "Guinea Ecuatorial", "Eritrea", "Estonia",
	                          "Esuatini", "Etiopía", "Islas Malvinas", "Islas Feroe", "Fiyi", "Finlandia", "Francia", "Guayana Francesa", "Polinesia Francesa", "Tierras Australes y Antárticas Francesas",
	                          "Gabón", "Gambia", "Georgia", "Alemania", "Ghana", "Gibraltar", "Grecia", "Groenlandia", "Granada", "Guadalupe",
	                          "Guam", "Guatemala", "Guernesey", "Guinea", "Guinea-Bisáu", "Guyana", "Haití", "Islas Heard y McDonald", "Ciudad del Vaticano", "Honduras",
	                          "Hong Kong", "Hungría", "Islandia", "India", "Indonesia", "Irán", "Irak", "Irlanda", "Isla de Man", "Israel",
	                          "Italia", "Jamaica", "Japón", "Jersey", "Jordania", "Kazajistán", "Kenia", "Kiribati", "Corea del Norte", "Corea del Sur",
	                          "Kuwait", "Kirguistán", "Laos", "Letonia", "Líbano", "Lesoto", "Liberia", "Libia", "Liechtenstein", "Lituania",
	                          "Luxemburgo", "Macao", "Madagascar", "Malaui", "Malasia", "Maldivas", "Malí", "Malta", "Islas Marshall", "Martinica",
	                          "Mauritania", "Mauricio", "Mayotte", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro", "Montserrat",
	                          "Marruecos", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Países Bajos", "Nueva Caledonia", "Nueva Zelanda", "Nicaragua",
	                          "Níger", "Nigeria", "Niue", "Isla Norfolk", "Macedonia del Norte", "Islas Marianas del Norte", "Noruega", "Omán", "Pakistán", "Palaos",
	                          "Palestina", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Filipinas", "Islas Pitcairn", "Polonia", "Portugal", "Puerto Rico",
	                          "Catar", "Reunión", "Rumania", "Rusia", "Ruanda", "San Bartolomé", "Santa Elena", "San Cristóbal y Nieves", "Santa Lucía", "San Martín (parte francesa)",
	                          "San Pedro y Miquelón", "San Vicente y las Granadinas", "Samoa", "San Marino", "Santo Tomé y Príncipe", "Arabia Saudita", "Senegal", "Serbia", "Seychelles", "Sierra Leona",
	                          "Singapur", "Sint Maarten (parte neerlandesa)", "Eslovaquia", "Eslovenia", "Islas Salomón", "Somalia", "Sudáfrica", "Islas Georgias del Sur y Sandwich del Sur", "Sudán del Sur", "España",
	                          "Sri Lanka", "Sudán", "Surinam", "Svalbard y Jan Mayen", "Suecia", "Suiza", "Siria", "Taiwán", "Tayikistán", "Tanzania",
	                          "Tailandia", "Timor-Leste", "Togo", "Tokelau", "Tonga", "Trinidad y Tobago", "Túnez", "Turquía", "Turkmenistán", "Islas Turcas y Caicos",
	                          "Tuvalu", "Uganda", "Ucrania", "Emiratos Árabes Unidos", "Reino Unido", "Estados Unidos", "Islas Ultramarinas de EE. UU.", "Uruguay", "Uzbekistán", "Vanuatu",
	                          "Venezuela", "Vietnam", "Islas Vírgenes Británicas", "Islas Vírgenes de EE. UU.", "Wallis y Futuna", "Sahara Occidental", "Yemen", "Zambia", "Zimbabue"};
	
	private static JRadioButton rdbtnOpcion1 = new JRadioButton("");
	private static JRadioButton rdbtnOpcion2 = new JRadioButton("");
	private static JRadioButton rdbtnOpcion3 = new JRadioButton("");
	private static JRadioButton rdbtnOpcion4 = new JRadioButton("");
	private static JRadioButton[] seleccion = {rdbtnOpcion1, rdbtnOpcion2, rdbtnOpcion3,rdbtnOpcion4};
	private static int banderaImagen;
	private static int correcto;
	private static String nombreBandera;
	private static final long serialVersionUID = 1L;
	private static final String RUTA = "C:\\Users\\Tarde\\Downloads\\Juego Banderas\\Imagenes\\";
	private JPanel contentPane;
	private static int puntuacion = 0;
	private static int contadorPreguntas = 0;
	private final JLabel lbPregunta = new JLabel("¿Que bandera es?");
	private JLabel lblPuntuacion;
	private JButton btnConfirmar;
	private JButton btnTerminar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoDeBanderas frame = new JuegoDeBanderas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private static int nombreAzar() {
		int numero = (int)(Math.random() * ((PAISES_ISO.length - 1) - 0 + 1)) + 0;
		return numero;
	}
	private static void pais() {
		int numero = (int)(Math.random() * ((PAISES_ISO.length - 1) - 0 + 1)) + 0;
		banderaImagen = numero;
		nombreBandera = PAISES_NOMBRES[banderaImagen];
		
	}
	
	private static void pregunta() {
	    boolean unico = false;
	    int numero1 = (int)(Math.random() * 4);
	    if(!unico) {
	        correcto = numero1;
	        seleccion[numero1].setText(PAISES_NOMBRES[banderaImagen]);
	        unico = true;
	    }
	    for (int i = 0; i < 4; i++) {
	        if (i != correcto) {
	            int bandera;
	            do {
	                bandera = nombreAzar();
	            } while(bandera == banderaImagen || textos(seleccion, PAISES_NOMBRES[bandera]));
	            seleccion[i].setText(PAISES_NOMBRES[bandera]);
	        }
	    }
	}

	private static boolean textos(JRadioButton[] botones, String texto) {
	    for (JRadioButton btn : botones) {
	        if (btn.getText().equals(texto)) return true;
	    }
	    return false;
	}

	public JuegoDeBanderas() {
		pais();
		pregunta();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setVisible(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!rdbtnOpcion1.isSelected() && !rdbtnOpcion2.isSelected() && !rdbtnOpcion3.isSelected() && !rdbtnOpcion4.isSelected()) {
                	JOptionPane.showMessageDialog(null, "Selecciona una opción","Advertencia",JOptionPane.WARNING_MESSAGE);
                }
				else {
					for (int i = 0; i < seleccion.length; i++) {
			            if (seleccion[i].isSelected()) {
				                if (i == correcto) {
				                	JOptionPane.showMessageDialog(null, "Has Acertado","Información",JOptionPane.INFORMATION_MESSAGE);
				                    pais();
				                    pregunta();
				                    lblImagen.setIcon(new ImageIcon(RUTA + PAISES_ISO[banderaImagen] + ".png"));
				                    puntuacion++;
				                }
				                else {
				                	JOptionPane.showMessageDialog(null, "Has Fallado, era: " + nombreBandera,"Información",JOptionPane.ERROR_MESSAGE);
				                	pais();
				                    pregunta();
				                    lblImagen.setIcon(new ImageIcon(RUTA + PAISES_ISO[banderaImagen] + ".png"));
				                }
			                break;
			            }
			        }
					contadorPreguntas++;
					lblPuntuacion.setText("Puntuación: " + puntuacion + "/" + contadorPreguntas);
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 822, 502);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Empezar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				btnNewButton.setVisible(false);
				rdbtnOpcion1.setVisible(true);
				rdbtnOpcion2.setVisible(true);
				rdbtnOpcion3.setVisible(true);;
				rdbtnOpcion4.setVisible(true);;
				lbPregunta.setVisible(true);
				lblPuntuacion.setVisible(true);
				btnConfirmar.setVisible(true);
				btnTerminar.setVisible(true);
				lblImagen.setVisible(true);
			}
		});
		btnNewButton.setBounds(302, 218, 165, 53);
		panel.add(btnNewButton);
		btnConfirmar.setBounds(635, 459, 123, 32);
		contentPane.add(btnConfirmar);
		rdbtnOpcion1.setBackground(new Color(255, 255, 255));
		rdbtnOpcion1.setVisible(false);
		rdbtnOpcion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnOpcion2.setSelected(false);
				rdbtnOpcion3.setSelected(false);
				rdbtnOpcion4.setSelected(false);
			}
		});
		rdbtnOpcion1.setBounds(6, 310, 359, 66);
		contentPane.add(rdbtnOpcion1);
		rdbtnOpcion2.setBackground(new Color(255, 255, 255));
		rdbtnOpcion2.setVisible(false);
		rdbtnOpcion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnOpcion1.setSelected(false);
				rdbtnOpcion3.setSelected(false);
				rdbtnOpcion4.setSelected(false);
			}
		});
		rdbtnOpcion2.setBounds(367, 310, 395, 66);
		contentPane.add(rdbtnOpcion2);
		rdbtnOpcion3.setBackground(new Color(255, 255, 255));
		rdbtnOpcion3.setVisible(false);
		rdbtnOpcion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnOpcion2.setSelected(false);
				rdbtnOpcion1.setSelected(false);
				rdbtnOpcion4.setSelected(false);
			}
		});
		rdbtnOpcion3.setBounds(6, 379, 359, 66);
		contentPane.add(rdbtnOpcion3);
		rdbtnOpcion4.setBackground(new Color(255, 255, 255));
		rdbtnOpcion4.setVisible(false);
		rdbtnOpcion4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnOpcion2.setSelected(false);
				rdbtnOpcion3.setSelected(false);
				rdbtnOpcion1.setSelected(false);
			}
		});
		rdbtnOpcion4.setBounds(367, 379, 395, 66);
		contentPane.add(rdbtnOpcion4);
		
		lblImagen = new JLabel("");
		lblImagen.setVisible(false);
		lblImagen.setIcon(new ImageIcon(RUTA + PAISES_ISO[banderaImagen] + ".png"));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(6, 11, 756, 342);
		contentPane.add(lblImagen);
		
		lblPuntuacion = new JLabel("Puntuación: " + puntuacion + "/" + contadorPreguntas);
		lblPuntuacion.setVisible(false);
		lblPuntuacion.setBackground(new Color(255, 255, 255));
		lblPuntuacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblPuntuacion.setBounds(608, 0, 150, 42);
		contentPane.add(lblPuntuacion);
		lbPregunta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbPregunta.setVisible(false);
		lbPregunta.setBounds(224, 28, 325, 14);
		lbPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		
		contentPane.add(lbPregunta);
		
		btnTerminar = new JButton("Salir");
		btnTerminar.setVisible(false);
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null,"Estas seguro de que quieres salir?","Pregunta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

			        if (opcion == JOptionPane.YES_OPTION) {
			            System.exit(0);
			        } 
			}
		});
		btnTerminar.setBounds(6, 464, 123, 32);
		contentPane.add(btnTerminar);
	}
}