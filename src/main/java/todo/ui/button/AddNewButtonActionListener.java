package todo.ui.button;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

@Component("addNewButtonActionListener")
public class AddNewButtonActionListener extends
        ListTableActionListener {

    public void actionPerformed(ActionEvent e) {
        list.add("New Item");
        table.revalidate();
    }
}