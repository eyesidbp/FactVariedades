package Images;

//Esta clase permite almacenar los iconos que se van a utilizar en la interfaz grafica
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Iconos {

    Icon OkIcon = new ImageIcon(getClass().getResource("like.png"));
    Icon BadIcon = new ImageIcon(getClass().getResource("unlike.png"));
    Icon handIcon = new ImageIcon(getClass().getResource("hand.png"));
    Icon cancelIcon = new ImageIcon(getClass().getResource("cancel.png"));
    Icon questionIcon = new ImageIcon(getClass().getResource("pregunta.png"));
    Icon cancel1Icon = new ImageIcon(getClass().getResource("Cancel1.png"));
    Icon editIcon = new ImageIcon(getClass().getResource("editar.png"));

    public Icon getOkIcon() {
        return OkIcon;
    }

    public Icon getBadIcon() {
        return BadIcon;
    }

    public Icon getHandIcon() {
        return handIcon;
    }

    public Icon getCancelIcon() {
        return cancelIcon;
    }

    public Icon getQuestionIcon() {
        return questionIcon;
    }

    public Icon getCancel1Icon() {
        return cancel1Icon;
    }

}
