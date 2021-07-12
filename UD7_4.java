import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class UD7_4 {
	
	public static void menuCaja(Hashtable<String, Double> precios, Hashtable<String, Double> IVAs, Hashtable<String, Double>lista) {
		String texto = "Selecciona una opción: \n"
						+ "1. Añadir artículo \n"
						+ "2. Pago \n";
		int n = Integer.parseInt(JOptionPane.showInputDialog(texto));
		switch (n) {
			case 1: añadirCaja(precios, IVAs, lista);
				break;
			case 2: pago(lista);
				break;
			default: JOptionPane.showMessageDialog(null, "Opción no válida");
				break;
		}
	}
	
	public static void menuInventario(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String texto = "Selecciona una opción: \n"
						+ "1. Añadir artículo/cantidad \n"
						+ "2. Ver información de un artículo \n"
						+ "3. Ver toda la información";
		int n = Integer.parseInt(JOptionPane.showInputDialog(texto));
		switch (n) {
			case 1: añadirInv(stockPrecios, stockCantidades);
				break;
			case 2: buscar(stockPrecios, stockCantidades);
				break;
			case 3: mostrar(stockPrecios, stockCantidades);
				break;
			default: JOptionPane.showMessageDialog(null, "Opción no válida");
				break;
		}
	}
	
	public static void añadirCaja(Hashtable<String, Double> precios, Hashtable<String, Double> IVAs, Hashtable<String, Double>lista) {
		String articulo = JOptionPane.showInputDialog("Artículo:");
		double precio = precios.get(articulo) + (precios.get(articulo) * IVAs.get(articulo));
		double precioIVA = Math.round(precio * 100.0) / 100.0;
		JOptionPane.showMessageDialog(null, "Artículo: " + articulo.toLowerCase() + "\n"
											+ "IVA aplicado: " + IVAs.get(articulo) + "\n"
											+ "Precio bruto: " + precios.get(articulo) + "\n"
											+ "Precio más IVA: " + precioIVA);
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad del artículo:"));
		precio = precioIVA * cantidad;
		precioIVA = Math.round(precio * 100.0 / 100.0);
		lista.put(articulo, precioIVA);
		menuCaja(precios, IVAs, lista);
	}
	
	public static void pago(Hashtable<String, Double>lista) {
		Enumeration<Double> enumeracion = lista.elements();
		int contador = 0, suma = 0;
		while (enumeracion.hasMoreElements()) {
			suma += enumeracion.nextElement();
			contador++;
		}
		int pago = Integer.parseInt(JOptionPane.showInputDialog("Número de artículos comprados: " + contador + "\n"
									+ "Cantidad a pagar: " + suma + "\n"
									+ "Cantidad pagada:"));
		if (pago - suma != 0) {
			JOptionPane.showMessageDialog(null, "Cambio a devolver: " + (pago - suma));
		}
	}
	
	public static void añadirInv(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String articulo = JOptionPane.showInputDialog("Artículo por añadir:");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del artículo:"));
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad del artículo:"));
		
		stockPrecios.put(articulo, precio);
		stockCantidades.put(articulo, cantidad);
		
		menuInventario(stockPrecios, stockCantidades);
	}
	
	public static void buscar(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String articulo = JOptionPane.showInputDialog("Artículo para buscar:");
		
		JOptionPane.showMessageDialog(null, "Artículo: " + articulo.toLowerCase() + "\n"
											+ "Precio: " + stockPrecios.get(articulo) + "\n"
											+ "Cantidad: " + stockCantidades.get(articulo));
	}
	
	public static void mostrar(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		JOptionPane.showMessageDialog(null, "Artículos con precio: " + stockPrecios.toString() + "\n"
										+ "Artículos con cantidad: " + stockCantidades.toString());
	}

	public static void main(String[] args) {
		Hashtable<String, Double> precios = new Hashtable<String, Double>();
		precios.put("Cerezas", 1.69);
		precios.put("Naranjas", 3.15);
		precios.put("Sandía", 2.10);
		precios.put("Melón", 1.90);
		precios.put("Manzanas", 2.44);
		precios.put("Peras", 2.27);
		precios.put("Plátanos", 1.79);
		precios.put("Tomates", 2.05);
		precios.put("Zanahorias", 2.30);
		precios.put("Patatas", 3.11);
		
		Hashtable<String, Integer> stockCantidades = new Hashtable<String, Integer>();
		stockCantidades.put("Cerezas", 13);
		stockCantidades.put("Naranjas", 15);
		stockCantidades.put("Sandía", 12);
		stockCantidades.put("Melón", 16);
		stockCantidades.put("Manzanas", 23);
		stockCantidades.put("Peras", 14);
		stockCantidades.put("Plátanos", 32);
		stockCantidades.put("Tomates", 25);
		stockCantidades.put("Zanahorias", 17);
		stockCantidades.put("Patatas", 23);
		
		Hashtable<String, Double> IVAs = new Hashtable<String, Double>();
		IVAs.put("Cerezas", 0.04);
		IVAs.put("Naranjas", 0.21);
		IVAs.put("Sandía", 0.21);
		IVAs.put("Melón", 0.21);
		IVAs.put("Manzanas", 0.04);
		IVAs.put("Peras", 0.04);
		IVAs.put("Plátanos", 0.04);
		IVAs.put("Tomates", 0.21);
		IVAs.put("Zanahorias", 0.04);
		IVAs.put("Patatas", 0.21);
		
		Hashtable<String, Double>lista = new Hashtable<String, Double>();
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Acceso para: \n"
															+ "1. Caja \n"
															+ "2. Inventario"));
		switch (n) {
			case 1: menuCaja(precios, IVAs, lista);
				break;
			case 2: menuInventario(precios, stockCantidades);
				break;
			default: JOptionPane.showMessageDialog(null, "Opción no válida");
				break;
		}
	}
}