
package com.uga.energie.IHM;

import com.uga.energie.Optimizer;
import com.uga.energie.Parse.Parser;
import com.uga.energie.Parse.p_Quartier;
import com.uga.energie.UnZip;
import com.uga.energie.model.*;
import com.uga.energie.repository.*;

import javax.swing.*;
import java.io.File;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

public class MainFrame extends javax.swing.JFrame {

    private Connection connection;
    private AppareilRepository appareilRepository;
    private QuartierRepository quartierRepository;
    private MaisonRepository maisonRepository;
    private TypeAppareilRepository typeAppareilRepository;
    private ConsommationRepository consommationRepository;
    private DateRepository dateRepository;
    private HeureRepository heureRepository;

    // <editor-fold defaultstate="collapsed" desc="Generated VARIABLE by Netbeans DEMANDE A SEB DE MODIFIER">
    private javax.swing.JButton jButtonDeleteAll;
    private javax.swing.JButton jButtonDeleteArchives;
    private javax.swing.JButton jButtonParcourirArchive;
    private javax.swing.JButton jButtonParcourirDestination;
    private javax.swing.JButton jButtonReadAll;
    private javax.swing.JButton jButtonReadTen;
    private javax.swing.JButton jButtonUnzip;
    private javax.swing.JButton jButtonUnzipSousFichier;
    private javax.swing.JLabel jLabelArchive;
    private javax.swing.JLabel jLabelDestination;
    private javax.swing.JLabel jLabelProgress;
    private javax.swing.JLabel jLabelTitleFrame;
    private javax.swing.JLabel jLabelTitleManager;
    private javax.swing.JLabel jLabelTitlePanelArchive;
    private javax.swing.JPanel jPanelArchive;
    private javax.swing.JPanel jPanelData;
    private javax.swing.JProgressBar jProgressBarBottom;
    private javax.swing.JTextField jTextFieldArchive;
    private javax.swing.JTextField jTextFieldDestination;
    //</editor-fold>


    UnZip unzip;
    Parser parser;
    JFileChooser fcDestination;
    JFileChooser fcArchive;
    String INPUT_ZIP_FILE = "D:\\Temp\\AnalyseFonctionnelleEnergie\\input\\data.zip";
    String OUTPUT_FOLDER = "D:\\Temp\\AnalyseFonctionnelleEnergie\\output";


