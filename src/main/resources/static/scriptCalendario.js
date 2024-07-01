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

    let mesAtual = new Date().getMonth();
    let anoAtual = new Date().getFullYear();
    let diaAtual = new Date().getDate();
    let dataAtual = new Date(anoAtual, mesAtual, diaAtual);

    const nomesMeses = [
        'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
        'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
    ];

    // Recupera os eventos salvos no localStorage ou inicializa como um array vazio
    let eventos = JSON.parse(localStorage.getItem('eventos')) || [];

    function formatarData(dataISO) {
        const data = new Date(dataISO);
        const dia = String(data.getUTCDate()).padStart(2, '0');
        const mes = String(data.getUTCMonth() + 1).padStart(2, '0');
        const ano = data.getUTCFullYear();
        return `${dia}/${mes}/${ano}`;
    }

    function compararHorarios(evento1, evento2) {
        const hora1 = evento1.hora.split(':').map(Number);
        const hora2 = evento2.hora.split(':').map(Number);

        if (hora1[0] !== hora2[0]) {
            return hora1[0] - hora2[0];
        } else {
            return hora1[1] - hora2[1];
        }
    }

    function atualizarEventosDia(data) {
        const dataAtualFormatada = data.toISOString().split('T')[0];
        const eventosHoje = eventos.filter(evento => evento.data === dataAtualFormatada);

        eventosHoje.sort(compararHorarios); // Ordena os eventos por horário

        novosEventos.innerHTML = '';
        if (eventosHoje.length === 0) {
            const semCompromissos = document.createElement('div');
            semCompromissos.classList.add('evento');
            semCompromissos.textContent = 'Sem compromissos hoje';
            novosEventos.appendChild(semCompromissos);
        } else {
            eventosHoje.forEach(evento => {
                const novoEvento = document.createElement('div');
                novoEvento.classList.add('evento');
            
                novoEvento.innerHTML = `
                    <p><strong>Cliente:</strong> ${evento.cliente}</p>
                    <p><strong>Animal:</strong> ${evento.animal}</p>
                    <p><strong>Nome do pet:</strong> ${evento.nomeAnimal}</p>
                    <p><strong>Data:</strong> ${formatarData(evento.data)}</p>
                    <p><strong>Hora:</strong> ${evento.hora}</p>
                    <p><strong>Serviço:</strong> ${evento.servico}</p>
                `;
            
                // Botão de editar
                const btnEditar = document.createElement('button');
                btnEditar.textContent = 'Editar';
                btnEditar.classList.add('btn', 'btn-primary', 'btn-sm', 'me-2');
                btnEditar.addEventListener('click', function() {
                    // Preenche o formulário de edição com os detalhes atuais do evento
                    document.getElementById('cliente').value = evento.cliente;
                    document.getElementById('animal').value = evento.animal;
                    document.getElementById('nomeAnimal').value = evento.nomeAnimal;
                    document.getElementById('data').value = evento.data;
                    document.getElementById('hora').value = evento.hora;
                    document.getElementById('servico').value = evento.servico;
            
                    // Exibe o formulário de agendamento para edição
                    popupAgendamento.style.display = 'block';
            
                    // Define uma função para atualizar o evento ao salvar as alterações
                    formularioAgendamento.onsubmit = function(e) {
                        e.preventDefault();
            
                        // Atualiza os detalhes do evento na lista de eventos
                        evento.cliente = document.getElementById('cliente').value;
                        evento.animal = document.getElementById('animal').value;
                        evento.nomeAnimal = document.getElementById('nomeAnimal').value;
                        evento.data = document.getElementById('data').value;
                        evento.hora = document.getElementById('hora').value;
                        evento.servico = document.getElementById('servico').value;
            
                        // Atualiza o localStorage com a lista de eventos modificada
                        localStorage.setItem('eventos', JSON.stringify(eventos));
            
                        // Atualiza a visualização dos eventos na tela
                        atualizarEventosDia(dataAtual);
            
                        // Esconde o popup de agendamento após a edição
                        popupAgendamento.style.display = 'none';
                    };
                });
            
                // Botão de deletar
                const btnDeletar = document.createElement('button');
                btnDeletar.textContent = 'Deletar';
                btnDeletar.classList.add('btn', 'btn-outline-danger', 'btn-sm');
                btnDeletar.addEventListener('click', function() {
                    const confirmacao = confirm('Tem certeza que deseja deletar este evento?');
                    if (confirmacao) {
                        // Remove o evento da lista de eventos
                        eventos = eventos.filter(e => e !== evento);
            
                        // Atualiza o localStorage com a lista de eventos modificada
                        localStorage.setItem('eventos', JSON.stringify(eventos));
            
                        // Atualiza a visualização dos eventos na tela
                        atualizarEventosDia(dataAtual);
                    }
                });
            
                novoEvento.appendChild(btnEditar);
                novoEvento.appendChild(btnDeletar);
                novosEventos.appendChild(novoEvento);
            });
            
        }
    }

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

                    // Verifica se é um dia útil (segunda a sexta-feira)
                    if (dataCelula.getDay() !== 0 && dataCelula.getDay() !== 6) {
                        link.addEventListener('click', function () {
                            if (dataCelula >= new Date(ano, mesAtual, diaAtual)) {
                                const elementosAtuais = document.querySelectorAll('.dia-atual');
                                elementosAtuais.forEach(elemento => elemento.classList.remove('dia-atual'));
                                link.classList.add('dia-atual');

                                // Atualizar a data atual para a data clicada
                                dataAtual = dataCelula;
                                atualizarEventosDia(dataAtual);
                            }
                        });

                        // Adiciona a classe de horário disponível apenas se for um dia útil
                        if (dataCelula > dataAtual || dataCelula.toDateString() === dataAtual.toDateString()) {
                            link.classList.add('horario-disponivel');
                        }
                    } else {
                        // Se for sábado (6) ou domingo (0), exibe um alerta ao tentar adicionar evento
                        link.addEventListener('click', function (event) {
                            event.preventDefault();
                            alert('Eventos não podem ser agendados aos sábados ou domingos.');
                        });
                        link.classList.add('nao-disponivel');
                    }

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

    btnAgendamento.addEventListener('click', function () {
        popupAgendamento.style.display = 'block';
    });

    closePopup.addEventListener('click', function () {
        popupAgendamento.style.display = 'none';
    });

    formularioAgendamento.addEventListener('submit', function (e) {
        e.preventDefault();

        const cliente = document.getElementById('cliente').value;
        const animal = document.getElementById('animal').value;
        const nomeAnimal = document.getElementById('nomeAnimal').value;
        const data = document.getElementById('data').value;
        const hora = document.getElementById('hora').value;
        const servico = document.getElementById('servico').value;

        const dataFormatada = new Date(data + 'T00:00:00');
        const dia = String(dataFormatada.getUTCDate()).padStart(2, '0');
        const mes = String(dataFormatada.getUTCMonth() + 1).padStart(2, '0');
        const ano = dataFormatada.getUTCFullYear();
        const dataFormatadaString = `${ano}-${mes}-${dia}`; // Formato ISO

        // Verifica se é um dia útil (segunda a sexta-feira)
        if (dataFormatada.getDay() === 0 || dataFormatada.getDay() === 6) {
            alert('Eventos não podem ser agendados aos sábados ou domingos.');
            return;
        }

        const novoEvento = {
            cliente,
            animal,
            nomeAnimal,
            data: dataFormatadaString,
            hora,
            servico
        };

        eventos.push(novoEvento);

        // Salva os eventos no localStorage
        localStorage.setItem('eventos', JSON.stringify(eventos));

        atualizarEventosDia(dataAtual);

        formularioAgendamento.reset();
        popupAgendamento.style.display = 'none';
    });

    // Atualiza os eventos do dia atual na inicialização
    atualizarEventosDia(dataAtual);
});