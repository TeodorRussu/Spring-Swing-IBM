package todo;

import org.springframework.context.ApplicationContext;
import
        org.springframework.context.support.ClassPathXmlApplicationContext;
import main.java.todo.ui.MainFrame;

public class Launcher {
    public void launch() {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        MainFrame frame = (MainFrame)context.getBean("mainFrame");
    }
}