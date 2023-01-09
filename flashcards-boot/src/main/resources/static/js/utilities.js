// utilities.js
// Skrypt definiuje obiekt z kilkoma przydatnymi funkcjami.

// Obiekt U będzie jedyną zmienną globalną utworzoną przez skrypt.
var U = {

    // Pobiera referencję do elementu na podstawie jego identyfikatora:
    $: function (id) {
        'use strict';
        if (typeof id == 'string') {
            return document.getElementById(id);
        }
    }, // Koniec funkcji $().

    // Funkcja ustawiająca tekst elementu:
    setText: function (id, message) {
        'use strict';
        if ((typeof id == 'string') && (typeof message == 'string')) {

            // Pobierz referencję do elementu:
            var output = this.$(id);
            if (!output) return false;

            // Ustaw tekst:
            if (output.textContent !== undefined) {
                output.textContent = message;
            } else {
                output.innerText = message;
            }
            return true;
        } // Koniec IF.
    }, // Koniec funkcji setText().

    // Funkcja przypisująca procedurę obsługi:
    /**
     * pierwszym elementem przekazywanym jako argument jest obiekt, a nie identyfikator.
     * To konieczne, by móc dodawać procedury obsługi zdarzeń do obiektów window lub document.
     */
    addEvent: function (obj, type, fn) {
        'use strict';
        if (obj) { // W3C
            obj.addEventListener(type, fn, false);
        }
    }, // Koniec funkcji addEvent().

    // Funkcja usuwająca procedurę obsługi:
    removeEvent: function (obj, type, fn) {
        'use strict';
        if (obj) { // W3C
            obj.removeEventListener(type, fn, false);
        }
    } //Koniec funkcji removeEvent().

}; // Koniec deklaracji U.
