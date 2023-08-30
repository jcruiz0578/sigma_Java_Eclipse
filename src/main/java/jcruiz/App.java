package jcruiz;

import java.awt.FontFormatException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException, FontFormatException
    {

    	Dashboard form = new Dashboard();

        form.setTitle("SISTEMA INTEGRAL DE GESTIÓN MATRICULAR AVANZADO");
        form.setSize(960, 600);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }



}
