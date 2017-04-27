(function() {
  var $confirm;

  $confirm = null;

  $(function() {
    $(".switch").bootstrapSwitch();
    $(".switch").on('switchChange.bootstrapSwitch', function(event, state) {
	  if(state){
		  $('#IsManul').val(1);
		  $('#SellPrice').attr('readonly',false);
	  }else{
		  $('#IsManul').val(0);
		  $('#SellPrice').attr('readonly',true);
	  }
    });
  });

}).call(this);
