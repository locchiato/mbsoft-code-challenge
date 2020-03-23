package ejercicio_3;

import java.util.*;

public class CodeListManagement {

    public static void main(String[] args) {

        List<String> codeList1 = Arrays.asList(
                "DCR-88578-9",
                "WIJ-12345-6",
                "PGH-12345-6",
                "PCD-38455-1",
                "IFG-12345-7"
        );

        List<String> codeList2 = Arrays.asList(
                "WBC-12345-6",
                "ABC-57444-6",
                "PCD-38455-1",
                "WIJ-12345-6",
                "DCR-88578-9"
        );

        System.out.println("Lista 1:");
        showList(codeList1);

        System.out.println("Lista 2:");
        showList(codeList2);


        System.out.println("Evaluando lista 1:");
        for (String codigo : codeList1) {
            System.out.println(codigo + ":");
            System.out.println("- " + (esPrioritario(codigo) ? "" : "no ") + "es prioritario.");
            System.out.println("- " + (verificar(codigo) ? "" : "no ") + "es valido.");
            System.out.println();
        }

        System.out.println("Lista 2 - ordenada:");
        sortList(codeList2);

        System.out.println("Lista 3 - union de los elementos de las listas 1 y 2:");
        showList(unionList(codeList1, codeList2));

        System.out.println("Lista 4 - interseccion de los elementos de las listas 1 y 2:");
        showList(crossList(codeList1, codeList2));

    }

    private static void showList(List list){
        list.forEach(System.out::println);
        System.out.println();
    }

    private static void sortList(List list) {
        Collections.sort(list);
        showList(list);
    }

    // funcion esPrioritario
    static boolean esPrioritario(String codigo){
        char primerCaracter = codigo.charAt(0);
        return primerCaracter == 'P' || primerCaracter == 'W';
    }

    // funcion verificar
    static boolean verificar(String codigo){

        String numbers = codigo.substring(4, 9);
        char lastCharacter = codigo.charAt(codigo.length() -1);
        int digitVerificator = Integer.parseInt(String.valueOf(lastCharacter));

        // sumo cada cifra, hasta llegar a 1 sola cifra
        int acumulator;
        do {
            acumulator = 0;
            for (char number : numbers.toCharArray())
                acumulator += Integer.parseInt(String.valueOf(number));
            numbers = String.valueOf(acumulator);
        }while(acumulator > 9);

        return acumulator == digitVerificator;
    }

    // unir dos listas
    static List unionList(List list1, List list2){
        List union = new ArrayList<>();
        union.addAll(list1);
        union.addAll(list2);
        return union;
    }

    // intersectar dos listas
    static List crossList(List list1, List list2){
        List cross = new ArrayList<>(list1);
        cross.retainAll(list2);
        return cross;
    }

}
