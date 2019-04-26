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
        root = new Node ('^');
        map = new HashMap<>();

        Node e = new Node('e');
        e.setParent(root);
        Node t = new Node('t');
        t.setParent(root);
        root.setLeft(e);
        root.setRight(t);


        Node i = new Node('i');
        i.setParent(e);
        e.setLeft(i);
        Node a = new Node('a');
        a.setParent(e);
        e.setRight(a);


        Node n = new Node('n');
        n.setParent(e);
        t.setLeft(n);
        Node m = new Node('m');
        m.setParent(e);
        t.setRight(m);


        Node s = new Node('s');
        s.setParent(i);
        i.setLeft(s);
        Node u = new Node('u');
        u.setParent(i);
        i.setRight(u);


        Node r = new Node('r');
        r.setParent(a);
        a.setLeft(r);
        Node w = new Node('w');
        w.setParent(a);
        a.setRight(w);


        Node d = new Node('d');
        d.setParent(n);
        n.setLeft(d);
        Node k = new Node('k');
        k.setParent(n);
        n.setRight(k);


        Node g = new Node('g');
        g.setParent(m);
        m.setLeft(g);
        Node o = new Node('o');
        o.setParent(m);
        m.setRight(o);


        Node h = new Node('h');
        h.setParent(s);
        s.setLeft(h);
        Node v = new Node('v');
        v.setParent(s);
        s.setRight(v);


        Node f = new Node('f');
        f.setParent(u);
        u.setLeft(f);
        Node blank1 = new Node(' ');
        blank1.setParent(u);
        u.setRight(blank1);


        Node l = new Node('l');
        l.setParent(r);
        r.setLeft(l);
        Node blank2 = new Node(' ');
        blank2.setParent(r);
        r.setRight(blank2);


        Node p = new Node('p');
        p.setParent(w);
        w.setLeft(p);
        Node j = new Node('j');
        j.setParent(w);
        w.setRight(j);


        Node b = new Node('b');
        b.setParent(d);
        d.setLeft(b);
        Node x = new Node('x');
        x.setParent(d);
        d.setRight(x);


        Node c = new Node('c');
        c.setParent(k);
        k.setLeft(c);
        Node y = new Node('y');
        y.setParent(k);
        k.setRight(y);


        Node z = new Node('z');
        z.setParent(g)  ;
        g.setLeft(z);
        Node q = new Node('q');
        q.setParent(g);
        g.setRight(q);


        Node blank3 = new Node(' ');
        blank3.setParent(o);
        o.setLeft(blank3);
        Node blank4 = new Node(' ');
        blank4.setParent(o);
        o.setRight(blank4);


        Node n5 = new Node('5');
        n5.setParent(h);
        h.setLeft(n5);
        Node n4 = new Node('4');
        n4.setParent(h);
        h.setRight(n4);


        Node n3 = new Node('3');
        n3.setParent(v);
        v.setRight(n3);


        Node n2 = new Node('2');
        n2.setParent(blank1);
        blank1.setRight(n2);


        Node plus = new Node('+');
        plus.setParent(blank2)  ;
        blank2.setLeft(plus);


        Node n1 = new Node('1');
        n1.setParent(j);
        j.setRight(n1);


        Node n6 = new Node('6');
        n6.setParent(b);
        b.setLeft(n6);
        Node equal = new Node('=');
        equal.setParent(b);
        b.setRight(equal);

        Node slash = new Node('/');
        slash.setParent(x);
        x.setLeft(slash);


        Node n7 = new Node('7');
        n7.setParent(z);
        z.setLeft(n7);


        Node n8 = new Node('8');
        n8.setParent(blank3);
        blank3.setLeft(n8);

        Node n9 = new Node('9');
        n9.setParent(blank4);
        blank4.setLeft(n9);
        Node zero = new Node('0');
        zero.setParent(blank4);
        blank4.setRight(zero);

        
    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public char morseToChar(String code) {
        return ' ';
    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public String charToMorse(char c) {
        return " ";
    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.
    public LinkedList<String> getCodes() {
        return new LinkedList<>();
    }

}