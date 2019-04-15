package todo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.TableModel;

@Component("itemTable")
public class MyJTable extends JTable {

    @Autowired
    public MyJTable(ItemTableModel dm) {
        super(dm);
    }

}
