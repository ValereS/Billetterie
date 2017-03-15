$("#seanceId").change(function() {
    $.get(
        "FrontController",
        {
            section: "showing-display",
            seanceId: $(this).val()
        },
        function(result) {
            $("#showing-display").html(result);
        }
    );
});

$("#seanceOK").remove();
