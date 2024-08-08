import http, { get } from "k6/http";
import { sleep } from "k6";
import { Trend, Rate, Counter } from "k6/metrics";
import { check, fail } from "k6";

const url = 'http://localhost/api/v1/auth/login'

export default function () {
    let data = {
        "email": "admin@ablhds.com",
        "senha": "admin"
    }

    let res = http.post(url, JSON.stringify(data), {
        headers: { 'Content-Type': 'application/json' },
    });

    let token = res.json('token');

    console.log(token)

    let authHeaders = {
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
    };

    let resProva = http.get('http://localhost/api//v1/prova/all', authHeaders);

    console.log(resProva.json());

    sleep(3);
}