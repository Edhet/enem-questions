import { group, sleep } from "k6";
import PostLogin from "./scenarios/Post-Login.js";
import PostCadastro from "./scenarios/Post-Cadastro.js";
import GetProva from "./scenarios/Get-Prova.js";
import PostProva from "./scenarios/Post-Prova.js";


export default () => {
    group("EndPoint Post Login - Controller Login - EnemQuestions.api", () => {
        // receber o token
        PostProva();
    });



    sleep(2);
}