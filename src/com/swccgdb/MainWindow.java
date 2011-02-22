package com.swccgdb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainWindow
{

    private JFrame	     frmswipStarWars;
    private final ButtonGroup  buttonGroup = new ButtonGroup();
    private JTextField	 textFieldInventory;
    private JTextField	 textField;
    private JTextField	 textFieldNickname;
    private JTextField	 textFieldCounterpart;

    private DatabaseController dbc;
    private JList	      listCardList;
    private CardListModel      cardListModel;
    private JLabel	     lblNumCards;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    MainWindow window = new MainWindow();
		    window.frmswipStarWars.setVisible(true);
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public MainWindow()
    {
	dbc = new DatabaseController();
	cardListModel = new CardListModel(dbc);
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frmswipStarWars = new JFrame();
	frmswipStarWars.setResizable(false);
	frmswipStarWars
		.setTitle("[sw-ip] Star Wars: CCG Information Pool - Java\n");
	frmswipStarWars.setBounds(100, 100, 1016, 732);
	frmswipStarWars.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JMenuBar menuBar = new JMenuBar();
	frmswipStarWars.setJMenuBar(menuBar);

	JMenu mnFile = new JMenu("File");
	menuBar.add(mnFile);

	JMenuItem mntmExitswip = new JMenuItem("Exit [sw-ip]");
	mntmExitswip.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		System.exit(0);
	    }
	});
	mnFile.add(mntmExitswip);

	JMenu mnTools = new JMenu("Tools");
	menuBar.add(mnTools);

	JMenuItem mntmOptions = new JMenuItem("Options");
	mnTools.add(mntmOptions);

	JMenu mnHelp = new JMenu("Help");
	menuBar.add(mnHelp);

	JMenuItem mntmHelp = new JMenuItem("Help");
	mnHelp.add(mntmHelp);

	JMenuItem mntmInfo = new JMenuItem("Info");
	mnHelp.add(mntmInfo);
	frmswipStarWars.getContentPane().setLayout(null);

	lblNumCards = new JLabel("0 Cards");
	lblNumCards.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNumCards.setBounds(251, 6, 91, 16);
	frmswipStarWars.getContentPane().add(lblNumCards);

	JPanel panelCardDetails = new JPanel();
	panelCardDetails.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
		null, null, null));
	panelCardDetails.setBounds(354, 28, 237, 276);
	frmswipStarWars.getContentPane().add(panelCardDetails);
	panelCardDetails.setLayout(new BorderLayout(0, 0));

	JPanel panelFilter = new JPanel();
	panelFilter.setBorder(new TitledBorder(null, "Filter",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelFilter.setBounds(603, 28, 260, 203);
	frmswipStarWars.getContentPane().add(panelFilter);
	panelFilter.setLayout(null);

	JRadioButton rdbtnDarkSide = new JRadioButton("Dark Side");
	buttonGroup.add(rdbtnDarkSide);
	rdbtnDarkSide.setBounds(154, 17, 100, 23);
	panelFilter.add(rdbtnDarkSide);

	JRadioButton rdbtnLightside = new JRadioButton("Light Side");
	buttonGroup.add(rdbtnLightside);
	rdbtnLightside.setBounds(154, 43, 100, 23);
	panelFilter.add(rdbtnLightside);

	JButton btnFilter = new JButton("Filter");
	btnFilter.setBounds(154, 69, 100, 29);
	panelFilter.add(btnFilter);

	JComboBox comboBoxFilter1 = new JComboBox();
	comboBoxFilter1.setBounds(6, 16, 136, 27);
	panelFilter.add(comboBoxFilter1);

	JComboBox comboBoxFilter2 = new JComboBox();
	comboBoxFilter2.setBounds(6, 42, 136, 27);
	panelFilter.add(comboBoxFilter2);

	JComboBox comboBoxFilter3 = new JComboBox();
	comboBoxFilter3.setBounds(6, 69, 136, 27);
	panelFilter.add(comboBoxFilter3);

	JPanel panel_8 = new JPanel();
	panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
		null, null));
	panel_8.setBounds(6, 102, 136, 91);
	panelFilter.add(panel_8);
	panel_8.setLayout(new BorderLayout(0, 0));

	JList listFilterList = new JList();
	panel_8.add(listFilterList, BorderLayout.CENTER);

	JButton btnRemove = new JButton("Remove");
	btnRemove.setEnabled(false);
	btnRemove.setBounds(154, 132, 100, 29);
	panelFilter.add(btnRemove);

	JButton btnClearFilter = new JButton("Clear Filter");
	btnClearFilter.setBounds(154, 164, 100, 29);
	panelFilter.add(btnClearFilter);

	JPanel panelInventory = new JPanel();
	panelInventory.setBorder(new TitledBorder(null, "Cards",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelInventory.setBounds(875, 28, 87, 134);
	frmswipStarWars.getContentPane().add(panelInventory);
	panelInventory.setLayout(null);

	textFieldInventory = new JTextField();
	textFieldInventory.setText("0");
	textFieldInventory.setBounds(6, 34, 34, 28);
	panelInventory.add(textFieldInventory);
	textFieldInventory.setColumns(10);

	JLabel lblInventory = new JLabel("Inventory");
	lblInventory.setBounds(6, 17, 59, 16);
	panelInventory.add(lblInventory);

	JLabel lblNeeds = new JLabel("Needs");
	lblNeeds.setBounds(6, 63, 61, 16);
	panelInventory.add(lblNeeds);

	textField = new JTextField();
	textField.setText("0");
	textField.setBounds(6, 83, 34, 28);
	panelInventory.add(textField);
	textField.setColumns(10);

	JPanel panelViewInfo = new JPanel();
	panelViewInfo.setBorder(new TitledBorder(null, "View Information",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelViewInfo.setBounds(603, 243, 133, 61);
	frmswipStarWars.getContentPane().add(panelViewInfo);
	panelViewInfo.setLayout(new BorderLayout(0, 0));

	JCheckBox chckbxChangeView = new JCheckBox("Change View");
	chckbxChangeView.setEnabled(false);
	chckbxChangeView.setSelected(true);
	panelViewInfo.add(chckbxChangeView);

	JPanel panelExpRarity = new JPanel();
	panelExpRarity.setBorder(new TitledBorder(null, "Expansion and Rarity",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelExpRarity.setBounds(10, 320, 229, 44);
	frmswipStarWars.getContentPane().add(panelExpRarity);
	panelExpRarity.setLayout(new BorderLayout(0, 0));

	JLabel lblExpansion = new JLabel("Expansion");
	panelExpRarity.add(lblExpansion);

	JLabel lblRarity = new JLabel("Rarity");
	panelExpRarity.add(lblRarity, BorderLayout.EAST);

	JPanel panelCardHelp = new JPanel();
	panelCardHelp.setBorder(new TitledBorder(null, "Card Help",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelCardHelp.setBounds(10, 376, 229, 103);
	frmswipStarWars.getContentPane().add(panelCardHelp);
	panelCardHelp.setLayout(null);

	JLabel lblNickname = new JLabel("Abbreviation / Nickname");
	lblNickname.setBounds(65, 16, 158, 16);
	panelCardHelp.add(lblNickname);

	textFieldNickname = new JTextField();
	textFieldNickname.setBackground(UIManager.getColor("control"));
	textFieldNickname.setEditable(false);
	textFieldNickname.setBounds(6, 32, 217, 22);
	panelCardHelp.add(textFieldNickname);
	textFieldNickname.setColumns(10);

	JLabel lblCounterpart = new JLabel("Counterpart");
	lblCounterpart.setBounds(148, 57, 75, 16);
	panelCardHelp.add(lblCounterpart);

	textFieldCounterpart = new JTextField();
	textFieldCounterpart.setEditable(false);
	textFieldCounterpart.setBounds(6, 74, 217, 22);
	panelCardHelp.add(textFieldCounterpart);
	textFieldCounterpart.setColumns(10);

	JPanel panelPulling = new JPanel();
	panelPulling.setBorder(new TitledBorder(null, "Pulling",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelPulling.setBounds(10, 491, 229, 158);
	frmswipStarWars.getContentPane().add(panelPulling);
	panelPulling.setLayout(null);

	JLabel lblNewLabel = new JLabel("Pulls");
	lblNewLabel.setBounds(188, 19, 35, 16);
	panelPulling.add(lblNewLabel);

	final JTextArea txtrPulls = new JTextArea();
	txtrPulls.setBackground(UIManager.getColor("control"));
	txtrPulls.setWrapStyleWord(true);
	txtrPulls.setEditable(false);
	txtrPulls.setLineWrap(true);
	txtrPulls.setBounds(6, 36, 217, 44);
	panelPulling.add(txtrPulls);

	JLabel lblPulledBy = new JLabel("Is pulled by");
	lblPulledBy.setBounds(150, 92, 73, 16);
	panelPulling.add(lblPulledBy);

	final JTextArea txtrPulledBy = new JTextArea();
	txtrPulledBy.setBackground(UIManager.getColor("control"));
	txtrPulledBy.setWrapStyleWord(true);
	txtrPulledBy.setEditable(false);
	txtrPulledBy.setLineWrap(true);
	txtrPulledBy.setBounds(6, 108, 217, 44);
	panelPulling.add(txtrPulledBy);

	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new TitledBorder(null, "Information",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel_1.setBounds(251, 316, 242, 270);
	frmswipStarWars.getContentPane().add(panel_1);
	panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

	final JTextPane txtpnCardinfo = new JTextPane();
	txtpnCardinfo.setBackground(UIManager.getColor("control"));
	txtpnCardinfo.setEditable(false);
	panel_1.add(txtpnCardinfo);

	JPanel panel_2 = new JPanel();
	panel_2.setBorder(new TitledBorder(null, "Characteristics",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel_2.setBounds(251, 590, 242, 59);
	frmswipStarWars.getContentPane().add(panel_2);
	panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

	final JTextArea txtrCharacteristics = new JTextArea();
	txtrCharacteristics.setEditable(false);
	txtrCharacteristics.setBackground(UIManager.getColor("control"));
	txtrCharacteristics.setWrapStyleWord(true);
	txtrCharacteristics.setLineWrap(true);
	panel_2.add(txtrCharacteristics);

	JPanel panel_3 = new JPanel();
	panel_3.setBorder(new TitledBorder(null, "Combo", TitledBorder.LEADING,
		TitledBorder.TOP, null, null));
	panel_3.setBounds(505, 316, 242, 158);
	frmswipStarWars.getContentPane().add(panel_3);
	panel_3.setLayout(new BorderLayout(0, 0));

	final JTextArea txtrCombo = new JTextArea();
	txtrCombo.setBackground(UIManager.getColor("control"));
	txtrCombo.setWrapStyleWord(true);
	txtrCombo.setEditable(false);
	panel_3.add(txtrCombo, BorderLayout.CENTER);

	JPanel panel_4 = new JPanel();
	panel_4.setBorder(new TitledBorder(null, "Rules", TitledBorder.LEADING,
		TitledBorder.TOP, null, null));
	panel_4.setBounds(505, 491, 242, 158);
	frmswipStarWars.getContentPane().add(panel_4);
	panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

	final JTextArea txtrRules = new JTextArea();
	txtrRules.setBackground(UIManager.getColor("control"));
	txtrRules.setWrapStyleWord(true);
	txtrRules.setEditable(false);
	panel_4.add(txtrRules);

	JPanel panel_5 = new JPanel();
	panel_5.setBorder(new TitledBorder(null, "Canceling",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel_5.setLayout(null);
	panel_5.setBounds(759, 316, 229, 158);
	frmswipStarWars.getContentPane().add(panel_5);

	JLabel lblCancels = new JLabel("Cancels");
	lblCancels.setBounds(166, 16, 57, 16);
	panel_5.add(lblCancels);

	final JTextArea txtrCancels = new JTextArea();
	txtrCancels.setBackground(UIManager.getColor("control"));
	txtrCancels.setWrapStyleWord(true);
	txtrCancels.setEditable(false);
	txtrCancels.setLineWrap(true);
	txtrCancels.setBounds(6, 36, 217, 44);
	panel_5.add(txtrCancels);

	JLabel lblIsCanceledBy = new JLabel("Is canceled by");
	lblIsCanceledBy.setBounds(134, 92, 89, 16);
	panel_5.add(lblIsCanceledBy);

	final JTextArea txtrCanceledBy = new JTextArea();
	txtrCanceledBy.setBackground(UIManager.getColor("control"));
	txtrCanceledBy.setWrapStyleWord(true);
	txtrCanceledBy.setEditable(false);
	txtrCanceledBy.setLineWrap(true);
	txtrCanceledBy.setBounds(6, 108, 217, 44);
	panel_5.add(txtrCanceledBy);

	JPanel panel_6 = new JPanel();
	panel_6.setBorder(new TitledBorder(null, "Matching",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel_6.setLayout(null);
	panel_6.setBounds(759, 491, 229, 158);
	frmswipStarWars.getContentPane().add(panel_6);

	JLabel lblMatchingStarship = new JLabel("Matching Starship");
	lblMatchingStarship.setBounds(110, 16, 113, 16);
	panel_6.add(lblMatchingStarship);

	final JTextArea txtrMStarship = new JTextArea();
	txtrMStarship.setBackground(UIManager.getColor("control"));
	txtrMStarship.setWrapStyleWord(true);
	txtrMStarship.setEditable(false);
	txtrMStarship.setLineWrap(true);
	txtrMStarship.setBounds(6, 36, 217, 44);
	panel_6.add(txtrMStarship);

	JLabel lblMatchingWeapon = new JLabel("Matching Weapon");
	lblMatchingWeapon.setBounds(110, 92, 113, 16);
	panel_6.add(lblMatchingWeapon);

	final JTextArea txtrMWeapon = new JTextArea();
	txtrMWeapon.setBackground(UIManager.getColor("control"));
	txtrMWeapon.setWrapStyleWord(true);
	txtrMWeapon.setEditable(false);
	txtrMWeapon.setLineWrap(true);
	txtrMWeapon.setBounds(6, 108, 217, 44);
	panel_6.add(txtrMWeapon);

	JPanel panel_7 = new JPanel();
	panel_7.setBorder(new TitledBorder(null, "Edit Fields",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel_7.setBounds(748, 243, 141, 61);
	frmswipStarWars.getContentPane().add(panel_7);
	panel_7.setLayout(new BorderLayout(0, 0));

	final JButton btnAddCard = new JButton("+");
	btnAddCard.setVisible(false);
	btnAddCard.setBounds(23, 4, 41, 21);
	frmswipStarWars.getContentPane().add(btnAddCard);

	final JButton btnRemoveCard = new JButton("-");
	btnRemoveCard.setVisible(false);
	btnRemoveCard.setBounds(76, 4, 41, 21);
	frmswipStarWars.getContentPane().add(btnRemoveCard);

	final JCheckBox chckbxFieldsEditable = new JCheckBox("Fields Editable");
	chckbxFieldsEditable.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		boolean editable = chckbxFieldsEditable.isSelected();

		if (editable)
		{
		    int ans = JOptionPane
			    .showConfirmDialog(
				    frmswipStarWars,
				    "This will edit the card information in your datablase,\nAre you sure you want to continue?",
				    "Make fields editable?",
				    JOptionPane.OK_CANCEL_OPTION,
				    JOptionPane.WARNING_MESSAGE);
		    if (ans != 0)
		    {
			chckbxFieldsEditable.setSelected(false);
			return;
		    }
		}

		textFieldNickname.setEditable(editable);
		if (editable)
		    textFieldNickname.setBackground(Color.RED);
		else
		    textFieldNickname.setBackground(Color.WHITE);

		textFieldCounterpart.setEditable(editable);
		if (editable)
		    textFieldCounterpart.setBackground(Color.RED);
		else
		    textFieldCounterpart.setBackground(Color.WHITE);

		txtrPulls.setEditable(editable);
		if (editable)
		    txtrPulls.setBackground(Color.RED);
		else
		    txtrPulls.setBackground(UIManager.getColor("control"));

		txtrPulledBy.setEditable(editable);
		if (editable)
		    txtrPulledBy.setBackground(Color.RED);
		else
		    txtrPulledBy.setBackground(UIManager.getColor("control"));

		txtpnCardinfo.setEditable(editable);
		if (editable)
		    txtpnCardinfo.setBackground(Color.RED);
		else
		    txtpnCardinfo.setBackground(UIManager.getColor("control"));

		txtrCombo.setEditable(editable);
		if (editable)
		    txtrCombo.setBackground(Color.RED);
		else
		    txtrCombo.setBackground(UIManager.getColor("control"));

		txtrRules.setEditable(editable);
		if (editable)
		    txtrRules.setBackground(Color.RED);
		else
		    txtrRules.setBackground(UIManager.getColor("control"));

		txtrCancels.setEditable(editable);
		if (editable)
		    txtrCancels.setBackground(Color.RED);
		else
		    txtrCancels.setBackground(UIManager.getColor("control"));

		txtrCanceledBy.setEditable(editable);
		if (editable)
		    txtrCanceledBy.setBackground(Color.RED);
		else
		    txtrCanceledBy.setBackground(UIManager.getColor("control"));

		txtrMStarship.setEditable(editable);
		if (editable)
		    txtrMStarship.setBackground(Color.RED);
		else
		    txtrMStarship.setBackground(UIManager.getColor("control"));

		txtrMWeapon.setEditable(editable);
		if (editable)
		    txtrMWeapon.setBackground(Color.RED);
		else
		    txtrMWeapon.setBackground(UIManager.getColor("control"));

		txtrCharacteristics.setEditable(editable);
		if (editable)
		    txtrCharacteristics.setBackground(Color.RED);
		else
		    txtrCharacteristics.setBackground(UIManager
			    .getColor("control"));

		btnAddCard.setVisible(editable);
		btnRemoveCard.setVisible(editable);
	    }
	});
	panel_7.add(chckbxFieldsEditable, BorderLayout.CENTER);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 28, 332, 276);
	frmswipStarWars.getContentPane().add(scrollPane);

	listCardList = new JList();
	listCardList.addListSelectionListener(new ListSelectionListener()
	{
	    public void valueChanged(ListSelectionEvent arg0)
	    {
		//String name = cardListModel.getCardName(listCardList.getSelectedIndex());
	    }
	});
	scrollPane.setViewportView(listCardList);
	listCardList.setVisibleRowCount(14);
	listCardList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	listCardList.setModel(cardListModel);
	this.lblNumCards.setText(cardListModel.getSize() + " Cards");
    }
}

@SuppressWarnings("serial")
class CardListModel extends AbstractListModel
{
    List<String>       values = new ArrayList<String>();
    DatabaseController dbc;

    CardListModel(DatabaseController dbc)
    {
	this.dbc = dbc;
	updateModel("");
    }

    @Override
    public Object getElementAt(int index)
    {
	return values.get(index);
    }
    
    public String getCardName(int index)
    {
	return values.get(index);
    }

    @Override
    public int getSize()
    {
	return values.size();
    }

    public int updateModel(String keyterm)
    {
	values.clear();
	values = dbc.getCardNames(keyterm);
	return getSize();
    }
}