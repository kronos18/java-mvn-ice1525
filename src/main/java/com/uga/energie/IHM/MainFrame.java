
package com.uga.energie.IHM;

import com.uga.energie.Optimizer;
import com.uga.energie.Parse.Parser;
import com.uga.energie.Parse.p_Quartier;
import com.uga.energie.UnZip;
import com.uga.energie.controllers.ButtonListener;
import com.uga.energie.controllers.ChronoActionListener;
import com.uga.energie.dataSource.ConnectionClass;
import com.uga.energie.model.*;
import com.uga.energie.repository.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

public class MainFrame extends JFrame {

    private Connection connection;
    private AppareilRepository appareilRepository;
    private QuartierRepository quartierRepository;
    private MaisonRepository maisonRepository;
    private TypeAppareilRepository typeAppareilRepository;
    private ConsommationRepository consommationRepository;
    private DateRepository dateRepository;
    private HeureRepository heureRepository;

    private static int heure = 0, minute = 0, seconde = 0;

    // <editor-fold defaultstate="collapsed" desc="Generated VARIABLE by Netbeans DEMANDE A SEB DE MODIFIER">
    private javax.swing.JButton jButtonConsoObjetByDate;
    private javax.swing.JButton jButtonDeleteAll;
    private javax.swing.JButton jButtonDeleteArchives;
    private javax.swing.JButton jButtonParcourirArchive;
    private javax.swing.JButton jButtonParcourirDestination;
    private javax.swing.JButton jButtonReadAll;
    private javax.swing.JButton jButtonReadTen;
    private javax.swing.JButton jButtonUnzip;
    private javax.swing.JButton jButtonUnzipSousFichier;
    private javax.swing.JCheckBox jCheckBoxDate;
    private javax.swing.JCheckBox jCheckBoxZero;
    private javax.swing.JLabel jLabelArchive;
    private javax.swing.JLabel jLabelChrono;
    private javax.swing.JLabel jLabelClassementApareilConsoTotaleAppareil;
    private javax.swing.JLabel jLabelClassementApareilMaisonAppareil;
    private javax.swing.JLabel jLabelClassementApareilNomAppareil;
    private javax.swing.JLabel jLabelClassementApareilTypeAppareil;
    private javax.swing.JLabel jLabelClassementMaisonConsomation;
    private javax.swing.JLabel jLabelClassementMaisonMaison;
    private javax.swing.JLabel jLabelClassementMaisonNom;
    private javax.swing.JLabel jLabelClassementMaisonRechercheMaison;
    private javax.swing.JLabel jLabelClassementMaisonTitle;
    private javax.swing.JLabel jLabelConsoSemaineTitre;
    private javax.swing.JLabel jLabelConsoTotaleAppareil1;
    private javax.swing.JLabel jLabelDestination;
    private javax.swing.JLabel jLabelMaisonAppareil2;
    private javax.swing.JLabel jLabelNomAppareil2;
    private javax.swing.JLabel jLabelOptDate;
    private javax.swing.JLabel jLabelOptZero;
    private javax.swing.JLabel jLabelProgress;
    private javax.swing.JLabel jLabelRechercheAppareil;
    private javax.swing.JLabel jLabelRechercheConsoAppareil;
    private javax.swing.JLabel jLabelTitleConsoAppareil;
    private javax.swing.JLabel jLabelTitleFrame;
    private javax.swing.JLabel jLabelTitleManager;
    private javax.swing.JLabel jLabelTitlePaneChrono;
    private javax.swing.JLabel jLabelTitlePaneChrono1;
    private javax.swing.JLabel jLabelTitlePanelArchive;
    private javax.swing.JLabel jLabelTitlePanelRequest;
    private javax.swing.JLabel jLabelTitreClassementAppareil;
    private javax.swing.JLabel jLabelTypeAppareil1;
    private javax.swing.JPanel jPanelArchive;
    private javax.swing.JPanel jPanelChrono;
    private javax.swing.JPanel jPanelClassementApareil;
    private javax.swing.JPanel jPanelConsoAppareil;
    private javax.swing.JPanel jPanelConsoMaisonTotal;
    private javax.swing.JPanel jPanelConsoSemaine;
    private javax.swing.JPanel jPanelData;
    private javax.swing.JPanel jPanelParamètre;
    private javax.swing.JPanel jPanelRequest;
    private javax.swing.JProgressBar jProgressBarBottom;
    private javax.swing.JScrollPane jScrollPaneClassementMaisonRechercheMaison;
    private javax.swing.JScrollPane jScrollPaneConsoSemaine;
    private javax.swing.JScrollPane jScrollPaneRechercheAppareil;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPaneRequest;
    private javax.swing.JTable jTableClassementMaisonListeMaison;
    private javax.swing.JTable jTableConsoSemaine;
    private javax.swing.JTable jTableRechercheAppareil;
    private javax.swing.JTextField jTextFieldArchive;
    private javax.swing.JTextField jTextFieldChrono;
    private javax.swing.JTextField jTextFieldClassementApareilConsoTotale;
    private javax.swing.JTextField jTextFieldClassementApareilMaison;
    private javax.swing.JTextField jTextFieldClassementApareilNomAppareil;
    private javax.swing.JTextField jTextFieldClassementApareilTypeAppareil;
    private javax.swing.JTextField jTextFieldClassementMaisonConsoTotalMaison;
    private javax.swing.JTextField jTextFieldClassementMaisonNomMaison;
    private javax.swing.JTextField jTextFieldConsoTotaleAppareil2;
    private javax.swing.JTextField jTextFieldDay;
    private javax.swing.JTextField jTextFieldDestination;
    private javax.swing.JTextField jTextFieldMaisonAppareil1;
    private javax.swing.JTextField jTextFieldMonth;
    private javax.swing.JTextField jTextFieldNomAppareil2;
    private javax.swing.JTextField jTextFieldTypeAppareil1;
    private javax.swing.JTextField jTextFieldYear;
    //</editor-fold>


