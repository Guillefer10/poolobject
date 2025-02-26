/**
 * 
 */
package ubu.gii.dass.c01;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;



/**
 * @author Guillermo Fernandez Golpe gfg1001@alu.ubu.es
 *
 */
public class ReusablePoolTest {

	
	@BeforeAll
	public static void setUp(){
	}

	@BeforeEach
    public void resetPool(){
         ReusablePool.resetInstanceForTest();
    }
    /**
     * Test del método getInstance() para comprobar el patrón singleton.
     */
	@Test
    @DisplayName("testGetInstance")
    public void testGetInstance() {
         ReusablePool pool1 = ReusablePool.getInstance();
         ReusablePool pool2 = ReusablePool.getInstance();
         assertSame(pool1, pool2, "getInstance debe devolver siempre la misma instancia");
    }
	
    /**
     * Test del método acquireReusable() para comprobar que se adquieren correctamente 
     * los objetos y que se lanza la excepción al intentar adquirir más de los disponibles.
     */
    @Test
    @DisplayName("testAcquireReusable")
    public void testAcquireReusable() throws Exception {
         ReusablePool pool = ReusablePool.getInstance();
         // Adquirir dos objetos: son los únicos disponibles (pool de tamaño 2)
         Reusable r1 = pool.acquireReusable();
         assertNotNull(r1, "El primer objeto adquirido no debe ser nulo");
         Reusable r2 = pool.acquireReusable();
         assertNotNull(r2, "El segundo objeto adquirido no debe ser nulo");
         // Los dos objetos deben ser distintos
         assertNotSame(r1, r2, "Los objetos adquiridos deben ser instancias diferentes");
         
         // Al intentar adquirir un tercer objeto, debe lanzarse la excepción NotFreeInstanceException
         Exception exception = assertThrows(NotFreeInstanceException.class, () -> {
             pool.acquireReusable();
         });
         assertEquals("No hay más instancias reutilizables disponibles. Reintentalo más tarde", exception.getMessage());
    }

    /**
     * Test del método releaseReusable() para comprobar que al liberar un objeto se añade correctamente 
     * al pool y que lanzar liberar un objeto ya presente en el pool lanza DuplicatedInstanceException.
     */
    @Test
    @DisplayName("testReleaseReusable")
    public void testReleaseReusable() throws Exception {
         ReusablePool pool = ReusablePool.getInstance();
         // Adquirir un objeto
         Reusable r1 = pool.acquireReusable();
         // Liberarlo: se debe añadir de nuevo al pool
         pool.releaseReusable(r1);
         // Volver a adquirir: como se usa LIFO, se espera que sea el objeto liberado
         Reusable r2 = pool.acquireReusable();
         assertSame(r1, r2, "El objeto liberado debe ser readquirido como último añadido");
         
         // Liberar r2
         pool.releaseReusable(r2);
         // Intentar liberar nuevamente r2 debe generar excepción
         Exception exception = assertThrows(DuplicatedInstanceException.class, () -> {
              pool.releaseReusable(r2);
         });
         assertEquals("Ya existe esa instancia en el pool.", exception.getMessage());
    }
}

