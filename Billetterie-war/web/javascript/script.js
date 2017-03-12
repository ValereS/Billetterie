function getXhr() {
    var xhr = null;
    if (window.XMLHttpRequest) // Firefox et autres
        xhr = new XMLHttpRequest();
    else if (window.ActiveXObject) { // Internet Explorer
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    else { // XMLHttpRequest non supporté par le navigateur
        alert("Votre navigateur ne supporte pas les objets XMLHTTPRequest...");
        xhr = false;
    }
    return xhr;
}

function updateShowingDisplay(x) {
    var xhr = getXhr();
    var e = document.getElementById("seanceId");
    var seanceId = e.options[e.selectedIndex].value;
    var url = "FrontController?section=showing-display&seanceId=" + seanceId;
//    alert(url);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var texte = xhr.responseText;
//            alert(texte);
            var elem = document.getElementById("showing-display");
            elem.innerHTML = texte;
        }
    };
    xhr.open("GET", url, true);
    xhr.send(null);
}

