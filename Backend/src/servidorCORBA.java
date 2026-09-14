/**
 * Para Compilar arquivos normalmente use o comando: javac *.java CalculadoraApp/*.java
 * Executar o daemon do serviço(Servidor) de nomes "java orbd -ORBInitialPort 1050"
 * Rodar o servidor "java ServidorCORBA -ORBInitialPort 1050 -ORBInitialHost localhost"
 */

import CalculadoraApp.Calculadora;
import CalculadoraApp.CalculadoraHelper;


import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 * Primeiro temos que rodar o servidor de nomes
 * O servidorCORBA roda e regista o objecto no servidor de nome
 * O cliente faz acesso ao servidor de nomes para poder acessar ao referência ao objecto
 * 
 * 
 * servidorCORBA
 */
public class servidorCORBA {

    public static void main(String[] args) {
        try{
            //Criar e inicializa o ORB
            ORB orb = ORB.init(args,null);

            //Obter o  RootPOA (Portable Object Adapter) e ativa o gerenciador POA
            POA rootpoa =POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate(); 

            //Cria o serviço (Implementacao da calculadora) e registra ele com o ORB (Object Request Broker)
            CalculadoraImpl calculadoraImpl = new CalculadoraImpl();
            calculadoraImpl.setORB(orb);

            //Registar o Objecto (Calculadora) no POA:  Obtém a referência ao serviço disponibilizado pelo servidor 
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calculadoraImpl);
            
            //Converter para a referencia Calculadora
            Calculadora calculadora = CalculadoraHelper.narrow(ref);

            //Obter a referência para o serviço de nomes(Servidor de nomes/ Naming Service)
            org.omg.CORBA.Object objRef= orb.resolve_initial_references("NameService");
            NamingContextExt namingRef = NamingContextExtHelper.narrow(objRef);

            //Criar nome para o objecto: Vincula a referência do objecto a um nome, no servidor de nomes
            String objNome="Calculadora";
            NameComponent path[] = namingRef.to_name(objNome);

            //Registar o Naming Service
            namingRef.rebind(path,calculadora);

            System.out.println("Servidor pronto e aguardando pedidos!");

            //Aguarda pela invocação dos clientes
            orb.run();
            
        } catch (Exception e){
            System.err.println("Erro: "+e);
            e.printStackTrace(System.out);

        }



    }
}
