package com.uga.energie.controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lenovo on 28/06/2016.
 */
public class ButtonListener implements ActionListener {
    public static final String RESET = 0 + ":" + 0 + ":" + 0;
    private final Timer timer;
    private JLabel jLabelDisplayChrono;
    private ChronoActionListener chronoActionListener;
    private boolean isRunning;

    public ButtonListener(Timer timer, JLabel jLabelDisplayChrono, ChronoActionListener chronoActionListener) {
        this.timer = timer;
        this.jLabelDisplayChrono = jLabelDisplayChrono;
        this.chronoActionListener = chronoActionListener;
        this.isRunning = timer.isRunning();
    }

    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("Reinitialiser")) {
//            this.timer.start();
            if (this.isRunning) {
                this.timer.stop();
                this.isRunning = false;
            }
            resetChronometer();
            jLabelDisplayChrono.setText(getChronometerValue());
        }
    }

    private String getChronometerValue() {
        return chronoActionListener.getHeure() + ":" + chronoActionListener.getMinute() + ":" + chronoActionListener.getSeconde();
    }

    private void resetChronometer() {
        chronoActionListener.setHeure(0);
        chronoActionListener.setMinute(0);
        chronoActionListener.setSeconde(0);
    }

    public Timer getTimer() {
        return timer;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
