$(document).ready(function () {

    $("#btnSubmitUpload").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        submit_upload();

    });
    
    
    $("#btnSubmitSearch").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        submit_search();

    });

});

function submit_search() {

    // Get form
    var form = $('#fileSearchForm')[0];

    var data = new FormData(form);

    //data.append("CustomField", "This is some extra data, testing");

    $("#btnSubmitSearch").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/api/search/",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

            $("#resultsearch").text(data);
            console.log("SUCCESS : ", data);
            $("#btnSubmitSearch").prop("disabled", false);

        },
        error: function (e) {

            $("#resultsearch").text(e.responseText);
            console.log("ERROR : ", e);
            $("#btnSubmitSearch").prop("disabled", false);

        }
    });

}

function submit_upload() {

    // Get form
    var form = $('#fileUploadForm')[0];

    var data = new FormData(form);

    //data.append("CustomField", "This is some extra data, testing");

    $("#btnSubmitUpload").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/api/upload/",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

            $("#resultupload").text(data);
            console.log("SUCCESS : ", data);
            $("#btnSubmitUpload").prop("disabled", false);

        },
        error: function (e) {

            $("#resultupload").text(e.responseText);
            console.log("ERROR : ", e);
            $("#btnSubmitUpload").prop("disabled", false);

        }
    });

}