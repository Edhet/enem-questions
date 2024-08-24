// JA TEM UM PROVA.MODELS, ALTERAR DEPOIS

export interface Prova {
    dataRealizacao: Date;
    informacoes: {
        dia: string;
        ano: number;
    };
    cor: string; // AMARELO, AZUL, BRANCO e ROSA
    acertos: number;
    erros: number;
}