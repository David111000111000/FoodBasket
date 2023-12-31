package controllers;

import service.ShopService;
import view.AppView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class OrderListener implements MouseListener {
    private final JPanel panel;
    private final AppView appView;
    private final JButton back; //Кнопка возрощающая нас на главный экран уже не раз видели :)
    private final ShopService shopService; //Очень важное поле(Создает заказ!)

    public OrderListener(JPanel panel, AppView appView, JButton back, ShopService shopService) {
        this.shopService = shopService;
        this.back = back;
        this.panel = panel;
        this.appView = appView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        panel.removeAll();
        panel.setVisible(false);
        panel.setVisible(true);

        //Записываем в переменные значения введенные пользователем!
        JTextField input1 = ((JTextField) appView.children.get(2).getChildrenArrButtons().get(1));
        JTextField input2 = (JTextField) appView.children.get(2).getChildrenArrButtons().get(3);

        //Добавляем кнопки (OrderView.getChildrenArrButtons)
        for (int i = 0; i <= appView.children.get(2).getChildrenArrButtons().size(); i += 2) {
            panel.add(appView.children.get(2).getChildrenArrButtons().get(i));
            if (i == 0) {
                panel.add(input1);
            }
            if (i == 2) {
                panel.add(input2);
            }
        }
        //Слушатель мыши для кнопки Enter
        panel.getComponent(panel.getComponentCount()-1).addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                shopService.createOrder(input1.getText(), input2.getText());
                back.doClick(); // Поступаем по умному :)
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        panel.add(back);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}