package view;


import service.ShopService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogView extends AppView {
    final ShopService shopService; //Используеться для возвращения каталога

    public CatalogView(ShopService shopService, ArrayList<AppView> children) {
        super( "Catalog",children);
        this.shopService = shopService;
    }

    //Реакция CatalogView.getJButton выводит в окно (AddToCart,shopService.getCatalog())
    public  ArrayList<Component> getChildrenArrButtons(){
        ArrayList<Component> arrayList = new ArrayList<>();
        JButton jButton = new JButton(children.get(0).title); //Оброщаемся к названию ребенка и создаем кнопку (AddToCart)
        for (int i = 0; i < shopService.getCatalog().size(); i++) {
            arrayList.add(shopService.getCatalog().get(i));  //Добовляем товары полученные из каталога
        }
        arrayList.add(jButton);
        return arrayList;
    }

    //Метод для получения основной кнопки класса. Опять он!
    @Override
    public JButton getJButton() {
        JButton jButton = new JButton(title);
        return jButton;
    }
}
