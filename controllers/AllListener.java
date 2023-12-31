package controllers;

import service.ShopService;
import view.AppView;
import javax.swing.*;

public class AllListener  {
    public AllListener(JPanel panel, AppView appView,ShopService shopService,JButton back) {
        //Обработка событый для кнопоки Catalog
        panel.getComponent(0).addMouseListener(new CatalogListener(panel,appView,shopService,back));
        //Обработка событый для кнопоки Cart
        panel.getComponent(1).addMouseListener(new CartListener(panel,appView,back));
        //Обработка событый для кнопоки Order
        panel.getComponent(2).addMouseListener(new OrderListener(panel,appView,back,shopService));
    }
}
