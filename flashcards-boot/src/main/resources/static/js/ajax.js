// ajax.js
// Skrypt definiuje funkcję tworzącą obiekt XMLHttpRequest.

// Funkcja zwraca obiekt XMLHttpRequest.
function getXMLHttpRequestObject() {
	
    var ajax = null;

	// Większość przeglądarek:
	if (window.XMLHttpRequest) {
	    ajax = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // Starsze IE:
	    ajax = new ActiveXObject('MSXML2.XMLHTTP.3.0');
	}
	
	// Zwróć obiekt:
    return ajax;

} // Koniec funkcji getXMLHttpRequestObject().