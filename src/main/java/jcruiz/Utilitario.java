package jcruiz;


import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class Utilitario {



        public Font tipoLetra(String tipoFont, int tamanoFont) throws IOException, FontFormatException {


            Font fuente;
            InputStream myStream = null;

            myStream = getClass().getResourceAsStream("/Font/"+tipoFont+".ttf");
            assert myStream != null;
            fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fuente = fuente.deriveFont(Font.PLAIN, tamanoFont);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuente);


            return fuente;
        }


}
