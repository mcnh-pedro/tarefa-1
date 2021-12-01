package hello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author viter
 */
public class MessageBean implements Serializable {
     
    private String msg;
    private String tratamento;
    private String lang;

        
    public MessageBean() {
    }



    private enum Cumprimentos {
        PT("Oi", "Bom dia", "Boa tarde", "Boa noite", "Sr.", "Sra."),
        EN("Hello", "Good morning", "Good afternoon", "Good night", "Sir.", "Mrs."),
        DE("Hallo", "Guten Morgen", "Guten Nachmittag", "Gute Nacht","Herr.", "Frau."),
        FR("Salut", "Bonjuor", "Bon après-midi", "Bonne nuit", "Monsieur.", "Mme."),
        CH("你好 (Nǐ hǎo)", "早上好 (Zǎoshang hǎo)", "下午好 (Xiàwǔ hǎo)", "晚安 (Wǎn'ān)", "先生 (Xiānshēng)", "太太。 (Tàitài.)"),
        HD("नमस्ते (namaste)", "सुबह बख़ैर (subah bakhair)", "नमस्कार (namaskaar)", "शुभ रात्रि (shubh raatri)", "महोदय (mahoday)", "श्रीमती। (shreematee.)");



        private String ola;
        private String dia;
        private String tarde;
        private String noite;
        private String tratamentoM;
        private String tratamentoF;

        Cumprimentos(String ola, String dia, String tarde, String noite, String tratamentoM, String tratamentoF) {
            this.ola = ola;
            this.dia = dia;
            this.tarde = tarde;
            this.noite = noite;
            this.tratamentoM = tratamentoM;
            this.tratamentoF = tratamentoF;

        }
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String frase) {
        msg = this.getCumprimento(frase) + ", " + this.getTempo(frase);

    }

    public void setTratamento(String value) {
        String frase = lang;
        frase = frase.toUpperCase();
        if (value == "0") {
             tratamento = " ";
        }
        else if (value == "1") {
         tratamento = Cumprimentos.valueOf(frase).tratamentoM;
        }
        else if (value == "2") {
            tratamento = Cumprimentos.valueOf(frase).tratamentoF;
        }
    }

    public String getTratamento() {
        return tratamento;
    }

    public String getCumprimento(String frase) {
        frase = frase.toUpperCase();
        return Cumprimentos.valueOf(frase).ola;
    }

    public String getTempo(String frase) {
        frase = frase.toUpperCase();
        int horaAgora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (horaAgora >= 0 && horaAgora < 12) {
            return Cumprimentos.valueOf(frase).dia;
        } else if (horaAgora >= 12 && horaAgora < 18) {
            return Cumprimentos.valueOf(frase).tarde;
        } else {
            return Cumprimentos.valueOf(frase).noite;
        }
    }
}

