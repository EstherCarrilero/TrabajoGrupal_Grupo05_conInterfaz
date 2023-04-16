package Paginas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;
import PaqC05.*;

public class MainFrame extends JFrame{
    Hub hub1 = new Hub();
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
    private JLabel etiError;
    private JRadioButton botHub1;
    private JRadioButton botHub2;
    private JRadioButton botHub3;
    private JLabel etiHub;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Gestión de contadores");
        setSize(1300, 650);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Puerto puerto = new Puerto();
        textEstado.setText(puerto.getP(0).toString());

        //---BOTONES DE PRIORIDAD---
        ButtonGroup botones = new ButtonGroup();
        botones.add(botPrioridad1);
        botones.add(botPrioridad2);
        botones.add(botPrioridad3);

        //---BOTONES DE HUB---
        ButtonGroup botones_hub = new ButtonGroup();
        botones_hub.add(botHub1);
        botones_hub.add(botHub2);
        botones_hub.add(botHub3);



        //---BOTON MOSTRAR DATOS---
        botMostrarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(textMostrarDatos.getText(), "")){
                    etiError.setText("* Error no hay número de identificador");
                }
                else{
                    Contenedor C = puerto.mostrarDatos_puerto(Integer.parseInt(textMostrarDatos.getText()));
                    if (C != null) {
                        etiError.setText("");
                        Pag2 verPag2 = new Pag2(C);
                        verPag2.setVisible(true);
                    }
                    else {
                        etiError.setText("* Error número de identificador equivocado");
                    }
                }
            }
        });

        //BOTON DE CUANTOS
        botCuantos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemSeleccionado = (String) comboBoxCuantos.getSelectedItem();
                textCuantos.setText(String.valueOf(puerto.totalPaisPuerto(itemSeleccionado)));
            }
        });

        //--BOTON DESAPILAR--
        botDesapilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(textDesapilar.getText(), "")){
                    etiError.setText("* Error no hay columna");
                }
                else{
                    int numero = 0;
                    if (botHub1.isSelected()){
                        numero= 0;
                    }
                    else if (botHub2.isSelected()){
                        numero= 1;
                    }
                    else if (botHub3.isSelected()){
                        numero= 2;
                    }

                    int columna = Integer.parseInt(textDesapilar.getText());
                    boolean estado = puerto.desapilar(columna);

                    if(estado == false){
                        etiError.setText("* No se pudo desapilar");
                    }
                    else{
                        etiError.setText(" ");
                        textEstado.setText(puerto.getP(numero).toString());
                    }
                }
            }
        });

        //---CONTROLA NUMERO DE IDENTIFICACION---
        textNumIdentificacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '\n')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "El dato no es numérico, vuelve a introducirlo");
                }
            }
        });

        //---CONTROLA PESO---
        textPeso.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '\n')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "El dato no es numérico, vuelve a introducirlo");
                }
            }
        });

        //---CONTROLA DESCRIPCION DEL CONTENIDO---
        textDescContent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (textDescContent.getText().length() >= 100) {
                    e.consume();
                }
            }
        });

        //---CONTROLA EMPRESA REMITENTE---
        textEmpRemitente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (textEmpRemitente.getText().length() >= 20) {
                    e.consume();
                }
            }
        });

        //---CONTROLA EMPRESA RECEPTORA---
        textEmpReceptora.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (textEmpReceptora.getText().length() >= 20) {
                    e.consume();
                }
            }
        });

        //---CONTROLA NUMERO DE COLUMNA EN DESAPILAR---
        textDesapilar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '\n')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "El dato no es numérico, vuelve a introducirlo");
                }
            }
        });

        //---CONTROLA ID DE CONTENEDOR EN MOSTRAR DATOS---
        textMostrarDatos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '\n')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "El dato no es numérico, vuelve a introducirlo");
                }
            }
        });


        //---BOTON APILAR---
        botApilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int prio= 0;
                boolean T;
                int id = Integer.parseInt(textNumIdentificacion.getText());
                int peso = Integer.parseInt(textPeso.getText());

                int numero = 0;
                if (botHub1.isSelected()){
                    numero= 0;
                }
                else if (botHub2.isSelected()){
                    numero= 1;
                }
                else if (botHub3.isSelected()){
                    numero= 2;
                }

                if (botPrioridad1.isSelected()){
                    prio= 1;
                }
                else if (botPrioridad2.isSelected()){
                    prio= 2;
                }
                else if (botPrioridad3.isSelected()){
                    prio= 3;
                }

                if (checkBoxAduana.isSelected()){
                    T = true;
                }
                else {
                    T=false;
                }
                Contenedor C = new Contenedor(id,peso, comboBoxPais.getSelectedItem().toString(), T, prio, textDescContent.getText(), textEmpRemitente.getText(), textEmpReceptora.getText());
                ;
               boolean A =  puerto.apilar(C);
               if (A == false){
                   etiError.setText("* No se ha podido apilar");
               }else{
                   etiError.setText(" ");
               }
                textEstado.setText(puerto.getP(numero).toString());
            }
        });

        botHub1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textEstado.setText(puerto.getP(0).toString());
            }
        });
        botHub2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textEstado.setText(puerto.getP(1).toString());
            }
        });
        botHub3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textEstado.setText(puerto.getP(2).toString());
            }
        });
    }

    public static void main(String[] args) {
        MainFrame pag1 = new MainFrame();
    }

}
