$(function () {

    $("#test").click(function () {
        alert("fdsfdsf")
        $.ajax({
            type: "post",
            url: "/edituser",
            dataType: "json",
            data: {
                "username": "zuolei",
                "name": "zuolei",
                "role": [
                    1
                ],
                "college": "ruanjian",
                "reset": true
            },

            success: function (data) {
                alert(data.msg)
            }
        })
    })
})

