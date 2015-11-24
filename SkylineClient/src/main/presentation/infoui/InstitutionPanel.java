package main.presentation.infoui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

public class InstitutionPanel {
	private JPanel panel;
	private JTabbedPane tab;
	private JPanel addPanel;
	private JPanel inquirePanel;
	private JLabel title;
	private int panelWidth;
	private int panelHeight;
	private int tabWidth;
	private int tabHeight;
	private String[] kindString;
	private String[] inquireString;
	//新增界面的组件
	private JLabel kindLabel;
	private JLabel nameLabel;
	private JLabel placeLabel;
	private JLabel codeLabel;
	private JComboBox<String> kind;
	private JTextField name;
	private JTextField place;
	private JTextField code;
	private JButton saveButton;
	private JButton cancleButton;
	//查询界面的组件
	private JTextField inquireText;
	private JLabel inquireLabel;
	private JLabel inquireKind;
	private JLabel inquireName;
	private JLabel inquirePlace;
	private JLabel inquireCode;
	private JComboBox<String> kindBox;
	private JTextField nameText;
	private JTextField codeText;
	private JTextField placeText;
	private JButton inquireSave;
	private JButton  inquireCancle;
	private JButton inquireButton;
	private JButton backButton;
	private JLabel label;//
	private JLabel dataLabel;//这个label放组件，点击查询后setTrue
	
