document.addEventListener("DOMContentLoaded", () => {
  document.getElementById("btnBuscar").addEventListener("click", buscar);
  carregarFuncionarios();
  carregarCargos();
});

function carregarFuncionarios() {
  fetch("http://localhost:8080/api/funcionarios")
    .then(res => {
      if (!res.ok) throw new Error("Erro ao buscar funcionários");
      return res.json();
    })
    .then(data => {
      const select = document.getElementById("fFuncionario");
      select.innerHTML = '<option value="">Todos</option>';
      data.forEach(func => {
        const nome = func.nome || func.nomeCompleto || "Sem nome";
        select.innerHTML += `<option value="${func.id}">${nome}</option>`;
      });
    })
    .catch(err => {
      console.error("Erro ao carregar funcionários:", err);
      Swal.fire("Erro", "Não foi possível carregar os funcionários", "error");
    });
}

function carregarCargos() {
  fetch("http://localhost:8080/api/cargos")
    .then(res => {
      if (!res.ok) throw new Error("Erro ao buscar cargos");
      return res.json();
    })
    .then(data => {
      const select = document.getElementById("fCargo");
      select.innerHTML = '<option value="">Todos</option>';
      data.forEach(cargo => {
        select.innerHTML += `<option value="${cargo.idCargo}">${cargo.nome}</option>`;
      });
    })
    .catch(err => {
      console.error("Erro ao carregar cargos:", err);
      Swal.fire("Erro", "Não foi possível carregar os cargos", "error");
    });
}

function buscar() {
  const funcionarioId = document.getElementById("fFuncionario").value;
  const cargoId = document.getElementById("fCargo").value;

  let url = new URL("http://localhost:8080/api/funcionarioscargo");
  if (funcionarioId) url.searchParams.append("funcionarioId", funcionarioId);
  if (cargoId) url.searchParams.append("cargoId", cargoId);

  fetch(url)
    .then(res => {
      if (!res.ok) throw new Error("Erro ao buscar vínculos");
      return res.json();
    })
    .then(data => {
      const tbody = document.getElementById("tabelaVinculos");
      tbody.innerHTML = "";
      data.forEach(v => {
        const funcionario = v.funcionario?.nome || "N/A";
        const cargo = v.cargo?.nome || "N/A";
        const inicio = v.dataInicio || "-";
        const fim = v.dataFim || "-";
        const detalhes = v.detalhes || "-";
        tbody.innerHTML += `
          <tr>
            <td class="p-2 border">${funcionario}</td>
            <td class="p-2 border">${cargo}</td>
            <td class="p-2 border">${inicio}</td>
            <td class="p-2 border">${fim}</td>
            <td class="p-2 border">${detalhes}</td>
          </tr>
        `;
      });
    })
    .catch(err => {
      console.error("Erro ao buscar vínculos:", err);
      Swal.fire("Erro", "Não foi possível carregar os vínculos", "error");
    });
}
