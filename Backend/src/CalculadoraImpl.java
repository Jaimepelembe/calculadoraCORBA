import CalculadoraApp.CalculadoraPOA;

import org.omg.CORBA.ORB;

//Esta é a classe que realiza os cálculos aritméticos

public class CalculadoraImpl extends CalculadoraPOA {
    private ORB orb;

    public void setORB(ORB orb_val){
        orb=orb_val;
    }


    //Implementa os métodos declarados na interface CalculadoraOperations

    @Override 
    public double adicao(double a, double b){
        /**
         * Adiciona de dois números
         * @param a numero 1
         * @param b numero 2
         * @return A adição de dois numeros
         *  */ 
        return a+b;
    }


    @Override 
    public double subtracao(double a, double b){
        /**
         * Subtrai de dois números
         * @param a numero 1
         * @param b numero 2
         * @return A subtração dos dois numeros
         *  */ 
        return a-b;
    }


    @Override 
    public double multiplicacao(double a, double b){
        /**
         * Multiplica dois números
         * @param a numero 1
         * @param b numero 2
         * @return A multiplicação de dois numeros
         *  */ 
        return a*b;
    }


    @Override 
    public double divisao(double a, double b){
        /**
         * Multiplica dois números
         * @param a numero 1
         * @param b numero 2
         * @return A multiplicação de dois numeros
         *  */ 

        if (b==0){
            throw new ArithmeticException("Nao e possivel dividir por zero");
        }

        return a/b;
    }



    




    
}
