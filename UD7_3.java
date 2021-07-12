import java.util.Hashtable;

import javax.swing.JOptionPane;

public class UD7_3 {
	
	public static void menu(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String texto = "Selecciona una opci�n: \n"
						+ "1. A�adir art�culo/cantidad \n"
						+ "2. Ver informaci�n de un art�culo \n"
						+ "3. Ver toda la informaci�n";
		int n = Integer.parseInt(JOptionPane.showInputDialog(texto));
		switch (n) {
			case 1: a�adir(stockPrecios, stockCantidades);
				break;
			case 2: buscar(stockPrecios, stockCantidades);
				break;
			case 3: mostrar(stockPrecios, stockCantidades);
				break;
			default: JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
				break;
		}
	}
	
	public static void a�adir(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String articulo = JOptionPane.showInputDialog("Art�culo por a�adir:");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del art�culo:"));
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad del art�culo:"));
		
		stockPrecios.put(articulo, precio);
		stockCantidades.put(articulo, cantidad);
		
		menu(stockPrecios, stockCantidades);
	}
	
	public static void buscar(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String articulo = JOptionPane.showInputDialog("Art�culo para buscar:");
		
		JOptionPane.showMessageDialog(null, "Art�culo: " + articulo.toLowerCase() + "\n"
											+ "Precio: " + stockPrecios.get(articulo));
	}
	
	public static void mostrar(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		JOptionPane.showMessageDialog(null, "Art�culos con precio: " + stockPrecios.toString() + "\n"
										+ "Art�culos con cantidad: " + stockCantidades.toString());
	}

	public static void main(String[] args) {
		Hashtable<String, Double> stockPrecios = new Hashtable<String, Double>();
		stockPrecios.put("Cerezas", 1.69);
		stockPrecios.put("Naranjas", 3.15);
		stockPrecios.put("Sand�a", 2.10);
		stockPrecios.put("Mel�n", 1.90);
		stockPrecios.put("Manzanas", 2.44);
		stockPrecios.put("Peras", 2.27);
		stockPrecios.put("Pl�tanos", 1.79);
		stockPrecios.put("Tomates", 2.05);
		stockPrecios.put("Zanahorias", 2.30);
		stockPrecios.put("Patatas", 3.11);
		
		Hashtable<String, Integer> stockCantidades = new Hashtable<String, Integer>();
		stockCantidades.put("Cerezas", 3);
		stockCantidades.put("Naranjas", 5);
		stockCantidades.put("Sand�a", 2);
		stockCantidades.put("Mel�n", 6);
		stockCantidades.put("Manzanas", 3);
		stockCantidades.put("Peras", 4);
		stockCantidades.put("Pl�tanos", 2);
		stockCantidades.put("Tomates", 5);
		stockCantidades.put("Zanahorias", 7);
		stockCantidades.put("Patatas", 3);
		
		menu(stockPrecios, stockCantidades);
	}
}