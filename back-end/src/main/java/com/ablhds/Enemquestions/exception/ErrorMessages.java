package com.ablhds.Enemquestions.exception;

public interface ErrorMessages {
    String CADASTRO_CAMPO_INVALIDO = "O campo '%s' está inválido";
    String USUARIO_EMAIL_EM_USO = "Este email já está em uso";
    String USUARIO_SENHA_INVALIDA = "A senha fornecida é inválida";
    String USUARIO_NAO_ENCONTRADO = "Usuário não encontrado";
    String CONTA_DESATIVADA = "A conta está desativada";
    String CONTA_ATIVADA = "A conta está ativada";
    String PROVA_NAO_ENCONTRADA = "Prova não encontrada";
    String PROVA_COM_ID_ARBITRARIO = "A prova possui um id arbitrário";
    String QUESTAO_PROVA_TEM_LABELS_REPETIDOS = "A prova possui labels repetidos na opções de uma questão";
    String PROVA_TEM_QUESTOES_REPETIDAS = "A prova possui questões com números repetidos";
    String QUESTAO_CORRETA_FORA_DA_LISTA_DE_OPCOES = "Uma opção correta não está na lista de opções da questão";
    String NAO_AUTORIZADO = "Acesso não autorizado";
    String APLICACAO_PROVA_NAO_ENCONTRADA = "Aplicação de Prova não encontrada";
    String QUESTAO_NAO_ENCONTRADA = "Questão não encontrada";
    String RESPOSTA_QUESTAO_INVALIDA = "Uma das respostas se refere a uma questão que não está na prova";
    String RESPOSTA_OPCAO_INVALIDA = "A opção selecionada para uma questão não foi encontrada para a questão da prova";
    String OPCAO_NAO_ENCONTRADA = "Opção em questão não encontrada";
}
