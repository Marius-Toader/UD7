import java.util.Hashtable;

import javax.swing.JOptionPane;

public class UD7_3 {
	
	public static void menu(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String texto = "Selecciona una opción: \n"
						+ "1. Añadir artículo/cantidad \n"
						+ "2. Ver información de un artículo \n"
						+ "3. Ver toda la información";
		int n = Integer.parseInt(JOptionPane.showInputDialog(texto));
		switch (n) {
			case 1: añadir(stockPrecios, stockCantidades);
				break;
			case 2: buscar(stockPrecios, stockCantidades);
				break;
			case 3: mostrar(stockPrecios, stockCantidades);
				break;
			default: JOptionPane.showMessageDialog(null, "Opción no válida");
				break;
		}
	}
	
	public static void añadir(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String articulo = JOptionPane.showInputDialog("Artículo por añadir:");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del artículo:"));
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad del artículo:"));
		
		stockPrecios.put(articulo, precio);
		stockCantidades.put(articulo, cantidad);
		
		menu(stockPrecios, stockCantidades);
	}
	
	public static void buscar(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String articulo = JOptionPane.showInputDialog("Artículo para buscar:");
		
		JOptionPane.showMessageDialog(null, "Artículo: " + articulo.toLowerCase() + "\n"
											+ "Precio: " + stockPrecios.get(articulo));
	}
	
	public static void mostrar(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		JOptionPane.showMessageDialog(null, "Artículos con precio: " + stockPrecios.toString() + "\n"
										+ "Artículos con cantidad: " + stockCantidades.toString());
	}

	public static void main(String[] args) {
		Hashtable<String, Double> stockPrecios = new Hashtable<String, Double>();
		stockPrecios.put("Cerezas", 1.69);
		stockPrecios.put("Naranjas", 3.15);
		stockPrecios.put("Sandía", 2.10);
		stockPrecios.put("Melón", 1.90);
		stockPrecios.put("Manzanas", 2.44);
		stockPrecios.put("Peras", 2.27);
		stockPrecios.put("Plátanos", 1.79);
		stockPrecios.put("Tomates", 2.05);
		stockPrecios.put("Zanahorias", 2.30);
		stockPrecios.put("Patatas", 3.11);
		
		Hashtable<String, Integer> stockCantidades = new Hashtable<String, Integer>();
		stockCantidades.put("Cerezas", 3);
		stockCantidades.put("Naranjas", 5);
		stockCantidades.put("Sandía", 2);
		stockCantidades.put("Melón", 6);
		stockCantidades.put("Manzanas", 3);
		stockCantidades.put("Peras", 4);
		stockCantidades.put("Plátanos", 2);
		stockCantidades.put("Tomates", 5);
		stockCantidades.put("Zanahorias", 7);
		stockCantidades.put("Patatas", 3);
		
		menu(stockPrecios, stockCantidades);
	}
}