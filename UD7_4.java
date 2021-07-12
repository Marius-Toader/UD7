import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class UD7_4 {
	
	public static void menuCaja(Hashtable<String, Double> precios, Hashtable<String, Double> IVAs, Hashtable<String, Double>lista) {
		String texto = "Selecciona una opci�n: \n"
						+ "1. A�adir art�culo \n"
						+ "2. Pago \n";
		int n = Integer.parseInt(JOptionPane.showInputDialog(texto));
		switch (n) {
			case 1: a�adirCaja(precios, IVAs, lista);
				break;
			case 2: pago(lista);
				break;
			default: JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
				break;
		}
	}
	
	public static void menuInventario(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String texto = "Selecciona una opci�n: \n"
						+ "1. A�adir art�culo/cantidad \n"
						+ "2. Ver informaci�n de un art�culo \n"
						+ "3. Ver toda la informaci�n";
		int n = Integer.parseInt(JOptionPane.showInputDialog(texto));
		switch (n) {
			case 1: a�adirInv(stockPrecios, stockCantidades);
				break;
			case 2: buscar(stockPrecios, stockCantidades);
				break;
			case 3: mostrar(stockPrecios, stockCantidades);
				break;
			default: JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
				break;
		}
	}
	
	public static void a�adirCaja(Hashtable<String, Double> precios, Hashtable<String, Double> IVAs, Hashtable<String, Double>lista) {
		String articulo = JOptionPane.showInputDialog("Art�culo:");
		double precio = precios.get(articulo) + (precios.get(articulo) * IVAs.get(articulo));
		double precioIVA = Math.round(precio * 100.0) / 100.0;
		JOptionPane.showMessageDialog(null, "Art�culo: " + articulo.toLowerCase() + "\n"
											+ "IVA aplicado: " + IVAs.get(articulo) + "\n"
											+ "Precio bruto: " + precios.get(articulo) + "\n"
											+ "Precio m�s IVA: " + precioIVA);
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad del art�culo:"));
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
		int pago = Integer.parseInt(JOptionPane.showInputDialog("N�mero de art�culos comprados: " + contador + "\n"
									+ "Cantidad a pagar: " + suma + "\n"
									+ "Cantidad pagada:"));
		if (pago - suma != 0) {
			JOptionPane.showMessageDialog(null, "Cambio a devolver: " + (pago - suma));
		}
	}
	
	public static void a�adirInv(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String articulo = JOptionPane.showInputDialog("Art�culo por a�adir:");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del art�culo:"));
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad del art�culo:"));
		
		stockPrecios.put(articulo, precio);
		stockCantidades.put(articulo, cantidad);
		
		menuInventario(stockPrecios, stockCantidades);
	}
	
	public static void buscar(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		String articulo = JOptionPane.showInputDialog("Art�culo para buscar:");
		
		JOptionPane.showMessageDialog(null, "Art�culo: " + articulo.toLowerCase() + "\n"
											+ "Precio: " + stockPrecios.get(articulo) + "\n"
											+ "Cantidad: " + stockCantidades.get(articulo));
	}
	
	public static void mostrar(Hashtable<String, Double> stockPrecios, Hashtable<String, Integer> stockCantidades) {
		JOptionPane.showMessageDialog(null, "Art�culos con precio: " + stockPrecios.toString() + "\n"
										+ "Art�culos con cantidad: " + stockCantidades.toString());
	}

	public static void main(String[] args) {
		Hashtable<String, Double> precios = new Hashtable<String, Double>();
		precios.put("Cerezas", 1.69);
		precios.put("Naranjas", 3.15);
		precios.put("Sand�a", 2.10);
		precios.put("Mel�n", 1.90);
		precios.put("Manzanas", 2.44);
		precios.put("Peras", 2.27);
		precios.put("Pl�tanos", 1.79);
		precios.put("Tomates", 2.05);
		precios.put("Zanahorias", 2.30);
		precios.put("Patatas", 3.11);
		
		Hashtable<String, Integer> stockCantidades = new Hashtable<String, Integer>();
		stockCantidades.put("Cerezas", 13);
		stockCantidades.put("Naranjas", 15);
		stockCantidades.put("Sand�a", 12);
		stockCantidades.put("Mel�n", 16);
		stockCantidades.put("Manzanas", 23);
		stockCantidades.put("Peras", 14);
		stockCantidades.put("Pl�tanos", 32);
		stockCantidades.put("Tomates", 25);
		stockCantidades.put("Zanahorias", 17);
		stockCantidades.put("Patatas", 23);
		
		Hashtable<String, Double> IVAs = new Hashtable<String, Double>();
		IVAs.put("Cerezas", 0.04);
		IVAs.put("Naranjas", 0.21);
		IVAs.put("Sand�a", 0.21);
		IVAs.put("Mel�n", 0.21);
		IVAs.put("Manzanas", 0.04);
		IVAs.put("Peras", 0.04);
		IVAs.put("Pl�tanos", 0.04);
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
			default: JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
				break;
		}
	}
}