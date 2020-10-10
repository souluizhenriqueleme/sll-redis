## Instalando o Redis no MAC

Instalação com Brew

````
brew install redis
````

## Iniciando com o Redis

#### Inicializando o servidor

````
brew services start redis
````

#### Redis CLI

````
redis-cli
````

##### Primeiros comandos

````
[127.0.0.1:6379> ECHO "Jabulani"
"Jabulani"
````

Criando a primeira chave

````
[127.0.0.1:6379> SET ultimo_heroi "Chuck Norris"
OK
````
Recuperando o valor da chave

````
[127.0.0.1:6379> GET ultimo_heroi
"Chuck Norris"
````
Deletando a chave

````
[127.0.0.1:6379> DELETE ultimo_heroi
(integer) 1
````
