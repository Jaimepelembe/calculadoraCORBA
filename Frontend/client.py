import sys
from omniORB import CORBA
import CosNaming
import CalculadoraApp

def main():
    orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)

    naming_service = orb.resolve_initial_references("NameService")
    root_context = naming_service._narrow(CosNaming.NamingContext)

    name = [CosNaming.NameComponent("Calculadora", "")]
    obj = root_context.resolve(name)

    calc = obj._narrow(CalculadoraApp.Calculadora)
    if calc is None:
        print("Objecto não é uma Calculadora válida")
        sys.exit(1)

    isOn=True
    
    while isOn:
        opcao=input("\n===== CALCULADORA CORBA =====\n1 - Soma \n2 - Subtraccao \n3 - Multiplicacao \n4 - Divisao \n0 - Sair \nOpcao: ")
        opcao=int(opcao)
        if isinstance(opcao,int):
            
            if opcao == 0:
                print("A terminar o programa.")
                break
            else:        
                numero1=int(input("Primeiro numero: "))
                numero2=int(input("Segundo numero: "))
                 
            match opcao:
                case 1: 
                    resultado = calc.adicao(numero1,numero2)
                    
                case 2:
                    resultado = calc.subtracao(numero1,numero2)
                
                case 3:
                    resultado =calc.multiplicacao(numero1,numero2)
                case 4:
                    resultado= calc.divisao(numero1,numero2)                
                
                case _:
                    print(f"{opcao} e uma Opcao invalida")
                    continue
            
            print(f"Resultado = {resultado}")
        else:
            print(f"{opcao} nao e um inteiro. Digite um numero valido")            
    """  
    print("5 + 3 =", calc.adicao(5, 3))
    print("5 - 3 =", calc.subtracao(5, 3))
    print("5 * 3 =", calc.multiplicacao(5, 3))
    print("5 / 3 =", calc.divisao(5, 3))
"""  
if __name__ == "__main__":
    main()