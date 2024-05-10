(function() {
    $("#tabprodutos").on("click", ".js-delete", function() {
        let botaoclicado = $(this);
        $("#btnsim").attr("data-id", botaoclicado.attr("data-id"));
        $("#modalproduto").modal("show");
    });

    $("#btnsim").on("click", function() {
        let botaosim = $(this);
        let id = botaosim.attr("data-id");
        $.ajax({
            url: "/produtos/delete/" + id,
            method: "GET",
            success: function() {
                window.location.href = "/produtos";
            }
        });
    });
})();