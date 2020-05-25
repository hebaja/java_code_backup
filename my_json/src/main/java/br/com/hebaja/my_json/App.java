package br.com.hebaja.my_json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        ArrayList<String> heroes = new ArrayList<>();
        heroes.add("Spider-man");
        heroes.add("Super-man");
        heroes.add("Batman");
        heroes.add("Wonder Woman");
        heroes.add("Goku");
        heroes.add("Saitama");
        heroes.add("Hawk Girl");

        Collections.shuffle(heroes);

        System.out.println();

        heroes.trimToSize();

        List<String> lessHeroes = heroes.subList(0,3);

        for (String hero : heroes) {
            System.out.println(hero);
        }

        System.out.println();
        System.out.println();

//        for (String hero : lessHeroes) {
//            System.out.println(hero);
//        }

        List<String> novaLista = new ArrayList<String>();

        novaLista = heroes.subList(0, 3);

        for (String hero : novaLista) {
            System.out.println(hero);
        }
    }
}
