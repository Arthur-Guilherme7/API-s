// Executa quando a página carregar
document.addEventListener("DOMContentLoaded", () => {
  carregarAlunos();
});

// Função para buscar os alunos existentes (GET)
function carregarAlunos() {
  fetch("http://localhost:8080/api/alunos")
    .then((response) => response.json())
    .then((data) => {
      addLinhas(data);
    })
    .catch((error) => {
      console.error("Erro ao buscar dados:", error);
      Swal.fire({
        icon: 'error',
        title: 'Erro ao buscar dados',
        text: 'Não foi possível carregar os dados da API.'
      });
    });
}

// Adiciona uma ou mais linhas na tabela
function addLinhas(dadosAPI) {
  const tabela = document.getElementById("tabelaCorpo");
  tabela.innerHTML = ""; // limpa a tabela antes de adicionar
  dadosAPI.forEach((element) => {
    const linha = document.createElement("tr");
    linha.innerHTML = `
      <td class="px-4 py-2">${element.id || "-"}</td>
      <td class="px-4 py-2">${element.nome}</td>
      <td class="px-4 py-2">${element.email}</td>
      <td class="px-4 py-2">
        <button class="bg-red-500 text-white px-2 py-1 rounded" onclick="removerLinha(this)">Remover</button>
      </td>
    `;
    tabela.appendChild(linha);
  });
}

// Cadastrar novo aluno
function cadastrar(event) {
  event.preventDefault(); // Evita recarregar a página

  const nome = document.getElementById("nome").value.trim();
  const email = document.getElementById("email").value.trim();

  if (nome === "" || email === "") {
    Swal.fire({
      icon: 'warning',
      title: 'Atenção!',
      text: 'Preencha todos os campos.'
    });
    return;
  }

  const novoAluno = { nome, email };

  fetch("http://localhost:8080/api/alunos", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(novoAluno)
  })
    .then((response) => {
      if (!response.ok) throw new Error("Erro na resposta da API");
      return response.json();
    })
    .then((alunoCriado) => {
      Swal.fire({
        icon: 'success',
        title: 'Sucesso!',
        text: 'Cadastro realizado com sucesso.'
      });
      carregarAlunos(); // atualiza a tabela
      document.getElementById("formCadastro").reset();
    })
    .catch((error) => {
      console.error("Erro ao cadastrar:", error);
      Swal.fire({
        icon: 'error',
        title: 'Erro ao cadastrar',
        text: 'Não foi possível enviar os dados para a API.'
      });
    });
}

// Remover linha da tabela (apenas visualmente)
function removerLinha(botao) {
  const linha = botao.closest("tr");
  if (linha) linha.remove();
}
