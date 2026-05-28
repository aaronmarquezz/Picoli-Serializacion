package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SerializacionTest {
	private String path = "pruebaEstadoSerializado.data";

	@BeforeEach
	void before() {
		new File(path).delete();
	}

	@Test
	void test() {
		//queremos dos variables. una instancia de estado, grabarla y luego sacarla de grabado con otra variable. 
		Estado estado1 = new Estado();
		//lo grabamos. 
		AlmacenBinarioMonoObjetoSerializado<Estado> almacen = new AlmacenBinarioMonoObjetoSerializado<Estado>(path);
		almacen.grabar(estado1);
		
		//lo cargamos y guardamos en una variable. 
		Estado estado2 = null;
		try {
			estado2 = (Estado) almacen.leer();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		assertEquals(estado1, estado2);
		assertTrue(estado1.equals(estado2));
		
		//ahora vamos avanzando los dos y tendrían que ser iguales. 
		try {
			estado1.abrirPeriodo(0.4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		estado1.cerrarPeriodo();
		
		try {
			estado2.abrirPeriodo(0.4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		estado2.cerrarPeriodo();
		
		assertEquals(estado1, estado2);
	}

}
