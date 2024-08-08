import http from "k6/http";
import { sleep } from "k6";
import { Trend, Rate, Counter } from "k6/metrics";
import { check, fail } from "k6";

const urllogin = 'http://localhost/api/v1/auth/login';

const url = 'http://localhost/api//v1/prova/nova';

export default function () {
    let dataLogin = {
        "email": "admin@ablhds.com",
        "senha": "admin"
    }

    let resLogin = http.post(urllogin, JSON.stringify(dataLogin), {
        headers: { 'Content-Type': 'application/json' },
    });

    let token = resLogin.json('token');

    let authHeaders = {
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        },
    };

    let data = {
        "nome": "Nova prova " + Math.random(20),
        "areaProva": "EXATAS",
        "diaDeProva": "SEGUNDO",
        "ano": 2022,
        "cor": "Amarelo",
        "questoes": [
            {
                "numeroQuestao": 1,
                "dificuldadeQuestao": "MEDIO",
                "opcoes": [
                    {
                        "label": "A",
                        "texto": "Opcao um"
                    },
                    {
                        "label": "B",
                        "texto": "Opcao dois"
                    }
                ],
                "enunciado": "Enunciado de teste para checar a criação de provas",
                "labelOpcaoCorreta": "A"
            }
        ]
    }
    let res = http.post(url, JSON.stringify(data), authHeaders);
}