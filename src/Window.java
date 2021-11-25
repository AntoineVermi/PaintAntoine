import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Window extends JFrame {
    public Window(String Title,int x,int y){ // Création du constructeur qui créé une fenêtre

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame(Title);
        JPanel panelButton = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane() ;

        // Création de la barre des menus
        JMenuBar menuBar = new JMenuBar(); // Création de la barre des menus


        // Création d'une nouvelle zone de dessin
        Drawing dessin = new Drawing(); // On crée l'objet dessin pour dessiner les futures formes


        // Création du menu Fichier
        JMenu fichierMenu = new JMenu("Fichier");
        JMenuItem item = null;

        // Création d'un bouton Nouveau
        item = new JMenuItem("Nouveau");
        item.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.resetDrawing();
            }
        });
        fichierMenu.add(item); // On rajoute Nouveau au menu Fichier
        fichierMenu.insertSeparator(1);

        /**A faire : Création d'un bouton Ouvrir**/
        //JMenuItem itemOpen = new JMenuItem("Ouvrir") ;


        /**A faire : Création d'un bouton Sauvegarder**/
        //JMenuItem itemSave = new JMenuItem("Sauvegarder") ;



        // Création d'un bouton Quitter
        JMenuItem itemQuit = new JMenuItem("Quitter") ; // Création d'un item Quitter
        itemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        itemQuit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        fichierMenu.add(itemQuit);
        menuBar.add(fichierMenu);


        // Menu A Propos
        JMenu aproposMenu = new JMenu("À Propos");
        JMenu aproposCreateur = new JMenu("Créateur");
        JMenu aproposEcole = new JMenu("Ecole");
        JMenuItem buttonCreateur = new JMenuItem("Antoine VERMILLARD"); //
        JMenuItem buttonEcole = new JMenuItem("ENSEA");
        aproposCreateur.add(buttonCreateur);
        aproposEcole.add(buttonEcole);
        aproposMenu.add(aproposCreateur);
        aproposMenu.add(aproposEcole);
        menuBar.add(aproposMenu);


        // Création des boutons

        //Boutons couleurs

        //Bouton Noir
        JButton buttonNoir = new JButton("Noir");
        buttonNoir.setBackground(Color.black);
        buttonNoir.setForeground(Color.white);
        buttonNoir.setOpaque(true);
        buttonNoir.setBorderPainted(false);
        buttonNoir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setColor(Color.black); // On indique que la couler à utiliser est le noir
            }
        });

        //Bouton Rouge
        JButton buttonRouge = new JButton("Rouge");
        buttonRouge.setBackground(Color.red);
        buttonRouge.setOpaque(true);
        buttonRouge.setBorderPainted(false);
        buttonRouge.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setColor(Color.red);
            }
        });

        //Bouton Vert
        JButton buttonVert = new JButton("Vert");
        buttonVert.setBackground(Color.green);
        buttonVert.setOpaque(true);
        buttonVert.setBorderPainted(false);
        buttonVert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setColor(Color.green);
            }
        });

        //Bouton Bleu
        JButton buttonBleu = new JButton("Bleu");
        buttonBleu.setBackground(Color.blue);
        buttonBleu.setForeground(Color.white);
        buttonBleu.setOpaque(true);
        buttonBleu.setBorderPainted(false);
        buttonBleu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setColor(Color.blue);
            }
        });

        //Bouton Jaune
        JButton buttonJaune = new JButton("Jaune");
        buttonJaune.setBackground(Color.yellow);
        buttonJaune.setOpaque(true);
        buttonJaune.setBorderPainted(false);
        buttonJaune.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setColor(Color.yellow);
            }
        });

        //Bouton Rose
        JButton buttonRose = new JButton("Rose");
        buttonRose.setBackground(Color.pink);
        buttonRose.setOpaque(true);
        buttonRose.setBorderPainted(false);
        buttonRose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setColor(Color.pink);
            }
        });

        //Bouton Magenta
        JButton buttonMagenta = new JButton("Magenta");
        buttonMagenta.setBackground(Color.magenta);
        buttonMagenta.setOpaque(true);
        buttonMagenta.setBorderPainted(false);
        buttonMagenta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setColor(Color.magenta);
            }
        });

        //Bouton Orange
        JButton buttonOrange = new JButton("Orange");
        buttonOrange.setBackground(Color.orange);
        buttonOrange.setOpaque(true);
        buttonOrange.setBorderPainted(false);
        buttonOrange.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setColor(Color.orange);
            }
        });

        //Bouton Forme

        //Bouton Ellipse
        JButton buttonEllipse = new JButton("Ellipse");
        buttonEllipse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setNextFigure("Ellipse"); // On indique que le prochain dessin est une ellipse
            }
        });

        //Bouton Cercle
        JButton buttonCercle = new JButton("Cercle");
        buttonCercle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setNextFigure("Cercle");
            }
        });

        //Bouton Rectangle
        JButton buttonRectangle = new JButton("Rectangle");
        buttonRectangle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setNextFigure("Rectangle");
            }
        });

        //Bouton Carre
        JButton buttonCarre = new JButton("Carré");
        buttonCarre.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dessin.setNextFigure("Carre");
            }
        });

        // Création d'une grille de boutons de 2 lignes et 6 colonnes pour le GUI
        panelButton.setLayout(new GridLayout(2, 6));
        panelButton.add(buttonNoir);
        panelButton.add(buttonRouge);
        panelButton.add(buttonVert);
        panelButton.add(buttonBleu);
        panelButton.add(buttonEllipse);
        panelButton.add(buttonCercle);
        panelButton.add(buttonJaune);
        panelButton.add(buttonRose);
        panelButton.add(buttonMagenta);
        panelButton.add(buttonOrange);
        panelButton.add(buttonRectangle);
        panelButton.add(buttonCarre);


        // Ajout des éléments dans le GUI
        contentPanel.add(menuBar,  BorderLayout.NORTH); // Ajout de la barre des menus en haut du GUI
        contentPanel.add(dessin); // Ajout du dessin
        contentPanel.add(panelButton, BorderLayout.SOUTH); // Ajout des boutons au bas du GUI


        // Affichage du GUI
        frame.add(contentPanel);
        frame.pack();
        frame.setSize(x,y); // Taille de la fenêtre
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Window("Paint",800,600);
    }

}
