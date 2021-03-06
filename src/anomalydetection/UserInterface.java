/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anomalydetection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.FILES_ONLY;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.text.html.HTML;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author enam
 */
public class UserInterface extends javax.swing.JFrame {

    /**
     * Creates new form UserInterface
     */
    File testData, trainingData, outputData;
    Scanner cinTestData, cinTrainingData;
    FileWriter coutOurputData;
    double values[][] = new double[1000000][];
    double[] mean, varience;
    int dimension, noOfData;
    double threshold;
    private Object chart;

    public UserInterface() {
        super("Anomaly Detection");
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldTrainingData = new javax.swing.JTextField();
        jButtonBrowseTrainingData = new javax.swing.JButton();
        jLabelTrainingData = new javax.swing.JLabel();
        jLabelTestData = new javax.swing.JLabel();
        jTextFieldTestData = new javax.swing.JTextField();
        jButtonBrowseTestData = new javax.swing.JButton();
        jLabelOutputData = new javax.swing.JLabel();
        jTextFieldOutputData = new javax.swing.JTextField();
        jButtonBrowseOutputData = new javax.swing.JButton();
        jButtonSubmit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonBrowseTrainingData.setText("Browse");
        jButtonBrowseTrainingData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseTrainingDataActionPerformed(evt);
            }
        });

        jLabelTrainingData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTrainingData.setText("Training Data:");

        jLabelTestData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTestData.setText("Test Data:");

        jButtonBrowseTestData.setText("Browse");
        jButtonBrowseTestData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseTestDataActionPerformed(evt);
            }
        });

        jLabelOutputData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelOutputData.setText("Output Data:");

        jButtonBrowseOutputData.setText("Browse");
        jButtonBrowseOutputData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseOutputDataActionPerformed(evt);
            }
        });

        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelTrainingData, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabelTestData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelOutputData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldTestData, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBrowseTestData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldTrainingData, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBrowseTrainingData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jTextFieldOutputData, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonBrowseOutputData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTrainingData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTrainingData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBrowseTrainingData)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTestData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTestData)
                    .addComponent(jButtonBrowseTestData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOutputData)
                    .addComponent(jTextFieldOutputData)
                    .addComponent(jButtonBrowseOutputData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSubmit))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBrowseTrainingDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseTrainingDataActionPerformed
        // TODO add your handling code here:
        int retrival;
        jFileChooser.setFileSelectionMode(FILES_ONLY);
        retrival = jFileChooser.showOpenDialog(this);

        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                trainingData = jFileChooser.getSelectedFile();
                jTextFieldTrainingData.setText(trainingData.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonBrowseTrainingDataActionPerformed

    private void jButtonBrowseTestDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseTestDataActionPerformed
        // TODO add your handling code here:
        int retrival;
        jFileChooser.setFileSelectionMode(FILES_ONLY);
        retrival = jFileChooser.showOpenDialog(this);

        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                testData = jFileChooser.getSelectedFile();
                jTextFieldTestData.setText(testData.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonBrowseTestDataActionPerformed

    private void jButtonBrowseOutputDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseOutputDataActionPerformed
        // TODO add your handling code here:
        int retrival;
        jFileChooser.setFileSelectionMode(FILES_ONLY);
        retrival = jFileChooser.showOpenDialog(this);

        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                outputData = jFileChooser.getSelectedFile();
                jTextFieldOutputData.setText(outputData.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonBrowseOutputDataActionPerformed

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        // TODO add your handling code here:
        try {
            coutOurputData = new FileWriter(outputData);
            cinTrainingData = new Scanner(trainingData);
            cinTestData = new Scanner(testData);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        String ss = null;
        while (ss == null) {

            ss = JOptionPane.showInputDialog(this, "Enter Threshold value");
            if (ss == null) {
                JOptionPane.showMessageDialog(this, "Please enter the threshold value");
            } else {
                threshold = Double.parseDouble(ss);
                break;
            }
        }

        processTrainingData();
        processTestData();

        for (int i = 0; i < dimension; ++i) {
            PlotGraph pgd = new PlotGraph(mean[i], varience[i], i);
            pgd.pack();
            RefineryUtilities.centerFrameOnScreen(pgd);
            pgd.setVisible(true);
        }

        //JOptionPane.showMessageDialog(this,cinTrainingData.nextLine()+" "+cinTestData.nextLine()+" "+cinOurputData.nextLine(),"Process Done", INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void printAllTheData() {

        for (int i = 0; i < noOfData; ++i) {
            for (int j = 0; j < dimension; ++j) {
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }

    }

    private void inputTrainingData() {
        noOfData = dimension = 0;
        String line = cinTrainingData.nextLine();

        for (String ss : line.split(" ")) {
            dimension++;
        }

        mean = new double[dimension];
        varience = new double[dimension];

        int j = 0;
        values[noOfData] = new double[dimension];

        for (String ss : line.split(" ")) {
            double dd = Double.parseDouble(ss);
            values[noOfData][j++] = dd;
        }

        noOfData++;

        while (cinTrainingData.hasNext()) {
            values[noOfData] = new double[dimension];
            for (j = 0; j < dimension; ++j) {
                double dd = cinTrainingData.nextDouble();
                values[noOfData][j] = dd;
            }
            noOfData++;
        }
    }

    private void calculateMean() {
        for (int i = 0; i < noOfData; ++i) {
            for (int j = 0; j < dimension; ++j) {
                mean[j] += values[i][j];
            }
        }

        for (int j = 0; j < dimension; ++j) {
            mean[j] /= noOfData;
        }

    }

    private void calculateVarience() {
        for (int i = 0; i < noOfData; ++i) {
            for (int j = 0; j < dimension; ++j) {
                varience[j] += Math.pow(values[i][j] - mean[j], 2);
            }
        }

        for (int j = 0; j < dimension; ++j) {
            varience[j] /= noOfData;
        }
    }

    private void printMean() {
        for (int j = 0; j < dimension; ++j) {
            System.out.print(mean[j] + " ");
        }
        System.out.println();
    }

    private void printVarience() {
        for (int j = 0; j < dimension; ++j) {
            System.out.print(varience[j] + " ");
        }
        System.out.println();
    }

    private void processTrainingData() {

        inputTrainingData();
        calculateMean();
        calculateVarience();

//        printAllTheData();
//        printMean();
//        printVarience();
    }

    private double calculateProbability(int dim, double value) {
        return Math.exp(-((Math.pow(value - mean[dim], 2)) / (2 * varience[dim]))) / (Math.sqrt(2 * Math.PI * varience[dim]));
    }

    public void processTestData() {

        int no = 0;

        if (!outputData.exists()) {
            try {
                outputData.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (cinTestData.hasNext()) {

            double cumulativeProbability = 1.0;
            for (int i = 0; i < dimension; ++i) {
                double dd = cinTestData.nextDouble();

                double test = calculateProbability(i, dd);
                cumulativeProbability *= test;
            }

            if (cumulativeProbability >= threshold) {
                try {
                    coutOurputData.write(no + " Normal\n");
                    System.out.println(no + " Normal " + cumulativeProbability);
                } catch (IOException ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    coutOurputData.write(no + " Anomaly\n");
                    System.out.println(no + " Anomaly " + cumulativeProbability);
                } catch (IOException ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            no++;

        }

        try {
            coutOurputData.flush();
            coutOurputData.close();
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrowseOutputData;
    private javax.swing.JButton jButtonBrowseTestData;
    private javax.swing.JButton jButtonBrowseTrainingData;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabelOutputData;
    private javax.swing.JLabel jLabelTestData;
    private javax.swing.JLabel jLabelTrainingData;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldOutputData;
    private javax.swing.JTextField jTextFieldTestData;
    private javax.swing.JTextField jTextFieldTrainingData;
    // End of variables declaration//GEN-END:variables
}
