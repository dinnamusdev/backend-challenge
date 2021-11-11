# Documentação Api Backend-challenge
Spring boot Api Rest de validação de senha

# Métodos

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
	