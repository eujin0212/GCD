package com.eujin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.lang.*;
import javax.swing.border.TitledBorder;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int x,y,r;
    public static Main main = new Main();
    private JFrame mainFrame;
    private JButton calculate, clear;
    static JTextArea textArea;
    private JPanel inputPanel, btnPanel, outputPanel;
    private JLabel label,label2, labelInt1, lableInt2 , labelGCD, spacing;
    private TitledBorder inputBorder, btnBorder, outputBorder, textAreaBorder;
    private JTextField xText, yText, gcd;
    private JScrollPane scrollPane;

    public void showGUI() {
        mainFrame = new JFrame("GCD Calculator");
        mainFrame.setSize(450,420);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(3);

        label = new JLabel("Welcome to GCD Calculator",SwingConstants.CENTER);
        label.setBounds(0,5,400,30);
        label.setFont(label.getFont().deriveFont(13f));
        label2 = new JLabel("GCD is calclated using the Euclidean Algorithm",SwingConstants.CENTER);
        label2.setFont(label2.getFont().deriveFont(13f));
        label2.setBounds(0,25,450,30);
        labelInt1 = new JLabel("X :");
        labelInt1.setPreferredSize(new Dimension(20,25));
        lableInt2 = new JLabel("Y :");
        lableInt2.setPreferredSize(new Dimension(20,25));
        labelGCD = new JLabel("GCD :");
        spacing = new JLabel();
        spacing.setPreferredSize(new Dimension(10,25));
        xText = new JTextField();
        xText.setPreferredSize(new Dimension(165,25));
        xText.setHorizontalAlignment(JTextField.CENTER);
        yText = new JTextField();
        yText.setPreferredSize(new Dimension(165,25));
        yText.setHorizontalAlignment(JTextField.CENTER);
        gcd = new JTextField();
        gcd.setPreferredSize(new Dimension(165,25));
        gcd.setHorizontalAlignment(JTextField.CENTER);
        gcd.setEditable(false);


        calculate = new JButton("Calculate");
        calculate.setPreferredSize(new Dimension(200,25));
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a,b;
                textArea.setText("");
                a = xText.getText();
                b = yText.getText();
                x = Integer.parseInt(a);
                y = Integer.parseInt(b);
                int result = gcd(x,y);
                gcd.setText(String.valueOf(result));
                gcdFormula(x,y);
            }
        });

        clear = new JButton("Clear");
        clear.setPreferredSize(new Dimension(200,25));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xText.setText("");
                yText.setText("");
                gcd.setText("");
                textArea.setText("");
            }
        });

        inputBorder = new TitledBorder("User Input");
        inputPanel = new JPanel();
        inputPanel.setBounds(10,50,420,60);
        inputPanel.setBorder(inputBorder);
        inputPanel.add(labelInt1);
        inputPanel.add(xText);
        inputPanel.add(spacing);
        inputPanel.add(lableInt2);
        inputPanel.add(yText);

        btnBorder = new TitledBorder("Choose Action");
        btnPanel = new JPanel();
        btnPanel.setBounds(10,110,420,60);
        btnPanel.setBorder(btnBorder);
        btnPanel.add(calculate);
        btnPanel.add(clear);
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        textArea = new JTextArea();
        textArea.setForeground(Color.black);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setMargin( new Insets(5,10,5,10) );
        scrollPane = new JScrollPane (textArea);
        scrollPane.setPreferredSize(new Dimension(400,135));
        textAreaBorder = new TitledBorder("Calculation Steps");
        scrollPane.setBorder(textAreaBorder);

        outputBorder = new TitledBorder("Calculation Result");
        outputPanel = new JPanel();
        outputPanel.setBounds(10,170,420,200);
        outputPanel.setBorder(outputBorder);
        outputPanel.add(labelGCD);
        outputPanel.add(gcd);
        outputPanel.add(scrollPane);
        outputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);



        mainFrame.add(label);
        mainFrame.add(label2);
        mainFrame.add(inputPanel);
        mainFrame.add(btnPanel);
        mainFrame.add(outputPanel);
        mainFrame.setVisible(true);
    }

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }

    public static void gcdFormula(int a, int b)
    {
        if (a>b){
            if (b == 0){

            }else{
                //System.out.println(a + "=" + a/b + "(" + b + ")" + "+" + (a-((a/b)*b)));
                textArea.append(a + "=" + a/b + "(" + b + ")" + "+" + (a-((a/b)*b))+"\n");
                gcdFormula(b%a, (a-((a/b)*b)));
            }

        }else{
            //System.out.println(a + "=" + a/b + "(" + b + ")" + "+" + a);
            textArea.append(a + "=" + a/b + "(" + b + ")" + "+" + a +"\n");
            gcdFormula(b, a);
        }
    }

    public static void main(String[] args){

        main.showGUI();

    }

}

// Code Contributed by Mohit Gupta_OMG <(0_o)>

