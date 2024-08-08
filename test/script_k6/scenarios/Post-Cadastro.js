import http from 'k6/http';
import { check, sleep } from 'k6';
import { Trend, Rate, Counter } from "k6/metrics";

const url = 'http://localhost/api/v1/auth/login';

const urlcadastro = 'http://localhost/api/v1/auth/cadastro';

export default function () {
  let dataLogin = {
    "email": "admin@ablhds.com",
    "senha": "admin"
  }

  let resLogin = http.post(url, JSON.stringify(dataLogin), {
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
    "nome": "teste",
    "email": "mais" + Math.random(20) + "-um@teste.com",
    "senha": "teste"
  }

  console.log(data)

  let res = http.post(urlcadastro, JSON.stringify(data), authHeaders);
  
  console.log(res.json());
}