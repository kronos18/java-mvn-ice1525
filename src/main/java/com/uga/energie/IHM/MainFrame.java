
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
    private JButton jButtonConsoObjetByDate, jButtonDeleteAll, jButtonDeleteArchives, jButtonParcourirArchive;
    private JButton jButtonParcourirDestination, jButtonReadAll, jButtonReadTen, jButtonUnzip, jButtonUnzipSousFichier;
    private JButton jButtonreinitialiserChrono;
    private JButton jButtonTest;

    private JLabel jLabelArchive, jLabelChrono, jLabelClassementApareilConsoTotaleAppareil, jLabelClassementApareilMaisonAppareil;
    private JLabel jLabelClassementApareilNomAppareil, jLabelClassementApareilTypeAppareil, jLabelClassementMaisonConsomation;
    private JLabel jLabelClassementMaisonMaison;
    private JLabel jLabelClassementMaisonNom;
    private JLabel jLabelClassementMaisonRechercheMaison;
    private JLabel jLabelClassementMaisonTitle;
    private JLabel jLabelConsoSemaineTitre;
    private JLabel jLabelConsoTotaleAppareil1;
    private JLabel jLabelDestination;
    private JLabel jLabelMaisonAppareil2;
    private JLabel jLabelNomAppareil2;
    private JLabel jLabelProgress;
    private JLabel jLabelRechercheAppareil;
    private JLabel jLabelRechercheConsoAppareil;
    private JLabel jLabelTitleConsoAppareil;
    private JLabel jLabelTitleFrame;
    private JLabel jLabelTitleManager;
    private JLabel jLabelTitlePaneChrono;
    private JLabel jLabelTitlePanelArchive;
    private JLabel jLabelTitlePanelRequest;
    private JLabel jLabelTitreClassementAppareil;
    private JLabel jLabelTypeAppareil1;
    private JPanel jPanelArchive;
    private JPanel jPanelChrono;
    private JPanel jPanelClassementApareil;
    private JPanel jPanelConsoAppareil;
    private JPanel jPanelConsoMaisonTotal;
    private JPanel jPanelConsoSemaine;
    private JPanel jPanelData;
    private JPanel jPanelRequest;
    private JProgressBar jProgressBarBottom;
    private JScrollPane jScrollPaneClassementMaisonRechercheMaison;
    private JScrollPane jScrollPaneConsoSemaine;
    private JScrollPane jScrollPaneRechercheAppareil;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTabbedPane jTabbedPaneRequest;
    private JTable jTableClassementMaisonListeMaison;
    private JTable jTableConsoSemaine;
    private JTable jTableRechercheAppareil;
    private JTextField jTextFieldArchive;
    private JTextField jTextFieldChrono;
    private JTextField jTextFieldClassementApareilConsoTotale;
    private JTextField jTextFieldClassementApareilMaison;
    private JTextField jTextFieldClassementApareilNomAppareil;
    private JTextField jTextFieldClassementApareilTypeAppareil;
    private JTextField jTextFieldClassementMaisonConsoTotalMaison;
    private JTextField jTextFieldClassementMaisonNomMaison;
    private JTextField jTextFieldConsoTotaleAppareil2;
    private JTextField jTextFieldDay;
    private JTextField jTextFieldDestination;
    private JTextField jTextFieldMaisonAppareil1;
    private JTextField jTextFieldMonth;
    private JTextField jTextFieldNomAppareil2;
    private JTextField jTextFieldTypeAppareil1;
    private JTextField jTextFieldYear;
    //</editor-fold>


    UnZip unzip;
    Parser parser;
    JFileChooser fcDestination;
    JFileChooser fcArchive;
    String INPUT_ZIP_FILE = "D:\\Temp\\AnalyseFonctionnelleEnergie\\input\\data.zip";
    String OUTPUT_FOLDER = "D:\\Temp\\AnalyseFonctionnelleEnergie\\output";

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


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelTitleFrame = new JLabel();
        jProgressBarBottom = new JProgressBar();
        jLabelProgress = new JLabel();
        jPanelArchive = new JPanel();
        jButtonParcourirDestination = new JButton();
        jTextFieldDestination = new JTextField();
        jButtonParcourirArchive = new JButton();
        jLabelDestination = new JLabel();
        jButtonUnzip = new JButton();
        jLabelArchive = new JLabel();
        jTextFieldArchive = new JTextField();
        jLabelTitlePanelArchive = new JLabel();
        jButtonUnzipSousFichier = new JButton();
        jButtonDeleteArchives = new JButton();
        jSeparator2 = new JSeparator();
        jPanelData = new JPanel();
        jButtonReadAll = new JButton();
        jButtonReadTen = new JButton();
        jLabelTitleManager = new JLabel();
        jButtonDeleteAll = new JButton();
        jSeparator1 = new JSeparator();
        jPanelChrono = new JPanel();
        jLabelTitlePaneChrono = new JLabel();
        jLabelChrono = new JLabel();
        jTextFieldChrono = new JTextField();
        jPanelRequest = new JPanel();
        jLabelTitlePanelRequest = new JLabel();
        jTabbedPaneRequest = new JTabbedPane();
        jPanelConsoAppareil = new JPanel();
        jLabelTitleConsoAppareil = new JLabel();
        jLabelRechercheAppareil = new JLabel();
        jScrollPaneRechercheAppareil = new JScrollPane();
        jTableRechercheAppareil = new JTable();
        jLabelRechercheConsoAppareil = new JLabel();
        jTextFieldDay = new JTextField();
        jTextFieldMonth = new JTextField();
        jTextFieldYear = new JTextField();
        jButtonConsoObjetByDate = new JButton();
        jLabelTypeAppareil1 = new JLabel();
        jLabelNomAppareil2 = new JLabel();
        jTextFieldTypeAppareil1 = new JTextField();
        jTextFieldNomAppareil2 = new JTextField();
        jLabelMaisonAppareil2 = new JLabel();
        jTextFieldMaisonAppareil1 = new JTextField();
        jLabelConsoTotaleAppareil1 = new JLabel();
        jTextFieldConsoTotaleAppareil2 = new JTextField();
        jPanelClassementApareil = new JPanel();
        jLabelTitreClassementAppareil = new JLabel();
        jLabelClassementApareilTypeAppareil = new JLabel();
        jTextFieldClassementApareilTypeAppareil = new JTextField();
        jLabelClassementApareilNomAppareil = new JLabel();
        jTextFieldClassementApareilNomAppareil = new JTextField();
        jLabelClassementApareilMaisonAppareil = new JLabel();
        jTextFieldClassementApareilMaison = new JTextField();
        jLabelClassementApareilConsoTotaleAppareil = new JLabel();
        jTextFieldClassementApareilConsoTotale = new JTextField();
        jPanelConsoMaisonTotal = new JPanel();
        jLabelClassementMaisonTitle = new JLabel();
        jLabelClassementMaisonRechercheMaison = new JLabel();
        jScrollPaneClassementMaisonRechercheMaison = new JScrollPane();
        jTableClassementMaisonListeMaison = new JTable();
        jLabelClassementMaisonNom = new JLabel();
        jTextFieldClassementMaisonNomMaison = new JTextField();
        jLabelClassementMaisonMaison = new JLabel();
        jTextFieldClassementMaisonConsoTotalMaison = new JTextField();
        jLabelClassementMaisonConsomation = new JLabel();
        jPanelConsoSemaine = new JPanel();
        jLabelConsoSemaineTitre = new JLabel();
        jScrollPaneConsoSemaine = new JScrollPane();
        jTableConsoSemaine = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabelTitleFrame.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitleFrame.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitleFrame.setText("Gestion de données optimisée (DEVIS / ESPRIT / MORENO)");

        jLabelProgress.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelProgress.setText("Progression");

        jPanelArchive.setBorder(BorderFactory.createEtchedBorder());

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
        jLabelTitlePanelArchive.setHorizontalAlignment(SwingConstants.CENTER);
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

        GroupLayout jPanelArchiveLayout = new GroupLayout(jPanelArchive);
        jPanelArchive.setLayout(jPanelArchiveLayout);
        jPanelArchiveLayout.setHorizontalGroup(
                jPanelArchiveLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelArchiveLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitlePanelArchive, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                                .addComponent(jLabelDestination)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldDestination))
                                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                                .addComponent(jLabelArchive)
                                                .addGap(8, 8, 8)
                                                .addComponent(jTextFieldArchive))
                                        .addComponent(jButtonParcourirArchive, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonParcourirDestination, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator2)
                                        .addComponent(jButtonDeleteArchives, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonUnzipSousFichier, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonUnzip, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanelArchiveLayout.setVerticalGroup(
                jPanelArchiveLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelArchiveLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabelTitlePanelArchive)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelArchiveLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldArchive, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelArchive))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonParcourirArchive)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelArchiveLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDestination)
                                        .addComponent(jTextFieldDestination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonParcourirDestination)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jButtonUnzip)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUnzipSousFichier)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDeleteArchives)
                                .addContainerGap())
        );

        jButtonParcourirDestination.getAccessibleContext().setAccessibleName("boutonParcourirDestination");
        jTextFieldDestination.getAccessibleContext().setAccessibleName("textFieldDestination");
        jButtonParcourirArchive.getAccessibleContext().setAccessibleName("boutonParcourirArchive");
        jLabelDestination.getAccessibleContext().setAccessibleName("labelDestination");
        jButtonUnzip.getAccessibleContext().setAccessibleName("boutonUnzip");
        jLabelArchive.getAccessibleContext().setAccessibleName("labelPathArchive");
        jTextFieldArchive.getAccessibleContext().setAccessibleName("textFieldArchive");

        jPanelData.setBorder(BorderFactory.createEtchedBorder());

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
        jLabelTitleManager.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitleManager.setText("Gestion des données");

        jButtonDeleteAll.setText("Supprimer tout les fichiers");
        jButtonDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAllActionPerformed(evt);
            }
        });

        GroupLayout jPanelDataLayout = new GroupLayout(jPanelData);
        jPanelData.setLayout(jPanelDataLayout);
        jPanelDataLayout.setHorizontalGroup(
                jPanelDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDataLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonDeleteAll, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonReadTen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonReadAll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator1)
                                        .addComponent(jLabelTitleManager, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanelDataLayout.setVerticalGroup(
                jPanelDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDataLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitleManager)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonReadAll)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonReadTen)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(jButtonDeleteAll)
                                .addContainerGap())
        );

        jButtonReadAll.getAccessibleContext().setAccessibleName("boutonRead");
        jButtonReadTen.getAccessibleContext().setAccessibleName("boutonReadTen");

        /*-----------------------CHRONOMETRE---------------------------------*/
        jPanelChrono.setBorder(BorderFactory.createEtchedBorder());
        jButtonTest = new JButton("Reinitialiser");
        jLabelTitlePaneChrono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTitlePaneChrono.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitlePaneChrono.setText("Chronomètre");

        jLabelChrono.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelChrono.setText("Temps d'execution :");

        /*Initialisation of timer*/
        ChronoActionListener chronoActionListener = new ChronoActionListener(jLabelDisplayChrono);
        this.timer = new Timer(delais, chronoActionListener);

        jLabelDisplayChrono = new JLabel(chronoActionListener.getHeure() + ":" + chronoActionListener.getMinute() + ":" + chronoActionListener.getSeconde());
        jLabelDisplayChrono.setHorizontalAlignment(SwingConstants.CENTER);


        jButtonTest.addActionListener(new ButtonListener(this.timer, this.jLabelDisplayChrono, chronoActionListener));
