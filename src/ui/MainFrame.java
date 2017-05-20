package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import ui.MainFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;


public class MainFrame extends JFrame implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenu menuHelp;
	private JTabbedPane modulePanel;
	private JPanel panelControl;
	private JPanel panelUser;
	private JPanel panelLog;
	private JPanel panelSystem;
	private JPanel detailPanel;

	
	private static MainFrame mFrame = null;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainFrame();
		
	}
	
	public static Object getInstance() {
		if(mFrame == null)
		{
			mFrame = new MainFrame();
		}
		return mFrame;
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {	
		init();
		
	}
	
	public void init(){
		setTitle("MailServer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 660);
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuFile = new JMenu("�ļ�");
		menuBar.add(menuFile);
		
		JMenuItem miExit = new JMenuItem("�˳�");
		menuFile.add(miExit);
		
		menuHelp = new JMenu("����");
		menuBar.add(menuHelp);
		
		JMenuItem miAbout = new JMenuItem("�����ʼ�������");
		menuHelp.add(miAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ģ��ѡ�����
		modulePanel=getModulePanel();
		this.add(modulePanel);
		
		//�Ҳ���������
		detailPanel = getDetatilPanel();
		this.add(detailPanel);
		new ControlPanel(this).setDetailPanel(detailPanel);
				
		miExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		miAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "��ӭʹ��!"+"\n"+"ʱ��:  2017/05/20"+"\n"
					       +"MailServer","��ʾ"
									,JOptionPane.INFORMATION_MESSAGE);
			}
		});
		setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	// ģ�����
	private JTabbedPane getModulePanel(){
		JTabbedPane modulePanel=new JTabbedPane();
		modulePanel = new JTabbedPane(JTabbedPane.TOP);
		modulePanel.setBounds(0, 0, 874, 29);
		
		panelControl = new JPanel();
		modulePanel.addTab("�������", null, panelControl, null);
		
		panelUser = new JPanel();
		modulePanel.addTab("�û�����", null, panelUser, null);
		
		panelLog = new JPanel();
		modulePanel.addTab("��־����", null, panelLog, null);
		
		panelSystem = new JPanel();
		modulePanel.addTab("ϵͳ����", null, panelSystem, null);
		
		modulePanel.addChangeListener(this);
		return modulePanel;
			
	}
	
	
	// �����������
	public JPanel getDetatilPanel(){
		if(detailPanel == null){
			detailPanel = new JPanel();
			detailPanel.setBounds(0, 30, 874, 630);
		}		
		return detailPanel;
	}
	

	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int action = modulePanel.getSelectedIndex();
			
		switch(action){
		case 0:  
			new ControlPanel(this).setDetailPanel(detailPanel);
			break;
					
		case 1:
			new UserPanel(this).setDetailPanel(detailPanel);
			break;
					
		case 2:
			new LogPanel(this).setDetailPanel(detailPanel);
			break;
					
		case 3:
			new SystemPanel(this).setDetailPanel(detailPanel);
			break;	
					
		default:    
			new ControlPanel(this).setDetailPanel(detailPanel);
			break;

		}
			
		detailPanel.updateUI();
	}


}
