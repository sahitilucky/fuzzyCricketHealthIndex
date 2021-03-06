
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ritwika
 */
public class gui extends javax.swing.JFrame {

    /**
     * Creates new form gui
     */
    public gui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        team1 = new javax.swing.JComboBox();
        team2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        submitButton = new javax.swing.JButton();
        matches = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        run = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 242, 242));
        setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N

        team1.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        team1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TEAM1", "West Indies", "Sri Lanka", "India", "Pakistan", "England", "Australia", "South Africa", "New Zealand", "Netherlands", "Afghanistan", "Ireland", "Bangladesh", "Nepal", "Oman", "Zimbabwe", "Hong Kong", "Scotland", "Kenya", "UAE" }));
        team1.setToolTipText("");
        team1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                team1ActionPerformed(evt);
            }
        });

        team2.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        team2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TEAM2", "West Indies", "Sri Lanka", "India", "Pakistan", "England", "Australia", "South Africa", "New Zealand", "Netherlands", "Afghanistan", "Ireland", "Bangladesh", "Nepal", "Oman", "Zimbabwe", "Hong Kong", "Scotland", "Kenya", "UAE" }));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Team 1");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Team 2");

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel3.setText("Year");

        jComboBox1.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        matches.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        matches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Matches");

        run.setText("Run");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(team1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(team2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(matches, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(run, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(team1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(team2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(run))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void team1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_team1ActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        Scanner in = null;
        try {
            in = new Scanner(new FileInputStream("matches.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        String line,year,t1,t2; 
        t1 = (String) team1.getSelectedItem();
        t2 = (String) team2.getSelectedItem();
        year = (String) jComboBox1.getSelectedItem();
        System.out.println(t1 + ","+t2+","+year);
        ArrayList<String> getMatches = new ArrayList<String>();
        boolean dontTakeYear = year.contentEquals("Default");
        System.out.println(dontTakeYear);
        while(in.hasNext()){
            line = in.nextLine();
            if(line.contains(t2)&&line.contains(t1)){
               if(dontTakeYear){
                   getMatches.add(line.split(",")[0]);
               }
               else{
                    if(line.contains(year)){
                       getMatches.add(line.split(",")[0]);
                   }
               }
            }
        }
        in.close();
        String[] setMatches = new String[getMatches.size()];
        for (int i = 0; i < getMatches.size(); i++) {
            String get = getMatches.get(i);
            setMatches[i] = get;
        }
        matches.setModel(new javax.swing.DefaultComboBoxModel(setMatches));
    }//GEN-LAST:event_submitButtonActionPerformed

    private void matchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchesActionPerformed

       // TODO add your handling code here:
    }//GEN-LAST:event_matchesActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
        // TODO add your handling code here:
        String match = (String)matches.getSelectedItem(),line,file = null;
        String t1,t2; 
        t1 = (String) team1.getSelectedItem();
        t2 = (String) team2.getSelectedItem();
        Scanner in = null;
        try {
            in = new Scanner(new FileInputStream("matches.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(in.hasNext()){
            line = in.nextLine();
            if(line.contains(match)&&line.contains(t2)&&line.contains(t1)){
                file = line.split(",")[3] +".txt";
            }
        }
        in.close();
       
        MatchProcessing2 match1=new MatchProcessing2();
        try {
            System.out.println("Files/nwc/"+file);
            match1.ProcessMatch("Files/nwc/"+file);
            match1.runFsg("python Files/plot.py","dump.txt");
	    match1.runFsg("python Files/plot2.py","dump.txt");
	    match1.runFsg("python Files/plot3.py","dump.txt");
        } catch (IOException ex) {
            System.out.println(ex);
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
	Graphs g =new Graphs(match1);
        g.setVisible(true);
        System.out.println(file);
        
    }//GEN-LAST:event_runActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox matches;
    private javax.swing.JButton run;
    private javax.swing.JButton submitButton;
    private javax.swing.JComboBox team1;
    private javax.swing.JComboBox team2;
    // End of variables declaration//GEN-END:variables
}
