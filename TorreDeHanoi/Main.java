import java.lang.reflect.Array;
import java.util.Arrays;
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
                PilhaVetor<Integer> pilhaVetor1 = new PilhaVetor<Integer>(5);
                PilhaVetor<Integer> pilhaVetor2 = new PilhaVetor<Integer>(5);
                PilhaVetor<Integer> pilhaVetor3 = new PilhaVetor<Integer>(5);

                PilhaVetor<Integer> verificaFinal;

                PilhaVetor<Integer> pilhaVetor1Aux = new PilhaVetor<Integer>(5);
                PilhaVetor<Integer> pilhaVetor2Aux = new PilhaVetor<Integer>(5);
                PilhaVetor<Integer> pilhaVetor3Aux = new PilhaVetor<Integer>(5);

                for (int i = 5; i >= 1; i--) {
                    pilhaVetor1.push(i);
                }

                verificaFinal = pilhaVetor1;

                while (!finalizado) {
                    if (temErro) {
                        temErro = false;
                    }

                    //for (int i = 1; i <= 5; i++) {
                    //    System.out.println(pilhaVetor1Aux.pop() + "\t" + pilhaVetor2Aux.pop() + "\t" + pilhaVetor3Aux.pop());
                    //}

                    int entrada1 = -1;
                    int entrada2 = -1;

                    if (movimentos < 1) {
                        System.out.println("Digite para qual pino você quer mover o primeiro disco:");
                        Scanner input1 = new Scanner(System.in);
                        try {
                            entrada1 = input1.nextInt();
                        } catch (Exception e) {
                            System.out.println("O caracter inserido e invalido, favor inserir um numero");
                            temErro = true;
                        }
                    } else {
                        System.out.println("Digite de qual pino você quer remover o disco:");
                        Scanner input1 = new Scanner(System.in);
                        try {
                            entrada1 = input1.nextInt();
                            System.out.println(entrada1);
                        } catch (Exception e) {
                            System.out.println("O caracter inserido e invalido, favor inserir um numero");
                            temErro = true;
                        }

                        System.out.println("Digite para qual pino você quer mover o disco:");
                        Scanner input2 = new Scanner(System.in);
                        try {
                            entrada2 = input2.nextInt();
                            System.out.println(entrada2);
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
                    if (pilhaVetor3 == verificaFinal && !temErro) {
                        finalizado = true;
                        System.out.println("Parabens voce chegou ai final do jogo!");
                        System.out.println("Foram realizados ao todos " + movimentos + " movimentos");
                    }
                }
                break;
            }
            case "dinamica": {
                PilhaEncadeada<Integer> pilhaEncadeada1 = new PilhaEncadeada<Integer>();
                PilhaEncadeada<Integer> pilhaEncadeada2 = new PilhaEncadeada<Integer>();
                PilhaEncadeada<Integer> pilhaEncadeada3 = new PilhaEncadeada<Integer>();
            }
            case "sobre": {
                System.out.println("");
            }
            default: {
                System.out.println("A informação inserido não é válida");
                return;
            }
        }
        System.out.println("Jogo encerrado!");
    }
}