    UnZip unzip;
    Parser parser;
    JFileChooser fcDestination;
    JFileChooser fcArchive;
    String INPUT_ZIP_FILE = "D:\\Temp\\AnalyseFonctionnelleEnergie\\input\\data.zip";
    String OUTPUT_FOLDER = "D:\\Temp\\AnalyseFonctionnelleEnergie\\output";
    Boolean isOptimizeZero = false;
    Boolean isOptimizeDate = false;

    private int delais = 1000;

    private JLabel jLabelDisplayChrono;
    private Timer timer;


    public MainFrame() {
        this.connection = ConnectionClass.getDataSource();
        initComponents();
        unzip = new UnZip();
        jTextFieldArchive.setText(INPUT_ZIP_FILE);
        jTextFieldDestination.setText(OUTPUT_FOLDER);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code, DEMANDE A SEB DE MODIFIER">
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
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanelData = new javax.swing.JPanel();
        jButtonReadAll = new javax.swing.JButton();
        jButtonReadTen = new javax.swing.JButton();
        jLabelTitleManager = new javax.swing.JLabel();
        jButtonDeleteAll = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelChrono = new javax.swing.JPanel();
        jLabelTitlePaneChrono = new javax.swing.JLabel();
        jLabelChrono = new javax.swing.JLabel();
        jTextFieldChrono = new javax.swing.JTextField();
        jPanelRequest = new javax.swing.JPanel();
        jLabelTitlePanelRequest = new javax.swing.JLabel();
        jTabbedPaneRequest = new javax.swing.JTabbedPane();
        jPanelConsoAppareil = new javax.swing.JPanel();
        jLabelTitleConsoAppareil = new javax.swing.JLabel();
        jLabelRechercheAppareil = new javax.swing.JLabel();
        jScrollPaneRechercheAppareil = new javax.swing.JScrollPane();
        jTableRechercheAppareil = new javax.swing.JTable();
        jLabelRechercheConsoAppareil = new javax.swing.JLabel();
        jTextFieldDay = new javax.swing.JTextField();
        jTextFieldMonth = new javax.swing.JTextField();
        jTextFieldYear = new javax.swing.JTextField();
        jButtonConsoObjetByDate = new javax.swing.JButton();
        jLabelTypeAppareil1 = new javax.swing.JLabel();
        jLabelNomAppareil2 = new javax.swing.JLabel();
        jTextFieldTypeAppareil1 = new javax.swing.JTextField();
        jTextFieldNomAppareil2 = new javax.swing.JTextField();
        jLabelMaisonAppareil2 = new javax.swing.JLabel();
        jTextFieldMaisonAppareil1 = new javax.swing.JTextField();
        jLabelConsoTotaleAppareil1 = new javax.swing.JLabel();
        jTextFieldConsoTotaleAppareil2 = new javax.swing.JTextField();
        jPanelClassementApareil = new javax.swing.JPanel();
        jLabelTitreClassementAppareil = new javax.swing.JLabel();
        jLabelClassementApareilTypeAppareil = new javax.swing.JLabel();
        jTextFieldClassementApareilTypeAppareil = new javax.swing.JTextField();
        jLabelClassementApareilNomAppareil = new javax.swing.JLabel();
        jTextFieldClassementApareilNomAppareil = new javax.swing.JTextField();
        jLabelClassementApareilMaisonAppareil = new javax.swing.JLabel();
        jTextFieldClassementApareilMaison = new javax.swing.JTextField();
        jLabelClassementApareilConsoTotaleAppareil = new javax.swing.JLabel();
        jTextFieldClassementApareilConsoTotale = new javax.swing.JTextField();
        jPanelConsoMaisonTotal = new javax.swing.JPanel();
        jLabelClassementMaisonTitle = new javax.swing.JLabel();
        jLabelClassementMaisonRechercheMaison = new javax.swing.JLabel();
        jScrollPaneClassementMaisonRechercheMaison = new javax.swing.JScrollPane();
        jTableClassementMaisonListeMaison = new javax.swing.JTable();
        jLabelClassementMaisonNom = new javax.swing.JLabel();
        jTextFieldClassementMaisonNomMaison = new javax.swing.JTextField();
        jLabelClassementMaisonMaison = new javax.swing.JLabel();
        jTextFieldClassementMaisonConsoTotalMaison = new javax.swing.JTextField();
        jLabelClassementMaisonConsomation = new javax.swing.JLabel();
        jPanelConsoSemaine = new javax.swing.JPanel();
        jLabelConsoSemaineTitre = new javax.swing.JLabel();
        jScrollPaneConsoSemaine = new javax.swing.JScrollPane();
        jTableConsoSemaine = new javax.swing.JTable();
        jPanelParamètre = new javax.swing.JPanel();
        jLabelTitlePaneChrono1 = new javax.swing.JLabel();
        jLabelOptZero = new javax.swing.JLabel();
        jLabelOptDate = new javax.swing.JLabel();
        jCheckBoxZero = new javax.swing.JCheckBox();
        jCheckBoxDate = new javax.swing.JCheckBox();

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
                                .addContainerGap()
                                .addGroup(jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitlePanelArchive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                                .addComponent(jLabelDestination)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldDestination))
                                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                                .addComponent(jLabelArchive)
                                                .addGap(8, 8, 8)
                                                .addComponent(jTextFieldArchive))
                                        .addComponent(jButtonParcourirArchive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonParcourirDestination, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator2)
                                        .addComponent(jButtonDeleteArchives, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonUnzipSousFichier, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                        .addComponent(jButtonUnzip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jPanelArchiveLayout.setVerticalGroup(
                jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabelTitlePanelArchive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldArchive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelArchive))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonParcourirArchive)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDestination)
                                        .addComponent(jTextFieldDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonParcourirDestination)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUnzip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonUnzipSousFichier)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
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

        jButtonReadTen.setText("Lire et insérer (10 premiers)");
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
                                        .addComponent(jButtonDeleteAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonReadTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonReadAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator1)
                                        .addComponent(jLabelTitleManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanelDataLayout.setVerticalGroup(
                jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDataLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitleManager)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonReadAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonReadTen)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDeleteAll)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonReadAll.getAccessibleContext().setAccessibleName("boutonRead");
        jButtonReadTen.getAccessibleContext().setAccessibleName("boutonReadTen");

        jPanelChrono.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTitlePaneChrono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTitlePaneChrono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitlePaneChrono.setText("Chronomètre");

        jLabelChrono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelChrono.setText("Temps d'execution :");

        jTextFieldChrono.setEditable(false);
        jTextFieldChrono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldChrono.setText("00:00:00");

        javax.swing.GroupLayout jPanelChronoLayout = new javax.swing.GroupLayout(jPanelChrono);
        jPanelChrono.setLayout(jPanelChronoLayout);
        jPanelChronoLayout.setHorizontalGroup(
                jPanelChronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelChronoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelChronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitlePaneChrono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelChronoLayout.createSequentialGroup()
                                                .addComponent(jLabelChrono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldChrono, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanelChronoLayout.setVerticalGroup(
                jPanelChronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelChronoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitlePaneChrono)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelChronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelChrono)
                                        .addComponent(jTextFieldChrono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanelRequest.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTitlePanelRequest.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTitlePanelRequest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitlePanelRequest.setText("Récupération des données");

        jTabbedPaneRequest.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanelConsoAppareil.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 102, 102)));

        jLabelTitleConsoAppareil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTitleConsoAppareil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitleConsoAppareil.setText("Consommation d'un appareil pour un jour");

        jLabelRechercheAppareil.setText("Recherche de l'appareil :");

        jTableRechercheAppareil.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneRechercheAppareil.setViewportView(jTableRechercheAppareil);
        if (jTableRechercheAppareil.getColumnModel().getColumnCount() > 0) {
            jTableRechercheAppareil.getColumnModel().getColumn(0).setResizable(false);
            jTableRechercheAppareil.getColumnModel().getColumn(1).setResizable(false);
            jTableRechercheAppareil.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabelRechercheConsoAppareil.setText("Recherche de consomation pour l'appariel sélectionné et pour la date : ");

        jTextFieldDay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDay.setText("jour");
        jTextFieldDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDayActionPerformed(evt);
            }
        });

        jTextFieldMonth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldMonth.setText("mois");
        jTextFieldMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMonthActionPerformed(evt);
            }
        });

        jTextFieldYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldYear.setText("année");
        jTextFieldYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldYearActionPerformed(evt);
            }
        });

        jButtonConsoObjetByDate.setText("Valider");
        jButtonConsoObjetByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsoObjetByDateActionPerformed(evt);
            }
        });

        jLabelTypeAppareil1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTypeAppareil1.setText("Type");

        jLabelNomAppareil2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomAppareil2.setText("Nom");

        jTextFieldTypeAppareil1.setText("jTextField1");

        jTextFieldNomAppareil2.setText("jTextField2");

        jLabelMaisonAppareil2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMaisonAppareil2.setText("Consommation totale");

        jTextFieldMaisonAppareil1.setText("jTextField3");

        jLabelConsoTotaleAppareil1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelConsoTotaleAppareil1.setText("Maison");

        jTextFieldConsoTotaleAppareil2.setText("jTextField4");

        javax.swing.GroupLayout jPanelConsoAppareilLayout = new javax.swing.GroupLayout(jPanelConsoAppareil);
        jPanelConsoAppareil.setLayout(jPanelConsoAppareilLayout);
        jPanelConsoAppareilLayout.setHorizontalGroup(
                jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitleConsoAppareil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPaneRechercheAppareil, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabelRechercheAppareil)
                                                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabelTypeAppareil1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabelNomAppareil2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabelConsoTotaleAppareil1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabelMaisonAppareil2, javax.swing.GroupLayout.Alignment.LEADING))))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldNomAppareil2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldMaisonAppareil1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldConsoTotaleAppareil2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldTypeAppareil1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                                                .addComponent(jTextFieldDay, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTextFieldMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButtonConsoObjetByDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jLabelRechercheConsoAppareil))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelConsoAppareilLayout.setVerticalGroup(
                jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitleConsoAppareil, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelRechercheAppareil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneRechercheAppareil, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(jLabelRechercheConsoAppareil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonConsoObjetByDate))
                                .addGap(23, 23, 23)
                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTypeAppareil1)
                                        .addComponent(jTextFieldTypeAppareil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNomAppareil2)
                                        .addComponent(jTextFieldNomAppareil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                                .addComponent(jLabelConsoTotaleAppareil1)
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelMaisonAppareil2)
                                                        .addComponent(jTextFieldConsoTotaleAppareil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jTextFieldMaisonAppareil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jTabbedPaneRequest.addTab("Conso Appareil", jPanelConsoAppareil);

        jPanelClassementApareil.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTitreClassementAppareil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTitreClassementAppareil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitreClassementAppareil.setText("Appareil le plus gourmand lors du dernier mois");

        jLabelClassementApareilTypeAppareil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClassementApareilTypeAppareil.setText("Type");

        jTextFieldClassementApareilTypeAppareil.setText("jTextField1");

        jLabelClassementApareilNomAppareil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClassementApareilNomAppareil.setText("Nom");

        jTextFieldClassementApareilNomAppareil.setText("jTextField2");

        jLabelClassementApareilMaisonAppareil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClassementApareilMaisonAppareil.setText("Consommation totale");

        jTextFieldClassementApareilMaison.setText("jTextField3");

        jLabelClassementApareilConsoTotaleAppareil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClassementApareilConsoTotaleAppareil.setText("Maison");

        jTextFieldClassementApareilConsoTotale.setText("jTextField4");

        javax.swing.GroupLayout jPanelClassementApareilLayout = new javax.swing.GroupLayout(jPanelClassementApareil);
        jPanelClassementApareil.setLayout(jPanelClassementApareilLayout);
        jPanelClassementApareilLayout.setHorizontalGroup(
                jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelClassementApareilLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitreClassementAppareil, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                                        .addGroup(jPanelClassementApareilLayout.createSequentialGroup()
                                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelClassementApareilTypeAppareil, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabelClassementApareilNomAppareil, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabelClassementApareilConsoTotaleAppareil, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelClassementApareilMaisonAppareil, javax.swing.GroupLayout.Alignment.LEADING))))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldClassementApareilTypeAppareil, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldClassementApareilNomAppareil, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldClassementApareilMaison, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldClassementApareilConsoTotale, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelClassementApareilLayout.setVerticalGroup(
                jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelClassementApareilLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitreClassementAppareil, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClassementApareilTypeAppareil)
                                        .addComponent(jTextFieldClassementApareilTypeAppareil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClassementApareilNomAppareil)
                                        .addComponent(jTextFieldClassementApareilNomAppareil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelClassementApareilLayout.createSequentialGroup()
                                                .addComponent(jLabelClassementApareilConsoTotaleAppareil)
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelClassementApareilMaisonAppareil)
                                                        .addComponent(jTextFieldClassementApareilConsoTotale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jTextFieldClassementApareilMaison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneRequest.addTab("Classement Appareil", jPanelClassementApareil);

        jPanelConsoMaisonTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelClassementMaisonTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelClassementMaisonTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClassementMaisonTitle.setText("Consommation d'une maison sur la dernière heure");

        jLabelClassementMaisonRechercheMaison.setText("Sélection de la maison à analyser");

        jTableClassementMaisonListeMaison.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "Title 1", "Title 2"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneClassementMaisonRechercheMaison.setViewportView(jTableClassementMaisonListeMaison);
        if (jTableClassementMaisonListeMaison.getColumnModel().getColumnCount() > 0) {
            jTableClassementMaisonListeMaison.getColumnModel().getColumn(0).setResizable(false);
            jTableClassementMaisonListeMaison.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabelClassementMaisonNom.setText("Nom");

        jTextFieldClassementMaisonNomMaison.setText("jTextField2");

        jLabelClassementMaisonMaison.setText("Consommation totale");

        jTextFieldClassementMaisonConsoTotalMaison.setText("jTextField4");

        jLabelClassementMaisonConsomation.setText("Consomation durant la dernière heure :");

        javax.swing.GroupLayout jPanelConsoMaisonTotalLayout = new javax.swing.GroupLayout(jPanelConsoMaisonTotal);
        jPanelConsoMaisonTotal.setLayout(jPanelConsoMaisonTotalLayout);
        jPanelConsoMaisonTotalLayout.setHorizontalGroup(
                jPanelConsoMaisonTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConsoMaisonTotalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsoMaisonTotalLayout.createSequentialGroup()
                                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelClassementMaisonMaison)
                                                        .addComponent(jLabelClassementMaisonNom))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldClassementMaisonNomMaison, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldClassementMaisonConsoTotalMaison))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsoMaisonTotalLayout.createSequentialGroup()
                                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelClassementMaisonTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPaneClassementMaisonRechercheMaison, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                                                .addGap(14, 14, 14))
                                        .addGroup(jPanelConsoMaisonTotalLayout.createSequentialGroup()
                                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelClassementMaisonConsomation)
                                                        .addComponent(jLabelClassementMaisonRechercheMaison))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelConsoMaisonTotalLayout.setVerticalGroup(
                jPanelConsoMaisonTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConsoMaisonTotalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelClassementMaisonTitle)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelClassementMaisonRechercheMaison)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneClassementMaisonRechercheMaison, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelClassementMaisonConsomation)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClassementMaisonNom)
                                        .addComponent(jTextFieldClassementMaisonNomMaison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClassementMaisonMaison)
                                        .addComponent(jTextFieldClassementMaisonConsoTotalMaison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jTabbedPaneRequest.addTab("Conso Maison", jPanelConsoMaisonTotal);

        jPanelConsoSemaine.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelConsoSemaineTitre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelConsoSemaineTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelConsoSemaineTitre.setText("Consommation d'une maison supérieur à la semaine précédente");

        jTableConsoSemaine.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPaneConsoSemaine.setViewportView(jTableConsoSemaine);

        javax.swing.GroupLayout jPanelConsoSemaineLayout = new javax.swing.GroupLayout(jPanelConsoSemaine);
        jPanelConsoSemaine.setLayout(jPanelConsoSemaineLayout);
        jPanelConsoSemaineLayout.setHorizontalGroup(
                jPanelConsoSemaineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsoSemaineLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelConsoSemaineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPaneConsoSemaine, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                                        .addComponent(jLabelConsoSemaineTitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanelConsoSemaineLayout.setVerticalGroup(
                jPanelConsoSemaineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConsoSemaineLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelConsoSemaineTitre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPaneConsoSemaine, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPaneRequest.addTab("Conso semaine", jPanelConsoSemaine);

        javax.swing.GroupLayout jPanelRequestLayout = new javax.swing.GroupLayout(jPanelRequest);
        jPanelRequest.setLayout(jPanelRequestLayout);
        jPanelRequestLayout.setHorizontalGroup(
                jPanelRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelRequestLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitlePanelRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTabbedPaneRequest))
                                .addContainerGap())
        );
        jPanelRequestLayout.setVerticalGroup(
                jPanelRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRequestLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitlePanelRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPaneRequest)
                                .addContainerGap())
        );

        jPanelParamètre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTitlePaneChrono1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTitlePaneChrono1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitlePaneChrono1.setText("Paramètres");

        jLabelOptZero.setText("Activer optimisation de suppression des zéros");

        jLabelOptDate.setText("Activer optimisation utilisatant les tables Date et Heure");

        jCheckBoxZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxZeroActionPerformed(evt);
            }
        });

        jCheckBoxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelParamètreLayout = new javax.swing.GroupLayout(jPanelParamètre);
        jPanelParamètre.setLayout(jPanelParamètreLayout);
        jPanelParamètreLayout.setHorizontalGroup(
                jPanelParamètreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelParamètreLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelParamètreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelParamètreLayout.createSequentialGroup()
                                                .addComponent(jLabelTitlePaneChrono1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(jPanelParamètreLayout.createSequentialGroup()
                                                .addGroup(jPanelParamètreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabelOptDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelOptZero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(46, 46, 46)
                                                .addGroup(jPanelParamètreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCheckBoxZero)
                                                        .addComponent(jCheckBoxDate))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelParamètreLayout.setVerticalGroup(
                jPanelParamètreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelParamètreLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitlePaneChrono1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelParamètreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelParamètreLayout.createSequentialGroup()
                                                .addComponent(jLabelOptZero)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelOptDate))
                                        .addGroup(jPanelParamètreLayout.createSequentialGroup()
                                                .addComponent(jCheckBoxZero)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBoxDate)))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitleFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jPanelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jPanelArchive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jPanelChrono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jPanelParamètre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jPanelRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jProgressBarBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(104, 104, 104)
                                                                .addComponent(jLabelProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitleFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanelArchive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanelChrono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanelParamètre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanelRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelProgress)
                                .addGap(3, 3, 3)
                                .addComponent(jProgressBarBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jLabelProgress.getAccessibleContext().setAccessibleName("labelProgression");

        pack();
    }// </editor-fold>


    //<editor-fold defaultstate="collapsed" desc=" Fonction pour parcourir (JFileChooser)">
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
        RealdFilesAndInsertIntoDatabase(0);
    }

    private void jButtonReadTenActionPerformed(java.awt.event.ActionEvent evt) {
        RealdFilesAndInsertIntoDatabase(1);
    }

    private void RealdFilesAndInsertIntoDatabase(int iNbFilesToRead) {
        this.timer.start();
        parser = new Parser(jTextFieldDestination.getText());

        List<p_Quartier> lsQuartier = parser.Parse(iNbFilesToRead);

        //Execute des algos de compression de donnees. On peut choisir d'optimiser ou non en supprimant les zéro et/ou en utilisant ou non les tables Date et Heure
        Optimizer opt = new Optimizer(lsQuartier, isOptimizeZero, isOptimizeDate);
        opt.FromParserToJDBC();

        //Tu peux maintenant acceder aux objets à inserrer en base, par exemple la liste des appareils :
        List<Date> listeDate = opt.getListeDate();
        List<Heure> listeHeure = opt.getListeHeure();
        List<Quartier> listeQuartier = opt.getListeQuartier();
        List<Maison> listeMaison = opt.getListeMaison();
        List<TypeAppareil> listeTypeAppareil = opt.getListeTypeAppareil();
        List<Appareil> listeAppareil = opt.getListeAppareil();
        List<Consommation> listeConsommation = opt.getListeConsommation();
        System.out.println("Insertion date");
        Iterator iterator = listeDate.iterator();
        while (iterator.hasNext()) {
            Date date = (Date) iterator.next();
            Repository.getDateRepository().create(date);
        }

        System.out.println("Insertion heure");
        iterator = listeHeure.iterator();
        while (iterator.hasNext()) {
            Heure heure = (Heure) iterator.next();
            Repository.getHeureRepository().create(heure);
        }
        System.out.println("Insertion quartier");
        iterator = listeQuartier.iterator();
        while (iterator.hasNext()) {
            Quartier quartier = (Quartier) iterator.next();
            Repository.getQuartierRepository().create(quartier);
        }
        System.out.println("Insertion maison");
        iterator = listeMaison.iterator();
        while (iterator.hasNext()) {
            Maison maison = (Maison) iterator.next();
            Repository.getMaisonRepository().create(maison);
        }
        System.out.println("Insertion type appareil");
        iterator = listeTypeAppareil.iterator();
        while (iterator.hasNext()) {
            TypeAppareil typeAppareil = (TypeAppareil) iterator.next();
            Repository.getTypeAppareilRepository().create(typeAppareil);
        }
        System.out.println("Insertion appareil");
        iterator = listeAppareil.iterator();
        while (iterator.hasNext()) {
            Appareil appareil = (Appareil) iterator.next();
            Repository.getAppareilRepository().create(appareil);
        }
        System.out.println("Insertion consommation");
        iterator = listeConsommation.iterator();
        while (iterator.hasNext()) {
            Consommation consommation = (Consommation) iterator.next();
            Repository.getConsommationRepository().create(consommation);
        }
        this.timer.stop();

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
        File f = new File(OUTPUT_FOLDER);
        try {
            delete(f);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
        }
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

    private void jButtonConsoObjetByDateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextFieldYearActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextFieldMonthActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextFieldDayActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBoxZeroActionPerformed(java.awt.event.ActionEvent evt) {
        isOptimizeZero = jCheckBoxZero.isSelected();
    }

    private void jCheckBoxDateActionPerformed(java.awt.event.ActionEvent evt) {
        isOptimizeDate = jCheckBoxDate.isSelected();
    }


    private void delete(File f) throws IOException {
        if (f.isDirectory()) {
            for (File c : f.listFiles())
                delete(c);
        }
        if (!f.delete())
            throw new FileNotFoundException("Failed to delete file: " + f);
    }
    //</editor-fold>


}
