package org.vaadin.example;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;

public class VistaAlta extends VerticalLayout {
    ArrayList<Parametro> listaParametros = new ArrayList<>();
    public VistaAlta()
    {

    }

    public void mostrar()
    {
        removeAll();
        HorizontalLayout horizontal= new HorizontalLayout();

        Label etiqueta1 = new Label("Parametro 1");
        TextField texto1 = new TextField();
        Label etiqueta2 = new Label("Parametro 2");
        TextField texto2 = new TextField();


        Button boton = new Button("Añadir");
//Corregido y hecho
        boton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                ArrayList<Parametro> listaAux = new ArrayList<>();

                Parametro objeto = new Parametro(texto1.getValue(),texto2.getValue());
                listaAux = DataService.aniadirDatosLista(objeto, listaAux);


                texto1.setValue("");
                texto2.setValue("");

            }
        });

        horizontal.add(etiqueta1, texto1, etiqueta2);
        this.add(horizontal,boton);
    }
}
