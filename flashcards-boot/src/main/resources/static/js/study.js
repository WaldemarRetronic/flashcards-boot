window.onload = function () {
    'use strict';

    var ajax = getXMLHttpRequestObject();

    ajax.onreadystatechange = function () {

        if (ajax.readyState == 4) {

            if ((ajax.status >= 200 && ajax.status < 300)
                || (ajax.status == 304)) {
                let json = JSON.parse(this.responseText);
                if (json.finished === "false") {
                    U.$("front").innerHTML = json.frontSide;
                    U.$("back").innerHTML = json.backSide;
                    incNumOfCardsReviewed();
                    if (json.variety === "type_in_answer") {
                        U.$("typeAnswerDiv").removeAttribute("hidden");
                    }
                } else {
                    window.location.replace('/study-result');
                }
            } else {
                console.log(ajax.statusText);
            }

        }

    };

    let send = function (data) {
        let element = U.$('logoutForm').firstChild;
        let token = element.getAttribute('value');
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

    U.$('gotIt').onclick = function () {
        let data = '{"correct": "yes"}';
        send(data);
        hideDiv('answerDiv');
        hideDiv('backDiv');
        showDiv('frontDiv');
        showDiv('checkDiv');
    }

    U.$('oops').onclick = function () {
        let data = '{"correct": "no"}';
        send(data);
        hideDiv('answerDiv');
        hideDiv('backDiv');
        showDiv('frontDiv');
        showDiv('checkDiv');

    }

    U.$('btnCheck').onclick = function () {
        this.value = "Show Answer";
        let typeAnswerDiv = U.$('typeAnswerDiv');
        if (typeAnswerDiv.hidden) {
            hideDiv('checkDiv');
            showDiv('backDiv');
            showDiv('answerDiv');
        } else {
            hideDiv('typeAnswerDiv');
            hideDiv('checkDiv');
            showDiv('backDiv');
            showDiv('nextDiv');
        }
    }

    U.$('btnNext').onclick = function () {
        let typeAnswer = U.$('typeAnswer');
        if (typeAnswer.value === U.$("back").innerHTML) {
            send('{"correct": "yes"}');
        } else {
            send('{"correct": "no"}');
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

    function incNumOfCardsReviewed() {
        let fcReviewedText = U.$("fc-study-size")
        let numOfFlashcardsReviewed = parseInt(fcReviewedText.innerText);
        fcReviewedText.innerHTML = (++numOfFlashcardsReviewed).toString();
    }
}