	public InstitutionPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		initTitle();
		tab = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tab);
		tab.setBounds(panelWidth/10, panelHeight/15, panelWidth*4/5, panelHeight*13/15);
		tabWidth = tab.getWidth();
		tabHeight = tab.getHeight();
		addPanel = new JPanel();
		inquirePanel = new JPanel();
		addPanel.setLayout(null);
		inquirePanel.setLayout(null);
		tab.addTab("新增机构", addPanel);
		tab.addTab("查询机构", inquirePanel);
		initAddPanel();
		initInquirePanel();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("机构管理");
		panel.add(title);
		title.setBounds(panelWidth*2/5, panelHeight/60, panelWidth/5, panelHeight/30);
	}
	public void initAddPanel(){
		kindString = new String[]{"1", "2", "3", "4", "5"};
		kindLabel = new JLabel("种类");
		nameLabel = new JLabel("名字");
		placeLabel = new JLabel("地点");
		codeLabel = new JLabel("编号");
		kind = new JComboBox<String>(kindString);
		name = new JTextField();
		place = new JTextField();
		code = new JTextField();
		saveButton = new JButton("保存");
		cancleButton = new JButton("取消");
		
		addPanel.add(kindLabel);
		addPanel.add(nameLabel);
		addPanel.add(placeLabel);
		addPanel.add(codeLabel);
		addPanel.add(kind);
		addPanel.add(name);
		addPanel.add(place);
		addPanel.add(code);
		addPanel.add(saveButton);
		addPanel.add(cancleButton);
		
		saveButton.addMouseListener(new MouseAdapter(){
			
		});
		
		kindLabel.setBounds(tabWidth/10, tabHeight/9, tabWidth/10, tabHeight/15);
		nameLabel.setBounds(kindLabel.getX(), kindLabel.getY()+kindLabel.getHeight()+tabHeight/9, kindLabel.getWidth(), kindLabel.getHeight());
		placeLabel.setBounds(kindLabel.getX(), nameLabel.getY()+nameLabel.getHeight()+tabHeight/9, kindLabel.getWidth(), kindLabel.getHeight());
		codeLabel.setBounds(kindLabel.getX(), placeLabel.getY()+placeLabel.getHeight()+tabHeight/9, kindLabel.getWidth(), kindLabel.getHeight());
		kind.setBounds(tabWidth/4, kindLabel.getY(), tabWidth*13/20, kindLabel.getHeight());
		name.setBounds(kind.getX(), nameLabel.getY(), kind.getWidth(), kind.getHeight());
		place.setBounds(kind.getX(), placeLabel.getY(), kind.getWidth(), kind.getHeight());
		code.setBounds(kind.getX(), codeLabel.getY(), kind.getWidth(), kind.getHeight());
		saveButton.setBounds(tabWidth*3/4, code.getY()+code.getHeight()+tabHeight/9, tabWidth/8, tabHeight/15);
		cancleButton.setBounds(tabWidth*11/20, saveButton.getY(), tabWidth/8, tabHeight/15);
	}
	public void initInquirePanel(){
		inquireString = new String[]{"1", "2", "3", "4", "5"};
		inquireText = new JTextField();
		inquireLabel = new JLabel("查询");
		inquireKind = new JLabel("种类");
		inquireName = new JLabel("名字");
		inquirePlace = new JLabel("地址");
		inquireCode = new JLabel("编号");
		kindBox = new JComboBox<String>(inquireString);
		nameText = new JTextField();
		placeText = new JTextField();
		codeText = new JTextField();
		inquireSave = new JButton("保存");
		inquireCancle = new JButton("取消");
		inquireButton = new JButton("查询");
		backButton = new JButton("返回");
		label = new JLabel();
		dataLabel = new JLabel();
		
		inquirePanel.add(label);
		inquirePanel.add(dataLabel);
		label.setBounds(0, 0, panelWidth, panelHeight);
		dataLabel.setBounds(0, 0, panelWidth, panelHeight);
		label.setVisible(true);
		dataLabel.setVisible(false);
	
		label.add(inquireText);
		label.add(inquireLabel);
		label.add(inquireButton);
		
		inquireLabel.setBounds(tabWidth/10-tabWidth/40,tabHeight*2/5,tabWidth/10, tabHeight/15);
		inquireText.setBounds(tabWidth*3/20, tabHeight*2/5, tabWidth*3/5, tabHeight/15);
		inquireButton.setBounds(tabWidth*4/5, tabHeight*2/5, tabWidth/8, tabHeight/15);
		inquireButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				dataLabel.setVisible(true);
				label.setVisible(false);
			}
		});
		
		dataLabel.add(inquireKind);
		dataLabel.add(inquireName);
		dataLabel.add(inquirePlace);
		dataLabel.add(inquireCode);
		dataLabel.add(kindBox);
		dataLabel.add(nameText);
		dataLabel.add(placeText);
		dataLabel.add(codeText);
		dataLabel.add(inquireSave);
		dataLabel.add(inquireCancle);
		dataLabel.add(backButton);
		
		inquireKind.setBounds(tabWidth/10, tabHeight/9, tabWidth/10, tabHeight/15);
		inquireName.setBounds(inquireKind.getX(), inquireKind.getY()+inquireKind.getHeight()+tabHeight/9, inquireKind.getWidth(), inquireKind.getHeight());
		inquirePlace.setBounds(inquireKind.getX(), inquireName.getY()+inquireName.getHeight()+tabHeight/9, inquireKind.getWidth(), inquireKind.getHeight());
		inquireCode.setBounds(inquireKind.getX(), inquirePlace.getY()+inquirePlace.getHeight()+tabHeight/9, inquireKind.getWidth(), inquireKind.getHeight());
		kindBox.setBounds(tabWidth/4, inquireKind.getY(), tabWidth*13/20, inquireKind.getHeight());
		nameText.setBounds(kindBox.getX(), inquireName.getY(), kindBox.getWidth(), kindBox.getHeight());
		placeText.setBounds(kindBox.getX(), inquirePlace.getY(), kindBox.getWidth(), kindBox.getHeight());
		codeText.setBounds(kindBox.getX(), inquireCode.getY(), kindBox.getWidth(), kindBox.getHeight());
		inquireSave.setBounds(tabWidth*3/4, codeText.getY()+codeText.getHeight()+tabHeight/9, tabWidth/8, tabHeight/15);
		inquireCancle.setBounds(tabWidth*11/20, inquireSave.getY(), tabWidth/8, tabHeight/15);
		backButton.setBounds(2*inquireCancle.getX()-inquireSave.getX(), inquireSave.getY(), tabWidth/8, tabHeight/15);
		
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				label.setVisible(true);
				dataLabel.setVisible(false);
			}
		});
	}
}
