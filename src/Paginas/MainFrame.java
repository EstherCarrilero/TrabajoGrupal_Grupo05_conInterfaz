package Paginas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;
import PaqC05.*;

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
    private JLabel etiError;

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

        //---BOTON MOSTRAR DATOS---
        //Ejemplo para probar
        Hub h1 = new Hub();
        Contenedor c1 = new Contenedor(100, 1500, "España", true, 3, "Nada", "Correos Express", "Alireparte");
        Contenedor c2 = new Contenedor(101, 1501, "España", false, 2, "Nada 2", "Correos Express", "Alireparte");
        h1.apilar(c1);
        h1.apilar(c2);
        botMostrarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contenedor resultado;
                Contenedor correcto = null;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (h1.getM(i, j) != null) {
                            resultado = h1.getM(i, j);
                            if (resultado.getId() == Integer.parseInt(textMostrarDatos.getText())) {
                                correcto = h1.getM(i, j);
                                break;
                            }
                        }
                    }
                }
                if (correcto != null) {
                    etiError.setText("");
                    Pag2 verPag2 = new Pag2(correcto);
                    verPag2.setVisible(true);
                } else {
                    etiError.setText("* Error número de identificador equivocado");
                }
            }
        });
        //BOTON DE CUANTOS
        botCuantos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contenedor c;
                String itemSeleccionado = (String) comboBoxCuantos.getSelectedItem();
                int contador = 0;
                String s = " ";
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (h1.getM(i, j) != null) {
                            c = h1.getM(i, j);
                            if(c.getPais()==itemSeleccionado){
                                contador = contador + 1;
                            }
                        }
                    }
                }
                if (contador!=0) {
                    s = s + contador;
                    textCuantos.setText(s);
                } else {
                    s = s + 0;
                    textCuantos.setText(s);
                }
            }
        });

        //--BOTON DESAPILAR--
        //Ejemplo para probar
        puerto.setP(0, h1);
        textEstado.setText(puerto.getP(0).toString());
        botDesapilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int columna = Integer.parseInt(textDesapilar.getText());
                int numPuerto = puerto.desapilar(columna);

                if(numPuerto == -1){
                    etiError.setText("* No se pudo desapilar");
                }
                else{
                    etiError.setText("Se desapiló correctamente");
                    textEstado.setText(puerto.getP(numPuerto).toString());
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

    }
        //BOTÓN DE CONTAR PAISES


    public static void main(String[] args) {
        MainFrame pag1 = new MainFrame();
    }

}
