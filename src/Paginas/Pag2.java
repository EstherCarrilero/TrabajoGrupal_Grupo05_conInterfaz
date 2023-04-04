package Paginas;

import javax.swing.*;

public class Pag2 extends JFrame{
    private JTextField textNumIdentificacion;
    private JTextField textPeso;
    private JTextField textEmpRemitente;
    private JTextField textEmpReceptora;
    private JTextField textPais;
    private JRadioButton botPrioridad1;
    private JRadioButton botPrioridad2;
    private JRadioButton botPrioridad3;
    private JTextArea textDescContent;
    private JCheckBox checkBoxAduana;
    private JLabel etiNumIdentificacion;
    private JLabel etiPeso;
    private JLabel etiDescContent;
    private JLabel etiEmpRemitente;
    private JLabel etiEmpReceptora;
    private JLabel etiPais;
    private JLabel etiPrioridad;
    private JPanel pag2Panel;

    public Pag2(){
        setContentPane(pag2Panel);
        setTitle("Gestión de contadores");
        setSize(1200,600);
        setVisible(true);

        //---BOTONES DE PRIORIDAD---
        ButtonGroup botones = new ButtonGroup();
        botones.add(botPrioridad1);
        botones.add(botPrioridad2);
        botones.add(botPrioridad3);
    }

}
