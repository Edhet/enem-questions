import http from 'k6/http';
import { check, sleep } from 'k6';
import { Trend, Rate, Counter } from "k6/metrics";

const url = 'http://localhost/api/v1/auth/login';

export default function () {
  let data = {
    "email": "admin@ablhds.com",
    "senha": "admin"
  }

  let res = http.post(url, JSON.stringify(data), {
    headers: { 'Content-Type': 'application/json' },
  });

  console.log(res.json());

  return res.json();
}