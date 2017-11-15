import java.awt.EventQueue;

import javax.swing.JFrame;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.renderable.RenderableImageOp;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;

@SuppressWarnings("unused")
public class JanelaPrincipal {
	private JFrame jfQuiz;
	private JTextField jtfPergunta;
	private JTextField jtfResposta1;
	private JTextField jtfResposta2;
	private JTextField jtfResposta3;
	private JTextField jtfResposta4;
	private JTextField jtfResposta5;
	private final Action action = new SwingAction();
	com.db4o.ObjectContainer recordset;
	boolean novoRegistro = false;
	Pergunta perguntaAtual;
	int palpite = 0;
	ObjectSet<Pergunta> perguntas;
	JRadioButton radios[] = new JRadioButton[5];  


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
					window.jfQuiz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jfQuiz = new JFrame();
		jfQuiz.setTitle("QuizJava - HandsON");
		jfQuiz.setBounds(100, 100, 644, 416);
		jfQuiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfQuiz.getContentPane().setLayout(null);
		
		JPanel jpJogar = new JPanel();
		jpJogar.setBounds(0, 0, 628, 356);
		jfQuiz.getContentPane().add(jpJogar);
		jpJogar.setLayout(null);
		

		
		JLabel lblResponta = new JLabel("QuizJava - Jogar");
		lblResponta.setFont(new Font("Dialog", Font.BOLD, 20));
		lblResponta.setBounds(45, 22, 368, 41);
		jpJogar.add(lblResponta);
		
		
		JLabel label_7 = new JLabel("Pergunta:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(75, 85, 424, 15);
		jpJogar.add(label_7);
		
				JLabel label_1 = new JLabel("Resposta certa:");
				label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_1.setBounds(197, 264, 256, 15);
				jpJogar.add(label_1);
				
				
				JRadioButton jrbAlternativa1 = new JRadioButton("");
				jrbAlternativa1.setMnemonic('1');
				jrbAlternativa1.setBounds(113, 122, 430, 23);
				jrbAlternativa1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						palpite = 1;
						radios[1].setSelected(false);
						radios[2].setSelected(false);
						radios[3].setSelected(false);
						radios[4].setSelected(false);
						label_1.setText("");
						
					}
				});
				
				jpJogar.add(jrbAlternativa1);
				
				JRadioButton jrbAlternativa2 = new JRadioButton("");
				jrbAlternativa2.setMnemonic('1');
				jrbAlternativa2.setBounds(113, 148, 430, 23);
				jrbAlternativa2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						palpite = 2;
						radios[0].setSelected(false);
						radios[2].setSelected(false);
						radios[3].setSelected(false);
						radios[4].setSelected(false);
						label_1.setText("");
					}
				});
				jpJogar.add(jrbAlternativa2);
				
				JRadioButton jrbAlternativa3 = new JRadioButton("");
				jrbAlternativa3.setMnemonic('1');
				jrbAlternativa3.setBounds(113, 174, 430, 23);
				jrbAlternativa3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						palpite = 3;
						radios[0].setSelected(false);
						radios[1].setSelected(false);
						radios[3].setSelected(false);
						radios[4].setSelected(false);
						label_1.setText("");
					}
				});
				
				jpJogar.add(jrbAlternativa3);
				
				JRadioButton jrbAlternativa4 = new JRadioButton("");
				jrbAlternativa4.setMnemonic('1');
				jrbAlternativa4.setBounds(113, 204, 430, 23);
				jrbAlternativa4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						radios[0].setSelected(false);
						radios[1].setSelected(false);
						radios[2].setSelected(false);
						radios[4].setSelected(false);
						palpite = 4;
						label_1.setText("");
					}
				});
				jpJogar.add(jrbAlternativa4);
				
				JRadioButton jrbAlternativa5 = new JRadioButton("");
				jrbAlternativa5.setMnemonic('1');
				jrbAlternativa5.setBounds(113, 230, 430, 23);
				jrbAlternativa5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						palpite = 5;
						radios[0].setSelected(false);
						radios[1].setSelected(false);
						radios[2].setSelected(false);
						radios[3].setSelected(false);
						label_1.setText("");
					}
				});
				jpJogar.add(jrbAlternativa5);
				
				
				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (perguntaAtual.respostaCerta == palpite) {
							label_1.setText("Certa a resposta! Ha hai... hi hi...");
						}else
						{
							
							label_1.setText("Perdeu tudo!!! Ha hai... hi hi...");
							
						}
					}
				});
				btnConfirmar.setBounds(108, 301, 117, 25);
				jpJogar.add(btnConfirmar);		
				
				JButton btnPrxima = new JButton("Pr\u00F3xima");
				btnPrxima.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (perguntas.hasNext()){
							Pergunta p = perguntas.next();
							perguntaAtual = p;
							label_7.setText(p.descricao);
							jrbAlternativa1.setText(p.resposta1);
							jrbAlternativa2.setText(p.resposta2);
							jrbAlternativa3.setText(p.resposta3);
							jrbAlternativa4.setText(p.resposta4);
							jrbAlternativa5.setText(p.resposta5);
							label_1.setText("");
						}
						
					}
				});
				btnPrxima.setBounds(421, 301, 117, 25);
				jpJogar.add(btnPrxima);
				
				radios[0] = jrbAlternativa1;
				radios[1] = jrbAlternativa2;
				radios[2] = jrbAlternativa3;
				radios[3] = jrbAlternativa4;
				radios[4] = jrbAlternativa5;
				jpJogar.setVisible(false);
		
		JPanel jpCadastrarQuestao = new JPanel();
		jpCadastrarQuestao.setBounds(0, 0, 628, 356);
		jfQuiz.getContentPane().add(jpCadastrarQuestao);
		jpCadastrarQuestao.setLayout(null);
		
		JLabel jlblPergunta = new JLabel("Pergunta:");
		jlblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlblPergunta.setBounds(74, 90, 70, 15);
		jpCadastrarQuestao.add(jlblPergunta);
		
		jtfPergunta = new JTextField();
		jtfPergunta.setBounds(146, 84, 361, 27);
		jpCadastrarQuestao.add(jtfPergunta);
		jtfPergunta.setColumns(10);
		
		JLabel jlblAlternativa1 = new JLabel("1)");
		jlblAlternativa1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlblAlternativa1.setBounds(116, 122, 28, 15);
		jpCadastrarQuestao.add(jlblAlternativa1);
		
		jtfResposta1 = new JTextField();
		jtfResposta1.setColumns(10);
		jtfResposta1.setBounds(146, 117, 361, 27);
		jpCadastrarQuestao.add(jtfResposta1);
		
		JLabel jlblAlternativa2 = new JLabel("2)");
		jlblAlternativa2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlblAlternativa2.setBounds(116, 155, 28, 15);
		jpCadastrarQuestao.add(jlblAlternativa2);
		
		jtfResposta2 = new JTextField();
		jtfResposta2.setColumns(10);
		jtfResposta2.setBounds(146, 150, 361, 27);
		jpCadastrarQuestao.add(jtfResposta2);
		
		JLabel jlblAlternativa3 = new JLabel("3)");
		jlblAlternativa3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlblAlternativa3.setBounds(116, 188, 28, 15);
		jpCadastrarQuestao.add(jlblAlternativa3);
		
		jtfResposta3 = new JTextField();
		jtfResposta3.setColumns(10);
		jtfResposta3.setBounds(146, 183, 361, 27);
		jpCadastrarQuestao.add(jtfResposta3);
		
		JLabel jlblAlternativa4 = new JLabel("4)");
		jlblAlternativa4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlblAlternativa4.setBounds(116, 218, 28, 15);
		jpCadastrarQuestao.add(jlblAlternativa4);
		
		jtfResposta4 = new JTextField();
		jtfResposta4.setColumns(10);
		jtfResposta4.setBounds(146, 213, 361, 27);
		jpCadastrarQuestao.add(jtfResposta4);
		
		JLabel jlblAlternativa5 = new JLabel("5)");
		jlblAlternativa5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlblAlternativa5.setBounds(116, 251, 28, 15);
		jpCadastrarQuestao.add(jlblAlternativa5);
		
		jtfResposta5 = new JTextField();
		jtfResposta5.setColumns(10);
		jtfResposta5.setBounds(146, 246, 361, 27);
		jpCadastrarQuestao.add(jtfResposta5);
		
		JLabel lblRespostaCerta = new JLabel("Resposta certa:");
		lblRespostaCerta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRespostaCerta.setBounds(74, 286, 90, 15);
		jpCadastrarQuestao.add(lblRespostaCerta);
		
		JFormattedTextField jspRespostaCerta = new JFormattedTextField();
		jspRespostaCerta.setBounds(176, 283, 28, 20);
		jpCadastrarQuestao.add(jspRespostaCerta);
		
		JButton jbtnSalvar = new JButton("Salvar");
		jbtnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (novoRegistro) {
					Pergunta p = new Pergunta();
					p.setPergunta(jtfPergunta.getText(), (int) jspRespostaCerta.getValue(),jtfResposta1.getText(), jtfResposta2.getText(), jtfResposta3.getText(), jtfResposta4.getText(), jtfResposta5.getText());
					recordset.store(p);
					System.out.println("Registro salvo " + p);
					perguntaAtual = p;
					
				}else
				{
					
					ObjectSet<Pergunta> set = recordset.get(perguntaAtual); 
					if ( set.hasNext() ) {
						Pergunta p = (Pergunta)set.next();
						p.descricao = jtfPergunta.getText();
						p.resposta1 = jtfResposta1.getText();
						p.resposta2 = jtfResposta2.getText();
						p.resposta3 = jtfResposta3.getText();
						p.resposta4 = jtfResposta4.getText();
						p.resposta5 = jtfResposta5.getText();
						p.respostaCerta = (int)jspRespostaCerta.getValue();
						perguntaAtual = p;
						recordset.set(p);
						recordset.commit();
					}
					
				} 
				
			}
		});
		jbtnSalvar.setBounds(263, 293, 117, 25);
		jpCadastrarQuestao.add(jbtnSalvar);
		
		JLabel jlblCabecalho = new JLabel("QuizJava - Cadastrar Quest\u00E3o");
		jlblCabecalho.setFont(new Font("Dialog", Font.BOLD, 20));
		jlblCabecalho.setBounds(45, 22, 291, 41);
		jpCadastrarQuestao.add(jlblCabecalho);
		
		JButton btnNova = new JButton("Nova");
		btnNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfPergunta.setText("");
				jtfResposta1.setText("");
				jtfResposta2.setText("");
				jtfResposta3.setText("");
				jtfResposta4.setText("");
				jtfResposta5.setText("");
				jspRespostaCerta.setValue(1);
				novoRegistro = true;
			}
		});
		btnNova.setBounds(390, 294, 117, 25);
		jpCadastrarQuestao.add(btnNova);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		jfQuiz.setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmManutencao = new JMenuItem("Criar Quest\u00E3o");
		mntmManutencao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jpCadastrarQuestao.setVisible(true);
				jpJogar.setVisible(false);
			}
		});
		mnCadastro.add(mntmManutencao);
		
		JMenu mnJogar = new JMenu("Jogar");
		menuBar.add(mnJogar);
		
		JMenuItem mntmJogar = new JMenuItem("Jogar");
		mntmJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jpJogar.setVisible(true);
				jpCadastrarQuestao.setVisible(false);
				perguntas = recordset.query(Pergunta.class);
				
				if (perguntas.hasNext()){
					Pergunta p = perguntas.next();
					perguntaAtual = p;
					label_7.setText(p.descricao);
					jrbAlternativa1.setText(p.resposta1);
					jrbAlternativa2.setText(p.resposta2);
					jrbAlternativa3.setText(p.resposta3);
					jrbAlternativa4.setText(p.resposta4);
					jrbAlternativa5.setText(p.resposta5);
					label_1.setText("");
				}

			}
		});
		mnJogar.add(mntmJogar);
		
		recordset = Db4oEmbedded.openFile("quiz.bd"); 
		Pergunta p = new Pergunta();
		try {
			ObjectSet<Pergunta> os = recordset.query(Pergunta.class);
			if (os.hasNext()){
				perguntaAtual = os.next();
				jtfPergunta.setText(perguntaAtual.descricao);
				jtfResposta1.setText(perguntaAtual.resposta1);
				jtfResposta2.setText(perguntaAtual.resposta2);
				jtfResposta3.setText(perguntaAtual.resposta3);
				jtfResposta4.setText(perguntaAtual.resposta4);
				jtfResposta5.setText(perguntaAtual.resposta5);
				jspRespostaCerta.setValue(perguntaAtual.respostaCerta);
				novoRegistro = false;
			} else
			{
				jtfPergunta.setText("");
				jtfResposta1.setText("");
				jtfResposta2.setText("");
				jtfResposta3.setText("");
				jtfResposta4.setText("");
				jtfResposta5.setText("");
				jspRespostaCerta.setValue("");
				novoRegistro = true;
				
			}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
	}
	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
