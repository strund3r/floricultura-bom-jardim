package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Data {
    
     public static String dataAtualFormatada() {
        DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dataAtual = new java.util.Date();
        return formatar.format(dataAtual);
    }
    public static String formatarData(java.sql.Date parametro) {
        DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        return formatar.format(parametro);
    }
    public static java.sql.Date formatarData(String parametro) throws ParseException {
        DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        if (!parametro.isEmpty()) {
            return new java.sql.Date(formatar.parse(parametro).getTime());	
        }
        return null;
    }
    
}
