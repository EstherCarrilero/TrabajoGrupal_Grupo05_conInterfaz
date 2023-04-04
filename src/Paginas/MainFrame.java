package Paginas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class MainFrame extends JFrame{
    private JPanel mainPanel;
    private JTextField textEmpRemitente;
    private JTextField textEmpReceptora;
    private JTextField textPeso;
    private JTextArea textDescContent;
    private JComboBox comboBoxPais;
    private JRadioButton botPrioridad1;
    private JRadioButton botPrioridad2;
    private JRadioButton botPrioridad3;
    private JCheckBox checkBoxAduana;
    private JTextArea textEstado;
    private JButton botApilar;
    private JButton botDesapilar;
    private JButton botMostrarDatos;
    private JButton botCuantos;
    private JTextField textDesapilar;
    private JTextField textMostrarDatos;
    private JComboBox comboBoxCuantos;
    private JTextField textCuantos;
    private JLabel etiNumIdentificacion;
    private JTextField textNumIdentificacion;
    private JLabel etiPeso;
    private JLabel etiDescContent;
    private JLabel etiEmpRemitente;
    private JLabel etiEmpReceptora;
    private JLabel etiOperaciones;
    private JLabel etiPais;
    private JLabel etiPrioridad;
    private JLabel etiEstado;
    private JPanel panelOperaciones;
    private JLabel labNumIDMAL;
    private JLabel labPesoMAL;
    private JLabel etiLogo;

    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("Gestión de contadores");
        setSize(1300,650);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //---BOTONES DE PRIORIDAD---
        ButtonGroup botones = new ButtonGroup();
        botones.add(botPrioridad1);
        botones.add(botPrioridad2);
        botones.add(botPrioridad3);

        //---BOTON MOSTRAR DATOS---
        botMostrarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pag2 verPag2 = new Pag2();
                verPag2.setVisible(true);
            }
        });

        //---CONTROLA NUMERO DE IDENTIFICACION---
        textNumIdentificacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if(((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '\n')){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"El dato no es numérico, vuelve a introducirlo");
                }
            }
        });

        //---CONTROLA PESO---
        textPeso.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if(((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '\n')){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"El dato no es numérico, vuelve a introducirlo");
                }
            }
        });

        //---CONTROLA DESCRIPCION DEL CONTENIDO---
        textDescContent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(textDescContent.getText().length() >= 100){
                    e.consume();
                }
            }
        });

        //---CONTROLA EMPRESA REMITENTE---
        textEmpRemitente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(textEmpRemitente.getText().length() >= 20){
                    e.consume();
                }
            }
        });

        //---CONTROLA EMPRESA RECEPTORA---
        textEmpReceptora.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(textEmpReceptora.getText().length() >= 20){
                    e.consume();
                }
            }
        });

        //---CONTROLA NUMERO DE COLUMNA EN DESAPILAR---
        textDesapilar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if(((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '\n')){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"El dato no es numérico, vuelve a introducirlo");
                }
            }
        });

        //---CONTROLA ID DE CONTENEDOR EN MOSTRAR DATOS---
        textMostrarDatos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if(((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '\n')){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"El dato no es numérico, vuelve a introducirlo");
                }
            }
        });
    }

    public static void main(String[] args) {
        MainFrame pag1 = new MainFrame();
    }

}
