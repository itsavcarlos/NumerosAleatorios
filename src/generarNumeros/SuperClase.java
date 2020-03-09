package generarNumeros;

import javax.swing.JOptionPane;

public class SuperClase {
    // int num1, va1orInicial, valorFinal;

    double myNumbers[];

    public SuperClase() {
    }

    public static Double formatearDecimales(double numero, int numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }

    public boolean mayor(int num1, int va1orInicial, int valorFinal) {
        int absoluto = Math.abs(va1orInicial) + Math.abs(valorFinal);

        return absoluto >= num1 ? true : false;
    }

    public static double generarNumerosAleatorioDoub(int minimo, int maximo) {
        double num = (Math.random() * ((maximo - Math.abs(minimo) + 1) + Math.abs(minimo)));
        return num < minimo ? generarNumerosAleatorioDoub(minimo, maximo) : num;
    }

    public String asignarNumeroEnter() {
        String strMatriz = "";
        int contador = 20;

        for (int i = 0; i < myNumbers.length; i++) {
            if (i == contador) {
                strMatriz += "\n";
                contador += 20;
            }
            strMatriz += String.format("%7d | ", +(int) myNumbers[i]);
        }
        strMatriz += " ";
        return strMatriz;
    }

    public String asignarNumeroDecimal() {
        String strMatriz = "";
        int contador = 10;

        for (int i = 0; i < myNumbers.length; i++) {
            if (i == contador) {
                strMatriz += "\n";
                contador += 10;
            }
            strMatriz += "\t" + myNumbers[i];
        }
        strMatriz += "\n";
        return strMatriz;
    }

    public void empezar(int num1, int va1orInicial, int valorFinal, int desimal) {
        int i = 0;

        myNumbers = new double[num1];

        for (i = 0; i < num1; i++) {
            myNumbers[i] = formatearDecimales(generarNumerosAleatorioDoub(va1orInicial, valorFinal), desimal);

        }
    }

    public void empezarSin(int num1, int va1orInicial, int valorFinal, int desimal) {
        int i = 0;

        myNumbers = new double[num1];

        if (mayor(num1, va1orInicial, valorFinal)) {
            myNumbers[i] = formatearDecimales(generarNumerosAleatorioDoub(va1orInicial, valorFinal), desimal);

            for (i = 1; i < num1; i++) {
                myNumbers[i] = formatearDecimales(generarNumerosAleatorioDoub(va1orInicial, valorFinal), desimal);

                for (int j = 0; j < i; j++) {
                    if (myNumbers[j] == myNumbers[i]) {
                        i--;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede genral numeros Aleatorios");
        }
    }

}
