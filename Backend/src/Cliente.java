/**
 * Para rodar o cliente "java cliente -ORBInitial Port 1050 -ORBInitialHost localhost"
 */

import CalculadoraApp.Calculadora;
import CalculadoraApp.CalculadoraHelper;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.util.Scanner;


public class Cliente {

    public static void main(String[] args) {
        
        try{
            //Inicializar ORB
            ORB orb= ORB.init(args,null);

            //Obter Naming Service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt namingContext = NamingContextExtHelper.narrow(objRef);

            //Procurar a calculadora
            Calculadora calculadora = CalculadoraHelper.narrow(namingContext.resolve_str("Calculadora"));


            //Inicializar o objecto Scanner para fazer leitura de teclado
            Scanner scanner = new Scanner(System.in);

            while (true){

                
                System.out.println();
                System.out.println("===== CALCULADORA CORBA =====");
                System.out.println("1 - Soma");
                System.out.println("2 - Subtraccao");
                System.out.println("3 - Multiplicacao");
                System.out.println("4 - Divisao");
                System.out.println("0 - Sair");

                System.out.print("Opcao: ");
                int opcao = scanner.nextInt();

                if (opcao == 0) {
                    System.out.println("A terminar...");
                    break;
                }

                 System.out.print("Primeiro numero: ");
                int a = scanner.nextInt();

                System.out.print("Segundo numero: ");
                int b = scanner.nextInt();

                double resultado;

                switch (opcao) {

                    case 1:
                        resultado =
                            calculadora.adicao(a, b);
                        break;

                    case 2:
                        resultado =
                            calculadora.subtracao(a, b);
                        break;

                    case 3:
                        resultado =
                            calculadora.multiplicacao(a, b);
                        break;

                    case 4:
                        resultado =
                            calculadora.divisao(a, b);
                        break;

                    default:
                        System.out.println(
                            "Opcao invalida."
                        );
                        continue;
                }

                System.out.println("Resultado = " + resultado);
                
            }

            scanner.close();

            

       
    }

     catch(Exception e){
            System.err.println("Erro: "+e);
            e.printStackTrace(System.out);
        }

    
}
}
