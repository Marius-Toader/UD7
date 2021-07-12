import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UD7_1 {

	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Número de alumnos:"));
		ArrayList<Double> lista = new ArrayList<>();
		double media;
		double suma = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 7; j++) {
				double nota = Integer.parseInt(JOptionPane.showInputDialog("Nota del alumno " + (i + 1) + ": "));
				suma += nota;
			}
			media = suma / 7;
			lista.add(media);
			media = 0;
			suma = 0;
		}
		
		for (Object o:lista) {
			JOptionPane.showMessageDialog(null, "Media del alumno = " + o);
		}
	}
}