import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;


public class Transliterator extends JFrame {

	private JPanel contentPane;
	private JMenuItem menuItem_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transliterator frame = new Transliterator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Transliterator() {
		final char[] ch = { 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'ы', 'и',
				'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
				'х', 'ц', 'а', 'ш', 'щ', 'ь', 'ъ', 'э', 'ю', 'я', ' ', ',',
				'!', '?', '.', ':', ';', 'Ч', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё',
				'Ж', 'З', 'Ы', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р',
				'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'А', 'Ш', 'Щ', 'Ь', 'Ъ', 'Э',
				'Ю', 'Я', '-','1','2','3','4','5','6','7','8','9','0','(',')'};
		final String[] str = { "ch", "b", "v", "g", "d", "je", "yo", "ze", "z", "y",
				"i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u",
				"f", "h", "ts", "a", "sh", "sh'", "'", "\"", "e", "ju", "ya",
				" ", ",", "!", "?", ".", ":", ";", "Ch", "B", "V", "G", "D",
				"Je", "Yo", "Z", "Z", "Y", "I", "J", "K", "L", "M", "N", "O",
				"P", "R", "S", "T", "U", "F", "H", "Ts", "A", "Sh", "Sh'",
				"'", "", "E", "Ju", "Ya", "-","1","2","3","4","5","6","7","8","9","0","(",")" };
		setResizable(false);
		setTitle("Tranliterator v_0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Input", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 428, 100);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		final JTextArea textArea = new JTextArea();
		textArea.setRows(0);
		textArea.setText("");
		panel.add(textArea);
		
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem menuItem = new JMenuItem("\\u041A\\u043E\\u043F\\u0438\\u0440\\u043E\\u0432\\u0430\\u0442\\u044C");
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String myString = textArea.getText();
				StringSelection stringSelection = new StringSelection (myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
			}
		});
		popupMenu.add(menuItem);
		menuItem_3 = new JMenuItem("\\u0412\\u0441\\u0442\\u0430\\u0432\\u0438\\u0442\\u044C");
		popupMenu.add(menuItem_3);
		addPopup(textArea, popupMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Result", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_1.setBounds(10, 152, 428, 100);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		final JTextArea textArea_1 = new JTextArea();
		panel_1.add(textArea_1, BorderLayout.CENTER);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(textArea_1, popupMenu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u041A\u043E\u043F\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
		popupMenu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u0412\u0441\u0442\u0430\u0432\u0438\u0442\u044C");
		popupMenu_1.add(menuItem_2);
		
		JButton btnNewButton = new JButton("rus=>trans");
		btnNewButton.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				String newStr=textArea.getText();
				textArea_1.setText(null);
				for (int i = 0; i < newStr.length(); i++) {
					for (int j = 0; j < ch.length; j++) {
						if (newStr.charAt(i) == ch[j]) {
							textArea_1.setText(textArea_1.getText()+str[j]);
						}
					}
				}
			}
		});
		btnNewButton.setBounds(10, 112, 90, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("trans=>rus");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StringBuffer newStr= new StringBuffer(100);
						newStr.append(textArea.getText());
				textArea_1.setText(null);
				for (int i = 0; i < newStr.length()-1; i++) {
					for (int j = 0; j < str.length; j++) {
						if (String.valueOf(newStr.charAt(i)).equals(str[j])) {	
							if ((newStr.charAt(i)=='j')&(newStr.charAt(i+1)=='e')){textArea_1.setText(textArea_1.getText()+"е");i++;break;}
							if ((newStr.charAt(i)=='y')&&(newStr.charAt(i+1)=='o')){textArea_1.setText(textArea_1.getText()+"ё");i++;break;}
							if ((newStr.charAt(i)=='z')&&(newStr.charAt(i+1)=='e')){textArea_1.setText(textArea_1.getText()+"ж");i++;break;}
							if ((newStr.charAt(i)=='t')&&(newStr.charAt(i+1)=='s')){textArea_1.setText(textArea_1.getText()+"ц");i++;break;}
							if ((newStr.charAt(i)=='c')&&(newStr.charAt(i+1)=='h')){textArea_1.setText(textArea_1.getText()+"ч");i++;break;}
							if ((newStr.charAt(i)=='s')&&(newStr.charAt(i+1)=='h')&&(newStr.charAt(i+2)=='\'')){textArea_1.setText(textArea_1.getText()+"щ");i=i+2;break;}
							if ((newStr.charAt(i)=='s')&&(newStr.charAt(i+1)=='h')){textArea_1.setText(textArea_1.getText()+"ш");i++;break;}
							if ((newStr.charAt(i)=='j')&&(newStr.charAt(i+1)=='u')){textArea_1.setText(textArea_1.getText()+"ю");i++;break;}
							if ((newStr.charAt(i)=='y')&&(newStr.charAt(i+1)=='a')){textArea_1.setText(textArea_1.getText()+"я");i++;break;}
							if ((newStr.charAt(i)=='J')&&(newStr.charAt(i+1)=='e')){textArea_1.setText(textArea_1.getText()+"Е");i++;break;}
							if ((newStr.charAt(i)=='Y')&&(newStr.charAt(i+1)=='o')){textArea_1.setText(textArea_1.getText()+"Ё");i++;break;}
							if ((newStr.charAt(i)=='Z')&&(newStr.charAt(i+1)=='e')){textArea_1.setText(textArea_1.getText()+"Ж");i++;break;}
							if ((newStr.charAt(i)=='T')&&(newStr.charAt(i+1)=='s')){textArea_1.setText(textArea_1.getText()+"Ц");i++;break;}
							if ((newStr.charAt(i)=='C')&&(newStr.charAt(i+1)=='h')){textArea_1.setText(textArea_1.getText()+"Ч");i++;break;}
							if ((newStr.charAt(i)=='S')&&(newStr.charAt(i+1)=='h')&&(newStr.charAt(i+2)=='\'')){textArea_1.setText(textArea_1.getText()+"Щ");i=i+2;break;}
							if ((newStr.charAt(i)=='S')&&(newStr.charAt(i+1)=='h')){textArea_1.setText(textArea_1.getText()+"Ш");i++;break;}
							if ((newStr.charAt(i)=='J')&&(newStr.charAt(i+1)=='u')){textArea_1.setText(textArea_1.getText()+"Ю");i++;break;}
							if ((newStr.charAt(i)=='Y')&&(newStr.charAt(i+1)=='a')){textArea_1.setText(textArea_1.getText()+"Я");i++;break;}
							textArea_1.setText(textArea_1.getText()+ch[j]);
						}			
					}			
				}
			}
		});
		btnNewButton_1.setBounds(112, 112, 90, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String temp = textArea.getText();
				textArea.setText(temp.substring(0,temp.length() - temp.length()));
			}
		});
		btnNewButton_2.setBounds(214, 112, 210, 28);
		contentPane.add(btnNewButton_2);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
