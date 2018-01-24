package clases;


import java.awt.EventQueue;








import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import java.util.Calendar;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton dinero5;
	private JRadioButton dinero25;
	private JRadioButton dinero50;
	private JRadioButton dinero10;

	private JTextArea txtingresos;
	private JTextField txttotal;
	private JLabel lblDisponible;
	private JButton btncancelar;
	private JLabel lblCancelar;
	private JLabel lblBebidas;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l6;
	private JLabel l5;
	private JLabel l4;
	private JRadioButton rbfanta;
	private JRadioButton rbcoca;
	private JRadioButton rbagua;
	private JRadioButton rb7up;
	private JRadioButton rbpepsi;
	private JRadioButton rbred;
	private JButton btncomprar;
	

	
	////VARIABLES
	int dinero,contador=1;
	String cantidades_ingresadas="",direccion="q0.png";
	//Radio
	ButtonGroup monedas = new ButtonGroup();
	ButtonGroup bebidas = new ButtonGroup();
	
	///STOCK
	int fanta=1,coca=2,agua=3,up7=4,pepsi=5,red=6;
	private JLabel lbstock;
	private JLabel lbmensaje;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setVisible(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public principal() 
	{
	
		ventana();
		diseño();
		ingreso_dinero();
		cancelar();
		comprar();
		
		
		//q0
		estados();
		
		//los siguientes estados se cambian en los botoenes aceptar y cancelar
		
		//Stock
		mostrar_stock();
		
	
	}

	public void ventana()
	{
		
		
		
		setTitle("Maquin\u00E1 de refrescos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 762, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.desktop);
		panel.setBounds(456, 69, 280, 492);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		dinero5 = new JRadioButton("5 \u00A2");
		dinero5.setBounds(40, 112, 100, 57);
		panel.add(dinero5);
		dinero5.setBackground(Color.WHITE);
		
		////grupo de radiobuttons 
		 
		
		 monedas.add(dinero5);
		
		dinero10 = new JRadioButton("10 \u00A2");
		dinero10.setBounds(36, 47, 104, 61);
		panel.add(dinero10);
		dinero10.setBackground(Color.WHITE);
		monedas.add(dinero10);
		
		dinero25 = new JRadioButton("25 \u00A2");
		dinero25.setBounds(40, 173, 100, 76);
		panel.add(dinero25);
		dinero25.setBackground(Color.WHITE);
		monedas.add(dinero25);
		
		dinero50 = new JRadioButton("50 \u00A2");
		dinero50.setBounds(40, 247, 97, 66);
		panel.add(dinero50);
		dinero50.setBackground(Color.WHITE);
		 monedas.add(dinero50);
		 
		 btncancelar = new JButton("New button");
		 btncancelar.setBounds(60, 431, 49, 50);
		 panel.add(btncancelar);
		 btncancelar.setBackground(Color.RED);
		 btncancelar.setForeground(Color.RED);
		 btncancelar.setIcon(new ImageIcon("C:\\Users\\alejandro\\Desktop\\JAVA TRABAJOS\\Maq_refrescos\\src\\botones_iconos\\cancelar.png"));
		 
		 lblCancelar = new JLabel("CANCELAR");
		 lblCancelar.setBounds(50, 403, 80, 22);
		 panel.add(lblCancelar);
		 lblCancelar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		 
		 btncomprar = new JButton("New button");
		 btncomprar.setBounds(60, 342, 49, 50);
		 panel.add(btncomprar);
		 
		  btncomprar.setIcon(new ImageIcon("C:\\Users\\alejandro\\Desktop\\JAVA TRABAJOS\\Maq_refrescos\\src\\botones_iconos\\aceptar.jpg"));
		  
		  btncomprar.setForeground(Color.GREEN);
		  btncomprar.setBackground(Color.GREEN);
		  
		  JLabel lblComprar = new JLabel("COMPRAR");
		  lblComprar.setBounds(50, 320, 80, 22);
		  panel.add(lblComprar);
		  lblComprar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		 
		 JLabel lblIngresoDinero = new JLabel("INGRESO DINERO");
		 lblIngresoDinero.setBounds(10, 11, 260, 22);
		 panel.add(lblIngresoDinero);
		 lblIngresoDinero.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		 
		 panel_1 = new JPanel();
		 panel_1.setBounds(11, 69, 435, 492);
		 contentPane.add(panel_1);
		 panel_1.setLayout(null);
		 panel_1.setBackground(Color.white);
		 lblBebidas = new JLabel("BEBIDAS");
		 lblBebidas.setBounds(72, 271, 80, 22);
		 panel_1.add(lblBebidas);
		 lblBebidas.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		 
		 l1 = new JLabel("");
		 l1.setForeground(SystemColor.menu);
		 l1.setBounds(24, 307, 33, 50);
		 panel_1.add(l1);
		 
		 l2 = new JLabel("");
		 l2.setForeground(SystemColor.menu);
		 l2.setBounds(93, 307, 33, 50);
		 panel_1.add(l2);
		 
		 l3 = new JLabel("");
		 l3.setForeground(SystemColor.menu);
		 l3.setBounds(164, 307, 33, 50);
		 panel_1.add(l3);
		 
		 l6 = new JLabel("");
		 l6.setForeground(SystemColor.menu);
		 l6.setBounds(164, 393, 33, 50);
		 panel_1.add(l6);
		 
		 l5 = new JLabel("");
		 l5.setForeground(SystemColor.menu);
		 l5.setBounds(93, 393, 33, 50);
		 panel_1.add(l5);
		 
		 l4 = new JLabel("");
		 l4.setForeground(SystemColor.menu);
		 l4.setBounds(24, 393, 33, 50);
		 panel_1.add(l4);
		 
		 rbfanta = new JRadioButton("75 \u00A2");
		 rbfanta.setBounds(6, 364, 66, 23);
		 panel_1.add(rbfanta);
		 rbfanta.setBackground(Color.WHITE);
		 
		 ///Grupo Radio Buton Bebidas
	
			////grupo de radiobuttons 
		 
		
		 bebidas.add(rbfanta);
		 
		 rbcoca = new JRadioButton("80 \u00A2");
		 rbcoca.setBounds(80, 364, 72, 23);
		 panel_1.add(rbcoca);
		 rbcoca.setBackground(Color.WHITE);
		 bebidas.add(rbcoca);
		 
		 rbagua = new JRadioButton("50 \u00A2");
		 rbagua.setBounds(154, 364, 58, 23);
		 panel_1.add(rbagua);
		 rbagua.setBackground(Color.WHITE);
		 bebidas.add(rbagua);
		 
		 rb7up = new JRadioButton("65 \u00A2");
		 rb7up.setBounds(6, 440, 58, 23);
		 panel_1.add(rb7up);
		 rb7up.setBackground(Color.WHITE);
		 bebidas.add(rb7up);
		 
		 rbpepsi = new JRadioButton("65 \u00A2");
		 rbpepsi.setBounds(81, 440, 58, 23);
		 panel_1.add(rbpepsi);
		 rbpepsi.setBackground(Color.WHITE);
		 bebidas.add(rbpepsi);
		 
		 rbred = new JRadioButton("95 \u00A2");
		 rbred.setBounds(154, 440, 58, 23);
		 panel_1.add(rbred);
		 rbred.setBackground(Color.WHITE);
		 bebidas.add(rbred);
		 
		 JLabel lblTuEfectivo = new JLabel("TU EFECTIVO ");
		 lblTuEfectivo.setBounds(10, 13, 158, 22);
		 panel_1.add(lblTuEfectivo);
		 lblTuEfectivo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		 
		 txttotal = new JTextField();
		 txttotal.setForeground(new Color(124, 252, 0));
		 txttotal.setBackground(Color.BLACK);
		 txttotal.setFont(new Font("Digital Counter 7", Font.BOLD, 16));
		 txttotal.setBounds(10, 225, 197, 35);
		 panel_1.add(txttotal);
		 txttotal.setEditable(false);
		 txttotal.setColumns(10);
		 
		 lblDisponible = new JLabel("DISPONIBLE");
		 lblDisponible.setBounds(10, 192, 80, 22);
		 panel_1.add(lblDisponible);
		 lblDisponible.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		 
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 46, 197, 133);
		 panel_1.add(scrollPane);
		 
		 txtingresos = new JTextArea();
		 scrollPane.setViewportView(txtingresos);
		 txtingresos.setBackground(Color.BLACK);
		 txtingresos.setFont(new Font("Digital Counter 7", Font.BOLD, 22));
		 txtingresos.setForeground(Color.GREEN);
		 txtingresos.setEditable(false);
		 
		 lbstock = new JLabel("");
		 lbstock.setBounds(10, 458, 189, 23);
		 panel_1.add(lbstock);
		 lbstock.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		 Border raisedbevel;
		 raisedbevel = BorderFactory.createEtchedBorder();
		 panel.setBorder(raisedbevel);
		 panel_1.setBorder(raisedbevel);
		 
		 lbmensaje = new JLabel("");
		 lbmensaje.setBounds(535, 515, 285, 28);
		 contentPane.add(lbmensaje);
		 
		 
		 ///Hora en el mensaje
		 	Calendar calendario = Calendar.getInstance();
		 	int hora, minutos, segundos;
		    hora =calendario.get(Calendar.HOUR_OF_DAY);
		    minutos = calendario.get(Calendar.MINUTE);
		    segundos = calendario.get(Calendar.SECOND);
		 
	
		 //estado inicio
		

	
		 
	
		
		
	}
	
	
	
	public void diseño()
	{
		//////////////MONEDAS/////////////////
		
		///////5 centavos
		 String path ="/monedas/5ctv.JPG";  
		 java.net.URL url = this.getClass().getResource(path);  
		 ImageIcon icon = new ImageIcon(url);  
		 dinero5.setIcon(icon);  
		 
		 

		///////10 centavos
		String path2 ="/monedas/10ctv.JPG";  
		java.net.URL url2 = this.getClass().getResource(path2);  
		ImageIcon icon2 = new ImageIcon(url2);  
		dinero10.setIcon(icon2);  
		
		
		///////25 centavos
		String path3 ="/monedas/25ctv.png";  
		java.net.URL url3 = this.getClass().getResource(path3);  
		ImageIcon icon3 = new ImageIcon(url3);  
		dinero25.setIcon(icon3);  
		
		///////50 centavos
		String path4 ="/monedas/50ctv.png";  
		java.net.URL url4 = this.getClass().getResource(path4);  
		ImageIcon icon4 = new ImageIcon(url4);  
		dinero50.setIcon(icon4);  
			
		
		
		//////////////BEBIDAS/////////////////
		
		String path5 ="/bebidas/fanta.png";  
		java.net.URL url5 = this.getClass().getResource(path5);  
		ImageIcon icon5 = new ImageIcon(url5);  
		l1.setIcon(icon5);   
		
		String path6 ="/bebidas/cocacola.png";  
		java.net.URL url6 = this.getClass().getResource(path6);  
		ImageIcon icon6 = new ImageIcon(url6);  
		l2.setIcon(icon6);   
		
		String path7 ="/bebidas/agua.png";  
		java.net.URL url7 = this.getClass().getResource(path7);  
		ImageIcon icon7 = new ImageIcon(url7);  
		l3.setIcon(icon7);   
		
		String path8 ="/bebidas/7up.png";  
		java.net.URL url8 = this.getClass().getResource(path8);  
		ImageIcon icon8 = new ImageIcon(url8);  
		l4.setIcon(icon8); 
		
		String path9 ="/bebidas/pepsi.png";  
		java.net.URL url9 = this.getClass().getResource(path9);  
		ImageIcon icon9 = new ImageIcon(url9);  
		l5.setIcon(icon9); 
		
		String path10 ="/bebidas/red bull.png";  
		java.net.URL url10 = this.getClass().getResource(path10);  
		ImageIcon icon10 = new ImageIcon(url10);  
		l6.setIcon(icon10); 
			
		
	}


	
	public void ingreso_dinero()
	{
		//contados para enumerar las lineas del txt area y el orden del vuelto ingresado
		
		//////////
		
		
			
		
		dinero5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{  
				
		
				dinero=dinero+5;
				cantidades_ingresadas=cantidades_ingresadas + "5 ¢ \n" ;		
				//Imprimir en el text Area las cantidades ingresadas
				txtingresos.append(""+contador+".- 5 ¢");
				txtingresos.append(System.getProperty("line.separator"));  
				txttotal.setText(""+dinero+" ¢");
				contador++;	
				
				
				//estado q1
				direccion="q1.png";
				estados();
				
				//desaparecer msj
				
			}
		});
		
		
		///////
		dinero10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dinero=dinero+10;
				cantidades_ingresadas=cantidades_ingresadas + "10 ¢ \n" ;	
				//Imprimir en el text Area las cantidades ingresadas
				txtingresos.append(""+contador+".- 10 ¢");
				txtingresos.append(System.getProperty("line.separator"));  
				txttotal.setText(""+dinero+" ¢");
				contador++;	
				
				//estado q1
				direccion="q1.png";
				estados();
				
				//desaparecer msj
				
			}
		});
		
		
		///////
		dinero25.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					dinero=dinero+25;
					cantidades_ingresadas=cantidades_ingresadas + "25 ¢ \n" ;	
					//Imprimir en el text Area las cantidades ingresadas
					txtingresos.append(""+contador+".- 25 ¢");
					txtingresos.append(System.getProperty("line.separator"));  
					txttotal.setText(""+dinero+" ¢");
					contador++;	
					
					//estado q1
					direccion="q1.png";
					estados();
					
					//desaparecer msj
					
				}
			});
			
		///////
		dinero50.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					dinero=dinero+50;
					cantidades_ingresadas=cantidades_ingresadas + "50 ¢ \n";
					//Imprimir en el text Area las cantidades ingresadas
					txtingresos.append(""+contador+".- 50 ¢");
					txtingresos.append(System.getProperty("line.separator"));  
					txttotal.setText(""+dinero+" ¢");
					contador++;	
					
					//estado q1
					direccion="q1.png";
					estados();
					
					
					//desaparecer msj
					
				}
				});

		
		
		
	}




	public void cancelar()
	{
		 btncancelar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e)
			 	{
			 		if(contador >=2 )
			 		{	
			 		System.out.println("---TU DINERO---\n"+cantidades_ingresadas+"");
			 		cantidades_ingresadas="";
			 		dinero=0;
			 		txttotal.setText("");
			 		contador=1;
			 		txtingresos.setText("");
			 		lbstock.setText("");
			 		
			 		
			 		//llamar metodo limpiar rb
			 		limpiar_rb();
			 	
			 		
			 		
			 		//estado q1
					direccion="q0.png";
					estados();
					
					
					
					
			 		
			 		}
			 	}
			 });
		
	}



	public void comprar()
	{
	
	 btncomprar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) 
			 	{	
			 		String mensaje="";
	
			 	if(contador>=2)
			 	{	
			 		/////Cola Fanta
					if(rbfanta.isSelected()==true)
					{ 		 	
					if(fanta>0)
				 	{	
							if(dinero>=75)
					 		{
					 			int aux=dinero-75;
					 			
					 				if(aux > 0)
					 				{
					 					mensaje="Su cambio "+aux+" ¢";	
					 				}	
					 			////estado q2
									direccion="q2.png";
									estados();	
					 				
				 				JOptionPane.showMessageDialog(null,"Usted compro\nBebida Fanta\n"+mensaje+" Gracias\nVuelta pronto");
				 				fanta=fanta-1;
				 				////reinicar maquina
								cantidades_ingresadas="";
						 		dinero=0;
						 		txttotal.setText("");
						 		contador=1;
						 		txtingresos.setText("");
						 		lbstock.setText("");
						 		direccion="q0.png";
								estados();	
								limpiar_rb();
					
						 		
						 		
					 		}
				 			
				 			else
				 			{
				 				JOptionPane.showMessageDialog(null,"Revisé su bolsillo por favor");
				 			}				 			
				 		}
				 		else
				 		{
				 			JOptionPane.showMessageDialog(null,"Lo sentimos no disponible en stock");								
				 		}
														
					}	
			 		
					
					/////Coca - Cola
					if(rbcoca.isSelected()==true)
					{ 		 	
					if(coca>0)
				 	{	
							if(dinero>=80)
					 		{
					 			int aux=dinero-80;
					 			
					 				if(aux > 0)
					 				{
					 					mensaje="Su cambio "+aux+" ¢";	
					 				}	
					 				
					 			////estado q2
									direccion="q2.png";
									estados();	
					 				
				 				JOptionPane.showMessageDialog(null,"Usted compro\nBebida : Coca cola\n"+mensaje+" Gracias\nVuelta pronto");
				 				coca=coca-1;
				 				////reinicar maquina
								cantidades_ingresadas="";
						 		dinero=0;
						 		txttotal.setText("");
						 		contador=1;
						 		txtingresos.setText("");
						 		lbstock.setText("");
						 		direccion="q0.png";
								estados();	
								limpiar_rb();
				
						 		
					 		}
				 			
				 			else
				 			{
				 				JOptionPane.showMessageDialog(null,"Revisé su bolsillo por favor");
				 			}				 			
				 		}
				 		else
				 		{
				 			JOptionPane.showMessageDialog(null,"Lo sentimos no disponible en stock");								
				 		}
														
					}	
			 		
					
					
					
				/////Agua
					if(rbagua.isSelected()==true)
					{ 		 	
					if(agua>0)
				 	{	
							if(dinero>=50)
					 		{
					 			int aux=dinero-50;
					 			
					 				if(aux > 0)
					 				{
					 					mensaje="Su cambio "+aux+" ¢";	
					 				}					 			
					 			////estado q2
									direccion="q2.png";
									estados();
					 				
					 				
					 			JOptionPane.showMessageDialog(null,"Usted compro\nBebida : Agua sin gas\n"+mensaje+" Gracias\nVuelta pronto");
				 				agua=agua-1;
				 				////reinicar maquina
								cantidades_ingresadas="";
						 		dinero=0;
						 		txttotal.setText("");
						 		contador=1;
						 		txtingresos.setText("");
						 		lbstock.setText("");
						 		direccion="q0.png";
								estados();	
								limpiar_rb();
				
					 		}
				 			
				 			else
				 			{
				 				JOptionPane.showMessageDialog(null,"Revisé su bolsillo por favor");
				 			}				 			
				 		}
				 		else
				 		{
				 			JOptionPane.showMessageDialog(null,"Lo sentimos no disponible en stock");								
				 		}
														
					}	
			 		
					
				/////Agua
					if(rb7up.isSelected()==true)
					{ 		 	
					if(up7>0)
				 	{	
							if(dinero>=65)
					 		{
					 			int aux=dinero-65;
					 			
					 				if(aux > 0)
					 				{
					 					mensaje="Su cambio "+aux+" ¢";	
					 				}	
					 			
					 				////estado q2
									direccion="q2.png";
									estados();
					 				
				 				JOptionPane.showMessageDialog(null,"Usted compro\nBebida 7up\n"+mensaje+" Gracias\nVuelta pronto");
				 				up7=up7-1;
				 				////reinicar maquina
								cantidades_ingresadas="";
						 		dinero=0;
						 		txttotal.setText("");
						 		contador=1;
						 		txtingresos.setText("");
						 		lbstock.setText("");
						 		direccion="q0.png";
								estados();	
								limpiar_rb();
							
						 	
					 		}
				 			
				 			else
				 			{
				 				JOptionPane.showMessageDialog(null,"Revisé su bolsillo por favor");
				 			}				 			
				 		}
				 		else
				 		{
				 			JOptionPane.showMessageDialog(null,"Lo sentimos no disponible en stock");								
				 		}
														
					}	
					
					
					/////Pepsi
					if(rbpepsi.isSelected()==true)
					{ 		 	
					if(pepsi>0)
				 	{	
							if(dinero>=65)
					 		{
					 			int aux=dinero-65;
					 			
					 				if(aux > 0)
					 				{
					 					mensaje="Su cambio "+aux+" ¢";	
					 				}	
					 			////estado q2
									direccion="q2.png";
									estados();
					 				
				 				JOptionPane.showMessageDialog(null,"Usted compro\nBebida : Pepsi\n"+mensaje+" Gracias\nVuelta pronto");
				 				pepsi=pepsi-1;
				 				////reinicar maquina
								cantidades_ingresadas="";
						 		dinero=0;
						 		txttotal.setText("");
						 		contador=1;
						 		txtingresos.setText("");	
						 		lbstock.setText("");
						 		direccion="q0.png";
								estados();	
								limpiar_rb();
							
					 		}
				 			
				 			else
				 			{
				 				JOptionPane.showMessageDialog(null,"Revisé su bolsillo por favor");
				 			}				 			
				 		}
				 		else
				 		{
				 			JOptionPane.showMessageDialog(null,"Lo sentimos no disponible en stock");								
				 		}
														
					}
					
					
					/////Red
					if(rbred.isSelected()==true)
					{ 		 	
					if(red>0)
				 	{	
							if(dinero>=95)
					 		{
					 			int aux=dinero-95;
					 			
					 				if(aux > 0)
					 				{
					 					mensaje="Su cambio "+aux+" ¢";	
					 				}		
					 			////estado q2
								direccion="q2.png";
								estados();	
					 				
				 				JOptionPane.showMessageDialog(null,"Usted compro\n Bebida: Red Bull\n"+mensaje+" Gracias\nVuelta pronto");
				 				red=red-1;
				 				////reinicar maquina
								cantidades_ingresadas="";
						 		dinero=0;
						 		txttotal.setText("");
						 		contador=1;
						 		txtingresos.setText("");
						 		lbstock.setText("");
						 		direccion="q0.png";
								estados();	
								limpiar_rb();
							
						 	
					 		}
				 			
				 			else
				 			{
				 				JOptionPane.showMessageDialog(null,"Revisé su bolsillo por favor");
				 			}				 			
				 		}
				 		else
				 		{
				 			JOptionPane.showMessageDialog(null,"Lo sentimos no disponible en stock");								
				 		}
														
					}
						
					//cierro el if del contador
			 	}
			 	
			 	
			 		
			 		
			 		
			 	}
			 });	
		
		
	}

	
	public void mostrar_stock()
	{
		
		 rbfanta.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e)
			 	{
			 	lbstock.setText("Fanta : Disponible "+fanta+" unidades");
			 	}
			 });
		 
		 rbcoca.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e)
			 	{
			 	lbstock.setText("Coca-Cola Disponible "+coca+" unidades");
			 	}
			 });
		 
		 rbpepsi.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e)
			 	{
			 	lbstock.setText("Pepsi : Disponible "+pepsi+" unidades");
			 	}
			 });
		 
		 
		 rbagua.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e)
			 	{
			 	lbstock.setText("Agua : Disponible "+agua+" unidades");
			 	}
			 });
		 
		 rb7up.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e)
			 	{
			 	lbstock.setText("7up : Disponible "+up7+" unidades");
			 	}
			 });
		
		 rbred.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e)
			 	{
			 	lbstock.setText("Red Bull : Disponible "+red+" unidades");
			 	}
			 });
		 
	}
		
	
	
	public void estados()
	{
		 String path ="/estados/"+direccion+"";  
		 java.net.URL url = this.getClass().getResource(path);  
		 ImageIcon icon = new ImageIcon(url);
	}
	
	
		
	
	public void limpiar_rb()
	{
		//MONEDAS
 		monedas.remove(dinero5);
 		dinero5.setSelected(false);
 		monedas.add(dinero5);
 		
 		monedas.remove(dinero10);
 		dinero10.setSelected(false);
 		monedas.add(dinero10);
 		
 		monedas.remove(dinero25);
 		dinero25.setSelected(false);
 		monedas.add(dinero25);
 		
 		monedas.remove(dinero50);
 		dinero50.setSelected(false);
 		monedas.add(dinero50);
 		
 		//BEBIDAS
 		
 		bebidas.remove(rbfanta);
 		rbfanta.setSelected(false);
 		bebidas.add(rbfanta);
 		
 		bebidas.remove(rbcoca);
 		rbcoca.setSelected(false);
 		bebidas.add(rbcoca);
 		
 		bebidas.remove(rbpepsi);
 		rbpepsi.setSelected(false);
 		bebidas.add(rbpepsi);
 		
 		bebidas.remove(rbagua);
 		rbagua.setSelected(false);
 		bebidas.add(rbagua);
 		
 		bebidas.remove(rb7up);
 		rb7up.setSelected(false);
 		bebidas.add(rb7up);
 		
 		bebidas.remove(rbred);
 		rbred.setSelected(false);
 		bebidas.add(rbred);
 		
 	}
}



	
	
	
	


