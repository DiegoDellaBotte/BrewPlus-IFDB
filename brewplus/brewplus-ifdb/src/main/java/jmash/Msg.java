/*
 
 *
 *  This file is part of BrewPlus.
 *
 *  BrewPlus is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  BrewPlus is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with BrewPlus; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package jmash;

import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Alessandro
 */
public class Msg extends ModalInternalFrame {

	public static javax.swing.ImageIcon warnIcon = new javax.swing.ImageIcon(
			Msg.class.getResource("/jmash/images/messagebox_warning.png"));
	public static javax.swing.ImageIcon okIcon = new javax.swing.ImageIcon(
			Msg.class.getResource("/jmash/images/button_ok.png"));
	public static javax.swing.ImageIcon okEdit = new javax.swing.ImageIcon(
			Msg.class.getResource("/jmash/images/edit.png"));
	private static final long serialVersionUID = 7469706991053625358L;

	/** Creates new form Msg */
	public Msg() {
		initComponents();
		MutableAttributeSet standard = new SimpleAttributeSet();
		StyleConstants.setAlignment(standard, StyleConstants.ALIGN_CENTER);
	}

	public Msg(String msg) {
		this();
		setTextTxt(msg);
	}

	public Msg(String msg, Font font) {
		this(msg);
		setFontTxt(font);
	}

	public Msg(String msg, Font font, String title) {
		this(msg);
		if (font != null)
			setFontTxt(font);
		setTitleLabel(title);
	}

	public void setTextTxt(String msg) {
		txt2.setText(msg);
	}

	public void setFontTxt(Font font) {
		txt2.setFont(font);
	}

	public void setTitleLabel(String title) {
		jLabel3.setText(title);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {// GEN-BEGIN:initComponents
		jPanel1 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jButton2 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		txt2 = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		jPanel1.setLayout(new java.awt.BorderLayout());

		jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 11));
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("---");
		jLabel3.setMaximumSize(new java.awt.Dimension(110, 34));
		jLabel3.setMinimumSize(new java.awt.Dimension(110, 34));
		jLabel3.setPreferredSize(new java.awt.Dimension(110, 34));
		jPanel1.add(jLabel3, java.awt.BorderLayout.CENTER);

		jLabel1.setIcon(warnIcon);
		jPanel1.add(jLabel1, java.awt.BorderLayout.WEST);

		jLabel2.setIcon(warnIcon);
		jPanel1.add(jLabel2, java.awt.BorderLayout.EAST);

		getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

		jButton2.setIcon(okEdit);
		jButton2.setToolTipText("Copia nella clipboard");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jPanel2.add(jButton2);

		jButton1.setIcon(okIcon);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jPanel2.add(jButton1);

		getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

		txt2.setEditable(false);
		txt2.setFont(new java.awt.Font("Dialog", 1, 12));
		txt2.setLineWrap(true);
		txt2.setRows(1);
		txt2.setWrapStyleWord(true);
		txt2.setMargin(new java.awt.Insets(5, 5, 5, 5));
		jScrollPane1.setViewportView(txt2);

		getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 450) / 2, (screenSize.height - 259) / 2, 450, 259);
	}// GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		txt2.selectAll();
		txt2.copy();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		stopModal();
		dispose();
	}// GEN-LAST:event_jButton1ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	protected javax.swing.JLabel jLabel1;
	protected javax.swing.JLabel jLabel2;
	protected javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea txt2;
	// End of variables declaration//GEN-END:variables

	public static void showMsg(String str, JInternalFrame i) {
		Msg msg = Builder.getIstance().setText(str).build();
		Utils.center(msg, i);
		msg.startModal(i);
	}

	public static void showMsg(String str, String title) {
		Msg msg = Builder.getIstance().setText(str).setTitle(title).build();

		JInternalFrame i = new JInternalFrame();
		i.setLocation(Main.gui.getWidth() / 2 - msg.getWidth() / 2, Main.gui.getHeight() / 2 - msg.getHeight() / 2);
		Main.gui.getDesktop().add(i);
		i.setVisible(true);
		Utils.center(msg, i);
		msg.startModal(i);

		i.dispose();
	}

	public static class Builder {
		private Msg msg = new Msg();

		public static Builder getIstance() {
			return new Builder();
		}

		public Builder setText(String text) {
			msg.setTextTxt(text);
			return this;
		}

		public Builder setTitle(String title) {
			msg.setTitleLabel(title);
			return this;
		}

		public Builder setFont(Font font) {
			msg.setFontTxt(font);
			return this;
		}

		public Msg build() {
			return msg;
		}
	}
}
