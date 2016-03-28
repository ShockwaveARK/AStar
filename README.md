# AStar
Algoritmo A Star implementado para roteamento entre cidades
 > Feito usando a linguagem de programação Java

# Explicação
 > Algoritmo de roteamento para encontrar o menor caminho entre as cidades

 > Usa peso real e peso aparente para encontrar a solução

 > Leva em consideração a distância por estrada e a distância em linha reta

#Compilar
 > Navegue pelo terminal até a pasta onde estão os arquivos

 > Execute: javac Main.java

#Executar
 > Dentro da pasta após compilar

 > Execute: java Main <arquivo_de_teste> <Cidade_origem> <Cidade_destino>

#Arquivos de teste
 > teste1.txt

 > teste2.txt

#Configuração do arquivo de entrada
 > Modelo:

```
<numero_de_cidades>

<matriz_de_distancia_em_estrada>

<matriz_de_distancia_em_linha_reta>

```

 > Exemplo:
 
```
5

0 1 1 2 3
1 0 1 1 2
1 1 0 1 1
2 1 1 0 1
2 1 1 2 0

1 3 0 0 0
3 1 2 4 0
0 2 1 3 2
0 4 3 1 4
0 0 2 4 1

```

 > Cada linha representa uma cidade e a sua respectiva distância entre as outras

 > 0 (zero) define não existir conexão (Ou ser a própria cidade).
