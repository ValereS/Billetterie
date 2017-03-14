$("#seanceId").change(function() {
    $.ajax({
        url: "FrontController?section=showing-display&seanceId=" + $("#seanceId option:selected").val(),
        success: function(result) {
            $("#showing-display").html(result);
        }
    });
});

$("#seanceOK").remove();
