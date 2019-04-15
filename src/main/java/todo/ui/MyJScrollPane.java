package todo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component("itemScrollPane")
public class MyJScrollPane extends JScrollPane {


    @Autowired
    public MyJScrollPane(MyJTable myJTable) {
        super(myJTable);
    }
}