    public MainFrame() {
        initComponents();
        unzip = new UnZip();
        jTextFieldArchive.setText(INPUT_ZIP_FILE);
        jTextFieldDestination.setText(OUTPUT_FOLDER);

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelTitleFrame = new javax.swing.JLabel();
        jProgressBarBottom = new javax.swing.JProgressBar();
        jLabelProgress = new javax.swing.JLabel();
        jPanelArchive = new javax.swing.JPanel();
        jButtonParcourirDestination = new javax.swing.JButton();
        jTextFieldDestination = new javax.swing.JTextField();
        jButtonParcourirArchive = new javax.swing.JButton();
        jLabelDestination = new javax.swing.JLabel();
        jButtonUnzip = new javax.swing.JButton();
        jLabelArchive = new javax.swing.JLabel();
        jTextFieldArchive = new javax.swing.JTextField();
        jLabelTitlePanelArchive = new javax.swing.JLabel();
        jButtonUnzipSousFichier = new javax.swing.JButton();
        jButtonDeleteArchives = new javax.swing.JButton();
        jPanelData = new javax.swing.JPanel();
        jButtonReadAll = new javax.swing.JButton();
        jButtonReadTen = new javax.swing.JButton();
        jLabelTitleManager = new javax.swing.JLabel();
        jButtonDeleteAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabelTitleFrame.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitleFrame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitleFrame.setText("Gestion de données optimisée (DEVIS / ESPRIT / MORENO)");

        jLabelProgress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProgress.setText("Progression");

        jPanelArchive.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonParcourirDestination.setText("Parcourir");
        jButtonParcourirDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParcourirDestinationActionPerformed(evt);
            }
        });

        jButtonParcourirArchive.setText("Parcourir");
        jButtonParcourirArchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParcourirArchiveActionPerformed(evt);
            }
        });

        jLabelDestination.setText("Chemin destination");

        jButtonUnzip.setText("Unzip fichier");
        jButtonUnzip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnzipActionPerformed(evt);
            }
        });

        jLabelArchive.setText("Chemin fichier archive");

        jLabelTitlePanelArchive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTitlePanelArchive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitlePanelArchive.setText("Gestion de l'archive");

        jButtonUnzipSousFichier.setText("Unzip sous-fichiers");
        jButtonUnzipSousFichier.setToolTipText("");
        jButtonUnzipSousFichier.setActionCommand("Unzip sous-fichiers");
        jButtonUnzipSousFichier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnzipSousFichierActionPerformed(evt);
            }
        });

        jButtonDeleteArchives.setText("Delete archives");
        jButtonDeleteArchives.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteArchivesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelArchiveLayout = new javax.swing.GroupLayout(jPanelArchive);
        jPanelArchive.setLayout(jPanelArchiveLayout);
        jPanelArchiveLayout.setHorizontalGroup(
                jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                .addGroup(jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelArchive)
                                        .addComponent(jLabelDestination))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                                .addComponent(jTextFieldDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonParcourirDestination, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                                .addComponent(jTextFieldArchive, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonParcourirArchive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addComponent(jButtonUnzip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTitlePanelArchive, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonUnzipSousFichier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDeleteArchives, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelArchiveLayout.setVerticalGroup(
                jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                .addComponent(jLabelTitlePanelArchive)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldArchive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelArchive)
                                        .addComponent(jButtonParcourirArchive))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelDestination)
                                                .addComponent(jTextFieldDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButtonParcourirDestination))
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUnzip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUnzipSousFichier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDeleteArchives)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonParcourirDestination.getAccessibleContext().setAccessibleName("boutonParcourirDestination");
        jTextFieldDestination.getAccessibleContext().setAccessibleName("textFieldDestination");
        jButtonParcourirArchive.getAccessibleContext().setAccessibleName("boutonParcourirArchive");
        jLabelDestination.getAccessibleContext().setAccessibleName("labelDestination");
        jButtonUnzip.getAccessibleContext().setAccessibleName("boutonUnzip");
        jLabelArchive.getAccessibleContext().setAccessibleName("labelPathArchive");
        jTextFieldArchive.getAccessibleContext().setAccessibleName("textFieldArchive");

        jPanelData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonReadAll.setText("Lire et insérer");
        jButtonReadAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadAllActionPerformed(evt);
            }
        });

        jButtonReadTen.setText("Lire et insérer (10 premiers éléments)");
        jButtonReadTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadTenActionPerformed(evt);
            }
        });

        jLabelTitleManager.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTitleManager.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitleManager.setText("Gestion des données");

        jButtonDeleteAll.setText("Supprimer tout les fichiers");
        jButtonDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDataLayout = new javax.swing.GroupLayout(jPanelData);
        jPanelData.setLayout(jPanelDataLayout);
        jPanelDataLayout.setHorizontalGroup(
                jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDataLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonDeleteAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelDataLayout.createSequentialGroup()
                                                .addGroup(jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabelTitleManager, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                                                        .addGroup(jPanelDataLayout.createSequentialGroup()
                                                                .addComponent(jButtonReadAll, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButtonReadTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelDataLayout.setVerticalGroup(
                jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDataLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitleManager)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonReadAll)
                                        .addComponent(jButtonReadTen))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jButtonDeleteAll)
                                .addContainerGap())
        );

        jButtonReadAll.getAccessibleContext().setAccessibleName("boutonRead");
        jButtonReadTen.getAccessibleContext().setAccessibleName("boutonReadTen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jProgressBarBottom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelTitleFrame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelProgress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanelArchive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitleFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanelArchive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelProgress)
                                .addGap(3, 3, 3)
                                .addComponent(jProgressBarBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jLabelProgress.getAccessibleContext().setAccessibleName("labelProgression");

        pack();
    }// </editor-fold>


    //<editor-fold defaultstate="collapsed" desc=" Fonction pour parcourir (JFileChosser)">
    private void jButtonParcourirDestinationActionPerformed(java.awt.event.ActionEvent evt) {
        //Set up the file chooser.
        if (fcDestination == null) {
            fcDestination = new JFileChooser();

            fcDestination.setCurrentDirectory(new java.io.File("."));
            fcDestination.setDialogTitle("Dossier de destination");
            fcDestination.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fcDestination.setAcceptAllFileFilterUsed(false);
        }

        //Show it.
        int returnVal = fcDestination.showDialog(MainFrame.this, "Selectionner");

        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fcDestination.getSelectedFile();
            jTextFieldDestination.setText(file.getAbsolutePath());
            System.out.println("Attaching Folder: " + file.getName() + ".");
        } else {
            System.out.println("Attachment cancelled by user.");
        }
    }

    private void jButtonParcourirArchiveActionPerformed(java.awt.event.ActionEvent evt) {
        //Set up the file chooser.
        if (fcArchive == null) {
            fcArchive = new JFileChooser();
            fcArchive.setAcceptAllFileFilterUsed(true);
        }

        //Show it.
        int returnVal = fcArchive.showDialog(MainFrame.this, "Selectionner");

        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fcArchive.getSelectedFile();
            jTextFieldArchive.setText(file.getAbsolutePath());
            System.out.println("Attaching file: " + file.getName() + ".");
        } else {
            System.out.println("Attachment cancelled by user.");
        }
    }
    //</editor-fold>


    //<editor-fold defaultstate="collapsed" desc=" Fonction associé aux boutons effectuant une action opérationnelle ">
    private void jButtonReadAllActionPerformed(java.awt.event.ActionEvent evt) {
        parser = new Parser(jTextFieldDestination.getText());
        parser.Parse();
        List<p_Quartier> lsQuartier = parser.Parse();

        //todo : Executer des algos de compression de donnees
        Optimizer opt = new Optimizer(lsQuartier);
        opt.FromParserToJDBC();

        //Tu peux maintenant acceder aux objets à inserrer en base, par exemple la liste des appareils :
        List<Date> listeDate = opt.getListeDate();
        List<Heure> listeHeure = opt.getListeHeure();
        List<Quartier> listeQuartier = opt.getListeQuartier();
        List<Maison> listeMaison = opt.getListeMaison();
        List<TypeAppareil> listeTypeAppareil = opt.getListeTypeAppareil();
        List<Appareil> listeAppareil = opt.getListeAppareil();
        List<Consommation> listeConsommation = opt.getListeConsommation();

        Iterator iterator = listeDate.iterator();
        while (iterator.hasNext()) {
            Date date = (Date) iterator.next();
            Repository.getDateRepository().create(date);
        }

        iterator = listeHeure.iterator();
        while (iterator.hasNext()) {
            Heure heure = (Heure) iterator.next();
            Repository.getHeureRepository().create(heure);
        }
        iterator = listeQuartier.iterator();
        while (iterator.hasNext()) {
            Quartier quartier = (Quartier) iterator.next();
            Repository.getQuartierRepository().create(quartier);
        }
        iterator = listeMaison.iterator();
        while (iterator.hasNext()) {
            Maison maison = (Maison) iterator.next();
            Repository.getMaisonRepository().create(maison);
        }
        iterator = listeTypeAppareil.iterator();
        while (iterator.hasNext()) {
            TypeAppareil typeAppareil = (TypeAppareil) iterator.next();
            Repository.getTypeAppareilRepository().create(typeAppareil);
        }
        iterator = listeAppareil.iterator();
        while (iterator.hasNext()) {
            Appareil appareil = (Appareil) iterator.next();
            Repository.getAppareilRepository().create(appareil);
        }
        iterator = listeConsommation.iterator();
        while (iterator.hasNext()) {
            Consommation consommation = (Consommation) iterator.next();
            Repository.getConsommationRepository().create(consommation);
        }

        //todo : inserer la liste de quartier dans la bdd avec JDBC

    }

    private void jButtonReadTenActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonUnzipActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTextFieldArchive.getText().isEmpty() || jTextFieldDestination.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "champs vides", "Le champs destination ou archive est vide ce qui n'est pas autorisé", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("-------------------------------- NIVEAU 1 ------------------------------------");
        ProgressUnZipLevelOne progresserUnZipOne = new ProgressUnZipLevelOne(100, jProgressBarBottom, jTextFieldArchive.getText(), jTextFieldDestination.getText());
        progresserUnZipOne.start();
    }

    private void jButtonDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void jButtonUnzipSousFichierActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("-------------------------------- NIVEAU 2 ------------------------------------");
        ProgressUnZipLevelTwo progresserUnZipTwo = new ProgressUnZipLevelTwo(100, jProgressBarBottom, jTextFieldDestination.getText());
        progresserUnZipTwo.start();
    }

    private void jButtonDeleteArchivesActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("-------------------------------- NIVEAU 3 ------------------------------------");
        ProgressDelete progresserDelete = new ProgressDelete(100, jProgressBarBottom, jTextFieldDestination.getText());
        progresserDelete.start();
    }
    //</editor-fold>


}
