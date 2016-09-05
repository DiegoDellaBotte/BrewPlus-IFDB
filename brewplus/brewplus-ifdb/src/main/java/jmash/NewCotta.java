
package jmash;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;

import jmash.imagecomponents.ImageFileView;
import jmash.imagecomponents.ImageFilter;
import jmash.imagecomponents.ImagePreview;

public class NewCotta extends javax.swing.JInternalFrame {

	private static Logger LOGGER = Logger.getLogger(NewCotta.class);

	String fotografia = "";
	protected Component entered = null;

	private Ricetta ricettaOriginale = new Ricetta();
	private Ricetta ricettaReale = new Ricetta();
	PanelFermentationLog logF;
	PanelMashLog mashLog;
	PanelDegustazione degu = new PanelDegustazione();
	PanelMashStep mashDesign;
	WaterNeededNew waterNeeded = new WaterNeededNew();
	private File file;

	/** Creates new form NewCotta */
	public NewCotta() {
		initComponents();
		LoadNote();
		mashDesign = new PanelMashStep(null, this);
		Component c = ricettaOriginale.getComponent(0);
		JPanel pnl = new JPanel();
		pnl.setLayout(new BorderLayout());
		pnl.add(c, java.awt.BorderLayout.CENTER);
		// pnl.add(jPanel1, java.awt.BorderLayout.WEST);
		tabPane.add(pnl, "Dati previsti da ricetta originale");
		setBorder(Utils.getDefaultBorder());
		((JRootPane) c).setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 100, 50), 3, true));
		ricettaOriginale.setEnabled(false);
		ricettaOriginale.setCotta(true);
		c = ricettaReale.getComponent(0);
		ricettaReale.setCotta(true);
		tabPane.add(c, "Dati registrati nella cotta");
		((JRootPane) c).setBorder(Utils.getDefaultBorder());
		// ricettaReale.hideMashDesign();
		mashLog = new PanelMashLog(ricettaReale, this);

		ricettaReale.mashDesign.setLinkedPanel(mashDesign);
		mashDesign.addPHAxis();
		mashDesign.setReadOnly();
		mashLog.setMainPanel(mashDesign);
		tabPane.add(mashLog, "Log del mash");
		tabPane.add(waterNeeded.getComponent(0), "Acqua usata");
		logF = new PanelFermentationLog(ricettaReale, this);
		tabPane.add(logF, "Log della fermentazione");

		tabPane.add(degu, "Scheda degustazione");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jToolBar1 = new javax.swing.JToolBar();
		jButton1 = new javax.swing.JButton();
		jButton1.setVisible(false);
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		tabPane = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		fldBrewer = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		fldNoteA = new javax.swing.JEditorPane();
		jLabel3 = new javax.swing.JLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		fldNoteB = new javax.swing.JEditorPane();
		jLabel4 = new javax.swing.JLabel();
		fldDate = new com.toedter.calendar.JDateChooser();
		lblPicBeerCotta = new javax.swing.JLabel();

		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Registrazione di una cotta");
		setFont(getFont());
		getContentPane().setLayout(new java.awt.GridBagLayout());

		jToolBar1.setFloatable(false);
		jToolBar1.setRollover(true);

		jButton1.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/new.png"))); // NOI18N
		jButton1.setToolTipText("Nuova cotta");
		jButton1.setFocusable(false);
		jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton1);

		jButton2.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/open.png"))); // NOI18N
		jButton2.setToolTipText("Apri cotta");
		jButton2.setFocusable(false);
		jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton2);

		jButton3.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/save.png"))); // NOI18N
		jButton3.setToolTipText("Salva cotta");
		jButton3.setFocusable(false);
		jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton3);

		jButton4.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/saveas.png"))); // NOI18N
		jButton4.setToolTipText("Salva come...");
		jButton4.setFocusable(false);
		jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton4);

		jButton5.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/filefind.png"))); // NOI18N
		jButton5.setToolTipText("Importa ricetta di partenza");
		jButton5.setFocusable(false);
		jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton5);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
		gridBagConstraints.weightx = 0.1;
		getContentPane().add(jToolBar1, gridBagConstraints);

		jButtonNotes = new JButton();
		jButtonNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModelliNote f = new frmModelliNote();
				Main.gui.addFrame(f);
				Dimension desktopSize = Main.gui.desktopPane.getSize();
				Dimension jInternalFrameSize = f.getSize();
				f.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
						(desktopSize.height - jInternalFrameSize.height) / 2);

			}
		});
		jButtonNotes.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/inventario.png")));
		jButtonNotes.setVerticalTextPosition(SwingConstants.BOTTOM);
		jButtonNotes.setToolTipText("Modelli Note Cotta e Fermentazione");
		jButtonNotes.setHorizontalTextPosition(SwingConstants.CENTER);
		jButtonNotes.setFocusable(false);
		jToolBar1.add(jButtonNotes);

		jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jPanel2.setLayout(new java.awt.GridBagLayout());

		jLabel1.setFont(jLabel1.getFont());
		jLabel1.setText("Birrai");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new Insets(0, 5, 5, 5);
		jPanel2.add(jLabel1, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(0, 5, 5, 5);
		jPanel2.add(fldBrewer, gridBagConstraints);

		jLabel2.setText("Note cotta");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new Insets(0, 5, 5, 5);
		jPanel2.add(jLabel2, gridBagConstraints);

		jScrollPane3.setPreferredSize(new java.awt.Dimension(550, 120));
		jScrollPane3.setViewportView(fldNoteA);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 0.1;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new Insets(0, 5, 5, 5);
		jPanel2.add(jScrollPane3, gridBagConstraints);

		jLabel3.setText("Note fermentazione");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new Insets(0, 5, 5, 5);
		jPanel2.add(jLabel3, gridBagConstraints);

		jScrollPane4.setPreferredSize(new java.awt.Dimension(550, 120));
		jScrollPane4.setViewportView(fldNoteB);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 0.1;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new Insets(0, 5, 5, 5);
		jPanel2.add(jScrollPane4, gridBagConstraints);

		jLabel4.setText("Data della cotta");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new Insets(0, 5, 5, 5);
		jPanel2.add(jLabel4, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 0.1;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new Insets(0, 5, 5, 5);
		jPanel2.add(fldDate, gridBagConstraints);

		lblPicBeerCotta.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/kettles.png")));
		gbc_lblPicBeerCotta = new java.awt.GridBagConstraints();
		gbc_lblPicBeerCotta.gridx = 2;
		gbc_lblPicBeerCotta.gridy = 0;
		gbc_lblPicBeerCotta.gridheight = 21;
		gbc_lblPicBeerCotta.fill = GridBagConstraints.VERTICAL;
		gbc_lblPicBeerCotta.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPicBeerCotta.weightx = 0.1;
		gbc_lblPicBeerCotta.weighty = 0.1;
		gbc_lblPicBeerCotta.insets = new Insets(0, 5, 5, 0);
		jPanel2.add(lblPicBeerCotta, gbc_lblPicBeerCotta);
		lblPicBeerCotta.setToolTipText("<html>Clic sinistro: inserisci<br>Clic destro: elimina");
		lblPicBeerCotta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1)
					addPhotoFromFile();
				if (e.getButton() == MouseEvent.BUTTON3)
					deletePhoto();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (!(e.getSource() instanceof Component))
					return;
				exit();
				enter((Component) e.getSource());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exit();
			}
		});
		// lblPicBeerCotta.setIcon(new
		// ImageIcon(Utils.getImageFromBase64(this.fotografiaBase64)));

		tabPane.addTab("Dati generali", jPanel2);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
		gridBagConstraints.weightx = 0.1;
		gridBagConstraints.weighty = 1.0;
		getContentPane().add(tabPane, gridBagConstraints);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		read();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		clear();
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		save();
	}// GEN-LAST:event_jButton3ActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		saveAs();
	}// GEN-LAST:event_jButton4ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		File file1 = Utils.pickFileToLoad(new JInternalFrame(),
				(String) Main.getFromCache("recipe.dir", Main.recipeDir));
		if (file1 != null) {
			ricettaOriginale.read(file1);
			if (Ask.doAsk(this, "Si vuole usare questa ricetta come base per la cotta reale?")) {
				ricettaReale.read(file1);
			}
		}
	}// GEN-LAST:event_jButton5ActionPerformed

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
		GetRicettaFromHobbybirra frame = new GetRicettaFromHobbybirra();
		frame.startModal(this);
		Document doc = frame.getRicettaSelezionata();

		ricettaOriginale.read(doc);
		if (Ask.doAsk(this, "Si vuole usare questa ricetta come base per la cotta reale?")) {
			ricettaReale.read(doc);
		}
	}// GEN-LAST:event_jButton6ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField fldBrewer;
	private com.toedter.calendar.JDateChooser fldDate;
	private javax.swing.JEditorPane fldNoteA;
	private javax.swing.JEditorPane fldNoteB;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel lblPicBeerCotta;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JToolBar jToolBar1;
	private javax.swing.JTabbedPane tabPane;
	private GridBagConstraints gbc_lblPicBeerCotta;
	private JButton jButtonNotes;
	// End of variables declaration//GEN-END:variables

	public Document toXml() {
		Element RO = ricettaOriginale.toRecipeData().getXmlRoot();
		Element RR = ricettaReale.toRecipeData().getXmlRoot();
		RO.setAttribute("tipo", "prevista");
		RR.setAttribute("tipo", "reale");
		Document doc = new Document();
		Element root = new Element("cotta");
		root.setAttribute("brewer", fldBrewer.getText());
		if (fldDate.getDate() != null)
			root.setAttribute("date", new SimpleDateFormat("dd/MM/yyyy").format(fldDate.getDate()));
		root.setAttribute("noteA", fldNoteA.getText());
		root.setAttribute("noteB", fldNoteB.getText());
		// immagine
		root.setAttribute("immagine", fotografia);
		root.addContent(RO);
		root.addContent(RR);
		root.addContent(logF.toXml());
		root.addContent(mashLog.toXml());
		root.addContent(degu.toXml());
		root.addContent(waterNeeded.toXml());
		doc.setRootElement(root);
		return doc;
	}

	public void save() {
		if (this.file == null) {
			this.file = Utils.pickFileToSave(this, (String) Main.getFromCache("batch.dir", Main.batchDir));
		}
		if (this.file == null)
			return;
		Utils.saveXmlAsFile(toXml(), this.file, this);
		Main.putIntoCache("batch.dir", file.getAbsolutePath());
		setTitle(this.file.getName());
	}

	public void saveAs() {
		File file1 = Utils.pickFileToSave(this, (String) Main.getFromCache("batch.dir", Main.batchDir));
		if (file1 == null)
			return;
		Utils.saveXmlAsFile(toXml(), file1, this);
		this.file = file1;
		Main.putIntoCache("batch.dir", file.getAbsolutePath());
		setTitle(this.file.getName());
	}

	public void read() {
		File file1 = Utils.pickFileToLoad(new JInternalFrame(), (String) Main.getFromCache("batch.dir", Main.batchDir));

		if (file1 != null) {
			this.file = file1;
			setTitle(this.file.getName());
			Document doc = Utils.readFileAsXml(this.file.toString());
			Element root = doc.getRootElement();
			if (root.getName().compareToIgnoreCase("cotta") == 0) {
				fldBrewer.setText(root.getAttribute("brewer").getValue());
				if (root.getAttribute("date") != null) {
					try {
						fldDate.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(root.getAttribute("date").getValue()));
					} catch (ParseException ex) {
						LOGGER.error(ex.getMessage(), ex);
					}
				}
				fldNoteA.setText(root.getAttribute("noteA").getValue());
				fldNoteB.setText(root.getAttribute("noteB").getValue());
				logF.svuota();
				mashLog.svuota();
				try {
					if (root.getAttribute("immagine").getValue() == null
							|| root.getAttribute("immagine").getValue().trim() == "") {
						fotografia = "";
						lblPicBeerCotta.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/kettles.png")));
					} else {
						fotografia = root.getAttribute("immagine").getValue();
						lblPicBeerCotta.setIcon(new ImageIcon(Utils.getImageFromBase64(fotografia)));
					}
				} catch (Exception ex) {
					fotografia = "";
					lblPicBeerCotta.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/kettles.png")));
				}
				Iterator iterator = root.getChildren().iterator();
				while (iterator.hasNext()) {
					Element elem = (Element) iterator.next();
					if (elem.getName().compareToIgnoreCase(XmlTags.RECIPE) == 0) {
						String tipo = elem.getAttribute("tipo").getValue();
						RecipeData data = new RecipeData();
						data.read(elem);
						if (tipo.equalsIgnoreCase("prevista"))
							ricettaOriginale.fromRecipeData(data);
						if (tipo.equalsIgnoreCase("reale"))
							ricettaReale.fromRecipeData(data);
					} else if (elem.getName().compareToIgnoreCase("fermentazione") == 0) {
						Iterator it = elem.getChildren().iterator();
						while (it.hasNext()) {
							Element L = (Element) it.next();
							SGLog e = SGLog.fromXml(L);
							logF.add(e);
						}
					} else if (elem.getName().compareToIgnoreCase("mashLog") == 0) {
						Iterator it = elem.getChildren().iterator();
						while (it.hasNext()) {
							Element L = (Element) it.next();
							TLog e = TLog.fromXml(L);
							mashLog.add(e);
						}
					} else if (elem.getName().compareToIgnoreCase("degu") == 0) {
						degu.fromXml(elem);
					} else if (elem.getName().compareToIgnoreCase("water") == 0) {
						waterNeeded.fromXml(elem);
					}
				}
				logF.logModificato();
				mashLog.logModificato();
				degu.calc();
				ricettaReale.ricettaModificata();
				ricettaReale.mashDesign.mashModificato();
				ricettaOriginale.ricettaModificata();
				ricettaOriginale.mashDesign.mashModificato();
			}
		}
	}

	public void clear() {

		fldBrewer.setText("");
		fldDate.setDate(null);
		fldNoteA.setText("");
		fldNoteB.setText("");
		this.fotografia = "";
		lblPicBeerCotta.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/kettles.png")));

	}

	private void addPhotoFromFile() {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new ImageFilter());
		fc.setAcceptAllFileFilterUsed(false);
		fc.setFileView(new ImageFileView());
		fc.setAccessory(new ImagePreview(fc));
		int returnVal = fc.showDialog(this, "Apri");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			ImageIcon tmpIcon = new ImageIcon(file.getPath());
			if (tmpIcon.getIconWidth() < 1)
				return; // prende i files errati
			if (tmpIcon != null) {
				ImageIcon thumbnail;
				if (tmpIcon.getIconWidth() > 300) {
					thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
				} else {
					thumbnail = tmpIcon;
				}
				lblPicBeerCotta.setIcon(thumbnail);
				Image img = thumbnail.getImage();
				BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null),
						BufferedImage.TYPE_INT_RGB);
				Graphics2D g2 = bi.createGraphics();
				g2.setComposite(AlphaComposite.Src);
				g2.drawImage(img, 0, 0, null);
				g2.dispose();
				try {
					ImageIO.write(bi, "jpg", new File("pics/tmpthum.tmp"));
					String b64 = Utils.getBase64FromImageFile("pics/tmpthum.tmp");
					this.fotografia = b64;
				} catch (Exception ex) {
				}
			}
		}
		fc.setSelectedFile(null);
	}

	private void deletePhoto() {
		this.fotografia = "";
		lblPicBeerCotta.setIcon(new ImageIcon(NewCotta.class.getResource("/jmash/images/kettles.png")));
	}

	private void enter(Component c) {
		// change cursor appearance to HAND_CURSOR when the mouse pointed on
		// images
		Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		setCursor(cursor);
		entered = c;
	}

	private void LoadNote() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("config/NoteA.note"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			fldNoteA.setText(sb.toString());
			br.close();
		} catch (Exception ex) {
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader("config/NoteB.note"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			fldNoteB.setText(sb.toString());
			br.close();
		} catch (Exception ex) {
		}

	}

	private void exit() {
		Cursor cursor = Cursor.getDefaultCursor();
		setCursor(cursor);
		if (entered != null) {
			entered = null;
		}
	}

}