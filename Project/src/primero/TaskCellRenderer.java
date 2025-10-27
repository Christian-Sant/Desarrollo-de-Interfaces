package primero;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class TaskCellRenderer extends JPanel implements ListCellRenderer<Tarea>{

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TaskCellRenderer() {
		setBounds(100, 100, 512, 603);
	}

}
