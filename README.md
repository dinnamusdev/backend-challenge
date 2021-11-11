# Documentação Api Backend-challenge
Spring boot Api Rest de validação de senha


# Detalhes sobre a solução
	Para implementar essa api inicialmente criei um componente que encapsulou todas as	validações solicitadas.		
	
	Para realizar a validação da senha foi criado um serviço de validação que faz uso desse componente de validação.
	
	Tanto o serviço de validação como o componente validador são utilizados através de suas respectivas 	abstrações.
	
# Métodos da Api

| Método | Descrição |
|---|---|
| `POST` | realiza a operação de validação. |

# Resposta
| Código | Descrição |
|---|---|
| `200` | Operação de validação realizada |
| `400` | Erros na operação de validação |

# Método de validação de Senha [POST]
Uri:  /validator/v1/public/password

Utilize para a validação da senha. C

#### Dados para envio no POST
| Parâmetro | Descrição |
|---|---|
| `password` | Informar: A senha a ser validada |

+ Request (application/json)

    + Body

            {
                "password": "AbTp9!fok"                
            }

+ Response 200 (application/json)

    + Body

            {
                "passwordValidation": true                
            }
            
# Procedimento para execução do api
	1) Instalar o java JRE 1.8
	1) Abrir o prompt de comando e/ou shell
	1) Acessar a pasta raiz do projeto
	2) Executar o comando : mvn spring-boot:run
	