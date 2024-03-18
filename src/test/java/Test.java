import org.apache.logging.log4j.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
//        crearEstudiante();
//        recuperarPorId();
//        actualizarEstudiante();
        eliminarEstudiante();
    }
    private static void crearEstudiante(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Estudiante estudiante = new Estudiante ("RA101621", "Marvin", "Ramos");

        em.persist (estudiante);
        tx.commit();
        log.debug("Objeto: " + estudiante);
        em.close();
    }
    private static void recuperarPorId() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Estudiante estudiante = em.find (Estudiante.class, 3);
        tx.commit(); //Termina la transaccion
        System.out.println("Objeto: " + estudiante);
        em.close();
    }
    private static void actualizarEstudiante () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Estudiante estudiante = em.find(Estudiante.class, 5);
        tx.commit(); //Termina la transaccion
        System.out.println("Objeto Recuperado" + estudiante);

        estudiante.setNombres("Mateo"); //Modificados a Estudiante

        EntityTransaction tx2 = em.getTransaction(); //Creamos otra transaccion
        tx2.begin(); //Iniciamos la transaccion 2
        em.merge(estudiante); //Eliminadmos el objeto recuperado
        tx2.commit();
        System.out.println("Objeto: " + estudiante);
        em.close();
    }
    private static void eliminarEstudiante () {
        EntityManagerFactory emf = Persistence. createEntityManagerFactory ("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction ();

        tx.begin(); //Ininiciamos una transaccion
        Estudiante estudiante = em. find (Estudiante.class, 6);
        tx.commit(); //Termina la transaccion
        System.out.println("Objeto" + estudiante);

        EntityTransaction tx2 = em.getTransaction(); //Creamos otra transaccion
        tx2.begin(); //Iniciamos la transaccion 2
        em.remove (em.merge (estudiante)); //Eliminadmos el objeto recuperado
        tx2.commit();
        System.out.println("Objeto: " + estudiante);

        em.close(); //Cerramos el EM
    }
}
