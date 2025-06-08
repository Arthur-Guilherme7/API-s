document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Impede o envio do formulário

    const email = document.getElementById("iemail").value;
    const senha = document.getElementById("isenha").value;

    if (email && senha) {
        // Simulação de login
        if (email === "admin@teste.com" && senha === "1234") {
            Swal.fire({
                icon: "success",
                title: "Login realizado com sucesso!",
                text: `Bem-vindo, ${email}`
            });
        } else {
            Swal.fire({
                icon: "error",
                title: "Falha no login",
                text: "Email ou senha incorretos"
            });
        }
    }
});
