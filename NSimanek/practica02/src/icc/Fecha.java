package icc;

public class Fecha {
    private int dia;
    private int numMes;
    private int ano;

    //Constructor sin parametros.

    public Fecha() {
        this.dia = 1;
        this.numMes = 1;
        this.ano = 2026;
    }

    //Constructor con 3 enteros (día, mes y año).

    public Fecha(int dia, int numMes, int ano) {
        this.dia = dia;
        this.numMes = numMes;
        this.ano = ano;
    }

    //Constructor con 2 enteros (día y año) y una cadena que es el mes.
    public Fecha(int dia, String nomMes, int ano) {
        this.dia = dia;
        this.numMes = obtenNumeroMes(nomMes);
        this.ano = ano;
    }


    //Asigna valor a los campos de una fecha.
    public void setFecha(int dia, int numMes, int ano) {
        this.dia = dia;
        this.numMes = numMes;
        this.ano = ano;
    }

    //Asigna valor al campo día.
    public void setDia(int dia) {
        this.dia = dia;
    }

    //Asigna valor al campo mes.
    public void setMes(int numMes) {
        this.numMes = numMes;
    }

    //Asigna valor al campo año.
    public void setAno(int ano) {
        this.ano = ano;
    }

    //Obtiene el día de la fecha.
    public int getDia() {
        return this.dia;
    }

    // Obtiene el número de mes de la fecha.
    public int getnumMes() {
        return this.numMes;
    }

    //Obtiene el año de la fecha.
    public int getAno() {
        return this.ano;
    }

    /* Se va a determinar si un año es bisiesto.
     Para saber cual es un año bisiesto se debe dividir entre 4 (pues los años bisiestos son cada 4 años), si se puede dividir entre 100 no es
     bisiesto pero si se puede dividir entre 400, si lo es.
    */
    public boolean esBisiesto(int ano) {
        if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    //Devuelve el número de días que tiene un mes específico.
    public int diasEnMes(int numMes, int ano) {
        if (numMes == 1 || numMes == 3 || numMes == 5 || numMes == 7 || numMes == 8 || numMes == 10 || numMes == 12) {
            return 31;
        } else if (numMes == 4 || numMes == 6 || numMes == 9 || numMes == 11) {
            return 30;
        } else if (numMes == 2) {
            if (esBisiesto(ano)) {
                return 29;
            } else {
                return 28;
            }
	} else {
            return 0;
        }
    }

     /**
     * Para calcular los días totales transcurridos desde el año 1 d.C. hasta esta
       fecha y hacer el proceso más fácil (espero).
     */
    private int diasAbsolutos() {
        int y = this.ano - 1;
        int bisiestos = (y / 4) - (y / 100) + (y / 400);
        return (y * 365) + bisiestos + diasTranscurridos();
    }
     //Obtener la diferencia, en días, entre dos fechas.
    public int diferenciaDias(Fecha otra) {
        int diferencia = this.diasAbsolutos() - otra.diasAbsolutos();
        if (diferencia < 0) {
            diferencia = -diferencia;
        }
	return diferencia;
    }
     //Dada una fecha inicial y un número entero que representa una cantidad de días, obtener la fecha que corresponde (+ o -).
    public Fecha obtenerFechaPorDias(int cantidadDias) {
        int d = this.dia;
        int m = this.numMes;
        int a = this.ano;

        if (cantidadDias >= 0) {
            int i = 0;
            while (i < cantidadDias) {
                d = d + 1;
                if (d > diasEnMes(m, a)) {
                    d = 1;
                    m = m + 1;
                    if (m > 12) {
                        m = 1;
                        a = a + 1;
                    }
                }
                i = i + 1;
            }
        } else {
            int limite = -cantidadDias;
            int i = 0;
            while (i < limite) {
                d = d - 1;
                if (d < 1) {
                    m = m - 1;
                    if (m < 1) {
                        m = 12;
                        a = a - 1;
                    }
                    d = diasEnMes(m, a);
                }
                i = i + 1;
            }
        }
	return new Fecha(d, m, a);
    }

    //Determinar si dos fechas son iguales.
    public boolean esIgual(Fecha otra) {
        if (otra == null) {
            return false;
        }
	if (this.dia == otra.getDia() && this.numMes == otra.getnumMes() && this.ano == otra.getAno()) {
            return true;
        } else {
            return false;
        }
    }

    //Devolver el número correspondiente del mes a partir de que reciba una cadena con su nombre.
    public int obtenNumeroMes(String nombreMes) {
        if (nombreMes == null) {
            return 1;
        }

        String min = nombreMes.trim().toLowerCase();

        if (min.equals("enero")) {
            return 1;
        } else if (min.equals("febrero")) {
            return 2;
        } else if (min.equals("marzo")) {
            return 3;
        } else if (min.equals("abril")) {
            return 4;
        } else if (min.equals("mayo")) {
            return 5;
        } else if (min.equals("junio")) {
            return 6;
        } else if (min.equals("julio")) {
            return 7;
        } else if (min.equals("agosto")) {
            return 8;
        } else if (min.equals("septiembre")) {
            return 9;
        } else if (min.equals("octubre")) {
            return 10;
        } else if (min.equals("noviembre")) {
            return 11;
        } else if (min.equals("diciembre")) {
            return 12;
        } else {
            return 1;
        }
    }

    //Hacer lo contrario que hicimos en el otro.
    public String obtenNombreMes(int numeroMes) {
        if (numeroMes == 1) {
            return "enero";
        } else if (numeroMes == 2) {
            return "febrero";
        } else if (numeroMes == 3) {
            return "marzo";
        } else if (numeroMes == 4) {
            return "abril";
        } else if (numeroMes == 5) {
            return "mayo";
        } else if (numeroMes == 6) {
            return "junio";
        } else if (numeroMes == 7) {
            return "julio";
        } else if (numeroMes == 8) {
            return "agosto";
        } else if (numeroMes == 9) {
            return "septiembre";
        } else if (numeroMes == 10) {
            return "octubre";
        } else if (numeroMes == 11) {
            return "noviembre";
        } else if (numeroMes == 12) {
            return "diciembre";
        } else {
            return "desconocido";
        }
    }

    //Dada una fecha, especificar los días transcurridos en el año.
    public int diasTranscurridos() {
        int total = this.dia;
        int m = 1;
        while (m < this.numMes) {
            total = total + diasEnMes(m, this.ano);
            m = m + 1;
        }
        return total;
    }

    //Representar una fecha en el formato dd/mes/aaaa.
    public String aCadena() {
        String diaTexto = "";
        if (this.dia < 10) {
            diaTexto = "0" + this.dia;
        } else {
            diaTexto = "" + this.dia;
        }
        return diaTexto + "/" + obtenNombreMes(this.numMes) + "/" + this.ano;
    }
    //System.out.println(dia + "/" + nomMes + "/" + ano);
}
