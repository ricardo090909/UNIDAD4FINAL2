package interfaces;

import java.util.List;

public interface Operable {
	boolean isFull();
	boolean isEmpty();
	void add(Keyable item);
	int getPosition(String clave);
	boolean exist(int position);
	Keyable getItem(int position);
	void remove(int position);
	void update(Keyable item , int position);
	String getList(String titulo);
	void ordenar();
	void sort();
	
}
