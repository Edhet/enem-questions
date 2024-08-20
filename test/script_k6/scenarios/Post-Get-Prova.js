import http from "k6/http";
import { sleep } from "k6";
import { Trend, Rate, Counter } from "k6/metrics";
import { check, fail } from "k6";

const urllogin = 'http://localhost/api/v1/auth/login';
const urlPostProva = 'http://localhost/api//v1/prova/nova';
const urlget = 'http://localhost/api//v1/prova/all';

export default function () {

    let token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhYmxoZHMuY29tIiwiaWF0IjoxNzI0MTEwMTEwLCJleHAiOjE3MjQxOTY1MTB9.8Jt90mbNJ1t2iWSWl7qLFzoHgWWjiOXtkgp0UwxpgO7TvXOGcrrFm1OXEoeO2_oJ6r5M-qdcI-aGEw5HBvFxFQ"

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

    let res = http.post(urlPostProva, JSON.stringify(data), authHeaders);

    let resget = http.get(urlget,authHeaders);
}
