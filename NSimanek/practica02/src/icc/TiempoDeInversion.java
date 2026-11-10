package icc;
import java.util.Scanner;


public class TiempoDeInversion {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String nombreInversor;
    double montoInvertir;
    int tiempoInversion;
    double inversion;
    double totalInversion;
    String respuesta;
    boolean continuar = true;

    System.out.println("Bienvenid@ al CienciBanco, donde su dinero esta 100% seguro el 20% de las veces. Por favor, diga su nombre: ");
    nombreInversor = in.nextLine();

    do {
        System.out.println("Bienvenid@ " + nombreInversor + ". ¿Què monto desea invertir el dìa de hoy?");
        montoInvertir = in.nextDouble();

        System.out.println("El monto que usted ha ingresado es: $" + montoInvertir + " . Por favor, proporcione una fecha para iniciar su inversiòn.");

        System.out.print("Escriba el día del 1-31: ");
        int diaInicio = in.nextInt();
        System.out.print("Escriba el mes del 1-12: ");
        int mesInicio = in.nextInt();
        System.out.print("Escriba los 4 dígitos del año: ");
        int anoInicio = in.nextInt();
        Fecha inicioInversion = new Fecha(diaInicio, mesInicio, anoInicio);

        System.out.println("Ha seleccionado " + inicioInversion.aCadena() + " para iniciar su inversiòn. Por favor, proporcione una fecha para finalizar su inversiòn.");

        System.out.print("Escriba el día del 1-31: ");
        int diaFin = in.nextInt();
        System.out.print("Escriba el mes del 1-12: ");
        int mesFin = in.nextInt();
        System.out.print("Escriba los 4 dígitos del año: ");
        int anoFin = in.nextInt();
        Fecha finInversion = new Fecha(diaFin, mesFin, anoFin);

        System.out.println("Ha seleccionado " + finInversion.aCadena() + " para finalizar su inversiòn.");

        tiempoInversion = inicioInversion.diferenciaDias(finInversion); //Esto no se mantendrà igual, solo es para tener una idea del programa, falta pulirlo
        inversion = montoInvertir * 0.12;
        totalInversion = inversion + montoInvertir;

        System.out.println("\nPerfecto, aquí están sus datos: ");

        System.out.println("Inversor(a): " + nombreInversor);
        System.out.println("Monto Invertido: $" + montoInvertir);
        System.out.println("Fecha de Inicio: " + inicioInversion.aCadena());
        System.out.println("Fecha de Finalización: " + finInversion.aCadena());
        System.out.println("Duración Total: " + tiempoInversion + " días.");
        System.out.println("Rendimiento Estimado (12%): $" + inversion);
        System.out.println("Monto Total: $" + totalInversion);

        System.out.println("\n¿No son sus datos? No se preocupe, solo llame a este número: 55 **** ****. (Es el número de mi ex pero le c#$@ tener empatía por los demás. :D).");

        System.out.println("¿Desea hacer otra simulaciòn? (si/no): ");
        in.nextLine();
        respuesta = in.nextLine().toLowerCase();
        if (respuesta.equals("si")){
           continuar = true;
        } else {
           continuar = false;
        }

    } while (continuar);

    System.out.println("\nGracias por confiar en CienciBanco. Nos preocupa tu mala decisión pero lo ignoramos por tu dinero. ¡Ten un gran día!"); //Solo un ejemplo
  }
}
