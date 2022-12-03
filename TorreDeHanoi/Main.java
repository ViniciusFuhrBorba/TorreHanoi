import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

//        if (args.length > 1) {
//            System.out.println("Quantidade de argumentos superior a permitida");
//            return;
//        }
//        if (args.length == 0) {
//            System.out.println("Favor inserir um argumento para começar");
//            return;
//        }

        String tipo = "contigua";
        boolean finalizado = false;
        boolean temErro = false;
        int movimentos = 0;

        switch (tipo) {
            case "contigua": {
                PilhaVetor<Integer> pilhaVetor1 = new PilhaVetor<>(5);
                PilhaVetor<Integer> pilhaVetor2 = new PilhaVetor<>(5);
                PilhaVetor<Integer> pilhaVetor3 = new PilhaVetor<>(5);

                PilhaVetor<Integer> verificaFinal;

                PilhaVetor<Integer> pilhaVetor1Aux;
                PilhaVetor<Integer> pilhaVetor2Aux;
                PilhaVetor<Integer> pilhaVetor3Aux;

                for (int i = 5; i >= 1; i--) {
                    pilhaVetor1.push(i);
                }

                verificaFinal = pilhaVetor1;

                while (!finalizado) {
                    if (temErro) {
                        temErro = false;
                    }

                    pilhaVetor1Aux = pilhaVetor1.clone();
                    pilhaVetor2Aux = pilhaVetor2.clone();
                    pilhaVetor3Aux = pilhaVetor3.clone();

                    StringBuilder pino1 = new StringBuilder();
                    StringBuilder pino2 = new StringBuilder();
                    StringBuilder pino3 = new StringBuilder();

                    for (int i = 5; i >= 1; i--) {
                        if (!pilhaVetor1Aux.isEmpty()) {
                            if (pilhaVetor1Aux.size() == i) {
                                int val = pilhaVetor1Aux.pop();
                                for (int i2 = 0; i2 < val; i2++) {
                                    pino1.append("_");
                                }
                                for (int i2 = val; i2 < 5; i2++) {
                                    pino1.append(" ");
                                }
                            } else {
                                for (int i2 = 1; i2 <= 5; i2++) {
                                    pino1.append(" ");
                                }
                            }
                        }else{
                            for (int i2 = 1; i2 <= 5; i2++) {
                                pino1.append(" ");
                            }
                        }
                        if (!pilhaVetor2Aux.isEmpty()) {
                            if (pilhaVetor2Aux.size() == i) {
                                int val = pilhaVetor2Aux.pop();
                                for (int i2 = 0; i2 < val; i2++) {
                                    pino2.append("_");
                                }
                                for (int i2 = val; i2 < 5; i2++) {
                                    pino2.append(" ");
                                }
                            } else {
                                for (int i2 = 1; i2 <= 5; i2++) {
                                    pino2.append(" ");
                                }
                            }
                        }else{
                            for (int i2 = 1; i2 <= 5; i2++) {
                                pino2.append(" ");
                            }
                        }
                        if (!pilhaVetor3Aux.isEmpty()) {
                            if (pilhaVetor3Aux.size() == i) {
                                int val = pilhaVetor3Aux.pop();
                                for (int i2 = 0; i2 < val; i2++) {
                                    pino3.append("_");
                                }
                                for (int i2 = val; i2 < 5; i2++) {
                                    pino3.append(" ");
                                }
                            } else {
                                for (int i2 = 1; i2 <= 5; i2++) {
                                    pino3.append(" ");
                                }
                            }
                        }else{
                            for (int i2 = 1; i2 <= 5; i2++) {
                                pino3.append(" ");
                            }
                        }
                        System.out.println(pino1 + "\t" + pino2 + "\t" + pino3);
                        pino1 = new StringBuilder("");
                        pino2 = new StringBuilder("");
                        pino3 = new StringBuilder("");
                    }

                    int entrada1 = -1;
                    int entrada2 = -1;

                    if (movimentos < 1) {
                        System.out.println("Digite para qual pino você quer mover o primeiro disco:");
                        Scanner input1 = new Scanner(System.in);
                        try {
                            entrada1 = input1.nextInt();
                        } catch (Exception e) {
                            System.out.println("O caracter inserido é invalido, favor inserir um numero");
                            temErro = true;
                        }
                    } else {
                        System.out.println("Digite de qual pino você quer remover o disco:");
                        Scanner input1 = new Scanner(System.in);
                        try {
                            entrada1 = input1.nextInt();
                        } catch (Exception e) {
                            System.out.println("O caracter inserido e invalido, favor inserir um numero");
                            temErro = true;
                        }

                        System.out.println("Digite para qual pino você quer mover o disco:");
                        Scanner input2 = new Scanner(System.in);
                        try {
                            entrada2 = input2.nextInt();
                        } catch (Exception e) {
                            System.out.println("O caracter inserido e invalido, favor inserir um numero");
                            temErro = true;
                        }
                    }

                    if (!temErro) {
                        if (entrada1 != -1 && entrada2 == -1) {
                            if (entrada1 == 1) {
                                System.out.println("O pino selecionado é o de origem. Favor selecionar outro pino");
                                temErro = true;
                            } else if (entrada1 < 1 || entrada1 > 3) {
                                System.out.println("O pino selecionado não existe. Favor selecionar outro pino");
                                temErro = true;
                            }

                            if (!temErro) {
                                switch (entrada1) {
                                    case 2: {
                                        pilhaVetor2.push(pilhaVetor1.pop());
                                        movimentos++;
                                        break;
                                    }
                                    case 3: {
                                        pilhaVetor3.push(pilhaVetor1.pop());
                                        movimentos++;
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    if (!temErro) {
                        if (entrada1 != -1 && entrada2 != -1) {
                            if (entrada1 < 1 || entrada1 > 3) {
                                System.out.println("O pino de onde o disco sera removido não existe. Favor selecionar um pino entre 1 e 3");
                                temErro = true;
                            }
                            if (entrada2 < 1 || entrada2 > 3) {
                                System.out.println("O pino onde o disco sera inserido não existe. Favor selecionar um pino entre 1 e 3");
                                temErro = true;
                            }

                            if (!temErro) {
                                switch (entrada1) {
                                    case 1: {
                                        if (pilhaVetor1.isEmpty()) {
                                            System.out.println("O pino de onde sera removido o disco se encontra vazio.");
                                            temErro = true;
                                        } else {
                                            switch (entrada2) {
                                                case 2: {
                                                    if (pilhaVetor2.isFull()) {
                                                        System.out.println("O pino selecionado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaVetor2.isEmpty()) {
                                                            pilhaVetor2.push(pilhaVetor1.pop());
                                                            movimentos++;
                                                        } else if (pilhaVetor2.top() > pilhaVetor1.top()) {
                                                            pilhaVetor2.push(pilhaVetor1.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 2 e menor que o disco do pino 1.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 3: {
                                                    if (pilhaVetor3.isFull()) {
                                                        System.out.println("O pino selecionado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaVetor3.isEmpty()) {
                                                            pilhaVetor3.push(pilhaVetor1.pop());
                                                            movimentos++;
                                                        } else if (pilhaVetor3.top() > pilhaVetor1.top()) {
                                                            pilhaVetor3.push(pilhaVetor1.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 3 e menor que o disco do pino 1.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Nao e possivel remover um disco e adicionalo no mesmo disco");
                                                    temErro = true;
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        if (pilhaVetor2.isEmpty()) {
                                            System.out.println("O pino de onde sera removido o disco se encontra vazio.");
                                            temErro = true;
                                        } else {
                                            switch (entrada2) {
                                                case 1: {
                                                    if (pilhaVetor1.isFull()) {
                                                        System.out.println("O pino onde o disco sera colocado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaVetor1.isEmpty()) {
                                                            pilhaVetor1.push(pilhaVetor2.pop());
                                                            movimentos++;
                                                        } else if (pilhaVetor1.top() > pilhaVetor2.top()) {
                                                            pilhaVetor1.push(pilhaVetor2.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 1 e menor que o disco do pino 2.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 3: {
                                                    if (pilhaVetor3.isFull()) {
                                                        System.out.println("O pino onde o disco sera colocado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaVetor3.isEmpty()) {
                                                            pilhaVetor3.push(pilhaVetor2.pop());
                                                            movimentos++;
                                                        } else if (pilhaVetor3.top() > pilhaVetor2.top()) {
                                                            pilhaVetor3.push(pilhaVetor2.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 3 e menor que o disco do pino 2.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Nao e possivel remover um disco e adicionalo no mesmo disco");
                                                    temErro = true;
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 3: {
                                        if (pilhaVetor3.isEmpty()) {
                                            System.out.println("O pino de onde sera removido o disco se encontra vazio.");
                                            temErro = true;
                                        } else {
                                            switch (entrada2) {
                                                case 1: {
                                                    if (pilhaVetor1.isFull()) {
                                                        System.out.println("O pino onde o disco sera colocado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaVetor1.isEmpty()) {
                                                            pilhaVetor1.push(pilhaVetor3.pop());
                                                            movimentos++;
                                                        } else if (pilhaVetor1.top() > pilhaVetor3.top()) {
                                                            pilhaVetor1.push(pilhaVetor3.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 1 e menor que o disco do pino 3.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 2: {
                                                    if (pilhaVetor3.isFull()) {
                                                        System.out.println("O pino onde o disco sera colocado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaVetor2.isEmpty()) {
                                                            pilhaVetor2.push(pilhaVetor3.pop());
                                                            movimentos++;
                                                        } else if (pilhaVetor2.top() > pilhaVetor3.top()) {
                                                            pilhaVetor2.push(pilhaVetor3.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 2 e menor que o disco do pino 3.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Nao e possivel remover um disco e adicionalo no mesmo disco");
                                                    temErro = true;
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (pilhaVetor3.equals(verificaFinal) && !temErro) {
                        finalizado = true;
                        System.out.println("Parabens voce chegou ai final do jogo!");
                        System.out.println("Foram realizados ao todos " + movimentos + " movimentos");
                    }
                }
                break;
            }
            case "dinamica": {
                PilhaEncadeada<Integer> pilhaEncadeada1 = new PilhaEncadeada<>();
                PilhaEncadeada<Integer> pilhaEncadeada2 = new PilhaEncadeada<>();
                PilhaEncadeada<Integer> pilhaEncadeada3 = new PilhaEncadeada<>();

                PilhaEncadeada<Integer> verificaFinal;

                PilhaEncadeada<Integer> pilhaEncadeada1Aux;
                PilhaEncadeada<Integer> pilhaEncadeada2Aux;
                PilhaEncadeada<Integer> pilhaEncadeada3Aux;

                for (int i = 5; i >= 1; i--) {
                    pilhaEncadeada1.push(i);
                }

                verificaFinal = pilhaEncadeada1;

                while (!finalizado) {
                    if (temErro) {
                        temErro = false;
                    }

                    pilhaEncadeada1Aux = pilhaEncadeada1.clone();
                    pilhaEncadeada2Aux = pilhaEncadeada2.clone();
                    pilhaEncadeada3Aux = pilhaEncadeada3.clone();

                    StringBuilder pino1 = new StringBuilder();
                    StringBuilder pino2 = new StringBuilder();
                    StringBuilder pino3 = new StringBuilder();

                    for (int i = 5; i >= 1; i--) {
                        if (!pilhaEncadeada1Aux.isEmpty()) {
                            if (pilhaEncadeada1Aux.size() == i) {
                                int val = pilhaEncadeada1Aux.pop();
                                for (int i2 = 0; i2 < val; i2++) {
                                    pino1.append("_");
                                }
                                for (int i2 = val; i2 < 5; i2++) {
                                    pino1.append(" ");
                                }
                            } else {
                                for (int i2 = 1; i2 <= 5; i2++) {
                                    pino1.append(" ");
                                }
                            }
                        }else{
                            for (int i2 = 1; i2 <= 5; i2++) {
                                pino1.append(" ");
                            }
                        }
                        if (!pilhaEncadeada2Aux.isEmpty()) {
                            if (pilhaEncadeada2Aux.size() == i) {
                                int val = pilhaEncadeada2Aux.pop();
                                for (int i2 = 0; i2 < val; i2++) {
                                    pino2.append("_");
                                }
                                for (int i2 = val; i2 < 5; i2++) {
                                    pino2.append(" ");
                                }
                            } else {
                                for (int i2 = 1; i2 <= 5; i2++) {
                                    pino2.append(" ");
                                }
                            }
                        }else{
                            for (int i2 = 1; i2 <= 5; i2++) {
                                pino2.append(" ");
                            }
                        }
                        if (!pilhaEncadeada3Aux.isEmpty()) {
                            if (pilhaEncadeada3Aux.size() == i) {
                                int val = pilhaEncadeada3Aux.pop();
                                for (int i2 = 0; i2 < val; i2++) {
                                    pino3.append("_");
                                }
                                for (int i2 = val; i2 < 5; i2++) {
                                    pino3.append(" ");
                                }
                            } else {
                                for (int i2 = 1; i2 <= 5; i2++) {
                                    pino3.append(" ");
                                }
                            }
                        }else{
                            for (int i2 = 1; i2 <= 5; i2++) {
                                pino3.append(" ");
                            }
                        }
                        System.out.println(pino1 + "\t" + pino2 + "\t" + pino3);
                        pino1 = new StringBuilder("");
                        pino2 = new StringBuilder("");
                        pino3 = new StringBuilder("");
                    }

                    int entrada1 = -1;
                    int entrada2 = -1;

                    if (movimentos < 1) {
                        System.out.println("Digite para qual pino você quer mover o primeiro disco:");
                        Scanner input1 = new Scanner(System.in);
                        try {
                            entrada1 = input1.nextInt();
                        } catch (Exception e) {
                            System.out.println("O caracter inserido é invalido, favor inserir um numero");
                            temErro = true;
                        }
                    } else {
                        System.out.println("Digite de qual pino você quer remover o disco:");
                        Scanner input1 = new Scanner(System.in);
                        try {
                            entrada1 = input1.nextInt();
                        } catch (Exception e) {
                            System.out.println("O caracter inserido e invalido, favor inserir um numero");
                            temErro = true;
                        }

                        System.out.println("Digite para qual pino você quer mover o disco:");
                        Scanner input2 = new Scanner(System.in);
                        try {
                            entrada2 = input2.nextInt();
                        } catch (Exception e) {
                            System.out.println("O caracter inserido e invalido, favor inserir um numero");
                            temErro = true;
                        }
                    }

                    if (!temErro) {
                        if (entrada1 != -1 && entrada2 == -1) {
                            if (entrada1 == 1) {
                                System.out.println("O pino selecionado é o de origem. Favor selecionar outro pino");
                                temErro = true;
                            } else if (entrada1 < 1 || entrada1 > 3) {
                                System.out.println("O pino selecionado não existe. Favor selecionar outro pino");
                                temErro = true;
                            }

                            if (!temErro) {
                                switch (entrada1) {
                                    case 2: {
                                        pilhaEncadeada2.push(pilhaEncadeada1.pop());
                                        movimentos++;
                                        break;
                                    }
                                    case 3: {
                                        pilhaEncadeada3.push(pilhaEncadeada1.pop());
                                        movimentos++;
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    if (!temErro) {
                        if (entrada1 != -1 && entrada2 != -1) {
                            if (entrada1 < 1 || entrada1 > 3) {
                                System.out.println("O pino de onde o disco sera removido não existe. Favor selecionar um pino entre 1 e 3");
                                temErro = true;
                            }
                            if (entrada2 < 1 || entrada2 > 3) {
                                System.out.println("O pino onde o disco sera inserido não existe. Favor selecionar um pino entre 1 e 3");
                                temErro = true;
                            }

                            if (!temErro) {
                                switch (entrada1) {
                                    case 1: {
                                        if (pilhaEncadeada1.isEmpty()) {
                                            System.out.println("O pino de onde sera removido o disco se encontra vazio.");
                                            temErro = true;
                                        } else {
                                            switch (entrada2) {
                                                case 2: {
                                                    if (pilhaEncadeada2.size() == 5) {
                                                        System.out.println("O pino selecionado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaEncadeada2.isEmpty()) {
                                                            pilhaEncadeada2.push(pilhaEncadeada1.pop());
                                                            movimentos++;
                                                        } else if (pilhaEncadeada2.top() > pilhaEncadeada1.top()) {
                                                            pilhaEncadeada2.push(pilhaEncadeada1.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 2 e menor que o disco do pino 1.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 3: {
                                                    if (pilhaEncadeada3.size() == 5) {
                                                        System.out.println("O pino selecionado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaEncadeada3.isEmpty()) {
                                                            pilhaEncadeada3.push(pilhaEncadeada1.pop());
                                                            movimentos++;
                                                        } else if (pilhaEncadeada3.top() > pilhaEncadeada1.top()) {
                                                            pilhaEncadeada3.push(pilhaEncadeada1.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 3 e menor que o disco do pino 1.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Nao e possivel remover um disco e adicionalo no mesmo disco");
                                                    temErro = true;
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        if (pilhaEncadeada2.isEmpty()) {
                                            System.out.println("O pino de onde sera removido o disco se encontra vazio.");
                                            temErro = true;
                                        } else {
                                            switch (entrada2) {
                                                case 1: {
                                                    if (pilhaEncadeada1.size() == 5) {
                                                        System.out.println("O pino onde o disco sera colocado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaEncadeada1.isEmpty()) {
                                                            pilhaEncadeada1.push(pilhaEncadeada2.pop());
                                                            movimentos++;
                                                        } else if (pilhaEncadeada1.top() > pilhaEncadeada2.top()) {
                                                            pilhaEncadeada1.push(pilhaEncadeada2.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 1 e menor que o disco do pino 2.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 3: {
                                                    if (pilhaEncadeada3.size() == 5) {
                                                        System.out.println("O pino onde o disco sera colocado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaEncadeada3.isEmpty()) {
                                                            pilhaEncadeada3.push(pilhaEncadeada2.pop());
                                                            movimentos++;
                                                        } else if (pilhaEncadeada3.top() > pilhaEncadeada2.top()) {
                                                            pilhaEncadeada3.push(pilhaEncadeada2.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 3 e menor que o disco do pino 2.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Nao e possivel remover um disco e adicionalo no mesmo disco");
                                                    temErro = true;
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 3: {
                                        if (pilhaEncadeada3.isEmpty()) {
                                            System.out.println("O pino de onde sera removido o disco se encontra vazio.");
                                            temErro = true;
                                        } else {
                                            switch (entrada2) {
                                                case 1: {
                                                    if (pilhaEncadeada1.size() == 5) {
                                                        System.out.println("O pino onde o disco sera colocado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaEncadeada1.isEmpty()) {
                                                            pilhaEncadeada1.push(pilhaEncadeada3.pop());
                                                            movimentos++;
                                                        } else if (pilhaEncadeada1.top() > pilhaEncadeada3.top()) {
                                                            pilhaEncadeada1.push(pilhaEncadeada3.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 1 e menor que o disco do pino 3.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 2: {
                                                    if (pilhaEncadeada3.size() == 5) {
                                                        System.out.println("O pino onde o disco sera colocado se encontra cheio.");
                                                        temErro = true;
                                                    } else {
                                                        if (pilhaEncadeada2.isEmpty()) {
                                                            pilhaEncadeada2.push(pilhaEncadeada3.pop());
                                                            movimentos++;
                                                        } else if (pilhaEncadeada2.top() > pilhaEncadeada3.top()) {
                                                            pilhaEncadeada2.push(pilhaEncadeada3.pop());
                                                            movimentos++;
                                                        } else {
                                                            System.out.println("O primeiro disco do pino 2 e menor que o disco do pino 3.");
                                                            temErro = true;
                                                        }
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Nao e possivel remover um disco e adicionalo no mesmo disco");
                                                    temErro = true;
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (pilhaEncadeada3.equals(verificaFinal) && !temErro) {
                        finalizado = true;
                        System.out.println("Parabens voce chegou ai final do jogo!");
                        System.out.println("Foram realizados ao todos " + movimentos + " movimentos");
                    }
                }
                break;
            }
            case "sobre": {
                System.out.println("Jogo Torre de Hanoi desenvolvido por: ");
                System.out.println("Vinícius Führ de Borba");
                System.out.println("Willian Robson de Souza");
                break;
            }
            default: {
                System.out.println("A informação inserida não é válida");
                break;
            }
        }
        System.out.println("Jogo encerrado!");
    }
}