//        jTextFieldChrono.setEditable(false);
//        jTextFieldChrono.setHorizontalAlignment(JTextField.CENTER);

        GroupLayout jPanelChronoLayout = new GroupLayout(jPanelChrono);
        jPanelChrono.setLayout(jPanelChronoLayout);
        jPanelChronoLayout.setHorizontalGroup(
                jPanelChronoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelChronoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelChronoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitlePaneChrono, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelChronoLayout.createSequentialGroup()
                                                .addComponent(jLabelChrono, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelDisplayChrono, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonTest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))

                                .addContainerGap())
        );
        jPanelChronoLayout.setVerticalGroup(
                jPanelChronoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelChronoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitlePaneChrono)
                                .addGap(24, 24, 24)
                                .addGroup(jPanelChronoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelChrono)
                                        .addComponent(jLabelDisplayChrono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonTest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        /*---------------------------------------------------------------------*/

        jPanelRequest.setBorder(BorderFactory.createEtchedBorder());

        jLabelTitlePanelRequest.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTitlePanelRequest.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitlePanelRequest.setText("Récupération des données");

        jTabbedPaneRequest.setBorder(BorderFactory.createEtchedBorder());

        jPanelConsoAppareil.setBorder(BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 102, 102)));

        jLabelTitleConsoAppareil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTitleConsoAppareil.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitleConsoAppareil.setText("Consommation d'un appareil pour un jour");

        jLabelRechercheAppareil.setText("Recherche de l'appareil :");

        jTableRechercheAppareil.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPaneRechercheAppareil.setViewportView(jTableRechercheAppareil);
        if (jTableRechercheAppareil.getColumnModel().getColumnCount() > 0) {
            jTableRechercheAppareil.getColumnModel().getColumn(0).setResizable(false);
            jTableRechercheAppareil.getColumnModel().getColumn(1).setResizable(false);
            jTableRechercheAppareil.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabelRechercheConsoAppareil.setText("Recherche de consomation pour l'appariel sélectionné et pour la date : ");

        jTextFieldDay.setHorizontalAlignment(JTextField.CENTER);
        jTextFieldDay.setText("jour");
        jTextFieldDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDayActionPerformed(evt);
            }
        });

        jTextFieldMonth.setHorizontalAlignment(JTextField.CENTER);
        jTextFieldMonth.setText("mois");
        jTextFieldMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMonthActionPerformed(evt);
            }
        });

        jTextFieldYear.setHorizontalAlignment(JTextField.CENTER);
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

        jLabelTypeAppareil1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTypeAppareil1.setText("Type");

        jLabelNomAppareil2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelNomAppareil2.setText("Nom");

        jTextFieldTypeAppareil1.setText("");

        jTextFieldNomAppareil2.setText("");

        jLabelMaisonAppareil2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelMaisonAppareil2.setText("Consommation totale");

        jTextFieldMaisonAppareil1.setText("");

        jLabelConsoTotaleAppareil1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelConsoTotaleAppareil1.setText("Maison");

        jTextFieldConsoTotaleAppareil2.setText("");

        GroupLayout jPanelConsoAppareilLayout = new GroupLayout(jPanelConsoAppareil);
        jPanelConsoAppareil.setLayout(jPanelConsoAppareilLayout);
        jPanelConsoAppareilLayout.setHorizontalGroup(
                jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitleConsoAppareil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPaneRechercheAppareil, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabelRechercheAppareil)
                                                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabelTypeAppareil1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(GroupLayout.Alignment.LEADING, jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabelNomAppareil2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(GroupLayout.Alignment.LEADING, jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabelConsoTotaleAppareil1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabelMaisonAppareil2, GroupLayout.Alignment.LEADING))))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldNomAppareil2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldMaisonAppareil1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldConsoTotaleAppareil2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldTypeAppareil1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                                                .addComponent(jTextFieldDay, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTextFieldMonth, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextFieldYear, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButtonConsoObjetByDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jLabelRechercheConsoAppareil))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelConsoAppareilLayout.setVerticalGroup(
                jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitleConsoAppareil, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelRechercheAppareil)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneRechercheAppareil, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addComponent(jLabelRechercheConsoAppareil)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonConsoObjetByDate))
                                .addGap(23, 23, 23)
                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTypeAppareil1)
                                        .addComponent(jTextFieldTypeAppareil1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNomAppareil2)
                                        .addComponent(jTextFieldNomAppareil2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelConsoAppareilLayout.createSequentialGroup()
                                                .addComponent(jLabelConsoTotaleAppareil1)
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanelConsoAppareilLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelMaisonAppareil2)
                                                        .addComponent(jTextFieldConsoTotaleAppareil2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jTextFieldMaisonAppareil1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jTabbedPaneRequest.addTab("Conso Appareil", jPanelConsoAppareil);

        jPanelClassementApareil.setBorder(BorderFactory.createEtchedBorder());

        jLabelTitreClassementAppareil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTitreClassementAppareil.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitreClassementAppareil.setText("Appareil le plus gourmand lors du dernier mois");

        jLabelClassementApareilTypeAppareil.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelClassementApareilTypeAppareil.setText("Type");

        jTextFieldClassementApareilTypeAppareil.setText("");

        jLabelClassementApareilNomAppareil.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelClassementApareilNomAppareil.setText("Nom");

        jTextFieldClassementApareilNomAppareil.setText("");

        jLabelClassementApareilMaisonAppareil.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelClassementApareilMaisonAppareil.setText("Consommation totale");

        jTextFieldClassementApareilMaison.setText("");

        jLabelClassementApareilConsoTotaleAppareil.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelClassementApareilConsoTotaleAppareil.setText("Maison");

        jTextFieldClassementApareilConsoTotale.setText("");

        GroupLayout jPanelClassementApareilLayout = new GroupLayout(jPanelClassementApareil);
        jPanelClassementApareil.setLayout(jPanelClassementApareilLayout);
        jPanelClassementApareilLayout.setHorizontalGroup(
                jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelClassementApareilLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitreClassementAppareil, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                                        .addGroup(jPanelClassementApareilLayout.createSequentialGroup()
                                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelClassementApareilTypeAppareil, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(GroupLayout.Alignment.LEADING, jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabelClassementApareilNomAppareil, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(GroupLayout.Alignment.LEADING, jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabelClassementApareilConsoTotaleAppareil, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelClassementApareilMaisonAppareil, GroupLayout.Alignment.LEADING))))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldClassementApareilTypeAppareil, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldClassementApareilNomAppareil, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldClassementApareilMaison, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldClassementApareilConsoTotale, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelClassementApareilLayout.setVerticalGroup(
                jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelClassementApareilLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitreClassementAppareil, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClassementApareilTypeAppareil)
                                        .addComponent(jTextFieldClassementApareilTypeAppareil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClassementApareilNomAppareil)
                                        .addComponent(jTextFieldClassementApareilNomAppareil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelClassementApareilLayout.createSequentialGroup()
                                                .addComponent(jLabelClassementApareilConsoTotaleAppareil)
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanelClassementApareilLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelClassementApareilMaisonAppareil)
                                                        .addComponent(jTextFieldClassementApareilConsoTotale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanelClassementApareilLayout.createSequentialGroup()
                                                .addComponent(jTextFieldClassementApareilMaison, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(287, 500, Short.MAX_VALUE))))
        );

        jTabbedPaneRequest.addTab("Classement Appareil", jPanelClassementApareil);

        jPanelConsoMaisonTotal.setBorder(BorderFactory.createEtchedBorder());

        jLabelClassementMaisonTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelClassementMaisonTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelClassementMaisonTitle.setText("Consommation d'une maison sur la dernière heure");

        jLabelClassementMaisonRechercheMaison.setText("Sélection de la maison à analyser");

        jTableClassementMaisonListeMaison.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String[]{
                        "Title 1", "Title 2"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPaneClassementMaisonRechercheMaison.setViewportView(jTableClassementMaisonListeMaison);
        if (jTableClassementMaisonListeMaison.getColumnModel().getColumnCount() > 0) {
            jTableClassementMaisonListeMaison.getColumnModel().getColumn(0).setResizable(false);
            jTableClassementMaisonListeMaison.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabelClassementMaisonNom.setText("Nom");

        jTextFieldClassementMaisonNomMaison.setText("");

        jLabelClassementMaisonMaison.setText("Consommation totale");

        jTextFieldClassementMaisonConsoTotalMaison.setText("");

        jLabelClassementMaisonConsomation.setText("Consomation durant la dernière heure :");

        GroupLayout jPanelConsoMaisonTotalLayout = new GroupLayout(jPanelConsoMaisonTotal);
        jPanelConsoMaisonTotal.setLayout(jPanelConsoMaisonTotalLayout);
        jPanelConsoMaisonTotalLayout.setHorizontalGroup(
                jPanelConsoMaisonTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConsoMaisonTotalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelConsoMaisonTotalLayout.createSequentialGroup()
                                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelClassementMaisonMaison)
                                                        .addComponent(jLabelClassementMaisonNom))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldClassementMaisonNomMaison, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldClassementMaisonConsoTotalMaison))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelConsoMaisonTotalLayout.createSequentialGroup()
                                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelClassementMaisonTitle, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPaneClassementMaisonRechercheMaison, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
                                                .addGap(14, 14, 14))
                                        .addGroup(jPanelConsoMaisonTotalLayout.createSequentialGroup()
                                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelClassementMaisonConsomation)
                                                        .addComponent(jLabelClassementMaisonRechercheMaison))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelConsoMaisonTotalLayout.setVerticalGroup(
                jPanelConsoMaisonTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConsoMaisonTotalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelClassementMaisonTitle)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelClassementMaisonRechercheMaison)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneClassementMaisonRechercheMaison, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelClassementMaisonConsomation)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClassementMaisonNom)
                                        .addComponent(jTextFieldClassementMaisonNomMaison, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelConsoMaisonTotalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClassementMaisonMaison)
                                        .addComponent(jTextFieldClassementMaisonConsoTotalMaison, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jTabbedPaneRequest.addTab("Conso Maison", jPanelConsoMaisonTotal);

        jPanelConsoSemaine.setBorder(BorderFactory.createEtchedBorder());

        jLabelConsoSemaineTitre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelConsoSemaineTitre.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelConsoSemaineTitre.setText("Consommation d'une maison supérieur à la semaine précédente");

        jTableConsoSemaine.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPaneConsoSemaine.setViewportView(jTableConsoSemaine);

        GroupLayout jPanelConsoSemaineLayout = new GroupLayout(jPanelConsoSemaine);
        jPanelConsoSemaine.setLayout(jPanelConsoSemaineLayout);
        jPanelConsoSemaineLayout.setHorizontalGroup(
                jPanelConsoSemaineLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelConsoSemaineLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelConsoSemaineLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPaneConsoSemaine, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                                        .addComponent(jLabelConsoSemaineTitre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanelConsoSemaineLayout.setVerticalGroup(
                jPanelConsoSemaineLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConsoSemaineLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelConsoSemaineTitre)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPaneConsoSemaine, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPaneRequest.addTab("Conso semaine", jPanelConsoSemaine);

        GroupLayout jPanelRequestLayout = new GroupLayout(jPanelRequest);
        jPanelRequest.setLayout(jPanelRequestLayout);
        jPanelRequestLayout.setHorizontalGroup(
                jPanelRequestLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelRequestLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelRequestLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitlePanelRequest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTabbedPaneRequest))
                                .addContainerGap())
        );
        jPanelRequestLayout.setVerticalGroup(
                jPanelRequestLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelRequestLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitlePanelRequest, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPaneRequest)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitleFrame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jPanelData, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jPanelArchive, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jPanelChrono, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jPanelRequest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jProgressBarBottom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelProgress, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitleFrame, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanelRequest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanelArchive, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(jPanelData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)
                                                .addComponent(jPanelChrono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelProgress)
                                .addGap(3, 3, 3)
                                .addComponent(jProgressBarBottom, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
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
        Optimizer opt = new Optimizer(lsQuartier, true, true);
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
