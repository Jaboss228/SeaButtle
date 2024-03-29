package mvc.panels;

import mvc.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelButtons extends JPanel {
    private View view;
    private JTextField infoField;
    private JButton startGameButton;
    private JButton exitButton;
    private JButton restartGameButton;

    public PanelButtons(View view) {
        this.view = view;
        setLayout(null);
        setPreferredSize(new Dimension(400, 50));
        infoField = new JTextField();
        setTextInfo("РАССТАВЛЯЕМ КОРАБЛИ");
        infoField.setEnabled(false);
        infoField.setBounds(10, 15, 180, 20);
        startGameButton = new JButton("Начать игру");
        startGameButton.setBounds(210, 5, 150, 40);
        startGameButton.addActionListener(new ActionButtonStartClass());
        exitButton = new JButton("Прервать и выйти");
        exitButton.setBounds(370, 5, 150, 40);
        exitButton.addActionListener(new ActionButtonDisconnect());
        exitButton.setEnabled(false);
        restartGameButton = new JButton("Играть еще");
        restartGameButton.setBounds(530, 5, 150, 40);
        restartGameButton.setEnabled(false);
        restartGameButton.addActionListener(new ActionButtonRestartGame());
        add(infoField);
        add(startGameButton);
        add(exitButton);
        add(restartGameButton);
    }

    public JButton getRestartGameButton() {
        return restartGameButton;
    }

    public JButton getStartGameButton() {
        return startGameButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setTextInfo(String text) {
        infoField.setText(text.toUpperCase());
    }

    //класс слушатель для кнопки "Начать игру"
    private class ActionButtonStartClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.startGame();
        }
    }

    //класс слушатель для кнопки отключения
    private class ActionButtonDisconnect implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.disconnectGameRoom();
            exitButton.setEnabled(false);
            restartGameButton.setEnabled(true);
        }
    }

    //класс слушатель для кнопики "играть еще"
    private class ActionButtonRestartGame implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.init();
        }
    }
}