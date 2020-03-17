package com.java.book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JRestoreCalculator extends JFrame implements ItemListener {
    final int BASE_PRICE = 200;
    final int WEEKEND_PREMIUM = 100;
    final int BREAKFAST_PREMIUM = 20;
    final int GOLF_PREMIUM = 75;
    int totalTotal = BASE_PRICE;
    JCheckBox weekend = new JCheckBox("Weekend premium $" + WEEKEND_PREMIUM, false);
    JCheckBox breakFast = new JCheckBox("Breakfast $ " + BREAKFAST_PREMIUM,false);
    JCheckBox golf = new JCheckBox("Gold $" + GOLF_PREMIUM,false);
    JLabel resortLabel = new JLabel("Resort Price Calculator");
    JLabel priceLabel = new JLabel("The Price for your stay is ");
    JTextField totPrice = new JTextField(6);
    JLabel optionExplainLabel = new JLabel("Base Price for the room is $" + BASE_PRICE + ".");
    JLabel optionExplainLabel2 = new JLabel("Check the options you want");
    public JRestoreCalculator()
    {
        super("Resort Price Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(resortLabel);
        add(optionExplainLabel);
        add(optionExplainLabel2);
        add(weekend);
        add(breakFast);
        add(golf);
        add(priceLabel);
        add(totPrice);
        totPrice.setText("$" + totalTotal);
        weekend.addItemListener(this);
        breakFast.addItemListener(this);
        golf.addItemListener(this);


    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        int select = e.getStateChange();
        System.out.println(select);
        if (source == weekend)
            if ( select == ItemEvent.SELECTED)
            {
                System.out.println(ItemEvent.SELECTED);
                totalTotal += WEEKEND_PREMIUM;
            }
            else
                totalTotal -= WEEKEND_PREMIUM;
            else if (source == breakFast)
            if ( select == ItemEvent.SELECTED)
            {
                System.out.println(ItemEvent.SELECTED);
                totalTotal += BREAKFAST_PREMIUM;
            }

            else
                totalTotal -= BREAKFAST_PREMIUM;
        else if (source == golf)
            if ( select == ItemEvent.SELECTED)
                totalTotal += GOLF_PREMIUM;
            else
                totalTotal -= GOLF_PREMIUM;
            totPrice.setText("$" + totalTotal);



    }
}
