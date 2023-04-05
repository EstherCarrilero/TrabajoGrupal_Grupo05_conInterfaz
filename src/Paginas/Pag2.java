package Paginas;

import javax.swing.*;
import PaqC05.*;
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

    public Pag2(Contenedor c){
        setContentPane(pag2Panel);
        setTitle("Gestión de contadores");
        setSize(1200,600);
        setVisible(true);

        //---BOTONES DE PRIORIDAD---
        ButtonGroup botones = new ButtonGroup();
        botones.add(botPrioridad1);
        botones.add(botPrioridad2);
        botones.add(botPrioridad3);

        //---MUESTRA DE IDENTIFICACIÓN ---
        textNumIdentificacion.setText(String.valueOf(c.getId()));

        //---MUESTRA DE PESO ---
        textPeso.setText(String.valueOf(c.getPeso()));

        //---MUESTRA DE DESCRIPCIÓN---
        textDescContent.setText(c.getDescripcion());

        //---MUESTRA DE EMPRESA REMITENTE---
        textEmpRemitente.setText(c.getEmpresaRemitente());

        //---MUESTRA DE EMPRESA RECEPTORA---
        textEmpReceptora.setText(c.getEmpresaReceptora());

        //---MUESTRA DE PAÍS---
        textPais.setText(c.getPais());

        //---MUESTRA DE PRIORIDAD---
        int prio=c.getPrioridad();

        if (prio==1){
            botPrioridad1.setSelected(true);
        }else if (prio==2){
            botPrioridad2.setSelected(true);
        }else{
            botPrioridad3.setSelected(true);
        }

        //---MUESTRA DE ADUANAS ---
        checkBoxAduana.setSelected(c.getInspeccionado());
    }

}
