import { group, sleep } from "k6";
import GetProva from "./scenarios/Get-Prova.js";
import PostCadastro from "./scenarios/Post-Cadastro.js";
import PostLogin from "./scenarios/Post-Login.js";
import PostProva from "./scenarios/Post-Prova.js";

export default () => {
    group("EndPoint Post Login - Controller Login - EnemQuestions.api", () => {
        PostProva();
    });

    sleep(2);
}