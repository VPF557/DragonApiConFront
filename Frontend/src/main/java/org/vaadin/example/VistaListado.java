package org.vaadin.example;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class VistaListado extends VerticalLayout {
    ArrayList<Parametro> listaParametro = new ArrayList<>();
    public VistaListado()
    {

    }
    public void mostrar()
    {
        removeAll();
        HorizontalLayout horizontal= new HorizontalLayout();
        ArrayList<Parametro> listaParams = new ArrayList<>();
        ArrayList<Parametro> listaAux = new ArrayList<>();

        Grid<Parametro> grid = new Grid<>(Parametro.class, false);
        grid.addColumn(Parametro::getParameter1).setHeader("Parametro 1");
        grid.addColumn(Parametro::getParameter2).setHeader("Parametro 2");


        GridContextMenu<Parametro> menu = grid.addContextMenu();
        menu.setOpenOnClick(true);
        menu.addItem("Delete", event ->
        {
            grid.setItems(DataService.eliminarParam(event.getItem().get(),listaAux));
        });
        grid.setAllRowsVisible(true);
        this.add(grid);
        add(horizontal);

       try {
           listaParams = DataService.getProductos(listaParams);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        grid.setItems(listaParams);

        this.add(horizontal,grid);
    }

}