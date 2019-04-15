package todo.configuration;

import main.java.todo.ui.MainFrame;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import todo.ui.BoxLayoutPanel;
import todo.ui.button.ActionListenerButton;
import todo.ui.button.AddNewButtonActionListener;
import todo.ui.button.DeleteButtonActionListener;
import todo.ui.button.ListTableActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.peer.ButtonPeer;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class UIConfiguration {
    @Bean("itemList")
    List<String> itemList() {
        List<String> items = new ArrayList<String>();
        items.add("item 1");
        items.add("item 2");
        items.add("item 3");
        return items;
    }

    @Bean(initMethod = "init")
    public MainFrame mainFrame(@Value("#{mainPanel}") BoxLayoutPanel panel) {
        MainFrame frame = new MainFrame();
        frame.setTitle("My To Do List");
        frame.setContentPane(panel);
        return frame;
    }

    @Bean(initMethod = "init")
    public ActionListenerButton deleteButton(
            @Value("#{deleteButtonActionListener}") DeleteButtonActionListener listener) {
        ActionListenerButton deleteButton = new ActionListenerButton();
        deleteButton.setText("Delete");
        deleteButton.setActionListener(listener);
        return deleteButton;
    }

    @Bean(initMethod = "init")
    public ActionListenerButton addNewButton(@Value("#{addNewButtonActionListener}") AddNewButtonActionListener listener) {
        ActionListenerButton addNewButton = new ActionListenerButton();
        addNewButton.setText("Add New");
        addNewButton.addActionListener(listener);

        return addNewButton;
    }

    @Bean("buttonList")
    List<ActionListenerButton> buttonsList(@Value("#{addNewButton}") ActionListenerButton addNewButton, @Value("#{deleteButton}") ActionListenerButton deleteButton) {
        List<ActionListenerButton> buttonsList = new ArrayList<ActionListenerButton>();
        buttonsList.add(addNewButton);
        buttonsList.add(deleteButton);
        return buttonsList;
    }

    @Bean
    int buttonAxis() {
        return 0;
    }

    @Bean
    int panelAxis() {
        return 1;
    }

    @Bean
    BoxLayoutPanel buttonPanel(@Value("#{buttonAxis}") int axis, @Value("#{buttonList}") List components) {
        BoxLayoutPanel buttonPanel = new BoxLayoutPanel();
        buttonPanel.setAxis(axis);
        buttonPanel.setPanelComponents(components);
        return buttonPanel;
    }

    @Bean
    List<Object> panelComponents(@Value("#{itemScrollPane}") Component scrollPane, @Value("#{buttonPanel}")Component buttonPanel){
        List<Object> list = new ArrayList<Object>();
        list.add(scrollPane);
        list.add(buttonPanel);
        return list;
    }

    @Bean("mainPanel")
    BoxLayoutPanel mainPanel (@Value("#{panelAxis}") int axis, @Value("#{panelComponents}") List components){
        BoxLayoutPanel  mainPanel = new BoxLayoutPanel();
        mainPanel.setPanelComponents(components);
        mainPanel.setAxis(axis);
        return mainPanel;
    }
}
