/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CharacterApi.ICharacter;
import CharacterApi.IWeapon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriel
 */
public class GameFrame extends javax.swing.JFrame {

    private Controller controller;
    
    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
    }

    public GameFrame(Controller controller) {
        initComponents();
        this.controller = controller;
        try {
            initCharacters();
        } catch (IOException ex) {
            Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        setUserName();
        setRivalName();
    }
    
    public GameFrame getInstance() {
        return this;
    }

    private void initCharacters() throws IOException {
        List<String> paths = controller.getImgList();
        BufferedImage buffImg1 = ImageIO.read(new File( paths.get(0) ));
        ImageIcon icon1 = new ImageIcon( buffImg1 );
        Image image1 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        img1.setIcon(new ImageIcon(image1));
        
        BufferedImage buffImg2 = ImageIO.read(new File( paths.get(1) ));
        ImageIcon icon2 = new ImageIcon( buffImg2 );
        Image image2 = icon2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        img2.setIcon(new ImageIcon(image2));
        
        BufferedImage buffImg3 = ImageIO.read(new File( paths.get(2) ));
        ImageIcon icon3 = new ImageIcon( buffImg3 );
        Image image3 = icon3.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        img3.setIcon(new ImageIcon(image3));
        
        BufferedImage buffImg4 = ImageIO.read(new File( paths.get(3) ));
        ImageIcon icon4 = new ImageIcon( buffImg4 );
        Image image4 = icon4.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        img4.setIcon(new ImageIcon(image4));
    }
    
    private void showCharacter1Stats() {
        ICharacter charact = controller.getCharacter1();
        nombreLabel.setText(charact.getName());
        hpLabel.setText(Double.toString(charact.getHp()));
        tipoLabel.setText(charact.getType());
        ArrayList<IWeapon> weapons = (ArrayList<IWeapon>) charact.getWeapons();
        arma1.setText(weapons.get(0).getName());
        arma2.setText(weapons.get(1).getName());
        arma3.setText(weapons.get(2).getName());
        arma4.setText(weapons.get(3).getName());
        arma5.setText(weapons.get(4).getName());
        armaArray1.setText(controller.weaponsToString(weapons.get(0).getMultipliers()));
        armaArray2.setText(controller.weaponsToString(weapons.get(1).getMultipliers()));
        armaArray3.setText(controller.weaponsToString(weapons.get(2).getMultipliers()));
        armaArray4.setText(controller.weaponsToString(weapons.get(3).getMultipliers()));
        armaArray5.setText(controller.weaponsToString(weapons.get(4).getMultipliers()));
    }
    
    private void showCharacter2Stats() {
        ICharacter charact = controller.getCharacter2();
        nombreLabel.setText(charact.getName());
        hpLabel.setText(Double.toString(charact.getHp()));
        tipoLabel.setText(charact.getType());
        ArrayList<IWeapon> weapons = (ArrayList<IWeapon>) charact.getWeapons();
        arma1.setText(weapons.get(0).getName());
        arma2.setText(weapons.get(1).getName());
        arma3.setText(weapons.get(2).getName());
        arma4.setText(weapons.get(3).getName());
        arma5.setText(weapons.get(4).getName());
        armaArray1.setText(controller.weaponsToString(weapons.get(0).getMultipliers()));
        armaArray2.setText(controller.weaponsToString(weapons.get(1).getMultipliers()));
        armaArray3.setText(controller.weaponsToString(weapons.get(2).getMultipliers()));
        armaArray4.setText(controller.weaponsToString(weapons.get(3).getMultipliers()));
        armaArray5.setText(controller.weaponsToString(weapons.get(4).getMultipliers()));
    }
    
    private void showCharacter3Stats() {
        ICharacter charact = controller.getCharacter3();
        nombreLabel.setText(charact.getName());
        hpLabel.setText(Double.toString(charact.getHp()));
        tipoLabel.setText(charact.getType());
        ArrayList<IWeapon> weapons = (ArrayList<IWeapon>) charact.getWeapons();
        arma1.setText(weapons.get(0).getName());
        arma2.setText(weapons.get(1).getName());
        arma3.setText(weapons.get(2).getName());
        arma4.setText(weapons.get(3).getName());
        arma5.setText(weapons.get(4).getName());
        armaArray1.setText(controller.weaponsToString(weapons.get(0).getMultipliers()));
        armaArray2.setText(controller.weaponsToString(weapons.get(1).getMultipliers()));
        armaArray3.setText(controller.weaponsToString(weapons.get(2).getMultipliers()));
        armaArray4.setText(controller.weaponsToString(weapons.get(3).getMultipliers()));
        armaArray5.setText(controller.weaponsToString(weapons.get(4).getMultipliers()));
    }
    
    private void showCharacter4Stats() {
        ICharacter charact = controller.getCharacter4();
        nombreLabel.setText(charact.getName());
        hpLabel.setText(Double.toString(charact.getHp()));
        tipoLabel.setText(charact.getType());
        ArrayList<IWeapon> weapons = (ArrayList<IWeapon>) charact.getWeapons();
        arma1.setText(weapons.get(0).getName());
        arma2.setText(weapons.get(1).getName());
        arma3.setText(weapons.get(2).getName());
        arma4.setText(weapons.get(3).getName());
        arma5.setText(weapons.get(4).getName());
        armaArray1.setText(controller.weaponsToString(weapons.get(0).getMultipliers()));
        armaArray2.setText(controller.weaponsToString(weapons.get(1).getMultipliers()));
        armaArray3.setText(controller.weaponsToString(weapons.get(2).getMultipliers()));
        armaArray4.setText(controller.weaponsToString(weapons.get(3).getMultipliers()));
        armaArray5.setText(controller.weaponsToString(weapons.get(4).getMultipliers()));
    }
    
    public void addMessage(String text) {
        String current = consola.getText();
        consola.setText(current + "\n" + text);
    }
    
    public void setUserName() {
        UserName.setText(controller.getUserName());
    }
    
    public void setRivalName() {
        rivalName.setText(controller.getRivalName());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        consola = new javax.swing.JTextArea();
        chatField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();
        img4 = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        rivalName = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        UserName2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        arma1 = new javax.swing.JLabel();
        arma2 = new javax.swing.JLabel();
        arma4 = new javax.swing.JLabel();
        arma3 = new javax.swing.JLabel();
        arma5 = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        hpLabel = new javax.swing.JLabel();
        tipoLabel = new javax.swing.JLabel();
        armaArray1 = new javax.swing.JLabel();
        armaArray2 = new javax.swing.JLabel();
        armaArray3 = new javax.swing.JLabel();
        armaArray5 = new javax.swing.JLabel();
        armaArray4 = new javax.swing.JLabel();
        enterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        consola.setEditable(false);
        consola.setColumns(20);
        consola.setRows(5);
        consola.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 3, true));
        jScrollPane1.setViewportView(consola);

        chatField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 3, true));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204), 3));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204), 3));

        img2.setBorder(new javax.swing.border.MatteBorder(null));
        img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img2MouseClicked(evt);
            }
        });

        img3.setBorder(new javax.swing.border.MatteBorder(null));
        img3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img3MouseClicked(evt);
            }
        });

        img4.setBorder(new javax.swing.border.MatteBorder(null));
        img4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img4MouseClicked(evt);
            }
        });

        img1.setBorder(new javax.swing.border.MatteBorder(null));
        img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img1MouseClicked(evt);
            }
        });

        rivalName.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        rivalName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rivalName.setText("rivalname");

        UserName.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        UserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserName.setText("username");

        UserName2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        UserName2.setForeground(new java.awt.Color(204, 0, 0));
        UserName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserName2.setText("VS");

        jButton1.setForeground(new java.awt.Color(153, 153, 255));
        jButton1.setText("Global Stats");

        jLabel3.setText("Nombre:");

        jLabel4.setText("HP:");

        jLabel5.setText("Tipo:");

        jLabel6.setText("Armas:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Fuego|Aire|Agua|M.Blanca|M.Negra|Electricidad|Hielo|Acid|Espiritualidad|Hierro");

        arma1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        arma2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        arma4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        arma3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        arma5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        armaArray1.setText("  ");

        armaArray2.setText("  ");

        armaArray3.setText("  ");

        armaArray5.setText(" ");

        armaArray4.setText(" ");

        enterButton.setForeground(new java.awt.Color(0, 255, 0));
        enterButton.setText("Enter");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(nombreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tipoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(hpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(252, 252, 252))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(539, 539, 539)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(img4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(arma5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(arma3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(arma2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(arma1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(arma4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(armaArray1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                                    .addComponent(armaArray2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(armaArray3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(armaArray5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(armaArray4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel2)
                        .addGap(496, 496, 496))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(jButton1)
                                .addGap(58, 58, 58)
                                .addComponent(UserName2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rivalName, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chatField, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enterButton)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rivalName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(UserName2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tipoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(arma1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(armaArray1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(arma2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(armaArray2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(arma3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(armaArray3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arma5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(armaArray5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(arma4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(armaArray4)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chatField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void img1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img1MouseClicked
        showCharacter1Stats();
    }//GEN-LAST:event_img1MouseClicked

    private void img2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img2MouseClicked
        showCharacter2Stats();
    }//GEN-LAST:event_img2MouseClicked

    private void img3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img3MouseClicked
        showCharacter3Stats();
    }//GEN-LAST:event_img3MouseClicked

    private void img4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img4MouseClicked
        showCharacter4Stats();
    }//GEN-LAST:event_img4MouseClicked

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed
        controller.sendMessage(chatField.getText());
        chatField.setText("");
    }//GEN-LAST:event_enterButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserName;
    private javax.swing.JLabel UserName2;
    private javax.swing.JLabel arma1;
    private javax.swing.JLabel arma2;
    private javax.swing.JLabel arma3;
    private javax.swing.JLabel arma4;
    private javax.swing.JLabel arma5;
    private javax.swing.JLabel armaArray1;
    private javax.swing.JLabel armaArray2;
    private javax.swing.JLabel armaArray3;
    private javax.swing.JLabel armaArray4;
    private javax.swing.JLabel armaArray5;
    private javax.swing.JTextField chatField;
    private javax.swing.JTextArea consola;
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel hpLabel;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel img4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel rivalName;
    private javax.swing.JLabel tipoLabel;
    // End of variables declaration//GEN-END:variables

}
