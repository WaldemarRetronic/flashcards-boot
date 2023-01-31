let U = {

    $: function (id) {
        'use strict';
        if (typeof id == 'string') {
            return document.getElementById(id);
        }
    },

    setText: function (id, message) {
        'use strict';
        if ((typeof id == 'string') && (typeof message == 'string')) {

            let output = this.$(id);
            if (!output) return false;

            if (output.textContent !== undefined) {
                output.textContent = message;
            } else {
                output.innerText = message;
            }
            return true;
        }
    },

    addEvent: function (obj, type, fn) {
        'use strict';
        if (obj) {
            obj.addEventListener(type, fn, false);
        }
    },

    removeEvent: function (obj, type, fn) {
        'use strict';
        if (obj) {
            obj.removeEventListener(type, fn, false);
        }
    }

};
