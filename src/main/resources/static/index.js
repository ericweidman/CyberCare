function addCustomer(customer){
  $.ajax({
    url: '/create-customer',
    method: "POST",
    data: JSON.stringify(customer),
    dataType: 'json',
    contentType: "application/json",
    success: function(data){
      alert("Not Fail!")
    },
    error: function(error){
    }
  });
}

$('#addCustomer').submit(function(event){
  event.preventDefault();
  var customer = {};
  customer.name = $('input[name=name]').val();
  customer.email = $('input[name=email]').val();
  customer.phone = $('input[name=phone]').val();
  customer.street = $('input[name=street]').val();
  customer.city = $('input[name=city]').val();
  customer.state = $('input[name=state]').val();
  customer.zip = $('input[name=zip]').val();
  addCustomer(customer);
  document.getElementById("addCustomer").reset();
});
