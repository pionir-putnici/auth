<?php

require('db.php');
require('functions.php');


$manuf=getManufacturers();
$model=getModels();

?>

<form action="#" method="post">


<select name='selectManufacturer' id='selectManuf'>

	<option value='-'>-----Odaberi-----</option>
<?php
	foreach($manuf as $m){
		echo '<option class="'.$m['name'].'" value="'.$m['id'].'">'.strtoupper($m['name']).'</option>';
	}
?>


</select>

<select name='selectModel' id='selectModel'>

	<option value='-'>-----Odaberi-----</option>
<?php
	foreach($model as $mo){
		echo '<option class="'.$mo['manufname'].'" value="'.$mo['modid'].'">'.strtoupper($mo['modname']).'</option>';
	}
?>


</select>


</form>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src=""></script>

<script>


$(document).ready(function () {    
    var allOptions = $('#selectModel option')
    $('#selectManuf').change(function () {
        $('#selectModel option').remove()
        var classN = $('#selectManuf option:selected').prop('class');
        var opts = allOptions.filter('.' + classN);
        $.each(opts, function (i, j) {
            $(j).appendTo('#selectModel');
        });
    });
});

</script>