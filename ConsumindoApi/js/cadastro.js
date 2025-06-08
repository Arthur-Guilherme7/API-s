document.getElementById("cadastroForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Impede envio real

    const nome = document.getElementById("idnome").value;
    const email = document.getElementById("idemail").value;

    Swal.fire({
        icon: "Sucesso",
        title: "Cadastro realizado!",
        text: `Bem-vindo, ${nome}! Verifique o email ${email}.`,
    });
});

// Função para buscar CEP automaticamente
document.getElementById("idcep").addEventListener("blur", function () {
    const cep = this.value.replace(/\D/g, "");

    if (cep.length !== 8) {
        Swal.fire({
            icon: "Tente novamente",
            title: "CEP inválido",
            text: "Digite um CEP com 8 números.",
        });
        return;
    }

    fetch(`https://viacep.com.br/ws/${cep}/json/`)
        .then(response => response.json())
        .then(data => {
            if (data.erro) {
                Swal.fire({
                    icon: "Error",
                    title: "CEP não encontrado",
                    text: "Por favor, verifique o CEP digitado.",
                });
            } else {
                document.getElementById("idendereço").value = data.logradouro || "";
                document.getElementById("idbairro").value = data.bairro || "";
                document.getElementById("idcidade").value = data.localidade || "";
                document.getElementById("idestado").value = data.uf || "";
            }
        })
        .catch(() => {
            Swal.fire({
                icon: "error",
                title: "Erro de conexão",
                text: "Não foi possível consultar o CEP.",
            });
        });
});
