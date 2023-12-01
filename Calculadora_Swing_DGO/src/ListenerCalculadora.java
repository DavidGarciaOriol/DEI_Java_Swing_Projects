import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerCalculadora implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
    }
}
