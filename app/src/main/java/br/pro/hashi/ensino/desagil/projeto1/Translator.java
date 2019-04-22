package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.LinkedList;

// Não é permitido mudar nada nessa classe
// exceto o recheio dos três métodos.

public class Translator {
    private final Node root;
    private final HashMap<Character, Node> map;


    // Você deve mudar o recheio deste construtor,
    // de acordo com os requisitos não-funcionais.
    public Translator() {
        root = null;
        map = null;


    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public char morseToChar(String code) {
        HashMap<String,Character> dict = new HashMap<String, Character>();
        //http://ascii-table.com/morse-code.php
        dict.put(".-",'a');
        dict.put("-...",'b');
        dict.put("-.-.",'c');
        dict.put("-..",'d');
        dict.put(".",'e');
        dict.put("..-.",'f');
        dict.put("--.",'g');
        dict.put("....",'h');
        dict.put("..",'i');
        dict.put(".---",'j');
        dict.put("-.-",'k');
        dict.put(".-..",'l');
        dict.put("--",'m');
        dict.put("-.",'n');
        dict.put("---",'o');
        dict.put(".--.",'p');
        dict.put("--.-",'q');
        dict.put(".-.",'r');
        dict.put("...",'s');
        dict.put("-",'t');
        dict.put("..-",'u');
        dict.put("...-",'v');
        dict.put(".--",'w');
        dict.put("-..-",'x');
        dict.put("-.--",'y');
        dict.put("--..",'z');

        char c;

        c = dict.get(code);

        return c ;
    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public String charToMorse(char c) {
        HashMap<String,String> dict = new HashMap<String, String>();
        //http://ascii-table.com/morse-code.php
        dict.put("a",".-");
        dict.put("b","-...");
        dict.put("c","-.-.");
        dict.put("d","-..");
        dict.put("e",".");
        dict.put("f","..-.");
        dict.put("g","--.");
        dict.put("h","....");
        dict.put("i","..");
        dict.put("j",".---");
        dict.put("k","-.-");
        dict.put("l",".-..");
        dict.put("m","--");
        dict.put("n","-.");
        dict.put("o","---");
        dict.put("p",".--.");
        dict.put("q","--.-");
        dict.put("r",".-.");
        dict.put("s","...");
        dict.put("t","-");
        dict.put("u","..-");
        dict.put("v","...-");
        dict.put("w",".--");
        dict.put("x","-..-");
        dict.put("y","-.--");
        dict.put("z","--..");
        dict.put(" "," ");

        String str;

        str = dict.get(c);

        return str;
    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public LinkedList<String> getCodes() {
        return new LinkedList<>();
    }

}
