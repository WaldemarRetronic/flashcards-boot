// study.js
// Skrypt wykonuje żądanie Ajax i uaktualnia stronę WWW otrzymanym wynikiem.

function sendAjax() {

}

// Ustaw podstawową funkcjonalność po wczytaniu strony:
window.onload = function () {
    'use strict';

    //jQuery
    // var token = $("meta[name='_csrf']").attr("content");
    // var header = $("meta[name='_csrf_header']").attr("content");
    //
    // console.log("token: ", token);
    // console.log("header: ", header);

    // Utwórz obiekt Ajax:
    var ajax = getXMLHttpRequestObject();

    // Funkcja wywoływana w przypadku zmian właściwości readyState:
    ajax.onreadystatechange = function () {

        // Sprawdź właściwość readyState:
        if (ajax.readyState == 4) {

            // Sprawdź kod statusu:
            if ((ajax.status >= 200 && ajax.status < 300)
                || (ajax.status == 304)) {
                var json = JSON.parse(this.responseText);
                if (json.finished === "false") {
                    U.$("front").innerHTML = json.frontSide;
                    U.$("back").innerHTML = json.backSide;
                    console.log("variety = ", json.variety);
                    if (json.variety === "type_in_answer") {
                        U.$("typeAnswerDiv").removeAttribute("hidden");
                    }
                } else {
                    window.location.replace('/flash-cards/resultStudy');
                }
            } else { // Błędny status!
               // document.getElementById('output').innerHTML = ajax.statusText;
                console.log('Błędny status: ' + ajax.statusText);
            }

        } // Koniec warunku IF.

    }; // Koniec funkcji anonimowej dla onreadystatechange.

    let send = function (data) {
        // var token = $("input[name='_csrf']");
        // var header = $("input[name='_csrf_header']").value("content");
        var element = U.$('logoutForm').firstChild;
        var token = element.getAttribute('value');
        console.log("token: ", token);
        ajax.open("POST", "/study", true);
        ajax.setRequestHeader("Accept", "application/json");
        ajax.setRequestHeader("Content-Type", "application/json");
        ajax.setRequestHeader("X-CSRF-TOKEN", token);
        ajax.send(data);
    }

    function showDiv(divIdShow) {
        let elementToShow = U.$(divIdShow);
        elementToShow.removeAttribute("hidden");
    }

    function hideDiv(divIdHide) {
        let elementToHide = U.$(divIdHide);
        elementToHide.setAttribute("hidden", "hidden");
    }

    // Dodaj procedurę obsługi kliknięcia przycisku:
    U.$('gotIt').onclick = function () {
        console.log('correct = yes');
        let data = '{"correct": "yes"}';
        console.log(data);
        send(data);
        hideDiv('answerDiv');
        hideDiv('backDiv');
        showDiv('frontDiv');
        showDiv('checkDiv');
    }

    // Dodaj procedurę obsługi kliknięcia przycisku:
    U.$('oops').onclick = function () {
        console.log('correct = no');
        let data = '{"correct": "no"}';
        console.log(data);
        send(data);
        hideDiv('answerDiv');
        hideDiv('backDiv');
        showDiv('frontDiv');
        showDiv('checkDiv');

    }

    U.$('btnCheck').onclick = function () {
        console.log('clicked btnCheck');
        this.value = "Show Answer";
        let typeAnswerDiv = U.$('typeAnswerDiv');
        if (typeAnswerDiv.hidden) {
            console.log("typeAnswerDiv is hidden");
            hideDiv('checkDiv');
            showDiv('backDiv');
            showDiv('answerDiv');
        } else {
            console.log("typeAnswerDiv is not hidden");
            console.log(this);
            console.log("typeAnswer.value = ",typeAnswer.value);
            hideDiv('typeAnswerDiv');
            hideDiv('checkDiv');
            showDiv('backDiv');
            showDiv('nextDiv');
        }
    }

    // Dodaj procedurę obsługi kliknięcia przycisku:
    U.$('btnNext').onclick = function () {
        let typeAnswer = U.$('typeAnswer');
        if (typeAnswer.value === U.$("back").innerHTML) {
            console.log("ok")
            send('{"correct": "yes"}');
        } else {
            send('{"correct": "no"}');
            console.log("wrong")
        }
        hideDiv('nextDiv');
        hideDiv('backDiv');
        showDiv('frontDiv');
        showDiv('checkDiv');
        typeAnswer.value = "";
    }

    U.$("btnStart").onclick = function () {
        send('{"correct": "start"}');
        hideDiv('messageDiv');
        hideDiv('startDiv');
        showDiv('frontDiv');
        showDiv('checkDiv');


    }

    // // JavaScript function to get cookie by name; retrieved from https://docs.djangoproject.com/en/3.1/ref/csrf/
    // function getCookie(name) {
    //     let cookieValue = null;
    //     if (document.cookie && document.cookie !== '') {
    //         const cookies = document.cookie.split(';');
    //         for (let i = 0; i < cookies.length; i++) {
    //             const cookie = cookies[i].trim();
    //             // Does this cookie string begin with the name we want?
    //             if (cookie.substring(0, name.length + 1) === (name + '=')) {
    //                 cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
    //                 break;
    //             }
    //         }
    //     }
    //     return cookieValue;
    // }
}; // Koniec funkcji anonimowej dla onload.
