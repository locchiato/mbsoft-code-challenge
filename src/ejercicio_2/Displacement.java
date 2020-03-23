package ejercicio_2;

public class Displacement {

    public static final Coordinates FIRST_POSITION = new Coordinates(0, 0);
    public static final Coordinates EXIT_POSITION = new Coordinates(0, 4);

    public static void main(String[] args) {

        int myArray [] = {1, 2, -1, 1, 0, 1, 2, -1, -1, -2};

        try {
            calculateFinalPosition(myArray);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    static void calculateFinalPosition(int myArray[]) throws Exception {

        System.out.println();
        if(myArray.length % 2 != 0) {
            throw new Exception("La cantidad de elementos es incorrecta.");
        }

        Coordinates moves[] = getMoves(myArray);
        Coordinates finalPosition = FIRST_POSITION;
        Coordinates actualPosition = FIRST_POSITION;
        int auxX, auxY;

        for (Coordinates move : moves) {
            actualPosition.setX(finalPosition.getX());
            actualPosition.setY(finalPosition.getY());

            auxX = actualPosition.getX() + move.getX();
            auxY = actualPosition.getY() + move.getY();

            if(auxX < 0) auxX = 0;
            if(auxX > 3) auxX = 3;
            if(auxY < 0) auxY = 0;
            if(auxY > 3) auxY = 3;

            finalPosition.setX(auxX);
            finalPosition.setY(auxY);
        }

        showFinalPosition(finalPosition);

    }

    private static void showFinalPosition(Coordinates finalPosition) {

        Coordinates actualPosition = new Coordinates(0, 0);

        System.out.println("╔═╦═╦═╦═╗");

        while(!actualPosition.equals(EXIT_POSITION)){
            while(actualPosition.getX() < 4){
                System.out.print(actualPosition.equals(finalPosition) ? "║X" : "║O");
                actualPosition.setX(actualPosition.getX()+1);
            }
            System.out.println("║");

            actualPosition.setX(0);
            actualPosition.setY(actualPosition.getY()+1);

            if(actualPosition.getY() < 4)
                System.out.println("╠═╬═╬═╬═╣");
        }

        System.out.println("╚═╩═╩═╩═╝");

    }

    private static Coordinates[] getMoves(int[] myArray) {

        Coordinates moves[] = new Coordinates[5];
        int index = 0;

        for (int i = 0; i < myArray.length; i+=2, index++) {
            moves[index] = new Coordinates(myArray[i], myArray[i+1]);
        }

        return moves;
    }

}
