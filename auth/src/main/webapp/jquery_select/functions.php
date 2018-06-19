<?php


function getManufacturers(){
	global $db;
	
	$sql=$db->prepare('SELECT id, name FROM manufacturer');
	$sql->execute();
	
	$result=$sql->fetchALL(PDO::FETCH_ASSOC);
	
	return $result;
}


function getModels(){
	global $db;
	
	$sql=$db->prepare('SELECT mo.id, mo.name as modname, mo.manufacturer, manuf.id as manufid, manuf.name as manufname FROM model as mo
						join manufacturer as manuf on mo.manufacturer=manuf.id ');
	$sql->execute();
	
	$result=$sql->fetchALL(PDO::FETCH_ASSOC);
	
	return $result;
}


?>