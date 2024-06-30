document.addEventListener('DOMContentLoaded', function () {
    const btnMesAnterior = document.getElementById('prevMonthBtn');
    const btnMesProximo = document.getElementById('nextMonthBtn');
    const exibicaoMesAno = document.getElementById('currentMonthYear');
    const corpoCalendario = document.getElementById('calendarBody');
    const popupAgendamento = document.getElementById('popupAgendamento');
    const btnAgendamento = document.getElementById('agendamento');
    const closePopup = document.querySelector('.close-popup');
    const formularioAgendamento = document.getElementById('formularioAgendamento');
    const novosEventos = document.getElementById('novosEventos');

    let mesAtual = new Date().getMonth(); // Mês atual (0-11)
    let anoAtual = new Date().getFullYear();
    const diaAtual = new Date().getDate();
    const dataAtual = new Date(anoAtual, mesAtual, diaAtual);

    const nomesMeses = [
        'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
        'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
    ];

    function atualizarCalendario(mes, ano) {
        corpoCalendario.innerHTML = '';

        let primeiroDia = new Date(ano, mes, 1);
        let diaInicial = primeiroDia.getDay();
        let ultimoDia = new Date(ano, mes + 1, 0).getDate();

        let data = 1;
        for (let i = 0; i < 6; i++) {
            let linha = document.createElement('tr');

            for (let j = 0; j < 7; j++) {
                let celula = document.createElement('td');
                if (i === 0 && j < diaInicial) {
                    linha.appendChild(celula);
                } else if (data > ultimoDia) {
                    linha.appendChild(celula);
                } else {
                    let link = document.createElement('a');
                    link.href = '#';
                    link.textContent = data;
                    link.classList.add('day-link');

                    let dataCelula = new Date(ano, mes, data);

                    if (dataCelula.toDateString() === dataAtual.toDateString()) {
                        link.classList.add('dia-atual');
                    }

                    if ((dataCelula > dataAtual || dataCelula.toDateString() === dataAtual.toDateString()) && dataCelula.getDay() !== 0 && dataCelula.getDay() !== 6) {
                        link.classList.add('horario-disponivel');
                    }

                    link.addEventListener('click', function () {
                        if (dataCelula >= dataAtual) {
                            const elementosAtuais = document.querySelectorAll('.dia-atual');
                            elementosAtuais.forEach(elemento => elemento.classList.remove('dia-atual'));
                            link.classList.add('dia-atual');
                        }
                    });

                    celula.appendChild(link);
                    linha.appendChild(celula);
                    data++;
                }
            }
            corpoCalendario.appendChild(linha);

            if (data > ultimoDia) {
                break;
            }
        }
        exibicaoMesAno.textContent = `${nomesMeses[mes]} ${ano}`;
    }

    atualizarCalendario(mesAtual, anoAtual);

    btnMesAnterior.addEventListener('click', function () {
        mesAtual--;
        if (mesAtual < 0) {
            mesAtual = 11;
            anoAtual--;
        }
        atualizarCalendario(mesAtual, anoAtual);
    });

    btnMesProximo.addEventListener('click', function () {
        mesAtual++;
        if (mesAtual > 11) {
            mesAtual = 0;
            anoAtual++;
        }
        atualizarCalendario(mesAtual, anoAtual);
    });

    // Abre o popup de agendamento
    btnAgendamento.addEventListener('click', function () {
        popupAgendamento.style.display = 'block';
    });

    // Fecha o popup de agendamento
    closePopup.addEventListener('click', function () {
        popupAgendamento.style.display = 'none';
    });

    // Adiciona o evento ao clicar no botão "Agendar"
    formularioAgendamento.addEventListener('submit', function (e) {
        e.preventDefault(); // Evita o envio do formulário

        const cliente = document.getElementById('cliente').value;
        const animal = document.getElementById('animal').value;
        const data = document.getElementById('data').value;
        const hora = document.getElementById('hora').value;
        const servico = document.getElementById('servico').value;

        // Formatação da data
        const dataFormatada = new Date(data);
        const dia = String(dataFormatada.getDate()).padStart(2, '0');
        const mes = String(dataFormatada.getMonth() + 1).padStart(2, '0');
        const ano = dataFormatada.getFullYear();
        const dataFormatadaString = `${dia}/${mes}/${ano}`;

        // Formatação da hora
        const [horaFormatada, minutosFormatados] = hora.split(':');
        const horaFormatadaString = `${horaFormatada}:${minutosFormatados}`;

        const novoEvento = document.createElement('div');
        novoEvento.classList.add('evento');
        novoEvento.innerHTML = `
            <p><strong>Cliente:</strong> ${cliente}</p>
            <p><strong>Animal:</strong> ${animal}</p>
            <p><strong>Data:</strong> ${dataFormatadaString}</p>
            <p><strong>Hora:</strong> ${horaFormatadaString}</p>
            <p><strong>Serviço:</strong> ${servico}</p>
        `;

        novosEventos.appendChild(novoEvento);

        // Limpa o formulário
        formularioAgendamento.reset();

        // Fecha o popup
        popupAgendamento.style.display = 'none';
    });
});
