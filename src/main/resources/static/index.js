$(document).ready(function() {
    $.ajax({
        url: '/get-customers',
        dataType: 'json',
        method: 'GET',

        success: function(response) {

            for (var i = 0; i < response.length; i++) {

                var singleCustomer = response[i];
                var name = singleCustomer.name;
                var email = singleCustomer.email;
                var phone = singleCustomer.phone;
                var street = singleCustomer.street;
                var city = singleCustomer.city;
                var state = singleCustomer.state;
                var zip = singleCustomer.zip;
                var table = document.getElementById("customerList");
                var row = table.insertRow(0);
                row.innerHTML = name + " " + email + " " + phone + " " + street + " " + city + " " + state + " " + zip;

            }

        },
        error: function(data) {
            alert("Or this!")
        },
    });
});

function addCustomer(customer) {
    $.ajax({
        url: '/create-customer',
        method: "POST",
        data: JSON.stringify(customer),
        dataType: 'json',
        contentType: "application/json",
        success: function(data) {},
        error: function(error) {}
    });
}

$('#addCustomer').submit(function(event) {
    event.preventDefault();
    var customer = {};
    var customerString = {};
    var table = document.getElementById("customerList");
    var row = table.insertRow(0);
    customer.name = $('input[name=name]').val();
    customer.email = $('input[name=email]').val();
    customer.phone = $('input[name=phone]').val();
    customer.street = $('input[name=street]').val();
    customer.city = $('input[name=city]').val();
    customer.state = $('input[name=state]').val();
    customer.zip = $('input[name=zip]').val();
    addCustomer(customer);
    row.innerHTML = customer.name + " " + customer.email + " " + customer.phone + " " + customer.street + " " + customer.city + " " + customer.state + " " + customer.zip;
    document.getElementById("addCustomer").reset();
});
