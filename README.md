# Calculadora usando CORBA

Essa é uma implementação de uma calculadora simples utilizando a tecnologia CORBA.

## 📋 Descrição

Este é um projecto simples desenvolvido utilizando a tecnologia CORBA. O projecto está dividido em duas partes, o Frontend e o Backend.

O Backend foi desenvolvido em Java e o Frontend(cliente) foi desenvolvido em Python



## 🛠️ Tecnologias utilizadas

- Python 3.13.12
- Java 8
- CORBA
- Git version 2.53.0.windows.1
- Github

## 📁 Estrutura do projeto

```text
calculadoraCORBA/
│
├── Backend/
│   ├── .vscode/
│   ├── lib/
│   └── src/
│       ├── CalculadoraApp/
│       ├── calculadora.idl
│       ├── CalculadoraImpl.class
│       ├── CalculadoraImpl.java
│       ├── Cliente.class
│       ├── Cliente.java
│       ├── servidorCORBA.class
│       └── servidorCORBA.java
│
├── Frontend/
│   ├── CalculadoraApp/
│   ├── CalculadoraApp_POA/
│   ├── calculadora_idl.py
│   └── client.py
│
├── LICENSE.txt
└── README.md

```

## 🚀 Como executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/Jaimepelembe/calculadoraCORBA.git
   ```
2. Entre na pasta do projeto:
   ```bash
   cd calculadoraCORBA
   ```
3. Execute o programa:

Para executar o servidor primeiro é necessário estar na pasta Backend/src. Em seguida
executar o servidor de nomes numa porta especifica, utilizando o comando: tnameserv -ORBInitialPort 5000

Por fim executar o servidor servidorCORBA, utilizando o seguinte comando:  java servidorCORBA -ORBInitialPort 5000

Para executar o cliente primeiro é necessário estar na pasta Frontend. 
Em seguida executar o cliente(client) na mesma porta que o servidor, utilizando o comando: python client.py -ORBInitRef NameService=corbaname::localhost:5000    



## 👤 Autor

Desenvolvido por **Jaime Fernando**

- GitHub: [@jaimepelembe](https://github.com/jaimepelembe)

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE.txt) para mais detalhes.