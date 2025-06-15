document.addEventListener("DOMContentLoaded", () => {
  carregarFuncionarios();
  carregarCargos();
  document.getElementById("formVinculo").addEventListener("submit", salvarVinculo);
});

const apiFun = "http://localhost:8080/api/usuarios";
const apiCargo = "http://localhost:8080/api/cargos";
const apiVinc = "http://localhost:8080/api/funcionarioscargo";

function carregarFuncionarios() {
  fetch(apiFun).then(res => res.json()).then(data => {
    const sel = document.getElementById("funcionario");
    data.forEach(f => sel.add(new Option(f.nome, f.id)));
  }).catch(() => Swal.fire("Erro", "Não foi possível carregar funcionários", "error"));
}

function carregarCargos() {
  fetch(apiCargo).then(res => res.json()).then(data => {
    const sel = document.getElementById("cargo");
    data.forEach(c => sel.add(new Option(c.nome, c.id)));
  }).catch(() => Swal.fire("Erro", "Não foi possível carregar cargos", "error"));
}

function salvarVinculo(e) {
  e.preventDefault();
  const body = {
    funcionarioId: parseInt(document.getElementById("funcionario").value),
    cargoId: parseInt(document.getElementById("cargo").value),
    dataInicio: document.getElementById("dataInicio").value,
    dataFim: document.getElementById("dataFim").value || null,
    detalhes: document.getElementById("detalhes").value.trim()
  };
  fetch(apiVinc, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(body)
  }).then(res => {
    if (!res.ok) throw new Error("Erro ao salvar vínculo");
    return res.json();
  }).then(() => {
    Swal.fire("Sucesso", "Vínculo cadastrado!", "success");
    document.getElementById("formVinculo").reset();
  }).catch(() => Swal.fire("Erro", "Não foi possível salvar o vínculo", "error"));
}
