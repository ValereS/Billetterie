$("#seanceId").change(function() {
    $.ajax({
        url: "FrontController?section=showing-display&seanceId=" + $("#seanceId").val(),
        success: function(result) {
            $("#showing-display").html(result);
        }
    });
});

$("#seanceOK").remove();
